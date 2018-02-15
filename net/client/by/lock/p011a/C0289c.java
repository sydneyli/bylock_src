package net.client.by.lock.p011a;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.client.by.lock.gui.p017a.C0376a;
import net.client.by.lock.gui.p017a.C0380e;
import net.client.by.lock.p012d.C0288k;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p014c.C0324b;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p016f.C0363h;

/* compiled from: MyApp */
public class C0289c extends C0288k {
    private SecretKeySpec f1250a;
    private IvParameterSpec f1251b;
    private int f1252c = 0;
    private C0363h f1253i;
    private byte[] f1254j;
    private byte[] f1255k;
    private byte[] f1256l;
    private byte[] f1257m = null;
    private byte[] f1258n;
    private C0290d f1259o;
    private boolean f1260p;

    private C0289c(C0337c c0337c, boolean z, String str, boolean z2) {
        m1918b(c0337c);
        m1917a(z);
        this.f1260p = z2;
        this.f1253i = new C0363h("0:00", "seconds");
        this.f = new C0363h("stateProperty");
        this.f.m2468a((Object) str);
        this.f1259o = new C0290d();
        c0337c.m2281q().addObserver(this.f1259o);
    }

    protected String mo318a() {
        return "Sesli Arama" + (((String) this.f.m2467a()).equals("CLOSED") ? " (" + ((String) this.f1253i.m2467a()) + ")" : "");
    }

    public C0363h m1938b() {
        return this.f1253i;
    }

    public void m1932a(IvParameterSpec ivParameterSpec) {
        this.f1251b = ivParameterSpec;
    }

    public void m1933a(SecretKeySpec secretKeySpec) {
        this.f1250a = secretKeySpec;
    }

    public IvParameterSpec m1941c() {
        return this.f1251b;
    }

    public SecretKeySpec m1942d() {
        return this.f1250a;
    }

    public byte[] m1943e() {
        return this.f1258n;
    }

    public void m1934a(byte[] bArr) {
        this.f1258n = bArr;
    }

    public byte[] m1944f() {
        return this.f1254j;
    }

    public byte[] m1945g() {
        return this.f1255k;
    }

    public byte[] m1946h() {
        return this.f1256l;
    }

    public void m1940b(byte[] bArr) {
        this.f1256l = bArr;
    }

    public static C0289c m1926a(C0337c c0337c, byte[] bArr, byte[] bArr2) {
        C0289c c0289c = new C0289c(c0337c, true, "CALLING", false);
        c0289c.m1933a(new SecretKeySpec(bArr, "AES"));
        c0289c.m1932a(new IvParameterSpec(bArr2));
        return c0289c;
    }

    public static C0289c m1927a(C0337c c0337c, byte[] bArr, byte[] bArr2, boolean z) {
        C0289c c0289c = new C0289c(c0337c, false, "RINGING", z);
        c0289c.m1928c(bArr);
        c0289c.m1934a(bArr2);
        return c0289c;
    }

    public static C0289c m1925a(C0337c c0337c) {
        return new C0289c(c0337c, false, "CALLEE BUSY", false);
    }

    public synchronized void m1947i() {
        if (m1937a("RINGING")) {
            C0332j.m2148a().m2170b(this);
        }
    }

