package net.client.by.lock.gui.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: MyApp */
class C0414x extends BroadcastReceiver {
    final /* synthetic */ MainActivity f1828a;

    C0414x(MainActivity mainActivity) {
        this.f1828a = mainActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            MainActivity.f1649u = intent.getStringExtra("caption");
            if (MainActivity.f1649u == null || MainActivity.f1649u.length() == 0) {
                this.f1828a.m1020f().mo192a(this.f1828a.f1654s[this.f1828a.f1652p.getCurrentItem()]);
            } else {
                this.f1828a.m1020f().mo192a(MainActivity.f1649u);
            }
        }
    }
}
