package net.client.by.lock.p012d;

import java.io.UnsupportedEncodingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.client.by.lock.p013b.C0308a;
import net.client.by.lock.p013b.C0312d;
import net.client.by.lock.p016f.C0363h;

/* compiled from: MyApp */
public class C0334a implements C0308a {
    C0363h f1450a = new C0363h("fileId");
    SecretKeySpec f1451b;
    byte[] f1452c;
    IvParameterSpec f1453d;
    byte[] f1454e;
    String f1455f;
    byte[] f1456g;
    byte[] f1457h;
    int f1458i;
    C0312d f1459j = null;

    public C0334a(String str, String str2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i) {
        this.f1450a.m2468a((Object) str);
        this.f1456g = bArr;
        this.f1452c = bArr2;
        this.f1454e = bArr3;
        this.f1457h = bArr4;
        this.f1458i = i;
    }

    public C0334a(C0308a c0308a) {
        if (c0308a instanceof C0312d) {
            this.f1450a.m2469a(((C0312d) c0308a).m2040h());
        } else {
            this.f1450a.m2468a(c0308a.mo322b());
        }
        this.f1451b = c0308a.mo323c();
        this.f1453d = c0308a.mo324d();
        this.f1458i = c0308a.mo326f().intValue();
        this.f1455f = c0308a.mo325e();
    }

    public void m2195a(C0312d c0312d) {
        this.f1459j = c0312d;
    }

    public C0312d m2194a() {
        return this.f1459j;
    }

    public String mo322b() {
        return (String) this.f1450a.m2467a();
    }

    public byte[] m2203g() {
        return this.f1456g;
    }

    public String mo325e() {
        return this.f1455f;
    }

    public byte[] m2204h() {
        return this.f1452c;
    }

    public byte[] m2205i() {
        return this.f1454e;
    }

    public byte[] m2206j() {
        return this.f1457h;
    }

    public Integer mo326f() {
        return Integer.valueOf(this.f1458i);
    }

    public void m2196a(byte[] bArr) {
        this.f1457h = bArr;
    }

    public boolean m2197a(C0340f c0340f) {
        this.f1452c = c0340f.m2299a(this.f1451b.getEncoded());
        this.f1454e = c0340f.m2299a(this.f1453d.getIV());
        try {
            this.f1456g = c0340f.m2299a(this.f1455f.getBytes("UTF-8"));
            if (this.f1452c == null || this.f1454e == null || this.f1456g == null) {
                return false;
            }
            return true;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean m2207k() {
        this.f1451b = new SecretKeySpec(C0351r.m2359i().m2394p().m2355b(this.f1452c), "AES");
        this.f1453d = new IvParameterSpec(C0351r.m2359i().m2394p().m2355b(this.f1454e));
        try {
            this.f1455f = new String(C0351r.m2359i().m2394p().m2355b(this.f1456g), "UTF-8");
            if (this.f1451b == null || this.f1453d == null || this.f1455f == null) {
                return false;
            }
            return true;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public SecretKeySpec mo323c() {
        return this.f1451b;
    }

    public IvParameterSpec mo324d() {
        return this.f1453d;
    }
}
