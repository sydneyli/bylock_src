package net.client.by.lock.gui.activity;

import android.os.Handler;
import android.support.v4.view.ca;
import android.view.View;

/* compiled from: MyApp */
class C0415y extends ca {
    final /* synthetic */ MainActivity f1829a;

    C0415y(MainActivity mainActivity) {
        this.f1829a = mainActivity;
    }

    public void mo103a(int i) {
        if (MainActivity.f1649u == null || MainActivity.f1649u.length() == 0) {
            this.f1829a.m1020f().mo192a(this.f1829a.f1654s[i]);
        }
        if (i == 1 || i == 4) {
            this.f1829a.getWindow().setSoftInputMode(16);
        } else {
            this.f1829a.getWindow().setSoftInputMode(32);
        }
        for (int i2 = 0; i2 < 5; i2++) {
            boolean z;
            View view = this.f1829a.f1653r[i2];
            if (i2 != i) {
                z = true;
            } else {
                z = false;
            }
            view.setEnabled(z);
        }
        new Handler().postDelayed(new C0416z(this), 500);
    }
}
