package com.marcus;

import com.marcus.basic.IFileDiffTool;
import com.marcus.bsdiff.BsdiffTool;
import com.marcus.google.GoogleDiffMatchTool;

public class Main {

    public static void main(String[] args) {

        IFileDiffTool googleTool = new GoogleDiffMatchTool();
        IFileDiffTool bsdiffTool = new BsdiffTool();

        DiffTestProcess process = new DiffTestProcess(googleTool,
                "common.android.jsbundle",
                "index.android.org.jsbundle");

        process.doTest();

        process.setTool(bsdiffTool);

        process.doTest();


//        TestSuit bsdiffTest2 = new TestSuit(bsdiffTool,
//                "common_package_min.jsbundle",
//                "rn_demo_all_min.jsbundle",
//                "rn_demo_all_min_patch_by_bsdiff.patch",
//                "rn_demo_all_min_new_by_bsdiff.jsbundle"
//        );
//        bsdiffTest2.doTest();
//
//        TestSuit googleTest = new TestSuit(googleTool,
//                "common_package_min.jsbundle",
//                "rn_demo_all_min.jsbundle",
//                "rn_demo_all_min_patch_by_google.txt",
//                "rn_demo_all_min_new_by_google.jsbundle"
//                );
//        googleTest.doTest();
//
//        TestSuit bsdiffTest1 = new TestSuit(bsdiffTool,
//                "common_package_min.jsbundle",
//                "helloworld_all_min.jsbundle",
//                "helloworld_all_min_patch_by_bsdiff.patch",
//                "helloworld_all_min_new_by_bsdiff.jsbundle"
//        );
//        bsdiffTest1.doTest();
//
//        TestSuit googleTest2 = new TestSuit(googleTool,
//                "common_package_min.jsbundle",
//                "helloworld_all_min.jsbundle",
//                "helloworld_all_min_patch_by_google.txt",
//                "helloworld_all_min_new_by_google.jsbundle"
//        );
//        googleTest2.doTest();

       //  System.out.println(">> Stop Compare ...");

    }
}
