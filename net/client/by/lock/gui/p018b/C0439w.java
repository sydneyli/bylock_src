package net.client.by.lock.gui.p018b;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import net.client.by.lock.p012d.C0351r;

/* compiled from: MyApp */
class C0439w implements OnClickListener {
    private final /* synthetic */ TextView f1916a;
    private final /* synthetic */ TextView f1917b;
    private final /* synthetic */ TextView f1918c;
    private final /* synthetic */ TextView f1919d;
    private final /* synthetic */ Dialog f1920e;

    C0439w(TextView textView, TextView textView2, TextView textView3, TextView textView4, Dialog dialog) {
        this.f1916a = textView;
        this.f1917b = textView2;
        this.f1918c = textView3;
        this.f1919d = textView4;
        this.f1920e = dialog;
    }

    public void onClick(View view) {
        int i = 0;
        if (view != this.f1916a) {
            if (view == this.f1917b) {
                i = 1;
            } else if (view == this.f1918c) {
                i = 2;
            } else if (view == this.f1919d) {
                i = 3;
            }
        }
        C0351r.m2359i().m2370b(Integer.valueOf(i));
        this.f1920e.dismiss();
    }
}
