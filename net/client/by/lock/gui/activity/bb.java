package net.client.by.lock.gui.activity;

import android.view.View;
import android.view.View.OnClickListener;
import net.client.by.lock.p012d.C0334a;
import net.client.by.lock.p013b.C0312d;

/* compiled from: MyApp */
class bb implements OnClickListener {
    private Object f1775a;

    public bb(Object obj) {
        this.f1775a = obj;
    }

    public void onClick(View view) {
        C0312d a = ((C0334a) this.f1775a).m2194a();
        if (a != null && ((String) a.m1914F().m2467a()).equals("IN PROGRESS")) {
            a.m2043k();
        }
        aw.m2681c((C0334a) this.f1775a);
    }
}
