package com.github.twitch4j.codegen.java.feign.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JavaCodegenUtils {

    /**
     * packageToPath replaces all dots in the path with a /
     *
     * @param sourceFolder
     * @param packageName
     * @return
     */
    public String packageToPath(String sourceFolder, String packageName) {
        return (sourceFolder + "/" + packageName).replace(".", "/");
    }

}
