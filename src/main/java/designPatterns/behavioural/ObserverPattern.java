package designPatterns.behavioural;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    private List<Topic> topics = new ArrayList<>();

    public void createTopic(String topicName) {
        topics.add(new Topic(topicName));
    }

    void subscribe(String topicName, String subscriberEmail) {
        topics.stream().filter(topic -> topic.name.equals(topicName)).forEach(topic -> topic.addSubscriber(new Subscriber(subscriberEmail)));
    }

    void update(String topicName, String message) {
        topics.forEach(topic -> {
            if (topic.name.equals(topicName)) {
                notify(topic.subscribers, message);
            }
        });
    }

    private void notify(List<Subscriber> subscribers, String message) {
        subscribers.forEach(subscriber -> System.out.println("Message: " + message + " sent to " + subscriber.email));
    }
}

class Topic {
    String name;
    List<Subscriber> subscribers = new ArrayList<>();

    public Topic(String name) {
        this.name = name;
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }
}

class Subscriber {
    String email;

    public Subscriber(String email) {
        this.email = email;
    }
}
