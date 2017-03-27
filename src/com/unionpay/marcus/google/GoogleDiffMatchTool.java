package com.unionpay.marcus.google;

import com.unionpay.marcus.basic.fileDiffToolInterface;
import com.unionpay.marcus.util.FileUtils;

import java.util.Calendar;
import java.util.LinkedList;

/**
 * Created by marcus on 17/3/27.
 */
public class GoogleDiffMatchTool implements fileDiffToolInterface {
    @Override
    public void diff(String filePath, String filePath2, String outputFilePath) {
        long startTime = Calendar.getInstance().getTimeInMillis();

        // start
        diff_match_patch dmp = new diff_match_patch();

        String commonStr = FileUtils.readFileContent(filePath);
        String compareStr = FileUtils.readFileContent(filePath2);

        // String hexCommonStr = Hex.str2HexStr(commonStr);
        // String hexCompareStr = Hex.str2HexStr(compareStr);

        LinkedList<diff_match_patch.Diff> diffs = dmp.diff_main(commonStr, compareStr);
        // LinkedList<diff_match_patch.Diff> diffs = dmp.diff_main(hexCommonStr, hexCompareStr);
//        for(diff_match_patch.Diff diff : diffs){
//            System.out.println(diff.toString());
//        }

        LinkedList<diff_match_patch.Patch> patches = dmp.patch_make(diffs);
        String patchesStr = dmp.patch_toText(patches);

        FileUtils.writeContextToFile(patchesStr, outputFilePath);

        // patches = (LinkedList<diff_match_patch.Patch>)dmp.patch_fromText(patchesStr);
        // Object[] results = dmp.patch_apply(patches, commonStr);
        // end
        // System.out.println("result = " + results[0]);
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println(" diff exec time: " + String.valueOf(endTime - startTime)  + " ms");
    }

    @Override
    public void patch(String filePath, String outputFilePath, String patchPath) {
        long startTime = Calendar.getInstance().getTimeInMillis();

        // start
        diff_match_patch dmp = new diff_match_patch();

        String commonStr = FileUtils.readFileContent(filePath);
        String patchesStr = FileUtils.readFileContent(patchPath);

        // String hexCommonStr = Hex.str2HexStr(commonStr);

        LinkedList<diff_match_patch.Patch> patches = (LinkedList<diff_match_patch.Patch>)dmp.patch_fromText(patchesStr);

        // Object[] results = dmp.patch_apply(patches, hexCommonStr);
        Object[] results = dmp.patch_apply(patches, commonStr);

        // String fileContent = Hex.hexStr2Str(String.valueOf(results[0]));
        String fileContent = String.valueOf(results[0]);
        FileUtils.writeContextToFile(fileContent, outputFilePath);
        // end

        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println(" patch exec time: " + String.valueOf(endTime - startTime)  + " ms");

    }
}
