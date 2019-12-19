package com.atguigu.jvm;

import java.net.URL;

public class T1 {
    public static void main(String[] args) {
        URL[] urLs = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL element : urLs) {
            System.out.println(element.toExternalForm());

        }
    }
}
