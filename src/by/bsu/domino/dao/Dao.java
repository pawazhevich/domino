package by.bsu.domino.dao;

import java.util.ArrayList;

public abstract class Dao<T> {
    public abstract void insert(T object);
    public abstract T getById(int id);
    public abstract void update(T object);
    public abstract void delete(T object);
    public abstract ArrayList<T> getAll();
}

