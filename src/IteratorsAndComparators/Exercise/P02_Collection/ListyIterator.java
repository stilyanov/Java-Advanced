package IteratorsAndComparators.Exercise.P02_Collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {

    private List<String> elements;
    private int index;

    public ListyIterator(String... elements) {
        this.elements = List.of(elements);
        this.index = 0;
    }

    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public void printAll() {
        System.out.println(String.join(" ", elements));
    }

    public boolean hasNext() {
        return index < elements.size() - 1;
    }

    public void print() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(this.elements.get(index));
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return index < elements.size();
            }

            @Override
            public String next() {
                return elements.get(index++);
            }
        };
    }
}
