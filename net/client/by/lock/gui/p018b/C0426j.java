package net.client.by.lock.gui.p018b;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0341g;

/* compiled from: MyApp */
class C0426j implements OnClickListener {
    private final /* synthetic */ C0337c f1885a;
    private final /* synthetic */ C0341g f1886b;
    private final /* synthetic */ Dialog f1887c;

    C0426j(C0337c c0337c, C0341g c0341g, Dialog dialog) {
        this.f1885a = c0337c;
        this.f1886b = c0341g;
        this.f1887c = dialog;
    }

    public void onClick(View view) {
        C0418b.m2740b(view.getContext(), this.f1885a, this.f1886b).show();
        this.f1887c.dismiss();
    }
}
