package Lesson4;

import Lesson4.SimpleLinkedListImplEx1;
import Lesson4.TwoSideLinkedList;

import java.util.Iterator;

public class TwoSideLinkedListImplEx2<E> extends SimpleLinkedListImplEx1<E> implements TwoSideLinkedList<E> {
    protected People<E> lastPeople;

    static class DequeListEx2 {
        private TwoSideLinkedListImplEx2 list;

        public DequeListEx2() {
            list = new TwoSideLinkedListImplEx2();
        }

        public void pushFront(String name) {
            list.insertFirst(name);
        }

        public void pushBack(String name) {
            list.insertLast(name);
        }

        public void popFront() {
            list.removeFirst();
        }

        public void popBack() {
            list.removeLast();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public void display() {
            list.display();
        }
    }

    @Override
    public void insertFirst(E name) {
        super.insertFirst(name);
        if (size == 1) {
            lastPeople = firstPeople;
        }
    }

    @Override
    public void insertLast(E name) {
        People<E> newPeople = new People<>(name, null);

        if (isEmpty()) {
            firstPeople = newPeople;
        } else {
            lastPeople.next = newPeople;
        }

        lastPeople = newPeople;
        size++;
    }

    @Override
    public E getLast() {
        return getValue(lastPeople);
    }


    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();
        if (isEmpty()) {
            lastPeople = null;
        }
        return removedValue;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (lastPeople == firstPeople) {
            return null;
        }

        People<E> removedPeople = lastPeople;
        People<E> preRemovedPeople = null;
        People<E> tempPeople = firstPeople;
        while (tempPeople != lastPeople && tempPeople != null) {
            preRemovedPeople = tempPeople;
            tempPeople = tempPeople.next;
        }

        removedPeople.next = null;
        assert preRemovedPeople != null;
        preRemovedPeople.next = null;

        size--;
        return removedPeople.item;
    }

    @Override
    public boolean remove(E value) {
        People<E> current = firstPeople;
        People<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        } else if (current == firstPeople) {
            removeFirst();
            return true;
        } else if (current == lastPeople) {
            lastPeople = previous;
            previous.next = null;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;
        return true;
    }
}
