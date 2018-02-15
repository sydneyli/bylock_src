package net.client.by.lock.p014c;

import android.os.AsyncTask;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicBoolean;
import net.client.by.lock.p011a.C0289c;
import net.client.by.lock.p011a.C0297k;
import net.client.by.lock.p011a.C0299m;
import net.client.by.lock.p011a.C0301o;
import net.client.by.lock.p011a.C0303q;
import net.client.by.lock.p011a.C0305s;
import net.client.by.lock.p011a.C0306t;
import net.client.by.lock.p016f.C0365j;

/* compiled from: MyApp */
public class C0324b {
    public static AtomicBoolean f1410a = new AtomicBoolean(false);
    private static DatagramSocket f1411b = null;
    private static AsyncTask f1412c = null;
    private static AsyncTask f1413d = null;
    private static C0306t f1414e;
    private static C0305s f1415f;

    public static void m2085a(C0289c c0289c, int i, boolean z) {
        f1410a.set(false);
        try {
            InetAddress byName = InetAddress.getByName("46.166.164.181");
            f1414e = new C0306t();
            f1414e.m2000a();
            f1415f = new C0305s();
            f1415f.m1994a();
            try {
                f1411b = new DatagramSocket();
                f1411b.connect(byName, i);
                if (z) {
                    f1412c = new C0303q(f1411b, f1414e, c0289c.m1942d(), c0289c.m1941c(), c0289c.m1943e(), c0289c.m1955q());
                    f1413d = new C0299m(f1411b, f1415f, c0289c.m1942d(), c0289c.m1941c(), c0289c.m1943e());
                } else {
                    f1412c = new C0301o(f1411b, f1414e, c0289c.m1942d(), c0289c.m1941c(), c0289c.m1943e(), c0289c.m1955q());
                    f1413d = new C0297k(f1411b, f1415f, c0289c.m1942d(), c0289c.m1941c(), c0289c.m1943e());
                }
                if (z) {
                    ((C0299m) f1413d).f1295f.start();
                    ((C0303q) f1412c).f1332l.start();
                } else {
                    ((C0297k) f1413d).f1280f.start();
                    ((C0301o) f1412c).f1316o.start();
                }
                if (z) {
                    ((C0299m) f1413d).m1985a();
                    ((C0303q) f1412c).m1993a();
                    return;
                }
                ((C0297k) f1413d).m1981a();
                ((C0301o) f1412c).m1989a();
            } catch (Throwable e) {
                C0365j.m2476a("CallThreadsManager", e);
                f1415f.m1996b();
                f1414e.m2001b();
                c0289c.m1958t();
            }
        } catch (Throwable e2) {
            C0365j.m2476a("CallThreadsManager", e2);
            c0289c.m1958t();
        }
    }

    public static void m2084a() {
        f1415f = null;
        f1414e = null;
        if (f1411b != null) {
            f1411b.close();
        }
        f1412c = null;
        f1413d = null;
    }
}
