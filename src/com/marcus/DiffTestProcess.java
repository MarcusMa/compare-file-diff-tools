package com.marcus;

import com.marcus.basic.IFileDiffTool;
import com.marcus.util.LogUtils;

import java.io.File;
import java.io.IOException;

public class DiffTestProcess {

    private DiffToolProxy mTool;

    private File mCommonFile;

    private File mBusinessFile;


    public DiffTestProcess(IFileDiffTool mTool, String mCommonFilePath, String mBussinessFilePath) {
        this.mTool = new DiffToolProxy(mTool);
        this.mCommonFile = new File(mCommonFilePath);
        this.mBusinessFile = new File(mBussinessFilePath);
        LogUtils.D("CommonFile Path: \t" + mCommonFile.getAbsolutePath());
        LogUtils.D("BusinessFile Path: \t" + mBusinessFile.getAbsolutePath());
    }

    public DiffToolProxy getTool() {
        return mTool;
    }

    public void setTool(IFileDiffTool mTool) {
        this.mTool = new DiffToolProxy(mTool);
    }

    public void doTest() {
        try {
            LogUtils.D("DiffTestProcess Start");
            LogUtils.D("-----------------------");
            LogUtils.D("Using Tool: \t" + mTool.getToolName());
            LogUtils.D("Common File Size : \t" + mCommonFile.length());
            LogUtils.D("Business File Size : \t" + mBusinessFile.length());
            LogUtils.D("-----------------------");
            LogUtils.D("1. Diff Progress ....");
            File patchFile = new File(mBusinessFile.getParent(),
                    mBusinessFile.getName() + "[" + mTool.getToolName() + "].patch");
            patchFile.createNewFile();
            LogUtils.D("Patch File Size : \t" + patchFile.getAbsolutePath());

            mTool.diff(mCommonFile, mBusinessFile, patchFile);
            LogUtils.D("Patch File Size : \t" + patchFile.length());
            LogUtils.D("Time Cost: \t" + mTool.diffTimeCost);
            LogUtils.D("-----------------------");
            LogUtils.D("2. Patch Progress ....");
            File tmpBusinessFile = new File(mBusinessFile.getParent(),
                    mBusinessFile.getName() + "[" + mTool.getToolName() + "].rebuild");
            tmpBusinessFile.createNewFile();
            mTool.path(mCommonFile, tmpBusinessFile, patchFile);
            LogUtils.D("Rebuild File Size : \t" + tmpBusinessFile.length());
            LogUtils.D("Time Cost: \t" + mTool.pathTimeCost);
            LogUtils.D("-----------------------");
            LogUtils.D("DiffTestProcess End\r\n\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class DiffToolProxy implements IFileDiffTool {

        private IFileDiffTool mTarget;

        public long diffTimeCost = 0L;
        public long pathTimeCost = 0L;

        public DiffToolProxy(IFileDiffTool mTarget) {
            this.mTarget = mTarget;
        }

        @Override
        public String getToolName() {
            return mTarget.getToolName();
        }

        @Override
        public void diff(File file, File file2, File outputFile) {
            long startTimeInMillis = System.currentTimeMillis();
            mTarget.diff(file, file2, outputFile);
            diffTimeCost = System.currentTimeMillis() - startTimeInMillis;
        }

        @Override
        public void path(File file, File outputFile, File patchFile) {
            long startTimeInMillis = System.currentTimeMillis();
            mTarget.path(file, outputFile, patchFile);
            pathTimeCost = System.currentTimeMillis() - startTimeInMillis;
        }

        @Override
        public void diff(String filePath, String filePath2, String outputFileName) {
            long startTimeInMillis = System.currentTimeMillis();
            mTarget.diff(filePath, filePath2, outputFileName);
            diffTimeCost = System.currentTimeMillis() - startTimeInMillis;
        }

        @Override
        public void patch(String filePath, String outputFilePatch, String patchPath) {
            long startTimeInMillis = System.currentTimeMillis();
            mTarget.diff(filePath, outputFilePatch, patchPath);
            pathTimeCost = System.currentTimeMillis() - startTimeInMillis;
        }
    }

}
