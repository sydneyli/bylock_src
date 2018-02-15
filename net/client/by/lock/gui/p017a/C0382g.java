package net.client.by.lock.gui.p017a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import net.client.by.lock.R;
import net.client.by.lock.p012d.C0335b;

/* compiled from: MyApp */
public class C0382g extends C0376a {
    private C0335b f1594j;
    private boolean f1595k;

    public C0382g(C0335b c0335b) {
        super(c0335b);
        this.f1594j = c0335b;
        this.f1595k = c0335b.m1912D();
    }

    public void mo331a(Context context) {
        this.a = View.inflate(context, R.layout.bubble_text, null);
        this.a.findViewById(this.f1595k ? R.id.left : R.id.right).setVisibility(8);
        this.a.findViewById(R.id.chat_bar).setVisibility(8);
        if (!this.f1595k) {
            m2552a();
            m2553a(8);
        }
        ((TextView) this.a.findViewById(this.f1595k ? R.id.chat_chat_right : R.id.chat_chat_left)).setText(this.f1594j.m2211b());
    }

    public void mo332a(String str) {
    }
}
