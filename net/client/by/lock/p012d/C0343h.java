package net.client.by.lock.p012d;

import java.util.Comparator;
import java.util.Iterator;
import net.client.by.lock.p016f.C0363h;

/* compiled from: MyApp */
public class C0343h extends C0342s {
    private C0363h f1499a;
    private C0363h f1500b;
    private C0344i f1501c;
    private C0345j f1502d = new C0345j();
    private Comparator f1503e;

    public C0343h(C0341g c0341g, Comparator comparator) {
        super(c0341g);
        this.f1503e = comparator;
        this.f1499a = new C0363h(Integer.valueOf(0), "totalCountProperty");
        this.f1500b = new C0363h(Integer.valueOf(0), "onlineCountProperty");
        this.f1501c = new C0344i();
    }

    public synchronized void m2311a(C0342s c0342s) {
        if (c0342s.m2305d() instanceof C0337c) {
            C0337c c0337c = (C0337c) c0342s.m2305d();
            m2306e().add(c0342s);
            c0337c.m2249a(this.f1501c);
            if (((Boolean) c0337c.m2281q().m2467a()).booleanValue()) {
                this.f1500b.m2468a(Integer.valueOf(((Integer) this.f1500b.m2467a()).intValue() + 1));
            }
            c0337c.m2236J().addObserver(this.f1502d);
            c0337c.m2232F().addObserver(this.f1502d);
            this.f1502d.update(null, null);
            this.f1499a.m2468a(Integer.valueOf(((Integer) this.f1499a.m2467a()).intValue() + 1));
        }
    }

    public synchronized void m2310a(int i) {
        Iterator it = m2306e().iterator();
        while (it.hasNext()) {
            C0342s c0342s = (C0342s) it.next();
            if (((C0337c) c0342s.m2305d()).m2237K() == i) {
                break;
            }
        }
        Object obj = null;
        if (obj != null && m2306e().remove(obj)) {
            C0337c c0337c = (C0337c) obj.m2305d();
            c0337c.m2259b(this.f1501c);
            if (((Boolean) c0337c.m2281q().m2467a()).booleanValue()) {
                c0337c.m2281q().m2468a(Boolean.valueOf(false));
            }
            this.f1501c.update(c0337c.m2281q(), null);
            c0337c.m2236J().deleteObserver(this.f1502d);
            c0337c.m2232F().deleteObserver(this.f1502d);
            this.f1499a.m2468a(Integer.valueOf(((Integer) this.f1499a.m2467a()).intValue() - 1));
        }
    }

    public synchronized void m2309a() {
        for (C0342s d : (C0342s[]) m2306e().toArray(new C0342s[0])) {
            m2310a(((C0337c) d.m2305d()).m2237K());
        }
    }

    public C0363h m2312b() {
        return this.f1499a;
    }

    public C0363h m2313c() {
        return this.f1500b;
    }
}
