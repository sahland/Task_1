package com.sahland;

public interface MultiSet <E> {

    void add(E elem); //Добавить элемент в мультисет

    void remove(E elem); //Удалить объект из мультисета

    void union(MultiSet<E> other); //Объединение одного мультисета с другим

    void intersect(MultiSet<E> other); //Пересечение одного мультисета с другим

    int getMultiplicity(E elem); //Возвращает кратность элемента. Если его нет, то возвращает 0

    boolean contains(E elem); //Проверка на содержание элемента

    int numberOfUniqueElements(); //Счётчик кол-ва уникальных элементов

    int size(); //Размер мультисета с повторяющимеся элементами

    java.util.Set<E> toSet(); //Набор уникальных элементов без повторов
}
