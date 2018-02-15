package net.client.by.lock.gui.activity;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: MyApp */
class C0393b implements AnimationListener {
    final /* synthetic */ CallActivity f1773a;

    C0393b(CallActivity callActivity) {
        this.f1773a = callActivity;
    }

    public void onAnimationEnd(Animation animation) {
        this.f1773a.f1617k.setVisibility(8);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
