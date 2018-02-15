package net.client.by.lock.p014c;

import java.io.File;
import java.util.ArrayList;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p013b.C0315h;
import net.client.by.lock.p016f.C0362g;

/* compiled from: MyApp */
public class C0326d {
    private static C0326d f1418c = null;
    C0362g f1419a = new C0362g();
    C0362g f1420b = new C0362g();

    private C0326d() {
    }

    public static C0326d m2089a() {
        if (f1418c == null) {
            f1418c = new C0326d();
        }
        return f1418c;
    }

    public void m2090a(C0337c c0337c, File file) {
        C0315h c0315h = new C0315h(file);
        ArrayList arrayList = new ArrayList();
        arrayList.add(c0337c);
        c0315h.m2059a(arrayList);
        this.f1420b.add(c0315h);
        c0315h.m2061m();
    }

    public C0362g m2091b() {
        return this.f1419a;
    }
}
