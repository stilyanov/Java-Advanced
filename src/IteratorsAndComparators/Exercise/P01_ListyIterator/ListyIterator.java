package IteratorsAndComparators.Exercise.P01_ListyIterator;

import java.util.List;

public class ListyIterator {
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

    public boolean hasNext() {
        return index < elements.size() - 1;
    }

    public void print() {
        if (elements.isEmpty()){
            throw new IllegalStateException("Invalid Operation!");
        } else {
            System.out.println(elements.get(index));
        }
    }
}
