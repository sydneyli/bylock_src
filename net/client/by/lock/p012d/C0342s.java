package net.client.by.lock.p012d;

import net.client.by.lock.p016f.C0362g;
import net.client.by.lock.p016f.C0363h;

/* compiled from: MyApp */
public class C0342s {
    private C0362g f1496a;
    private C0363h f1497b;
    private Object f1498c;

    public C0342s(Object obj) {
        this.f1496a = new C0362g();
        this.f1498c = obj;
        this.f1497b = new C0363h("isExpanded");
    }

    public C0342s() {
        this.f1496a = new C0362g();
        this.f1497b = new C0363h("isExpanded");
    }

    public Object m2305d() {
        return this.f1498c;
    }

    public C0362g m2306e() {
        return this.f1496a;
    }

    public void m2304a(boolean z) {
        this.f1497b.m2468a(Boolean.valueOf(z));
    }
}
