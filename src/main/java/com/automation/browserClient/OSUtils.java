package com.automation.browserClient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public final class OSUtils {

    private static final Logger LOGGER = LogManager.getLogger(OSUtils.class);

    private static boolean runCommand(String... cmds) throws IOException, InterruptedException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Running command: '{}'", Arrays.stream(cmds).collect(Collectors.joining(" ")));
        }
        return Runtime.getRuntime().exec(cmds).waitFor() == 0;
    }

    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("windows");
    }

    public static void killProcess(String name) {
        if (!isWindows()) {
            LOGGER.debug("Method is not implemented for this OS");
            return;
        }
        try {
            runCommand("taskkill", "/F", "/T", "/IM", name);
        } catch (IOException | InterruptedException e) {
            LOGGER.trace(e.getMessage(), e);
        }
    }
}
