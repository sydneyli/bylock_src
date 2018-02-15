package android.support.v7.internal.view.menu;

import android.support.v4.view.C0087n;
import android.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

/* compiled from: MyApp */
class C0173x extends ActionProvider {
    final C0087n f637a;
    final /* synthetic */ C0172w f638b;

    public C0173x(C0172w c0172w, C0087n c0087n) {
        this.f638b = c0172w;
        super(c0087n.m748a());
        this.f637a = c0087n;
        if (c0172w.f635b) {
            this.f637a.m751a(new C0189y(this, c0172w));
        }
    }

    public View onCreateActionView() {
        if (this.f638b.f635b) {
            this.f638b.m1288c();
        }
        return this.f637a.m753b();
    }

    public boolean onPerformDefaultAction() {
        return this.f637a.m757f();
    }

    public boolean hasSubMenu() {
        return this.f637a.m758g();
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
        this.f637a.m752a(this.f638b.m1278a(subMenu));
    }
}
