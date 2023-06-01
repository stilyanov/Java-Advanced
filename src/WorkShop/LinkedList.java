package WorkShop;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class LinkedList {
    class ListNode {
        int element;
        ListNode next;
        ListNode previous;

        public ListNode(int element) {
            this.element = element;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    //void addFirst(int element) – adds an element at the beginning of the collection
    public void addFirst(int element) {
        ListNode newNode = new ListNode(element);

        if (this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.previous = newNode;
            this.head = newNode;
        }
        size++;
    }
    //void addLast(int element) – adds an element at the end of the collection
    public void addLast(int element) {
        ListNode newNode = new ListNode(element);

        if (this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            newNode.previous = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        size++;
    }
    //int get(int index) - Returns the element at the specified position in this list
    public int get(int index) {
        checkIndex(index);

        ListNode currentNude;
        if (index <= this.size / 2) {
            currentNude = this.head;
            for (int i = 0; i < index; i++) {
                currentNude = currentNude.next;
            }
        } else {
            currentNude = this.tail;
            for (int i = this.size - 1; i > index; i--) {
                currentNude = currentNude.previous;
            }
        }
        return currentNude.element;
    }
    //int removeFirst() – removes the element at the beginning of the collection
    private int removeFirst() {
        checkEmpty();
        int firstElement = this.head.element;
        this.head = this.head.next;

        if (this.head == null) {
            //single element
            this.tail = null;
        } else {
            //Multiple elements
            this.head.previous = null;
        }
        this.size--;
        return firstElement;
    }
    //int removeLast() – removes the element at the end of the collection
    private int removeLast() {
        checkEmpty();
        int lastElement = this.tail.element;

        this.tail = this.tail.previous;
        if (this.tail == null) {
            //single element
            this.head = null;
        } else {
            //Multiple elements
            this.tail.next = null;
        }

        this.size--;
        return lastElement;
    }
    //void forEach() – goes through the collection and executes a given action
    public void forEach(Consumer<Integer> consumer) {
        ListNode currentNode = this.head;
        while (currentNode != null) {
            consumer.accept(currentNode.element);
            currentNode = currentNode.next;
        }
    }
    //int[] toArray() – returns the collection as an array
    public int[] toArray(){
        int[] array = new int[this.size];
        int i = 0;

        ListNode currentNode = this.head;
        while (currentNode != null) {
            array[i++] = currentNode.element;
            currentNode = currentNode.next;
        }
        return array;
    }
    private void checkEmpty() {
        if (this.size == 0) {
            throw new NoSuchElementException("List is empty!");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(String.format("Index %d is out of bounds for size %d", index, size));
        }
    }
}
