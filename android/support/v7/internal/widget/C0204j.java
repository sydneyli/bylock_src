package android.support.v7.internal.widget;

import android.content.Context;
import android.support.v4.p001b.p002a.C0041b;
import android.support.v7.internal.view.menu.C0174q;
import android.support.v7.internal.view.menu.C0187u;
import android.support.v7.internal.view.menu.af;
import android.support.v7.internal.view.menu.al;
import android.support.v7.p007c.C0158c;

/* compiled from: MyApp */
class C0204j implements af {
    C0174q f962a;
    C0187u f963b;
    final /* synthetic */ ActionBarView f964c;

    private C0204j(ActionBarView actionBarView) {
        this.f964c = actionBarView;
    }

    public void mo209a(Context context, C0174q c0174q) {
        if (!(this.f962a == null || this.f963b == null)) {
            this.f962a.mo237d(this.f963b);
        }
        this.f962a = c0174q;
    }

    public void mo214c(boolean z) {
        if (this.f963b != null) {
            Object obj;
            if (this.f962a != null) {
                int size = this.f962a.size();
                for (int i = 0; i < size; i++) {
                    if (((C0041b) this.f962a.getItem(i)) == this.f963b) {
                        obj = 1;
                        break;
                    }
                }
            }
            obj = null;
            if (obj == null) {
                mo213b(this.f962a, this.f963b);
            }
        }
    }

    public boolean mo211a(al alVar) {
        return false;
    }

    public void mo210a(C0174q c0174q, boolean z) {
    }

    public boolean mo215g() {
        return false;
    }

    public boolean mo212a(C0174q c0174q, C0187u c0187u) {
        this.f964c.f837g = c0187u.getActionView();
        this.f964c.f847q.m1477a(this.f964c.f843m.getConstantState().newDrawable(this.f964c.getResources()));
        this.f963b = c0187u;
        if (this.f964c.f837g.getParent() != this.f964c) {
            this.f964c.addView(this.f964c.f837g);
        }
        if (this.f964c.f847q.getParent() != this.f964c) {
            this.f964c.addView(this.f964c.f847q);
        }
        this.f964c.f846p.setVisibility(8);
        if (this.f964c.f848r != null) {
            this.f964c.f848r.setVisibility(8);
        }
        if (this.f964c.f854x != null) {
            this.f964c.f854x.setVisibility(8);
        }
        if (this.f964c.f852v != null) {
            this.f964c.f852v.setVisibility(8);
        }
        if (this.f964c.f855y != null) {
            this.f964c.f855y.setVisibility(8);
        }
        this.f964c.requestLayout();
        c0187u.m1407e(true);
        if (this.f964c.f837g instanceof C0158c) {
            ((C0158c) this.f964c.f837g).mo272a();
        }
        return true;
    }

    public boolean mo213b(C0174q c0174q, C0187u c0187u) {
        if (this.f964c.f837g instanceof C0158c) {
            ((C0158c) this.f964c.f837g).mo273b();
        }
        this.f964c.removeView(this.f964c.f837g);
        this.f964c.removeView(this.f964c.f847q);
        this.f964c.f837g = null;
        if ((this.f964c.f840j & 2) != 0) {
            this.f964c.f846p.setVisibility(0);
        }
        if ((this.f964c.f840j & 8) != 0) {
            if (this.f964c.f848r == null) {
                this.f964c.m1494m();
            } else {
                this.f964c.f848r.setVisibility(0);
            }
        }
        if (this.f964c.f854x != null && this.f964c.f839i == 2) {
            this.f964c.f854x.setVisibility(0);
        }
        if (this.f964c.f852v != null && this.f964c.f839i == 1) {
            this.f964c.f852v.setVisibility(0);
        }
        if (!(this.f964c.f855y == null || (this.f964c.f840j & 16) == 0)) {
            this.f964c.f855y.setVisibility(0);
        }
        this.f964c.f847q.m1477a(null);
        this.f963b = null;
        this.f964c.requestLayout();
        c0187u.m1407e(false);
        return true;
    }
}
