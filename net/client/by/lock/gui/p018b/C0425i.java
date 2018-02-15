package net.client.by.lock.gui.p018b;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p014c.C0332j;

/* compiled from: MyApp */
class C0425i implements OnClickListener {
    private final /* synthetic */ C0337c f1883a;
    private final /* synthetic */ Dialog f1884b;

    C0425i(C0337c c0337c, Dialog dialog) {
        this.f1883a = c0337c;
        this.f1884b = dialog;
    }

    public void onClick(View view) {
        C0332j.m2148a().m2172b(this.f1883a);
        this.f1884b.dismiss();
    }
}
