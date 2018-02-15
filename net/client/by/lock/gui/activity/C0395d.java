package net.client.by.lock.gui.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import net.client.by.lock.R;
import net.client.by.lock.p014c.C0324b;

/* compiled from: MyApp */
class C0395d implements OnClickListener {
    final /* synthetic */ CallActivity f1801a;

    C0395d(CallActivity callActivity) {
        this.f1801a = callActivity;
    }

    public void onClick(View view) {
        C0324b.f1410a.set(true);
        ((TextView) this.f1801a.f1614h.getCurrentView().findViewById(R.id.call_status)).setText(R.string.call_cancelled);
        view.postDelayed(new C0396e(this), 80);
    }
}
