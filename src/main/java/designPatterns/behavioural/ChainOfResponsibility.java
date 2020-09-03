package designPatterns.behavioural;

public class ChainOfResponsibility {

    private Logger firstLogger;

    ChainOfResponsibility() {
        DebugLogger debugLogger = new DebugLogger();
        TraceLogger traceLogger = new TraceLogger();
        ErrorLogger errorLogger = new ErrorLogger();
        debugLogger.setNextLogger(traceLogger);
        traceLogger.setNextLogger(errorLogger);
        firstLogger = debugLogger;
    }

    void log(int level, String message) {
        firstLogger.log(level, message);
    }

}

abstract class Logger {

    static final int DEBUG_LEVEL = 1;
    static final int TRACE_LEVEL = 2;
    static final int ERROR_LEVEL = 3;

    int level;

    private Logger nextLogger;

    public Logger(int level) {
        this.level = level;
    }

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    void log(int level, String message) {
        if (this.level >= level) {
            write(message);
        }

        if (nextLogger != null) {
            nextLogger.log(level, message);
        }
    }

    abstract void write(String message);
}

class ErrorLogger extends Logger {

    public ErrorLogger() {
        super(ERROR_LEVEL);
    }

    @Override
    void write(String message) {
        System.out.println("ERROR LOGGER : " + message);
    }
}

class DebugLogger extends Logger {

    public DebugLogger() {
        super(DEBUG_LEVEL);
    }

    @Override
    void write(String message) {
        System.out.println("DEBUG LOGGER : " + message);
    }
}

class TraceLogger extends Logger {

    public TraceLogger() {
        super(TRACE_LEVEL);
    }

    @Override
    void write(String message) {
        System.out.println("TRACE LOGGER : " + message);
    }
}
