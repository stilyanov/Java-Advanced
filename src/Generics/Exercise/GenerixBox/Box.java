package Generics.Exercise.GenerixBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> data;

    public Box() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        data.add(element);
    }

    public static <T> void swap(List<T> boxList, int firstIndex, int secondIndex) {
        T firstElement = boxList.get(firstIndex);
        T secondElement = boxList.get(secondIndex);

        boxList.set(firstIndex, secondElement);
        boxList.set(secondIndex, firstElement);
    }

    public int countOfGreaterItems(T elementToCompare) {
        return (int) data.stream().filter(elementFromBox -> elementFromBox.compareTo(elementToCompare) > 0).count();
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.data.getClass().getName(), this.data);
    }
}
