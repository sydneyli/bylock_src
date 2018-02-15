package net.client.by.lock.p012d;

import java.io.File;
import java.lang.ref.SoftReference;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observer;
import javax.crypto.KeyGenerator;
import net.client.by.lock.C0333c;
import net.client.by.lock.gui.p018b.C0417a;
import net.client.by.lock.p011a.C0289c;
import net.client.by.lock.p011a.C0294h;
import net.client.by.lock.p013b.C0308a;
import net.client.by.lock.p013b.C0311c;
import net.client.by.lock.p013b.C0312d;
import net.client.by.lock.p013b.C0314g;
import net.client.by.lock.p013b.C0315h;
import net.client.by.lock.p013b.C0319k;
import net.client.by.lock.p014c.C0330h;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p016f.C0362g;
import net.client.by.lock.p016f.C0363h;
import net.client.by.lock.p016f.C0365j;

/* compiled from: MyApp */
public class C0337c extends C0336p implements Comparable {
    private C0340f f1464a = null;
    private String f1465b;
    private int f1466c;
    private String f1467d = "";
    private String f1468e = "";
    private ArrayList f1469f = new ArrayList();
    private C0363h f1470g = new C0363h("", "sas");
    private C0363h f1471h = new C0363h("", "publicMessage");
    private C0363h f1472i = new C0363h("(No Login.)", "lastOnline");
    private C0363h f1473j = new C0363h(Integer.valueOf(0), "status");
    private C0363h f1474k = new C0363h(Integer.valueOf(0), "chatCount");
    private C0363h f1475l = new C0363h(Boolean.valueOf(false), "fileExists");
    private C0363h f1476m = new C0363h(Boolean.valueOf(false), "mailExists");
    private C0363h f1477n = new C0363h(Boolean.valueOf(false), "callExists");
    private C0363h f1478o = new C0363h("description");
    private C0363h f1479p = new C0363h(Boolean.valueOf(false), "onlineProperty");
    private boolean f1480q = false;
    private boolean f1481r = false;
    private Integer f1482s = Integer.valueOf(-1);
    private C0289c f1483t;
    private C0362g f1484u = new C0362g();
    private C0363h f1485v = new C0363h("NK", "verificationStateProperty");
    private C0363h f1486w = new C0363h(Boolean.valueOf(false), "notificationExists");
    private SoftReference f1487x;

    public /* synthetic */ int compareTo(Object obj) {
        return m2240a((C0337c) obj);
    }

    public C0337c() {
        Observer c0338d = new C0338d();
        this.f1474k.addObserver(c0338d);
        this.f1475l.addObserver(c0338d);
        this.f1476m.addObserver(c0338d);
        this.f1477n.addObserver(c0338d);
        this.f1473j.addObserver(new C0339e());
    }

    public synchronized void m2251a(C0288k c0288k) {
        this.f1484u.remove((Object) c0288k);
    }

    public synchronized void m2250a(C0335b c0335b) {
        if (this.f1464a != null && this.f1464a.m2296a(c0335b) && c0335b.m2217h()) {
            c0335b.m1918b(this);
            m2261b((C0288k) c0335b);
        }
        if (c0335b.m2212c().intValue() > this.f1482s.intValue()) {
            this.f1482s = c0335b.m2212c();
        }
        C0351r.m2359i().m2365a(this, c0335b.m2212c());
    }

    public synchronized void m2260b(C0335b c0335b) {
        if (this.f1464a != null && this.f1464a.m2296a(c0335b) && c0335b.m2217h()) {
            c0335b.m1918b(this);
            m2261b((C0288k) c0335b);
        }
        if (c0335b.m2212c().intValue() > this.f1482s.intValue()) {
            this.f1482s = c0335b.m2212c();
        }
        C0351r.m2359i().m2365a(this, c0335b.m2212c());
        this.f1474k.m2468a(Integer.valueOf(((Integer) this.f1474k.m2467a()).intValue() - 1));
    }

    public synchronized void m2246a(Integer num) {
        this.f1469f.add(num);
    }

    public synchronized void m2257b(Integer num) {
        this.f1469f.remove(num);
    }

    public ArrayList m2241a() {
        return this.f1469f;
    }

