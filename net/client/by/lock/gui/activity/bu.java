package net.client.by.lock.gui.activity;

import android.view.View;
import android.view.View.OnClickListener;
import net.client.by.lock.gui.p018b.C0418b;

/* compiled from: MyApp */
class bu implements OnClickListener {
    final /* synthetic */ SettingsActivity f1796a;

    bu(SettingsActivity settingsActivity) {
        this.f1796a = settingsActivity;
    }

    public void onClick(View view) {
        C0418b.m2744f(this.f1796a).show();
    }
}
