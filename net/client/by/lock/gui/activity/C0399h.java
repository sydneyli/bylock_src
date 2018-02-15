package net.client.by.lock.gui.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Chronometer;
import android.widget.TextView;
import net.client.by.lock.R;
import net.client.by.lock.p011a.C0289c;
import net.client.by.lock.p014c.C0324b;

/* compiled from: MyApp */
class C0399h implements OnClickListener {
    private C0289c f1806a;
    private Chronometer f1807b;
    private CallActivity f1808c;
    private boolean f1809d = false;

    public C0399h(C0289c c0289c, Chronometer chronometer, CallActivity callActivity) {
        this.f1806a = c0289c;
        this.f1807b = chronometer;
        this.f1808c = callActivity;
    }

    public void onClick(View view) {
        if (!this.f1809d) {
            this.f1809d = true;
            C0324b.f1410a.set(true);
            ((TextView) this.f1808c.f1614h.getCurrentView().findViewById(R.id.call_status)).setText(R.string.call_ended);
            this.f1807b.stop();
            view.postDelayed(new C0400i(this, this.f1807b.getText().toString()), 80);
        }
    }
}
