package com.yangnk.jvmClassLoaderSample;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    public static void main(String[] args) throws Exception {
        URLClassLoader loader_1 =
                new URLClassLoader(new URL[]{new File("/Users/yangnk/IdeaProjects/SpringBoot-Learning/SpringBootDemo/src/main/java/com/yangnk/jvmClassLoaderSample").toURI().toURL()});

        URLClassLoader loader_2 =
                new URLClassLoader(new URL[]{new File("/Users/yangnk/IdeaProjects/SpringBoot-Learning/SpringBootDemo/src/main/java/com/yangnk/jvmClassLoaderSample").toURI().toURL()});

        Class<?> clazz_1 = loader_1.loadClass("Test");
        clazz_1.newInstance();
        Class<?> clazz_2 = loader_2.loadClass("Test");
        clazz_2.newInstance();
    }
}