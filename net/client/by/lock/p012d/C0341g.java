package net.client.by.lock.p012d;

import net.client.by.lock.p016f.C0363h;

/* compiled from: MyApp */
public class C0341g extends C0336p {
    private int f1494a;
    private C0363h f1495b = new C0363h("nameProperty");

    public C0341g(int i, String str) {
        this.f1494a = i;
        this.f1495b.m2468a((Object) str);
    }

    public int m2301a() {
        return this.f1494a;
    }

    public C0363h m2303b() {
        return this.f1495b;
    }

    public void m2302a(String str) {
        this.f1495b.m2468a((Object) str);
    }

    public String toString() {
        return (String) this.f1495b.m2467a();
    }
}
