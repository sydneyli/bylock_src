package net.client.by.lock.gui.p018b;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import net.client.by.lock.p012d.C0337c;

/* compiled from: MyApp */
class C0424h implements OnClickListener {
    private final /* synthetic */ C0337c f1881a;
    private final /* synthetic */ Dialog f1882b;

    C0424h(C0337c c0337c, Dialog dialog) {
        this.f1881a = c0337c;
        this.f1882b = dialog;
    }

    public void onClick(View view) {
        C0418b.m2737a(view.getContext(), this.f1881a).show();
        this.f1882b.dismiss();
    }
}
