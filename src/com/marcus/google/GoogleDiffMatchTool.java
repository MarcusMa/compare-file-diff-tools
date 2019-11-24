package com.marcus.google;

import com.marcus.basic.IFileDiffTool;
import com.marcus.util.FileUtils;

import java.io.File;
import java.util.LinkedList;

/**
 * Created by marcus on 17/3/27.
 */
public class GoogleDiffMatchTool implements IFileDiffTool {
    @Override
    public String getToolName() {
        return "google-diff-match-patch";
    }

    @Override
    public void diff(File file, File file2, File outputFile) {
        diff(file.getAbsolutePath(), file2.getAbsolutePath(), outputFile.getAbsolutePath());
    }

    @Override
    public void path(File file, File outputFile, File patchFile) {
        patch(file.getAbsolutePath(), outputFile.getAbsolutePath(), patchFile.getAbsolutePath());
    }

    @Override
    public void diff(String filePath, String filePath2, String outputFilePath) {
        diff_match_patch dmp = new diff_match_patch();
        String commonStr = FileUtils.readFileContent(filePath);
        String compareStr = FileUtils.readFileContent(filePath2);
        LinkedList<diff_match_patch.Diff> diffs = dmp.diff_main(commonStr, compareStr);
        LinkedList<diff_match_patch.Patch> patches = dmp.patch_make(diffs);
        String patchesStr = dmp.patch_toText(patches);
        FileUtils.writeContextToFile(patchesStr, outputFilePath);
    }

    @Override
    public void patch(String filePath, String outputFilePath, String patchPath) {
        diff_match_patch dmp = new diff_match_patch();
        String commonStr = FileUtils.readFileContent(filePath);
        String patchesStr = FileUtils.readFileContent(patchPath);
        LinkedList<diff_match_patch.Patch> patches = (LinkedList<diff_match_patch.Patch>) dmp.patch_fromText(patchesStr);
        Object[] results = dmp.patch_apply(patches, commonStr);
        String fileContent = String.valueOf(results[0]);
        FileUtils.writeContextToFile(fileContent, outputFilePath);
    }
}
