package io.github.javaasasecondlanguage.lecture03.practice1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Classic LIFO stack
 *
 * @param <E> the type of elements in stack
 */
public class Stack<E> {
    List<E> list = new ArrayList<>();

    public void push(E e) {
        list.add(0, e);
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.remove(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void popAll(Collection<? super E> dst) {//make it type safe
        while (!isEmpty()) {
            dst.add(pop());
        }
    }

    public void pushAll(Iterable<? extends E> src) {//make it type safe
        for (E e : src) {
            push(e);
        }
    }
}