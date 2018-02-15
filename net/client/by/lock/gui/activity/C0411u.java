package net.client.by.lock.gui.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: MyApp */
class C0411u implements OnTouchListener {
    final /* synthetic */ LoginActivity f1824a;
    private final /* synthetic */ View f1825b;

    C0411u(LoginActivity loginActivity, View view) {
        this.f1824a = loginActivity;
        this.f1825b = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f1824a.f1646k.hideSoftInputFromWindow(this.f1825b.getWindowToken(), 0);
        return false;
    }
}
