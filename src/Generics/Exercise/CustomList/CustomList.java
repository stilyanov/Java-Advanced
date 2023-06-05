package Generics.Exercise.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }
    public int size() {
        return this.list.size();
    }
    public T get(int index) {
        return this.list.get(index);
    }

    public void add(T element) {
        list.add(element);
    }

    public void remove(int index) {
        list.remove(index);
    }

    public boolean contains(T element) {
        return list.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(list, firstIndex, secondIndex);
    }

    public int countGreaterThan(T element) {
        return (int) list.stream().filter(e -> e.compareTo(element) > 0).count();
    }
    public T getMax(){
        return list.stream().max(Comparable::compareTo).get();
    }
    public T getMin(){
        return list.stream().min(Comparable::compareTo).get();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        list.forEach(e -> sb.append(e.toString()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
