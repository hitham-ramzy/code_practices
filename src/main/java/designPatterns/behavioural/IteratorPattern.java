package designPatterns.behavioural;

import java.util.ArrayList;
import java.util.List;

public class IteratorPattern {
}

interface Iterator {

    boolean hasNext();

    Object getNext();

}

class NameIterator implements Iterator {

    List<String> names = new ArrayList<>();
    int index = 0;

    public NameIterator() {
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    @Override
    public boolean hasNext() {
        return index < names.size();
    }

    @Override
    public String getNext() {
        if (!hasNext()) {
            return null;
        }
        String result = names.get(index);
        index++;
        return result;
    }
}

interface Container {

    Iterator getIterator();

}

class NameContainer implements Container {

    @Override
    public NameIterator getIterator() {
        return new NameIterator();
    }
}
