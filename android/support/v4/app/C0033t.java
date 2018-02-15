package android.support.v4.app;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: MyApp */
class C0033t implements AnimationListener {
    final /* synthetic */ Fragment f231a;
    final /* synthetic */ C0031r f232b;

    C0033t(C0031r c0031r, Fragment fragment) {
        this.f232b = c0031r;
        this.f231a = fragment;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f231a.f47b != null) {
            this.f231a.f47b = null;
            this.f232b.m231a(this.f231a, this.f231a.f48c, 0, 0, false);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
