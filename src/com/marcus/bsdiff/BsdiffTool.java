package com.marcus.bsdiff;

import com.marcus.basic.IFileDiffTool;

import java.io.File;

/**
 * Created by marcus on 17/3/27.
 */
public class BsdiffTool implements IFileDiffTool {
    @Override
    public String getToolName() {
        return "bsdiff";
    }

    @Override
    public void diff(File file, File file2, File outputPathFile) {
        diff(file.getAbsolutePath(), file2.getAbsolutePath(), outputPathFile.getAbsolutePath());
    }

    @Override
    public void path(File file, File outputFile, File pathFile) {
        patch(file.getAbsolutePath(), outputFile.getAbsolutePath(), pathFile.getAbsolutePath());
    }

    @Override
    public void diff(String filePath, String filePath2, String outputFileName) {
        try {
            String[] cmd = {"./bsdiff", filePath, filePath2, outputFileName};
            Process process = Runtime.getRuntime().exec(cmd, null, null);
            int status = process.waitFor();
            if (status != 0) {
                System.err.println("Failed to call shell's command and the return status's is: " + status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void patch(String filePath, String outputFilePatch, String patchPath) {
        try {
            String[] cmd = {"./bspatch", filePath, outputFilePatch, patchPath};
            Process process = Runtime.getRuntime().exec(cmd, null, null);
            int status = process.waitFor();
            if (status != 0) {
                System.err.println("Failed to call shell's command and the return status's is: " + status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
