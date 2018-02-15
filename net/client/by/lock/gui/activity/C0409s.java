package net.client.by.lock.gui.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MyApp */
class C0409s implements OnClickListener {
    final /* synthetic */ LoginActivity f1822a;

    C0409s(LoginActivity loginActivity) {
        this.f1822a = loginActivity;
    }

    public void onClick(View view) {
        this.f1822a.f1641f.setEnabled(false);
        this.f1822a.f1646k.hideSoftInputFromWindow(this.f1822a.f1641f.getWindowToken(), 0);
        this.f1822a.m2608c();
    }
}
