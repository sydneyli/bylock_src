package net.client.by.lock.p014c;

import java.util.Comparator;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0342s;

/* compiled from: MyApp */
class C0328f implements Comparator {
    final /* synthetic */ C0327e f1429a;

    C0328f(C0327e c0327e) {
        this.f1429a = c0327e;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m2109a((C0342s) obj, (C0342s) obj2);
    }

    public int m2109a(C0342s c0342s, C0342s c0342s2) {
        if ((c0342s.m2305d() instanceof C0337c) && (c0342s2.m2305d() instanceof C0337c)) {
            return ((C0337c) c0342s.m2305d()).m2240a((C0337c) c0342s2.m2305d());
        }
        return 0;
    }
}
