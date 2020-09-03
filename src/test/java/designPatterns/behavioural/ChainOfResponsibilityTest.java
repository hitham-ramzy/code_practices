package designPatterns.behavioural;

import org.junit.Test;

import static designPatterns.behavioural.Logger.DEBUG_LEVEL;
import static designPatterns.behavioural.Logger.ERROR_LEVEL;
import static designPatterns.behavioural.Logger.TRACE_LEVEL;

public class ChainOfResponsibilityTest {


    @Test
    public void logDebugTest(){

        ChainOfResponsibility chainOfResponsibility = new ChainOfResponsibility();
        chainOfResponsibility.log(DEBUG_LEVEL, "DEBUG MESSAGE");
    }

    @Test
    public void logTraceTest(){

        ChainOfResponsibility chainOfResponsibility = new ChainOfResponsibility();
        chainOfResponsibility.log(TRACE_LEVEL, "TRACE MESSAGE");
    }

    @Test
    public void logTestTest(){

        ChainOfResponsibility chainOfResponsibility = new ChainOfResponsibility();
        chainOfResponsibility.log(ERROR_LEVEL, "ERROR MESSAGE");
    }
}
