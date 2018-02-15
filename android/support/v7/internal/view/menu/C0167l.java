package android.support.v7.internal.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* compiled from: MyApp */
public abstract class C0167l implements af {
    private ag f559a;
    private int f560b;
    protected Context f561c;
    protected Context f562d;
    protected C0174q f563e;
    protected LayoutInflater f564f;
    protected LayoutInflater f565g;
    protected ah f566h;
    private int f567i;
    private int f568j;

    public abstract void mo218a(C0187u c0187u, ai aiVar);

    public C0167l(Context context, int i, int i2) {
        this.f561c = context;
        this.f564f = LayoutInflater.from(context);
        this.f560b = i;
        this.f567i = i2;
    }

    public void mo209a(Context context, C0174q c0174q) {
        this.f562d = context;
        this.f565g = LayoutInflater.from(this.f562d);
        this.f563e = c0174q;
    }

    public ah mo216a(ViewGroup viewGroup) {
        if (this.f566h == null) {
            this.f566h = (ah) this.f564f.inflate(this.f560b, viewGroup, false);
            this.f566h.mo221a(this.f563e);
            mo214c(true);
        }
        return this.f566h;
    }

    public void mo214c(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f566h;
        if (viewGroup != null) {
            int i;
            if (this.f563e != null) {
                this.f563e.m1351i();
                ArrayList h = this.f563e.m1350h();
                int size = h.size();
                int i2 = 0;
                i = 0;
                while (i2 < size) {
                    int i3;
                    C0187u c0187u = (C0187u) h.get(i2);
                    if (mo219a(i, c0187u)) {
                        View childAt = viewGroup.getChildAt(i);
                        C0187u itemData = childAt instanceof ai ? ((ai) childAt).getItemData() : null;
                        View a = mo217a(c0187u, childAt, viewGroup);
                        if (c0187u != itemData) {
                            a.setPressed(false);
                        }
                        if (a != childAt) {
                            m1214a(a, i);
                        }
                        i3 = i + 1;
                    } else {
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!mo220a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    protected void m1214a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f566h).addView(view, i);
    }

    protected boolean mo220a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public void m1211a(ag agVar) {
        this.f559a = agVar;
    }

    public ai m1219b(ViewGroup viewGroup) {
        return (ai) this.f564f.inflate(this.f567i, viewGroup, false);
    }

    public View mo217a(C0187u c0187u, View view, ViewGroup viewGroup) {
        ai aiVar;
        if (view instanceof ai) {
            aiVar = (ai) view;
        } else {
            aiVar = m1219b(viewGroup);
        }
        mo218a(c0187u, aiVar);
        return (View) aiVar;
    }

    public boolean mo219a(int i, C0187u c0187u) {
        return true;
    }

    public void mo210a(C0174q c0174q, boolean z) {
        if (this.f559a != null) {
            this.f559a.mo169a(c0174q, z);
        }
    }

    public boolean mo211a(al alVar) {
        if (this.f559a != null) {
            return this.f559a.mo179b(alVar);
        }
        return false;
    }

    public boolean mo215g() {
        return false;
    }

    public boolean mo212a(C0174q c0174q, C0187u c0187u) {
        return false;
    }

    public boolean mo213b(C0174q c0174q, C0187u c0187u) {
        return false;
    }

    public void m1220b(int i) {
        this.f568j = i;
    }
}
