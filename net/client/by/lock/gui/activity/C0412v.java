package net.client.by.lock.gui.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import net.client.by.lock.p014c.C0332j;

/* compiled from: MyApp */
class C0412v implements OnClickListener {
    final /* synthetic */ LoginActivity f1826a;

    C0412v(LoginActivity loginActivity) {
        this.f1826a = loginActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1826a.m2607a(true);
        C0332j.m2148a().m2166b();
    }
}
