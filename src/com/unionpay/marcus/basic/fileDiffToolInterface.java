package com.unionpay.marcus.basic;

/**
 * Created by marcus on 17/3/27.
 */
public interface FileDiffToolInterface {

    String getToolName();

    void diff(String filePath, String filePath2, String outputFileName);

    void patch(String filePath, String outputFilePatch, String patchPath);

}
