package net.client.by.lock.gui.p017a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import net.client.by.lock.gui.activity.ReadIMailActivity;
import net.client.by.lock.gui.activity.ReadOMailActivity;
import net.client.by.lock.p012d.C0347l;
import net.client.by.lock.p014c.C0325c;

/* compiled from: MyApp */
public class C0387l implements OnClickListener {
    final /* synthetic */ C0385k f1601a;

    protected C0387l(C0385k c0385k) {
        this.f1601a = c0385k;
    }

    public void onClick(View view) {
        Class cls;
        Context b = C0325c.m2086a().m2088b();
        if (b == null) {
            b = view.getContext();
        }
        if (this.f1601a.f1598k instanceof C0347l) {
            cls = ReadIMailActivity.class;
        } else {
            cls = ReadOMailActivity.class;
        }
        Intent intent = new Intent(b, cls);
        intent.putExtra("id", this.f1601a.f1598k.m1913E().m2237K());
        intent.putExtra("mailId", this.f1601a.f1598k.m2321j());
        ((Activity) b).startActivityForResult(intent, 22);
    }
}
