package edu.hw3.Task8;

import java.util.Iterator;
import java.util.List;

public class BackwardIterator<T> implements Iterator<T> {
    private final List<T> list;
    private int listSize;

    public BackwardIterator(List<T> list) {
        this.list = list;
        this.listSize = list.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return listSize > -1;
    }

    @Override
    public T next() {
        listSize--;
        return list.get(listSize + 1);
    }
}
