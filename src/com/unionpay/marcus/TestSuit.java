package com.unionpay.marcus;

import com.unionpay.marcus.basic.FileDiffToolInterface;

import java.io.File;
import java.util.Calendar;

/**
 * Created by marcus on 17/3/27.
 */
public class TestSuit {

    private FileDiffToolInterface mTool;
    private String mCommonFilePath;
    private String mCompareFilePath;
    private String mPatchFilePath;
    private String mOutputFielPath;

    private long execDiffTime;
    private long execPathTime;
    private long mCommonFileSize;
    private long mCompareFileSize;
    private long mPathFileSize;

    public TestSuit(FileDiffToolInterface tools, String commonFilePath, String compareFilePath, String patchFilePath, String outputFilePath){
        mTool = tools;
        mCommonFilePath = commonFilePath;
        mCompareFilePath = compareFilePath;
        mPatchFilePath = patchFilePath;
        mOutputFielPath = outputFilePath;
    }

    public void doTest(){
        // 1. do diff;
        doDiffTest();
        // 2. do patch
        doPatchTest();
        // 3. record the file size;
        mCommonFileSize = recordFileSize(mCommonFilePath);
        mCompareFileSize = recordFileSize(mCompareFilePath);
        mPathFileSize = recordFileSize(mPatchFilePath);
        // 4. print the result;
        printResult();
    }

    private void doPatchTest(){
        long startTime = Calendar.getInstance().getTimeInMillis();
        mTool.patch(mCommonFilePath,mOutputFielPath,mPatchFilePath);
        long endTime = Calendar.getInstance().getTimeInMillis();
        execPathTime = endTime - startTime;
    }

    private void doDiffTest(){
        long startTime = Calendar.getInstance().getTimeInMillis();
        mTool.diff(mCommonFilePath,mCompareFilePath,mPatchFilePath);
        long endTime = Calendar.getInstance().getTimeInMillis();
        execDiffTime = endTime - startTime;
    }

    private long recordFileSize(String filePath){
        File f= new File(filePath);
        if (f.exists() && f.isFile()){
            return f.length();
        }else{
            System.out.println("Can not get the size of the file.");
        }
        return -1;
    }

    private void printResult(){
        System.out.println();
        System.out.println("Test Algorithm: \t" + mTool.getToolName());
        System.out.println("A File: \t" + mCommonFilePath + "\t size: " + String.valueOf(mCommonFileSize) + " bytes");
        System.out.println("B File: \t" + mCompareFilePath + "\t size: " + String.valueOf(mCompareFileSize) + " bytes");
        System.out.println("patch File: \t" + mPatchFilePath + "\t size: " + String.valueOf(mPathFileSize) + " bytes");
        System.out.println("Exec Diff Time: \t" + execDiffTime + " ms" );
        System.out.println("Exec Patch Time: \t" + execPathTime +  " ms");
    }

}
