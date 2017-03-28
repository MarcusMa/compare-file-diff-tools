package com.unionpay.marcus.bsdiff;

import com.unionpay.marcus.basic.FileDiffToolInterface;

/**
 * Created by marcus on 17/3/27.
 */
public class BsdiffTool implements FileDiffToolInterface {
    @Override
    public String getToolName() {
        return "bsdiff";
    }

    @Override
    public void diff(String filePath, String filePath2, String outputFileName) {

    }

    @Override
    public void patch(String filePath, String outputFilePatch, String patchPath) {

    }
}
