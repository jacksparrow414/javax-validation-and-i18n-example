package com.example.validation.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Log
public class I18nUtil {

    private static ClassLoader resourceBundleClassLoader;

    /**
     * https://stackoverflow.com/questions/50434689/how-to-properly-setup-resourcebundle-and-classloader
     *
     * 加载ResourceBundle文件所在的文件夹的classloader,否则会报找不到错误
     */
    static {
        try {
            resourceBundleClassLoader = new URLClassLoader(new URL[]{new File(I18nUtil.class.getClassLoader().getResource("bundle/").getPath()).toURI().toURL()});
        } catch (MalformedURLException e) {
            log.log(Level.WARNING, "initialize resourceBundleClassLoader failed", e);
        }
    }

    public static ClassLoader getResourceBundleClassLoader() {
        return resourceBundleClassLoader;
    }
}
