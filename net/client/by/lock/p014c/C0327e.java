package net.client.by.lock.p014c;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Observable;
import net.client.by.lock.C0307a;
import net.client.by.lock.C0333c;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0341g;
import net.client.by.lock.p012d.C0342s;
import net.client.by.lock.p012d.C0343h;

/* compiled from: MyApp */
public class C0327e extends Observable {
    private static C0327e f1421a = new C0327e();
    private C0342s f1422b = new C0342s();
    private C0342s f1423c;
    private SparseArray f1424d;
    private SparseArray f1425e;
    private SparseArray f1426f;
    private final Comparator f1427g = new C0328f(this);
    private final Comparator f1428h = new C0329g(this);

    public C0327e() {
        this.f1422b.m2304a(true);
        this.f1423c = new C0342s();
        this.f1423c.m2304a(true);
        this.f1424d = new SparseArray();
        this.f1425e = new SparseArray();
        this.f1426f = new SparseArray();
        C0343h c0343h = new C0343h(new C0341g(0, "Friends"), this.f1427g);
        c0343h.m2304a(true);
        C0343h c0343h2 = new C0343h(new C0341g(0, "Friends"), this.f1428h);
        c0343h2.m2304a(true);
        this.f1424d.put(0, c0343h);
        this.f1425e.put(0, c0343h2);
        this.f1422b.m2306e().add(c0343h);
        this.f1423c.m2306e().add(c0343h2);
    }

    public synchronized void m2100a(C0341g c0341g) {
        C0343h c0343h = new C0343h(c0341g, this.f1427g);
        this.f1422b.m2306e().add(this.f1424d.size() - 1, c0343h);
        C0343h c0343h2 = new C0343h(c0341g, this.f1428h);
        this.f1423c.m2306e().add(this.f1425e.size() - 1, c0343h2);
        this.f1424d.put(c0341g.m2301a(), c0343h);
        c0343h.m2304a(true);
        this.f1425e.put(c0341g.m2301a(), c0343h2);
        c0343h2.m2304a(true);
        setChanged();
        notifyObservers();
    }

    public synchronized void m2096a(int i) {
        Object obj = (C0343h) this.f1424d.get(i);
        if (obj != null) {
            obj.m2309a();
            this.f1424d.remove(i);
            this.f1422b.m2306e().remove(obj);
        }
        obj = (C0343h) this.f1425e.get(i);
        if (obj != null) {
            obj.m2309a();
            this.f1425e.remove(i);
            this.f1423c.m2306e().remove(obj);
        }
        setChanged();
        notifyObservers();
    }

    public synchronized void m2099a(C0337c c0337c) {
        ((C0343h) this.f1424d.get(0)).m2311a(new C0342s(c0337c));
        ((C0343h) this.f1425e.get(0)).m2311a(new C0342s(c0337c));
        this.f1426f.put(c0337c.m2237K(), c0337c);
        setChanged();
        notifyObservers(c0337c);
    }

    public synchronized void m2104b(C0337c c0337c) {
        Iterator it = c0337c.m2241a().iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            C0343h c0343h = (C0343h) this.f1424d.get(num.intValue());
            if (c0343h != null) {
                c0343h.m2310a(c0337c.m2237K());
            }
            C0343h c0343h2 = (C0343h) this.f1425e.get(num.intValue());
            if (c0343h2 != null) {
                c0343h2.m2310a(c0337c.m2237K());
            }
        }
        ((C0343h) this.f1424d.get(0)).m2310a(c0337c.m2237K());
        ((C0343h) this.f1425e.get(0)).m2310a(c0337c.m2237K());
        this.f1426f.remove(c0337c.m2237K());
        C0333c.m2187c().m2189a(Integer.valueOf(c0337c.m2237K()), c0337c.m2229C());
        setChanged();
        notifyObservers();
    }

    public synchronized C0337c m2094a(Integer num) {
        return (C0337c) this.f1426f.get(num.intValue());
    }

    public synchronized C0343h m2101b(int i) {
        return (C0343h) this.f1424d.get(i);
    }

    public C0342s m2095a() {
        return this.f1422b;
    }

    public C0342s m2102b() {
        return this.f1423c;
    }

    public static synchronized C0327e m2092c() {
        C0327e c0327e;
        synchronized (C0327e.class) {
            if (f1421a == null) {
                f1421a = new C0327e();
                if (C0307a.f1342b != null) {
                    C0307a.f1342b.m2722b();
                }
            }
            c0327e = f1421a;
        }
        return c0327e;
    }

    public static void m2093d() {
        f1421a = null;
    }

    public synchronized ArrayList m2105e() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (int i = 0; i < this.f1424d.size(); i++) {
            arrayList.add((C0341g) ((C0343h) this.f1424d.get(this.f1424d.keyAt(i))).m2305d());
        }
        return arrayList;
    }

    public ArrayList m2106f() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f1426f.size(); i++) {
            arrayList.add((C0337c) this.f1426f.get(this.f1426f.keyAt(i)));
        }
        return arrayList;
    }

    public void m2107g() {
        for (int i = 0; i < this.f1426f.size(); i++) {
            ((C0337c) this.f1426f.get(this.f1426f.keyAt(i))).m2286v();
        }
    }

    public synchronized void m2097a(Integer num, Integer num2) {
        C0337c c0337c = (C0337c) this.f1426f.get(num.intValue());
        if (c0337c != null) {
            c0337c.m2246a(num2);
            C0343h c0343h = (C0343h) this.f1424d.get(num2.intValue());
            if (c0343h != null) {
                c0343h.m2311a(new C0342s(c0337c));
            }
            c0343h = (C0343h) this.f1425e.get(num2.intValue());
            if (c0343h != null) {
                c0343h.m2311a(new C0342s(c0337c));
            }
        }
        setChanged();
        notifyObservers();
    }

    public synchronized void m2103b(Integer num, Integer num2) {
        C0337c c0337c = (C0337c) this.f1426f.get(num.intValue());
        if (c0337c != null) {
            c0337c.m2257b(num2);
            C0343h c0343h = (C0343h) this.f1424d.get(num2.intValue());
            if (c0343h != null) {
                c0343h.m2310a(num.intValue());
            }
            c0343h = (C0343h) this.f1425e.get(num2.intValue());
            if (c0343h != null) {
                c0343h.m2310a(num.intValue());
            }
        }
        setChanged();
        notifyObservers();
    }

    public synchronized void m2098a(Integer num, String str) {
        C0343h c0343h = (C0343h) this.f1424d.get(num.intValue());
        if (c0343h != null) {
            ((C0341g) c0343h.m2305d()).m2302a(str);
        }
        c0343h = (C0343h) this.f1425e.get(num.intValue());
        if (c0343h != null) {
            ((C0341g) c0343h.m2305d()).m2302a(str);
        }
        setChanged();
        notifyObservers();
    }

    public void m2108h() {
        if (C0307a.f1342b != null) {
            C0307a.f1342b.m2723c();
        }
        f1421a = null;
    }
}
