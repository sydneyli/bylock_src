package net.client.by.lock.p016f;

import java.util.Observable;
import java.util.Observer;

/* compiled from: MyApp */
public class C0363h extends Observable {
    protected Object f1555a = null;
    protected Object f1556b = null;
    protected String f1557c;
    private Object f1558d = new Object();
    private Observer f1559e;

    public C0363h(String str) {
        this.f1557c = str;
        this.f1559e = new C0364i();
    }

    public C0363h(Object obj, String str) {
        this.f1555a = obj;
        this.f1557c = str;
        this.f1559e = new C0364i();
    }

    public Object m2467a() {
        return this.f1555a;
    }

    public Object m2470b() {
        return this.f1556b;
    }

    public void m2468a(Object obj) {
        synchronized (this.f1558d) {
            this.f1556b = this.f1555a;
            this.f1555a = obj;
        }
        setChanged();
        notifyObservers(this.f1557c);
    }

    public void m2469a(C0363h c0363h) {
        c0363h.addObserver(this.f1559e);
    }

    public String toString() {
        return this.f1555a.toString();
    }
}