    public synchronized boolean m2254a(C0314g c0314g) {
        boolean z = true;
        synchronized (this) {
            if (this.f1464a != null && this.f1464a.m2295a(c0314g) && c0314g.m2056q()) {
                m2261b((C0288k) c0314g);
                C0319k.m2069b().m2072a((C0308a) c0314g);
                if (!this.f1480q) {
                    this.f1475l.m2468a(Boolean.valueOf(true));
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    public synchronized void m2255b() {
        if (((Integer) this.f1474k.m2467a()).intValue() <= 0 || !this.f1480q) {
            this.f1481r = false;
        } else {
            C0332j.m2148a().m2177c(this);
            this.f1481r = true;
        }
    }

    public synchronized void m2247a(String str) {
        C0288k c0335b = new C0335b(this, str);
        m2261b(c0335b);
        c0335b.m2213d();
    }

    public synchronized void m2261b(C0288k c0288k) {
        if (this.f1484u.size() == 0) {
            this.f1484u.add(c0288k);
        } else if (c0288k.m1915a((C0288k) this.f1484u.get(this.f1484u.size() - 1)) >= 0) {
            this.f1484u.add(c0288k);
        } else {
            for (int i = 0; i < this.f1484u.size(); i++) {
                if (c0288k.m1915a((C0288k) this.f1484u.get(i)) < 0) {
                    this.f1484u.add(i, c0288k);
                    break;
                }
            }
        }
    }

    public synchronized void m2245a(File file) {
        if (this.f1464a == null) {
            C0330h.m2111a().m2114a(m2233G() + " has no key yet. No communication is possible.");
        } else {
            C0288k c0315h = new C0315h(file);
            c0315h.m1918b(this);
            C0311c a = m2242a((C0312d) c0315h);
            if (a != null) {
                c0315h.m2060l().add(a);
                m2261b(c0315h);
                c0315h.m2061m();
            } else {
                C0365j.m2476a("Error in sending file: FileRecipient object is null.", new Exception());
            }
        }
    }

    public synchronized void m2262c() {
        if (C0294h.m1972a().m1973b()) {
            try {
                KeyGenerator instance = KeyGenerator.getInstance("AES");
                instance.init(128, C0351r.m2359i().m2361a());
                C0288k a = C0289c.m1926a(this, instance.generateKey().getEncoded(), instance.generateKey().getEncoded());
                C0332j.m2148a().m2158a((C0289c) a);
                m2261b(a);
                this.f1483t = a;
            } catch (Throwable e) {
                C0365j.m2476a("Error in creating call key", e);
            }
        }
    }

    public synchronized void m2253a(byte[] bArr, byte[] bArr2, String str, boolean z) {
        C0289c a = C0289c.m1927a(this, bArr, bArr2, z);
        if (C0351r.m2359i().m2394p() == null) {
            C0332j.m2148a().m2176c(a);
        } else if (C0294h.m1972a().m1973b()) {
            m2261b((C0288k) a);
            a.m1919d(str);
            this.f1483t = a;
            C0330h.m2111a().m2115a(a);
        } else {
            C0332j.m2148a().m2176c(a);
            C0288k a2 = C0289c.m1925a(this);
            m2261b(a2);
            a2.m1919d(str);
        }
    }

    public synchronized void m2244a(int i, boolean z) {
        this.f1483t.m1931a(i, z);
    }

    public synchronized void m2264d() {
        this.f1483t.m1949k();
    }

    public synchronized void m2266e() {
        this.f1483t.m1950l();
    }

    public synchronized void m2268f() {
        this.f1483t.m1952n();
        if (!this.f1480q) {
            this.f1477n.m2468a(Boolean.valueOf(true));
        }
    }

    public synchronized void m2271g() {
        this.f1483t.m1957s();
    }

    public synchronized void m2272h() {
        this.f1483t.m1958t();
    }

    public synchronized void m2273i() {
        m2261b(C0289c.m1925a(this));
    }

    public synchronized void m2274j() {
        this.f1480q = true;
        if (((Integer) this.f1474k.m2467a()).intValue() > 0 && !this.f1481r) {
            C0332j.m2148a().m2177c(this);
            this.f1481r = true;
        }
        this.f1475l.m2468a(Boolean.valueOf(false));
        this.f1477n.m2468a(Boolean.valueOf(false));
        this.f1476m.m2468a(Boolean.valueOf(false));
    }

    public synchronized void m2275k() {
        this.f1480q = false;
    }

    public Integer m2276l() {
        return this.f1482s;
    }

    public synchronized void m2277m() {
        this.f1474k.m2468a(Integer.valueOf(((Integer) this.f1474k.m2467a()).intValue() + 1));
        if (this.f1480q && !this.f1481r && ((Integer) this.f1474k.m2467a()).intValue() > 0) {
            C0332j.m2148a().m2177c(this);
            this.f1481r = true;
        }
    }

    public C0362g m2278n() {
        return this.f1484u;
    }

    public synchronized int m2279o() {
        return ((Integer) this.f1474k.m2467a()).intValue();
    }

    public C0363h m2280p() {
        return this.f1474k;
    }

    public C0363h m2281q() {
        return this.f1479p;
    }

    public synchronized void m2243a(int i) {
        this.f1473j.m2468a(Integer.valueOf(i));
    }

    public synchronized void m2249a(Observer observer) {
        this.f1479p.addObserver(observer);
    }

    public synchronized void m2259b(Observer observer) {
        this.f1479p.deleteObserver(observer);
    }

    public C0363h m2282r() {
        return this.f1473j;
    }

    public String m2283s() {
        return (String) this.f1471h.m2467a();
    }

    public C0363h m2284t() {
        return this.f1471h;
    }

    public void m2258b(String str) {
        if (str.length() > 0) {
            this.f1471h.m2468a("\"" + str + "\"");
        } else {
            this.f1471h.m2468a((Object) "");
        }
    }

    public C0340f m2285u() {
        return this.f1464a;
    }

    public void m2252a(byte[] bArr) {
        if (bArr != null) {
            this.f1464a = new C0340f(bArr);
        } else {
            this.f1464a = null;
            m2235I();
            this.f1475l.m2468a(Boolean.valueOf(false));
            this.f1476m.m2468a(Boolean.valueOf(false));
            this.f1477n.m2468a(Boolean.valueOf(false));
            this.f1474k.m2468a(Integer.valueOf(0));
        }
        m2286v();
        m2287w();
    }

    public void m2286v() {
        if (this.f1464a == null || C0351r.m2359i().m2394p() == null) {
            this.f1470g.m2468a((Object) "");
            return;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            BigInteger b = C0351r.m2359i().m2394p().m2300b();
            BigInteger b2 = this.f1464a.m2300b();
            if (b.compareTo(b2) < 0) {
                instance.update(b.toByteArray());
                instance.update(b2.toByteArray());
            } else {
                instance.update(b2.toByteArray());
                instance.update(b.toByteArray());
            }
            byte[] digest = instance.digest();
            Object obj = "";
            int i = 0;
            while (i < 10) {
                String stringBuilder;
                digest[i] = (byte) (digest[i] & 31);
                if (digest[i] < (byte) 10) {
                    stringBuilder = new StringBuilder(String.valueOf(obj)).append(digest[i]).toString();
                } else {
                    char c = (char) ((digest[i] - 10) + 65);
                    if (c == 'O') {
                        c = 'Y';
                    } else if (c == 'Q') {
                        c = 'Z';
                    }
                    stringBuilder = new StringBuilder(String.valueOf(obj)).append(c).toString();
                }
                i++;
                String str = stringBuilder;
            }
            this.f1470g.m2468a(obj);
        } catch (Throwable e) {
            C0365j.m2476a("", e);
        }
    }

    public void m2287w() {
        if (this.f1464a == null) {
            this.f1485v.m2468a((Object) "NK");
        } else if (!C0333c.m2187c().m2192b(Integer.valueOf(this.f1466c), this.f1465b)) {
            this.f1485v.m2468a((Object) "KWOS");
        } else if (C0333c.m2187c().m2193b(Integer.valueOf(this.f1466c), this.f1465b, this.f1464a.m2298a())) {
            this.f1485v.m2468a((Object) "KWCS");
        } else {
            this.f1485v.m2468a((Object) "KWIS");
        }
    }

    public C0363h m2288x() {
        return this.f1485v;
    }

    public C0363h m2289y() {
        return this.f1475l;
    }

    public C0363h m2290z() {
        return this.f1476m;
    }

    public C0363h m2227A() {
        return this.f1477n;
    }

    public C0363h m2228B() {
        return this.f1470g;
    }

    public String m2229C() {
        return this.f1465b;
    }

    public void m2263c(String str) {
        this.f1465b = str;
        m2219N();
    }

    public String m2230D() {
        return this.f1468e;
    }

    public void m2265d(String str) {
        this.f1468e = str;
        m2219N();
    }

    public void m2267e(String str) {
        this.f1472i.m2468a((Object) str);
    }

    public String m2231E() {
        return this.f1467d;
    }

    public void m2269f(String str) {
        this.f1467d = str;
        m2219N();
    }

    private void m2219N() {
        if (this.f1468e != null && this.f1468e.length() > 0) {
            this.f1478o.m2468a(this.f1468e);
        } else if (this.f1467d == null || this.f1467d.length() <= 0) {
            this.f1478o.m2468a(this.f1465b);
        } else {
            this.f1478o.m2468a(this.f1467d);
        }
    }

    public C0363h m2232F() {
        return this.f1478o;
    }

    public String m2233G() {
        return (String) this.f1478o.m2467a();
    }

    public C0311c m2242a(C0312d c0312d) {
        C0311c c0311c = new C0311c(this);
        try {
            c0311c.m2016a(this.f1464a.m2299a(c0312d.mo325e().getBytes("UTF-8")));
        } catch (Throwable e) {
            C0365j.m2476a("", e);
        }
        c0311c.m2018b(this.f1464a.m2299a(c0312d.mo323c().getEncoded()));
        c0311c.m2020c(this.f1464a.m2299a(c0312d.mo324d().getIV()));
        return C0351r.m2359i().m2394p().m2351a(c0311c) ? c0311c : null;
    }

    public void m2234H() {
        if (C0333c.m2187c().m2192b(Integer.valueOf(this.f1466c), this.f1465b)) {
            C0333c.m2187c().m2189a(Integer.valueOf(this.f1466c), this.f1465b);
        } else {
            C0333c.m2187c().m2190a(Integer.valueOf(m2237K()), m2229C(), this.f1464a.m2298a());
        }
        m2287w();
    }

    public synchronized void m2235I() {
        this.f1484u.clear();
    }

    public synchronized void m2248a(String str, String str2, byte[] bArr, boolean z) {
        if (this.f1464a != null) {
            m2261b(new C0347l(this, str, str2, bArr, z));
            if (!(this.f1480q || z)) {
                this.f1476m.m2468a(Boolean.valueOf(true));
            }
        }
    }

    public C0363h m2236J() {
        return this.f1486w;
    }

    public int m2240a(C0337c c0337c) {
        if (((Boolean) this.f1486w.m2467a()).booleanValue() && !((Boolean) c0337c.f1486w.m2467a()).booleanValue()) {
            return -1;
        }
        if (!((Boolean) this.f1486w.m2467a()).booleanValue() && ((Boolean) c0337c.f1486w.m2467a()).booleanValue()) {
            return 1;
        }
        if ((((Integer) this.f1473j.m2467a()).intValue() == 3 || ((Integer) this.f1473j.m2467a()).intValue() == 2 || ((Integer) this.f1473j.m2467a()).intValue() == 1) && ((Integer) c0337c.f1473j.m2467a()).intValue() == 0) {
            return -2;
        }
        if ((((Integer) c0337c.f1473j.m2467a()).intValue() == 3 || ((Integer) c0337c.f1473j.m2467a()).intValue() == 2 || ((Integer) c0337c.f1473j.m2467a()).intValue() == 1) && ((Integer) this.f1473j.m2467a()).intValue() == 0) {
            return 2;
        }
        return ((String) this.f1478o.m2467a()).compareToIgnoreCase((String) c0337c.f1478o.m2467a());
    }

    public int m2237K() {
        return this.f1466c;
    }

    public void m2256b(int i) {
        this.f1466c = i;
    }

    public C0289c m2238L() {
        return this.f1483t;
    }

    public C0417a m2239M() {
        if (this.f1487x == null || this.f1487x.get() == null) {
            this.f1487x = new SoftReference(new C0417a(this.f1484u));
        }
        return (C0417a) this.f1487x.get();
    }

    public C0346m m2270g(String str) {
        Iterator it = this.f1484u.iterator();
        while (it.hasNext()) {
            C0288k c0288k = (C0288k) it.next();
            if (c0288k instanceof C0346m) {
                C0346m c0346m = (C0346m) c0288k;
                if (!(c0346m == null || c0346m.m2321j() == null || !c0346m.m2321j().equals(str))) {
                    return (C0346m) c0288k;
                }
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C0337c) && ((C0337c) obj).m2229C().equals(this.f1465b)) {
            return true;
        }
        return false;
    }
}
