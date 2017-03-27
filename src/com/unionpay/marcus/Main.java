package com.unionpay.marcus;

import com.unionpay.marcus.basic.fileDiffToolInterface;
import com.unionpay.marcus.google.GoogleDiffMatchTool;

public class Main {

    public static void main(String[] args) {
	// write your code
        System.out.println(">> Start Compare ...");
        fileDiffToolInterface googleTool = new GoogleDiffMatchTool();
        googleTool.diff("common_package_min.jsbundle","rn_upwallet_demo_all_min.jsbundle","rn_upwallet_demo_all_min_patch_by_google.txt");
        googleTool.patch("common_package_min.jsbundle","rn_upwallet_demo_all_min_new.jsbundle","rn_upwallet_demo_all_min_patch_by_google.txt");

        // googleTool.diff("123.txt","abc.txt","test_patch.txt");
        // googleTool.patch("123.txt","test_output.txt","test_patch.txt");

        System.out.println(">> Stop Compare ...");

    }
}
