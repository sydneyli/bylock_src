package net.client.by.lock.p016f;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Observable;

/* compiled from: MyApp */
public class C0362g extends Observable implements List {
    private ArrayList f1554a = new ArrayList();

    public boolean add(Object obj) {
        boolean add = this.f1554a.add(obj);
        setChanged();
        notifyObservers(obj);
        return add;
    }

    public void add(int i, Object obj) {
        this.f1554a.add(i, obj);
        setChanged();
        notifyObservers(obj);
    }

    public boolean addAll(Collection collection) {
        boolean addAll = this.f1554a.addAll(collection);
        setChanged();
        notifyObservers(collection);
        return addAll;
    }

    public boolean addAll(int i, Collection collection) {
        boolean addAll = this.f1554a.addAll(i, collection);
        setChanged();
        notifyObservers(Integer.valueOf(i));
        return addAll;
    }

    public void clear() {
        this.f1554a.clear();
        setChanged();
        notifyObservers();
    }

    public boolean contains(Object obj) {
        return this.f1554a.contains(obj);
    }

    public boolean containsAll(Collection collection) {
        return this.f1554a.containsAll(collection);
    }

    public Object get(int i) {
        return this.f1554a.get(i);
    }

    public int indexOf(Object obj) {
        return this.f1554a.indexOf(obj);
    }

    public boolean isEmpty() {
        return this.f1554a.isEmpty();
    }

    public Iterator iterator() {
        return this.f1554a.iterator();
    }

    public int lastIndexOf(Object obj) {
        return this.f1554a.lastIndexOf(obj);
    }

    public ListIterator listIterator() {
        return this.f1554a.listIterator();
    }

    public ListIterator listIterator(int i) {
        return this.f1554a.listIterator(i);
    }

    public Object remove(int i) {
        Object remove = this.f1554a.remove(i);
        hasChanged();
        notifyObservers();
        return remove;
    }

    public boolean remove(Object obj) {
        boolean remove = this.f1554a.remove(obj);
        hasChanged();
        notifyObservers();
        return remove;
    }

    public boolean removeAll(Collection collection) {
        boolean removeAll = this.f1554a.removeAll(collection);
        hasChanged();
        notifyObservers();
        return removeAll;
    }

    public boolean retainAll(Collection collection) {
        boolean retainAll = this.f1554a.retainAll(collection);
        hasChanged();
        notifyObservers();
        return retainAll;
    }

    public Object set(int i, Object obj) {
        Object obj2 = this.f1554a.set(i, obj);
        hasChanged();
        notifyObservers();
        return obj2;
    }

    public int size() {
        return this.f1554a.size();
    }

    public List subList(int i, int i2) {
        return this.f1554a.subList(i, i2);
    }

    public Object[] toArray() {
        return this.f1554a.toArray();
    }

    public Object[] toArray(Object[] objArr) {
        return this.f1554a.toArray(objArr);
    }
}