    public synchronized void m1936a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        if (m1937a("RINGING")) {
            this.f.m2468a((Object) "ANSWERED");
            this.f1254j = bArr;
            this.f1255k = bArr2;
            this.f1256l = bArr3;
            if (m1961w() && m1913E().m2285u().m2294a(this)) {
                m1939b(i, this.f1260p);
            } else {
                m1958t();
            }
        }
    }

    public synchronized void m1931a(int i, boolean z) {
        if (m1937a("RINGING")) {
            this.f.m2468a((Object) "ANSWERED");
            m1939b(i, z);
        }
    }

    public synchronized void m1948j() {
        if (m1937a("RINGING")) {
            m1924H();
            this.f.m2468a((Object) "REJECTED");
            C0332j.m2148a().m2176c(this);
        }
    }

    public synchronized void m1949k() {
        if (m1937a("RINGING")) {
            m1924H();
            this.f.m2468a((Object) "REJECTED");
        }
    }

    public synchronized void m1950l() {
        if (m1937a("RINGING")) {
            m1924H();
            this.f.m2468a((Object) "MISSED");
        }
    }

    public synchronized void m1951m() {
        if (m1937a("RINGING") || m1937a("CALLING")) {
            m1924H();
            this.f.m2468a((Object) "CANCELED");
            C0332j.m2148a().m2180d(this);
        }
    }

    public synchronized void m1952n() {
        if (m1937a("RINGING")) {
            m1924H();
            this.f.m2468a((Object) "CANCELED");
        }
    }

    public synchronized void m1953o() {
        if (m1937a("CALLING")) {
            m1924H();
            this.f.m2468a((Object) "CALLER BUSY");
        }
    }

    public synchronized void m1954p() {
        if ((m1959u() && m1937a("CALLING")) || m1960v()) {
            m1924H();
            this.f.m2468a((Object) "CALLEE BUSY");
        }
    }

    public synchronized void m1935a(byte[] bArr, byte[] bArr2) {
        if (m1937a("CALLING")) {
            m1928c(bArr);
            m1934a(bArr2);
            this.f.m2468a((Object) "RINGING");
        }
    }

    private synchronized void m1928c(byte[] bArr) {
        this.f1257m = bArr;
    }

    public byte[] m1955q() {
        return this.f1257m;
    }

    public synchronized void m1956r() {
        if (m1937a("ANSWERED")) {
            m1963y();
            m1924H();
            this.f.m2468a((Object) "CLOSED");
            C0332j.m2148a().m2183e(this);
        }
    }

    public synchronized void m1957s() {
        if (m1937a("ANSWERED")) {
            m1963y();
            m1924H();
            this.f.m2468a((Object) "CLOSED");
        }
    }

    public synchronized void m1958t() {
        if (m1937a("ANSWERED")) {
            m1957s();
        }
        m1924H();
        this.f.m2468a((Object) "SOME ERROR");
    }

    public boolean m1959u() {
        return b_();
    }

    public boolean m1960v() {
        return !b_();
    }

    public boolean m1937a(String str) {
        return ((String) this.f.m2467a()).equalsIgnoreCase(str);
    }

    public synchronized boolean m1961w() {
        boolean z;
        byte[] b = C0351r.m2359i().m2394p().m2355b(this.f1254j);
        byte[] b2 = C0351r.m2359i().m2394p().m2355b(this.f1255k);
        if (b == null || b2 == null) {
            z = false;
        } else {
            this.f1250a = new SecretKeySpec(b, "AES");
            this.f1251b = new IvParameterSpec(b2);
            z = true;
        }
        return z;
    }

    public synchronized boolean m1962x() {
        boolean z;
        this.f1254j = this.e.m2285u().m2299a(this.f1250a.getEncoded());
        this.f1255k = this.e.m2285u().m2299a(this.f1251b.getIV());
        z = (this.f1254j == null || this.f1255k == null) ? false : true;
        return z;
    }

    private boolean m1923G() {
        return m1937a("CALLING") || m1937a("RINGING") || m1937a("ANSWERED");
    }

    private void m1924H() {
        if (m1923G()) {
            C0294h.m1972a().m1974c();
        }
        this.e.m2281q().deleteObserver(this.f1259o);
    }

    public void m1939b(int i, boolean z) {
        C0324b.m2085a(this, i, z);
    }

    public void m1963y() {
        C0324b.m2084a();
    }

    public void mo319z() {
    }

    public C0376a mo317A() {
        if (this.h == null) {
            this.h = new C0380e(this);
        }
        return this.h;
    }
}
