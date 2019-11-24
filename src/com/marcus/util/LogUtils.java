package com.marcus.util;

public class LogUtils {

    public static void D(String... msgs){
        for (String msg: msgs) {
            System.out.print(msg);
        }
        System.out.println();
    };

}
