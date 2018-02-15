package android.support.v4.widget;

import android.view.View;

/* compiled from: MyApp */
class C0109j extends ah {
    final /* synthetic */ DrawerLayout f430a;
    private final int f431b;
    private af f432c;
    private final Runnable f433d;

    public void m901a() {
        this.f430a.removeCallbacks(this.f433d);
    }

    public boolean mo131a(View view, int i) {
        return this.f430a.m801g(view) && this.f430a.m793a(view, this.f431b) && this.f430a.m786a(view) == 0;
    }

    public void mo127a(int i) {
        this.f430a.m790a(this.f431b, i, this.f432c.m872c());
    }

    public void mo130a(View view, int i, int i2, int i3, int i4) {
        float f;
        int width = view.getWidth();
        if (this.f430a.m793a(view, 3)) {
            f = ((float) (width + i)) / ((float) width);
        } else {
            f = ((float) (this.f430a.getWidth() - i)) / ((float) width);
        }
        this.f430a.m796b(view, f);
        view.setVisibility(f == 0.0f ? 4 : 0);
        this.f430a.invalidate();
    }

    public void mo134b(View view, int i) {
        ((C0107h) view.getLayoutParams()).f428c = false;
        m898b();
    }

    private void m898b() {
        int i = 3;
        if (this.f431b == 3) {
            i = 5;
        }
        View a = this.f430a.m788a(i);
        if (a != null) {
            this.f430a.m803i(a);
        }
    }

    public void mo129a(View view, float f, float f2) {
        int i;
        float d = this.f430a.m798d(view);
        int width = view.getWidth();
        if (this.f430a.m793a(view, 3)) {
            i = (f > 0.0f || (f == 0.0f && d > 0.5f)) ? 0 : -width;
        } else {
            i = this.f430a.getWidth();
            if (f < 0.0f || (f == 0.0f && d < 0.5f)) {
                i -= width;
            }
        }
        this.f432c.m862a(i, view.getTop());
        this.f430a.invalidate();
    }

    public void mo128a(int i, int i2) {
        this.f430a.postDelayed(this.f433d, 160);
    }

    public boolean mo135b(int i) {
        return false;
    }

    public void mo133b(int i, int i2) {
        View a;
        if ((i & 1) == 1) {
            a = this.f430a.m788a(3);
        } else {
            a = this.f430a.m788a(5);
        }
        if (a != null && this.f430a.m786a(a) == 0) {
            this.f432c.m860a(a, i2);
        }
    }

    public int mo125a(View view) {
        return view.getWidth();
    }

    public int mo126a(View view, int i, int i2) {
        if (this.f430a.m793a(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        }
        int width = this.f430a.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i, width));
    }

    public int mo132b(View view, int i, int i2) {
        return view.getTop();
    }
}
