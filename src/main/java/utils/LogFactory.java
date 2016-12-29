package utils;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import java.io.InputStream;
import java.util.logging.LogManager;

/**
 * Created by akshay.kumar on 29/12/16.
 */
public class LogFactory {

    private static Logger logger;

    public static Logger getLogger(Class clazz){
        try {
            final InputStream inputStream = clazz.getResourceAsStream("/logging.properties");
            LogManager.getLogManager().readConfiguration(inputStream);
            logger = LoggerFactory.getLogger(clazz.getName());
            logger.info("LogFactory initialized");

        } catch(Exception ex) {

        }
        return logger;
    }
}
