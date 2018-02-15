package android.support.v7.internal.view.menu;

import android.support.v4.view.C0087n;
import android.support.v4.view.C0089p;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

/* compiled from: MyApp */
class ac extends C0173x implements C0089p {
    VisibilityListener f639c;
    final /* synthetic */ ab f640d;

    public ac(ab abVar, C0087n c0087n) {
        this.f640d = abVar;
        super(abVar, c0087n);
    }

    public View onCreateActionView(MenuItem menuItem) {
        return this.a.m749a(menuItem);
    }

    public boolean overridesItemVisibility() {
        return this.a.m754c();
    }

    public boolean isVisible() {
        return this.a.m755d();
    }

    public void refreshVisibility() {
        this.a.m756e();
    }

    public void setVisibilityListener(VisibilityListener visibilityListener) {
        C0089p c0089p;
        this.f639c = visibilityListener;
        C0087n c0087n = this.a;
        if (visibilityListener == null) {
            c0089p = null;
        }
        c0087n.m751a(c0089p);
    }

    public void mo230a(boolean z) {
        if (this.f639c != null) {
            this.f639c.onActionProviderVisibilityChanged(z);
        }
    }
}
