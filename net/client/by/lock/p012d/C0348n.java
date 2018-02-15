package net.client.by.lock.p012d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.client.by.lock.gui.activity.aw;
import net.client.by.lock.gui.p017a.C0376a;
import net.client.by.lock.gui.p017a.C0390o;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p016f.C0365j;

/* compiled from: MyApp */
public class C0348n extends C0346m {
    ArrayList f1517o;
    C0348n f1518p;
    private boolean f1519q;
    private boolean f1520r;

    public C0348n() {
        this.f1517o = null;
        this.f1518p = null;
        this.f1517o = new ArrayList();
        m1920e("IDLE");
        this.f1519q = false;
        this.f1520r = false;
        this.a = UUID.randomUUID().toString();
    }

    public C0348n(List list, String str, String str2, List list2) {
        this.f1517o = null;
        this.f1518p = null;
        this.f1517o = new ArrayList();
        this.b = str;
        this.c = str2;
        this.a = UUID.randomUUID().toString();
        for (C0334a a : list2) {
            super.m2315a(a);
        }
        for (C0337c c0348n : list) {
            this.f1517o.add(new C0348n(this, c0348n, list));
        }
        m1920e("IDLE");
        this.f1519q = false;
        this.f1520r = false;
    }

    private C0348n(C0348n c0348n, C0337c c0337c, List list) {
        this.f1517o = null;
        this.f1518p = null;
        this.f1518p = c0348n;
        m1918b(c0337c);
        for (C0337c c0337c2 : list) {
            if (c0337c2 != c0337c) {
                this.i.add(Integer.valueOf(c0337c2.m2237K()));
            }
        }
        this.b = c0348n.m2319h();
        this.c = c0348n.m2318g();
        this.f.m2469a(c0348n.m1914F());
        this.d.m2469a(c0348n.m1911C());
        this.a = c0348n.m2321j();
        Iterator it = c0348n.m2324m().iterator();
        while (it.hasNext()) {
            m2315a(new C0334a((C0334a) it.next()));
        }
    }

    public ArrayList m2337b() {
        if (this.f1518p != null) {
            return this.f1518p.m2337b();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f1517o.iterator();
        while (it.hasNext()) {
            arrayList.add(((C0348n) it.next()).m1913E());
        }
        return arrayList;
    }

    public ArrayList m2339c() {
        return this.f1517o;
    }

    public void m2338b(boolean z) {
        this.f1520r = z;
    }

    public boolean m2340d() {
        return this.f1520r;
    }

    public boolean b_() {
        return true;
    }

    public boolean m2341e() {
        if (this.f1519q) {
            return true;
        }
        this.f1520r = false;
        Iterator it;
        if (this.f1517o == null) {
            boolean z;
            if (!(this.b == null || this.c == null || this.e == null || this.e.m2285u() == null)) {
                this.j = this.e.m2285u().m2299a(this.b.getBytes("UTF-8"));
                this.k = this.e.m2285u().m2299a(this.c.getBytes("UTF-8"));
                String str = "";
                if (this.i.size() > 0) {
                    str = new StringBuilder(String.valueOf(str)).append(this.i.get(0)).toString();
                    int i = 1;
                    while (i < this.i.size()) {
                        try {
                            String stringBuilder = new StringBuilder(String.valueOf(str)).append(",").append(this.i.get(i)).toString();
                            i++;
                            str = stringBuilder;
                        } catch (Throwable e) {
                            C0365j.m2476a("", e);
                            this.j = null;
                            this.k = null;
                        }
                    }
                }
                if (str.length() > 0) {
                    this.l = this.e.m2285u().m2299a(str.getBytes("UTF-8"));
                } else {
                    this.l = new byte[0];
                }
                it = this.n.iterator();
                do {
                    if (it.hasNext()) {
                    }
                } while (((C0334a) it.next()).m2197a(this.e.m2285u()));
                this.f1519q = false;
                return false;
            }
            if (this.j == null || this.k == null || this.l == null) {
                z = false;
            } else {
                z = true;
            }
            this.f1519q = z;
            return this.f1519q;
        }
        it = this.f1517o.iterator();
        while (it.hasNext()) {
            if (!((C0348n) it.next()).m2341e()) {
                this.f1519q = false;
                return false;
            }
        }
        this.f1519q = true;
        return true;
    }

    public void m2336a(aw awVar) {
        Iterator it = this.f1517o.iterator();
        while (it.hasNext()) {
            C0288k c0288k = (C0348n) it.next();
            c0288k.m1913E().m2261b(c0288k);
        }
        C0332j.m2148a().m2165a(this, awVar);
    }

    public void mo319z() {
    }

    public C0376a mo317A() {
        if (this.h == null) {
            this.h = new C0390o(this);
        }
        return this.h;
    }
}
