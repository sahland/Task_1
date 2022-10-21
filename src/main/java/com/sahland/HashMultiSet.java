package com.sahland;

public class HashMultiSet<E> implements MultiSet<E> {

    private java.util.Map<E, Integer> map = new java.util.HashMap<>();

    @Override
    public void add(E elem) {
        int multiplicity = 1;

        if (map.containsKey(elem)) {
            map.put(elem, getMultiplicity(elem) + 1);
            return;
        }
        map.put(elem, multiplicity);
    }

    @Override
    public void remove(E elem) {
        if (map.containsKey(elem)) {
            map.put(elem, getMultiplicity(elem) - 1);
            if (getMultiplicity(elem) == 0) {
                map.remove(elem, 0);
            }
        }
    }

    @Override
    public void union(MultiSet<E> other) {
        for (E e : other.toSet())
            if (getMultiplicity(e) != 0)
                map.put(e, Math.max(getMultiplicity(e), other.getMultiplicity(e)));
            else
                map.put(e, other.getMultiplicity(e));
    }

    @Override
    public void intersect(MultiSet<E> other) {
        if (other.size() != 0) {
            for (E e : new java.util.HashSet<>(toSet()))
                if (other.getMultiplicity(e) != 0)
                    map.put(e, Math.min(getMultiplicity(e), other.getMultiplicity(e)));
                else
                    remove(e);
        } else
            map.clear();
    }

    @Override
    public int getMultiplicity(E elem) {
        return map.getOrDefault(elem, 0);
    }

    @Override
    public boolean contains(E elem) {
        return map.containsKey(elem);
    }

    @Override
    public int numberOfUniqueElements() {
        return map.size();
    }

    @Override
    public int size() {
        int size = 0;
        for (int i : map.values()) {
            size += i;
        }
        return size;
    }

    @Override
    public java.util.Set<E> toSet() {
        return map.keySet();
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
