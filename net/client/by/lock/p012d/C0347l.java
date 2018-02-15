package net.client.by.lock.p012d;

import java.util.Iterator;
import java.util.StringTokenizer;
import net.client.by.lock.gui.p017a.C0376a;
import net.client.by.lock.gui.p017a.C0386j;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p016f.C0363h;
import net.client.by.lock.p016f.C0365j;
import net.client.by.lock.p016f.C0368m;

/* compiled from: MyApp */
public class C0347l extends C0346m {
    private C0363h f1515o;
    private char[] f1516p = new char[5];

    public C0347l(C0337c c0337c, String str, String str2, byte[] bArr, boolean z) {
        m1918b(c0337c);
        this.a = str;
        m1919d(str2);
        this.f.m2468a((Object) "IDLE");
        this.j = bArr;
        this.b = "";
        this.f1515o = new C0363h(Boolean.valueOf(z), "isRead");
        try {
            this.b = new String(C0351r.m2359i().m2394p().m2355b(bArr), "UTF-8");
        } catch (Exception e) {
            this.b = "<No Subject>";
        }
        this.f1516p = C0368m.m2488a(C0351r.m2359i().m2391m());
    }

    public boolean b_() {
        return false;
    }

    public synchronized void m2329b() {
        this.f1515o.m2468a(Boolean.valueOf(true));
        C0351r.m2359i().m2364a(this.a);
    }

    public void m2328a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.j = bArr;
        this.k = bArr2;
        this.m = bArr3;
    }

    public void m2330c() {
        C0332j.m2148a().m2164a(this);
    }

    public boolean m2331d() {
        if (!(this.e == null || this.j == null || this.k == null || this.l == null)) {
            try {
                Iterator it = this.n.iterator();
                while (it.hasNext()) {
                    if (!((C0334a) it.next()).m2207k()) {
                        return false;
                    }
                }
                byte[] b = C0351r.m2359i().m2394p().m2355b(this.j);
                byte[] b2 = C0351r.m2359i().m2394p().m2355b(this.k);
                byte[] bArr = new byte[0];
                if (this.l.length > 0) {
                    bArr = C0351r.m2359i().m2394p().m2355b(this.l);
                }
                if (!(b == null || b2 == null || bArr == null)) {
                    this.b = new String(b, "UTF-8");
                    this.c = new String(b2, "UTF-8");
                    StringTokenizer stringTokenizer = new StringTokenizer(new String(bArr, "UTF-8"), ",");
                    while (stringTokenizer.hasMoreTokens()) {
                        try {
                            this.i.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
                        } catch (Exception e) {
                        }
                    }
                    return true;
                }
            } catch (Throwable e2) {
                C0365j.m2476a("", e2);
                this.b = null;
                this.c = null;
            }
        }
        return false;
    }

    public void mo319z() {
        C0332j.m2148a().m2185f(this.a);
    }

    public char[] m2332e() {
        return this.f1516p;
    }

    public C0376a mo317A() {
        if (this.h == null) {
            this.h = new C0386j(this);
        }
        return this.h;
    }

    public boolean m2333f() {
        return ((Boolean) this.f1515o.m2467a()).booleanValue();
    }
}
