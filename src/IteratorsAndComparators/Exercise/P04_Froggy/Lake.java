package IteratorsAndComparators.Exercise.P04_Froggy;


import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private List<Integer> lakes;

    public Lake(Integer... elements) {
        this.lakes = List.of(elements);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    public class Frog implements Iterator<Integer> {
        private int index = 0;
        private boolean firstRoundFinished = false;


        @Override
        public boolean hasNext() {
            return index < lakes.size();
        }

        @Override
        public Integer next() {
            Integer element = lakes.get(index);
            index += 2;
            if (index >= lakes.size() && !firstRoundFinished) {
                index = 1;
                firstRoundFinished = true;
            }
            return element;
        }
    }
}
