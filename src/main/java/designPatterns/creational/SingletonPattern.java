package designPatterns.creational;

/**
 * The type Singleton pattern.
 */
class SingletonPattern {

    private static SingletonPattern instance;

    private SingletonPattern() {
        super();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    static SingletonPattern getInstance() {
        if (instance == null) {
            instance = new SingletonPattern();
        }
        return instance;
    }
}
