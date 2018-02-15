package net.client.by.lock.gui.p018b;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0341g;
import net.client.by.lock.p014c.C0332j;

/* compiled from: MyApp */
class C0427k implements OnClickListener {
    private final /* synthetic */ C0337c f1888a;
    private final /* synthetic */ C0341g f1889b;
    private final /* synthetic */ Dialog f1890c;

    C0427k(C0337c c0337c, C0341g c0341g, Dialog dialog) {
        this.f1888a = c0337c;
        this.f1889b = c0341g;
        this.f1890c = dialog;
    }

    public void onClick(View view) {
        C0332j.m2148a().m2168b(Integer.valueOf(this.f1888a.m2237K()), Integer.valueOf(this.f1889b.m2301a()));
        this.f1890c.dismiss();
    }
}
