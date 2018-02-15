package net.client.by.lock.gui.activity;

import android.view.View;
import android.view.View.OnClickListener;
import net.client.by.lock.p014c.C0330h;

/* compiled from: MyApp */
class C0394c implements OnClickListener {
    final /* synthetic */ CallActivity f1800a;

    C0394c(CallActivity callActivity) {
        this.f1800a = callActivity;
    }

    public void onClick(View view) {
        this.f1800a.m2582a(1, -1);
        C0330h.m2111a().m2112a(10);
        this.f1800a.f1612f.m1947i();
    }
}
