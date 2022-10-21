package com.sahland;

import java.io.Serializable;
import java.util.*;
import java.util.HashMap;

import static java.util.Collections.addAll;

public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable {

    private transient HashMap<E,Object> map; // ключ элемента Set, а значение - object

    private static final Object PRESENT = new Object();

    public HashSet(){
        map = new HashMap<>();
    } //По-умолчанию стоит ёмкость - 16, коэф. нагрузки - 0.75

    //Ёмкость равна 16, а коэф. нагрузки - 0.75. Если ёмкость заполнена, то  она автоматически расширяется
    public HashSet(Collection<? extends E> c){
        map = new HashMap<>(Math.max((int) (c.size()/.75) + 1, 16));
        addAll(c);
    }


    public HashSet(int initialCapacity, float loadFactor) {
        map = new HashMap<>(initialCapacity, loadFactor); //initialCapacity - начальная ёмкость хэш-карты, loadFactor - коэф. нагрузки хэш-карты
    }

    public HashSet(int initialCapacity) {
        map = new HashMap<>(initialCapacity); //ёмкасть хэш-таблицы
    }

    //Добавляет тот элемент, который ещё не присутствует
    //Если в наборе уже содержится такой же элемент, то вызов оставляет без изменений и возвращает false
    //е - элементы которые нужно добавить в этот набор
    public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }

    //Удаляет указанный элемент из набора, если он присутствует
    public boolean remove(Object o) {
        return map.remove(o)==PRESENT;
    }

    //возвращает интератор по элементам
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    //Возвращает кол-во элементов в наборе
    public int size() {
        return map.size();
    }

    //Возращает true если набор не содержит элементов
    public boolean isEmpty() {
        return map.isEmpty();
    }

    //Возвращает true если набор содержит указанный элемент
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    //Удаляет вс элементы из набора
    public void clear() {
        map.clear();
    }

    //Копия экземпляра HashSet. Элементы не клонируются
    public Object clone() {
        try {
            HashSet<E> newSet = (HashSet<E>) super.clone();
            newSet.map = (HashMap<E, Object>) map.clone();
            return newSet;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
}
