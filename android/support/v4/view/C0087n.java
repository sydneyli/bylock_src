package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: MyApp */
public abstract class C0087n {
    private final Context f339a;
    private C0088o f340b;
    private C0089p f341c;

    public abstract View m753b();

    public Context m748a() {
        return this.f339a;
    }

    public View m749a(MenuItem menuItem) {
        return m753b();
    }

    public boolean m754c() {
        return false;
    }

    public boolean m755d() {
        return true;
    }

    public void m756e() {
        if (this.f341c != null && m754c()) {
            this.f341c.mo230a(m755d());
        }
    }

    public boolean m757f() {
        return false;
    }

    public boolean m758g() {
        return false;
    }

    public void m752a(SubMenu subMenu) {
    }

    public void m750a(C0088o c0088o) {
        this.f340b = c0088o;
    }

    public void m751a(C0089p c0089p) {
        if (!(this.f341c == null || c0089p == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f341c = c0089p;
    }
}
