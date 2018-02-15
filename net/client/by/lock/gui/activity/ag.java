package net.client.by.lock.gui.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: MyApp */
class ag implements OnTouchListener {
    final /* synthetic */ ae f1727a;

    ag(ae aeVar) {
        this.f1727a = aeVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        ad.f1719a.hideSoftInputFromWindow(ae.f1724T.getWindowToken(), 0);
        return false;
    }
}
