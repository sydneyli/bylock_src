package net.client.by.lock.gui.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import net.client.by.lock.R;
import net.client.by.lock.p011a.C0289c;
import net.client.by.lock.p014c.C0330h;

/* compiled from: MyApp */
class C0402k implements OnClickListener {
    private C0289c f1813a;
    private CallActivity f1814b;
    private boolean f1815c = false;

    public C0402k(C0289c c0289c, CallActivity callActivity) {
        this.f1813a = c0289c;
        this.f1814b = callActivity;
    }

    public void onClick(View view) {
        if (!this.f1815c) {
            ((TextView) this.f1814b.f1614h.getCurrentView().findViewById(R.id.call_status)).setText(R.string.call_rejected);
            C0330h.m2111a().m2112a(10);
            this.f1813a.m1948j();
            this.f1813a.m1938b().m2468a((Object) "Rejected");
        }
    }
}
