package org.rntgroup;

import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AllureLogger {

    private static final Logger logger = LogManager.getLogger(AllureLogger.class);

    public static void info(String message) {
        logger.info(message);
        attachLogToAllure("[INFO] "+message);
    }

    public static void debug(String message) {
        logger.debug(message);
        attachLogToAllure("[DEBUG] "+message);
    }

    public static void error(String message) {
        logger.error(message);
        attachLogToAllure("[ERROR] "+message);
    }

    @Attachment(value="{message}", type="text/plain")
    private static String attachLogToAllure (String message) {
        return message;
    }
}
