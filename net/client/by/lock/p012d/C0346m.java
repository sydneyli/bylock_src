package net.client.by.lock.p012d;

import java.util.ArrayList;
import net.client.by.lock.p013b.C0308a;
import net.client.by.lock.p013b.C0319k;

/* compiled from: MyApp */
public abstract class C0346m extends C0288k {
    protected String f1506a;
    protected String f1507b;
    protected String f1508c;
    protected ArrayList f1509i = new ArrayList();
    protected byte[] f1510j;
    protected byte[] f1511k;
    protected byte[] f1512l;
    protected byte[] f1513m;
    protected ArrayList f1514n = new ArrayList();

    protected String mo318a() {
        return this.f1507b + " (Posta)";
    }

    public String m2318g() {
        return this.f1508c;
    }

    public String m2319h() {
        return this.f1507b;
    }

    public byte[] m2320i() {
        return this.f1513m;
    }

    public void m2316a(byte[] bArr) {
        this.f1513m = bArr;
    }

    public String m2321j() {
        return this.f1506a;
    }

    public byte[] m2322k() {
        return this.f1510j;
    }

    public byte[] m2323l() {
        return this.f1511k;
    }

    public void m2315a(C0334a c0334a) {
        C0319k.m2069b().m2072a((C0308a) c0334a);
        if (this.f1514n.isEmpty()) {
            this.f1514n.add(c0334a);
        } else if (c0334a.mo322b().compareTo(((C0334a) this.f1514n.get(0)).mo322b()) < 0) {
            this.f1514n.add(0, c0334a);
        } else {
            for (int size = this.f1514n.size() - 1; size >= 0; size--) {
                int compareTo = c0334a.mo322b().compareTo(((C0334a) this.f1514n.get(size)).mo322b());
                if (compareTo == 0) {
                    return;
                }
                if (compareTo > 0) {
                    this.f1514n.add(size + 1, c0334a);
                    return;
                }
            }
        }
    }

    public ArrayList m2324m() {
        return this.f1514n;
    }

    public byte[] m2325n() {
        return this.f1512l;
    }

    public void m2317b(byte[] bArr) {
        this.f1512l = bArr;
    }

    public ArrayList m2326o() {
        return this.f1509i;
    }
}
