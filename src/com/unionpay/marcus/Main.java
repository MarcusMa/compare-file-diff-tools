package com.unionpay.marcus;

import com.unionpay.marcus.basic.FileDiffToolInterface;
import com.unionpay.marcus.bsdiff.BsdiffTool;
import com.unionpay.marcus.google.GoogleDiffMatchTool;

public class Main {

    public static void main(String[] args) {


        System.out.println(">> Start Compare ...");
        FileDiffToolInterface googleTool = new GoogleDiffMatchTool();
        FileDiffToolInterface bsdiffTool = new BsdiffTool();

        TestSuit googleTest = new TestSuit(googleTool,
                "common_package_min.jsbundle",
                "rn_upwallet_demo_all_min.jsbundle",
                "rn_upwallet_demo_all_min_patch_by_google.txt",
                "rn_upwallet_demo_all_min_new_by_google.jsbundle"
                );
        googleTest.doTest();

        TestSuit googleTest2 = new TestSuit(googleTool,
                "common_package_min.jsbundle",
                "helloworld_all_min.jsbundle",
                "helloworld_all_min_patch_by_google.txt",
                "helloworld_all_min_new_by_google.jsbundle"
        );
        googleTest2.doTest();


        TestSuit bsdiffTest1 = new TestSuit(bsdiffTool,
                "common_package_min.jsbundle",
                "helloworld_all_min.jsbundle",
                "helloworld_all_min_patch_by_bsdiff.patch",
                "helloworld_all_min_new_by_bsdiff.jsbundle"
        );
        bsdiffTest1.doTest();

        TestSuit bsdiffTest2 = new TestSuit(googleTool,
                "common_package_min.jsbundle",
                "rn_upwallet_demo_all_min.jsbundle",
                "rn_upwallet_demo_all_min_patch_by_bsdiff.txt",
                "rn_upwallet_demo_all_min_new_by_bsdiff.jsbundle"
        );
        bsdiffTest2.doTest();

        System.out.println(">> Stop Compare ...");

    }
}
