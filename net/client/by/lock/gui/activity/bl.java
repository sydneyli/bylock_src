package net.client.by.lock.gui.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: MyApp */
class bl implements OnTouchListener {
    final /* synthetic */ RegisterActivity f1785a;
    private final /* synthetic */ View f1786b;

    bl(RegisterActivity registerActivity, View view) {
        this.f1785a = registerActivity;
        this.f1786b = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f1785a.f1703k.hideSoftInputFromWindow(this.f1786b.getWindowToken(), 0);
        return false;
    }
}
