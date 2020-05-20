package ru.ifmo.collections;

import java.util.*;

/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 *
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 *
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */
public class SortedSet<T> extends AbstractSet<T> {
    private final Map<T, Object> contents;

    private SortedSet(Map<T, Object> data) {
        contents = data;
    }

    public static <T> SortedSet<T> create() {
        return new SortedSet<>(new TreeMap<>());
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet<>(new TreeMap<>(comparator));
    }

    public List<T> getSorted() {
        return new ArrayList<>(contents.keySet());
    }

    public List<T> getReversed() {
        List<T> data = new ArrayList<>(contents.keySet());
        Collections.reverse(data);
        return data;
    }

    @Override
    public Iterator<T> iterator() {
        return contents.keySet().iterator();
    }

    @Override
    public int size() {
        return contents.size();
    }

    @Override
    public boolean add(T val) {
        return contents.put(val, null) == null;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        int count = contents.size();
        for (T i : collection) {
            add(i);
        }
        return count != contents.size();
    }

    @Override
    public boolean remove(Object o) {
        return contents.remove(o, null);
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        int count = contents.size();
        for (Object i : collection) {
            remove(i);
        }
        return count != contents.size();
    }
}
