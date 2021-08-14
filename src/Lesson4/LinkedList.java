package Lesson4;

import java.util.Iterator;

public interface LinkedList<T>  {

    void insertFirst(T name);

    T removeFirst();

    boolean remove(T name);

    boolean contains(T name);

    int size();

    boolean isEmpty();

    void display();

    T getFirst();

    void forEach();

    class People<T> {
        public T item;
        People<T> next;
        People<T> previous;

        public People(T item, People<T> next) {
            this(item, next, null);
        }

        public People(T item, People<T> next, People<T> previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }

    }
}
