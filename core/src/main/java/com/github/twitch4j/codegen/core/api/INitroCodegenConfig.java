package com.github.twitch4j.codegen.core.api;

import com.github.twitch4j.codegen.core.domain.config.NitroCodegenFile;

import java.util.LinkedList;
import java.util.List;

/**
 * Base for Advanced Configuration Options
 */
public interface INitroCodegenConfig {
    List<NitroCodegenFile> nitroFiles = new LinkedList<>();

    default void addNitroFile(NitroCodegenFile file) {
        nitroFiles.add(file);
    }

    default List<NitroCodegenFile> getNitroFiles() {
        return nitroFiles;
    }
}
