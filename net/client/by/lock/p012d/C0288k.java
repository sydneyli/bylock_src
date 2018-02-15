package net.client.by.lock.p012d;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import net.client.by.lock.C0307a;
import net.client.by.lock.gui.p017a.C0376a;
import net.client.by.lock.p016f.C0363h;

/* compiled from: MyApp */
public abstract class C0288k {
    private boolean f1244a;
    protected C0363h f1245d = new C0363h("01.01.2970 00:00", "dateTimeProperty");
    protected C0337c f1246e;
    protected C0363h f1247f = new C0363h("stateProperty");
    protected String f1248g;
    protected C0376a f1249h = null;

    public abstract C0376a mo317A();

    protected abstract String mo318a();

    public abstract void mo319z();

    public String toString() {
        if (this.f1244a) {
            return new StringBuilder(String.valueOf((String) C0351r.m2359i().m2381f().m2467a())).append(" (").append((String) this.f1245d.m2467a()).append("): ").append(mo318a()).toString();
        }
        return new StringBuilder(String.valueOf((String) this.f1246e.m2232F().m2467a())).append(" (").append((String) this.f1245d.m2467a()).append("): ").append(mo318a()).toString();
    }

    public String m1910B() {
        return (String) this.f1245d.m2467a();
    }

    public C0363h m1911C() {
        return this.f1245d;
    }

    public void m1919d(String str) {
        this.f1245d.m2468a((Object) str);
    }

    public void m1917a(boolean z) {
        this.f1244a = z;
    }

    public boolean b_() {
        return this.f1244a;
    }

    public boolean m1912D() {
        return this.f1244a;
    }

    public C0337c m1913E() {
        return this.f1246e;
    }

    public void m1918b(C0337c c0337c) {
        this.f1246e = c0337c;
    }

    public C0363h m1914F() {
        return this.f1247f;
    }

    public synchronized void m1920e(String str) {
        this.f1247f.m2468a((Object) str);
    }

    public synchronized void m1921f(String str) {
        this.f1247f.m2468a((Object) "ERROR");
        this.f1248g = str;
    }

    public int m1915a(C0288k c0288k) {
        try {
            try {
                return new SimpleDateFormat("dd.MM.yyyy HH:mm", C0307a.f1343c).parse((String) this.f1245d.m2467a()).compareTo(new SimpleDateFormat("dd.MM.yyyy HH:mm", C0307a.f1343c).parse((String) c0288k.f1245d.m2467a()));
            } catch (ParseException e) {
                return -1;
            }
        } catch (ParseException e2) {
            return 1;
        }
    }
}
