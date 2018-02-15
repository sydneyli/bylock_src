package net.client.by.lock.gui.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: MyApp */
class C0405n implements OnTouchListener {
    final /* synthetic */ ChatActivity f1818a;

    C0405n(ChatActivity chatActivity) {
        this.f1818a = chatActivity;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f1818a.f1630u.hideSoftInputFromWindow(this.f1818a.f1625o.getWindowToken(), 0);
        return false;
    }
}
