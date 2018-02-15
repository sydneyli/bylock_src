package net.client.by.lock.p013b;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.client.by.lock.gui.p017a.C0376a;
import net.client.by.lock.gui.p017a.C0383h;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p016f.C0365j;

/* compiled from: MyApp */
public class C0314g extends C0312d {
    private byte[] f1382c;
    private byte[] f1383i;
    private byte[] f1384j;
    private byte[] f1385k;

    public C0314g() {
        m1920e("IDLE");
    }

    public void m2051l() {
        this.b = C0332j.m2148a().m2151a(this);
        this.f.m2468a((Object) "IN PROGRESS");
    }

    public byte[] m2052m() {
        return this.f1382c;
    }

    public void m2047a(byte[] bArr) {
        this.f1382c = bArr;
    }

    public byte[] m2053n() {
        return this.f1383i;
    }

    public void m2048b(byte[] bArr) {
        this.f1383i = bArr;
    }

    public byte[] m2054o() {
        return this.f1384j;
    }

    public void m2049c(byte[] bArr) {
        this.f1384j = bArr;
    }

    public byte[] m2055p() {
        return this.f1385k;
    }

    public void m2050d(byte[] bArr) {
        this.f1385k = bArr;
    }

    public boolean m2056q() {
        try {
            byte[] b = C0351r.m2359i().m2394p().m2355b(this.f1382c);
            if (b == null) {
                return false;
            }
            m2033b(new String(b, "UTF-8"));
            m2031a(new SecretKeySpec(C0351r.m2359i().m2394p().m2355b(this.f1383i), "AES"));
            m2030a(new IvParameterSpec(C0351r.m2359i().m2394p().m2355b(this.f1384j)));
            if (mo325e() == null || mo323c() == null || mo324d() == null) {
                return false;
            }
            return true;
        } catch (Throwable e) {
            C0365j.m2476a("", e);
        }
    }

    public boolean b_() {
        return false;
    }

    public void mo319z() {
        C0332j.m2148a().m2179d(m2041i());
        C0319k.m2069b().m2071a(m2041i());
    }

    public C0376a mo317A() {
        if (this.h == null) {
            this.h = new C0383h(this);
        }
        return this.h;
    }
}
