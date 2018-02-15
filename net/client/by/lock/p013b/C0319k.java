package net.client.by.lock.p013b;

import java.util.HashMap;
import java.util.Iterator;
import net.client.by.lock.p016f.C0362g;

/* compiled from: MyApp */
public class C0319k {
    private static C0319k f1399a = new C0319k();
    private C0362g f1400b = new C0362g();
    private HashMap f1401c = new HashMap();

    private C0319k() {
    }

    public synchronized void m2072a(C0308a c0308a) {
        if (this.f1401c.get(c0308a.mo322b()) == null) {
            this.f1400b.add(c0308a);
            this.f1401c.put(c0308a.mo322b(), Integer.valueOf(1));
        } else {
            this.f1401c.put(c0308a.mo322b(), Integer.valueOf(((Integer) this.f1401c.get(c0308a.mo322b())).intValue() + 1));
        }
    }

    public synchronized void m2071a(String str) {
        Integer num = (Integer) this.f1401c.get(str);
        if (num != null) {
            if (num.intValue() == 1) {
                this.f1401c.remove(str);
                Iterator it = this.f1400b.iterator();
                while (it.hasNext()) {
                    C0308a c0308a = (C0308a) it.next();
                    if (c0308a.mo322b().equals(str)) {
                        break;
                    }
                }
                Object obj = null;
                if (obj != null) {
                    this.f1400b.remove(obj);
                }
            } else {
                this.f1401c.put(str, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized C0362g m2070a() {
        return this.f1400b;
    }

    public static C0319k m2069b() {
        return f1399a;
    }

    public C0308a m2073b(String str) {
        Iterator it = this.f1400b.iterator();
        while (it.hasNext()) {
            C0308a c0308a = (C0308a) it.next();
            if (c0308a.mo322b().equals(str)) {
                return c0308a;
            }
        }
        return null;
    }
}
