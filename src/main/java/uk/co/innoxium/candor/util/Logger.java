package uk.co.innoxium.candor.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.impl.Log4jContextFactory;
import uk.co.innoxium.candor.CandorLauncher;

import java.io.PrintStream;


public class Logger {

    public static org.apache.logging.log4j.Logger LOGGER;

    public static void initialise() {

        System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        LogManager.setFactory(new Log4jContextFactory());
        LOGGER = LogManager.getLogger(CandorLauncher.class);
        addLoggingProxies();
    }

    private static void addLoggingProxies() {

        System.setOut(new PrintStream(new LoggerProxyStream(LogManager.getLogger("STDOUT"), Level.INFO, System.out), true));
        System.setErr(new PrintStream(new LoggerProxyStream(LogManager.getLogger("STDERR"), Level.ERROR, System.err), true));
    }

    public static void info(String message) {

        LOGGER.info(message);
    }

    public static void info(Object obj) {

        LOGGER.info(obj);
    }
}
