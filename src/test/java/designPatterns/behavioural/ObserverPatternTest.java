package designPatterns.behavioural;

import org.junit.Test;

public class ObserverPatternTest {

    @Test
    public void observerPatternTest(){
        ObserverPattern notifier = new ObserverPattern();
        notifier.createTopic("New Topic");
        notifier.subscribe("New Topic", "hitham.ramzy@gmail.com");
        notifier.update("New Topic", "MESSAGE CONTENT");
    }
}
