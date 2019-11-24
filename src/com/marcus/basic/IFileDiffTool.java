package com.marcus.basic;

import java.io.File;

/**
 * Created by marcus on 17/3/27.
 */
public interface IFileDiffTool {


    String getToolName();

    void diff(File file, File file2, File outputPathFile);

    void path(File file, File outputFile, File patchFile);

    void diff(String filePath, String filePath2, String outputFileName);

    void patch(String filePath, String outputFilePatch, String patchPath);

}
