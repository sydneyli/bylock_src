package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.ao;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: MyApp */
public abstract class C0035v extends ao {
    private final C0029p f234a;
    private aa f235b = null;
    private Fragment f236c = null;

    public abstract Fragment mo345a(int i);

    public C0035v(C0029p c0029p) {
        this.f234a = c0029p;
    }

    public void mo20a(ViewGroup viewGroup) {
    }

    public Object mo18a(ViewGroup viewGroup, int i) {
        if (this.f235b == null) {
            this.f235b = this.f234a.mo15a();
        }
        long b = m299b(i);
        Fragment a = this.f234a.mo14a(C0035v.m291a(viewGroup.getId(), b));
        if (a != null) {
            this.f235b.mo12b(a);
        } else {
            a = mo345a(i);
            this.f235b.mo9a(viewGroup.getId(), a, C0035v.m291a(viewGroup.getId(), b));
        }
        if (a != this.f236c) {
            a.m56c(false);
            a.m61d(false);
        }
        return a;
    }

    public void mo21a(ViewGroup viewGroup, int i, Object obj) {
        if (this.f235b == null) {
            this.f235b = this.f234a.mo15a();
        }
        this.f235b.mo10a((Fragment) obj);
    }

    public void mo24b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f236c) {
            if (this.f236c != null) {
                this.f236c.m56c(false);
                this.f236c.m61d(false);
            }
            if (fragment != null) {
                fragment.m56c(true);
                fragment.m61d(true);
            }
            this.f236c = fragment;
        }
    }

    public void mo23b(ViewGroup viewGroup) {
        if (this.f235b != null) {
            this.f235b.mo11b();
            this.f235b = null;
            this.f234a.mo16b();
        }
    }

    public boolean mo22a(View view, Object obj) {
        return ((Fragment) obj).m68g() == view;
    }

    public Parcelable mo17a() {
        return null;
    }

    public void mo19a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public long m299b(int i) {
        return (long) i;
    }

    private static String m291a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }
}
