package net.client.by.lock.gui.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import net.client.by.lock.p014c.C0331i;
import net.client.by.lock.p014c.C0332j;

/* compiled from: MyApp */
class aa implements OnClickListener {
    final /* synthetic */ MainActivity f1715a;

    aa(MainActivity mainActivity) {
        this.f1715a = mainActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f1715a.moveTaskToBack(true);
        C0332j.m2148a().m2178d();
        C0331i.m2124a().m2136c(MainActivity.f1650w);
    }
}
