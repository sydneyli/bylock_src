package android.support.v7.p006a;

import android.support.v7.internal.view.menu.C0133r;
import android.support.v7.internal.view.menu.C0174q;
import android.support.v7.p007c.C0136b;
import android.support.v7.p007c.C0142a;
import android.view.Menu;
import android.view.MenuItem;

/* compiled from: MyApp */
class C0143o extends C0142a implements C0133r {
    final /* synthetic */ C0141n f498a;
    private C0136b f499b;
    private C0174q f500c;

    public C0143o(C0141n c0141n, C0136b c0136b) {
        this.f498a = c0141n;
        this.f499b = c0136b;
        this.f500c = new C0174q(c0141n.mo194b()).m1323a(1);
        this.f500c.mo231a((C0133r) this);
    }

    public Menu mo200a() {
        return this.f500c;
    }

    public void mo201b() {
        if (this.f498a.f472a == this) {
            if (C0141n.m1111b(this.f498a.f493v, this.f498a.f494w, false)) {
                this.f499b.mo184a(this);
            } else {
                this.f498a.f473b = this;
                this.f498a.f474c = this.f499b;
            }
            this.f499b = null;
            this.f498a.m1133f(false);
            this.f498a.f483l.m1472f();
            this.f498a.f482k.sendAccessibilityEvent(32);
            this.f498a.f472a = null;
        }
    }

    public void m1144c() {
        this.f500c.m1348f();
        try {
            this.f499b.mo187b(this, this.f500c);
        } finally {
            this.f500c.m1349g();
        }
    }

    public boolean m1145d() {
        this.f500c.m1348f();
        try {
            boolean a = this.f499b.mo185a((C0142a) this, this.f500c);
            return a;
        } finally {
            this.f500c.m1349g();
        }
    }

    public boolean mo176a(C0174q c0174q, MenuItem menuItem) {
        if (this.f499b != null) {
            return this.f499b.mo186a((C0142a) this, menuItem);
        }
        return false;
    }

    public void mo168a(C0174q c0174q) {
        if (this.f499b != null) {
            m1144c();
            this.f498a.f483l.mo246a();
        }
    }
}
