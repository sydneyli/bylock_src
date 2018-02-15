package net.client.by.lock.gui.p018b;

import android.view.View;
import android.view.View.OnClickListener;
import net.client.by.lock.p013b.C0308a;

/* compiled from: MyApp */
class aq implements OnClickListener {
    final /* synthetic */ ao f1869a;
    private C0308a f1870b;

    private aq(ao aoVar) {
        this.f1869a = aoVar;
    }

    public void onClick(View view) {
        if (this.f1869a.f1866b.contains(this.f1870b.mo322b())) {
            this.f1869a.f1866b.remove(this.f1870b.mo322b());
        } else {
            this.f1869a.f1866b.add(this.f1870b.mo322b());
        }
        this.f1869a.notifyDataSetChanged();
    }

    public void m2733a(C0308a c0308a) {
        this.f1870b = c0308a;
    }
}
