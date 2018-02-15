package net.client.by.lock.gui.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: MyApp */
class ax implements OnTouchListener {
    final /* synthetic */ aw f1770a;

    ax(aw awVar) {
        this.f1770a = awVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        ad.f1719a.hideSoftInputFromWindow(aw.f1759Q.getWindowToken(), 0);
        return false;
    }
}
