package android.support.v7.p006a;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.internal.view.C0160b;
import android.support.v7.internal.view.C0161c;
import android.support.v7.internal.view.menu.aj;
import android.support.v7.p007c.C0136b;
import android.support.v7.p007c.C0142a;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.Window.Callback;

/* compiled from: MyApp */
class C0139l extends C0132g {
    Menu f468d;

    C0139l(C0131f c0131f) {
        super(c0131f);
    }

    public C0126a mo164a() {
        return new C0146r(this.a, this.a);
    }

    public void mo188a(Bundle bundle) {
        if ("splitActionBarWhenNarrow".equals(m1042h())) {
            this.a.getWindow().setUiOptions(1, 1);
        }
        super.mo188a(bundle);
        if (this.b) {
            this.a.requestWindowFeature(8);
        }
        if (this.c) {
            this.a.requestWindowFeature(9);
        }
        Window window = this.a.getWindow();
        window.setCallback(m1089a(window.getCallback()));
    }

    Callback m1089a(Callback callback) {
        return new C0140m(this, callback);
    }

    public void mo167a(Configuration configuration) {
    }

    public void mo180d() {
    }

    public void mo181e() {
    }

    public void mo170a(View view) {
        this.a.mo154a(view);
    }

    public void mo166a(int i) {
        this.a.m1006a(i);
    }

    public void mo171a(View view, LayoutParams layoutParams) {
        this.a.m1010a(view, layoutParams);
    }

    public void mo178b(View view, LayoutParams layoutParams) {
        this.a.m1018b(view, layoutParams);
    }

    public View mo177b(int i) {
        return null;
    }

    public boolean mo173a(int i, Menu menu) {
        if (i != 0 && i != 8) {
            return this.a.m1011a(i, menu);
        }
        if (this.f468d == null) {
            this.f468d = aj.m1311a(menu);
        }
        return this.a.m1011a(i, this.f468d);
    }

    public boolean mo175a(int i, View view, Menu menu) {
        if (i == 0 || i == 8) {
            return this.a.m1013a(i, view, this.f468d);
        }
        return this.a.m1013a(i, view, menu);
    }

    public boolean mo174a(int i, MenuItem menuItem) {
        if (i == 0) {
            menuItem = aj.m1312a(menuItem);
        }
        return this.a.m1012a(i, menuItem);
    }

    public void mo172a(CharSequence charSequence) {
    }

    public C0142a mo165a(C0136b c0136b) {
        if (c0136b == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        Context i = m1043i();
        Object c0161c = new C0161c(i, c0136b);
        if (this.a.startActionMode(c0161c) == null) {
            return null;
        }
        C0160b c0160b = new C0160b(i, this.a.startActionMode(c0161c));
        c0161c.m1173a(c0160b);
        return c0160b;
    }

    public void m1093a(ActionMode actionMode) {
        this.a.m1008a(new C0160b(m1043i(), actionMode));
    }

    public void m1101b(ActionMode actionMode) {
        this.a.m1017b(new C0160b(m1043i(), actionMode));
    }

    public void mo182f() {
        this.f468d = null;
    }

    public boolean mo183g() {
        return false;
    }
}
