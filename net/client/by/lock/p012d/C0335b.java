package net.client.by.lock.p012d;

import net.client.by.lock.gui.p017a.C0376a;
import net.client.by.lock.gui.p017a.C0382g;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p016f.C0365j;

/* compiled from: MyApp */
public class C0335b extends C0288k {
    private Integer f1460a;
    private String f1461b = null;
    private byte[] f1462c = null;
    private byte[] f1463i = null;

    public C0335b(C0337c c0337c, String str) {
        super.m1918b(c0337c);
        this.f1461b = str;
        m1917a(true);
    }

    public C0335b(C0337c c0337c, Integer num, byte[] bArr, byte[] bArr2, String str) {
        this.f1460a = num;
        super.m1918b(c0337c);
        m1919d(str);
        this.f1462c = bArr;
        this.f1463i = bArr2;
        m1917a(false);
    }

    protected String mo318a() {
        return this.f1461b;
    }

    public String m2211b() {
        return this.f1461b;
    }

    public Integer m2212c() {
        return this.f1460a;
    }

    public void m2213d() {
        C0332j.m2148a().m2160a(this);
    }

    public byte[] m2214e() {
        return this.f1462c;
    }

    public byte[] m2215f() {
        return this.f1463i;
    }

    public void m2210a(byte[] bArr) {
        this.f1463i = bArr;
    }

    public boolean m2216g() {
        if (this.e == null || this.f1461b == null) {
            return false;
        }
        try {
            this.f1462c = this.e.m2285u().m2299a(this.f1461b.getBytes("UTF-8"));
            if (this.f1462c != null) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            C0365j.m2476a("", e);
            this.f1462c = null;
            return false;
        }
    }

    public boolean m2217h() {
        if (this.f1462c != null) {
            try {
                byte[] b = C0351r.m2359i().m2394p().m2355b(this.f1462c);
                if (b != null) {
                    this.f1461b = new String(b, "UTF-8");
                    return true;
                }
            } catch (Throwable e) {
                C0365j.m2476a("", e);
                this.f1461b = "";
            }
        }
        return false;
    }

    public void mo319z() {
        if (!b_()) {
            C0332j.m2148a().m2171b(this);
        }
    }

    public C0376a mo317A() {
        if (this.h == null) {
            this.h = new C0382g(this);
        }
        return this.h;
    }
}
