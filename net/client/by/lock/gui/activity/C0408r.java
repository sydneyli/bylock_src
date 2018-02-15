package net.client.by.lock.gui.activity;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import net.client.by.lock.R;

/* compiled from: MyApp */
class C0408r implements OnEditorActionListener {
    final /* synthetic */ LoginActivity f1821a;

    C0408r(LoginActivity loginActivity) {
        this.f1821a = loginActivity;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != R.id.login && i != 0) {
            return false;
        }
        this.f1821a.f1641f.setEnabled(false);
        this.f1821a.m2608c();
        return true;
    }
}
