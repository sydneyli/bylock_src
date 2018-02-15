package net.client.by.lock.gui.p017a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import net.client.by.lock.R;
import net.client.by.lock.p011a.C0289c;

/* compiled from: MyApp */
public class C0380e extends C0376a {
    private C0289c f1591j;
    private boolean f1592k;

    public C0380e(C0289c c0289c) {
        super(c0289c);
        this.f1591j = c0289c;
        c0289c.m1914F().addObserver(this.i);
        c0289c.m1938b().addObserver(this.i);
        this.f1592k = c0289c.m1912D();
    }

    public void mo331a(Context context) {
        this.a = View.inflate(context, R.layout.bubble, null);
        this.a.findViewById(this.f1592k ? R.id.left : R.id.right).setVisibility(8);
        ((ImageView) this.a.findViewById(this.f1592k ? R.id.chat_icon_right : R.id.chat_icon_left)).setImageResource(this.f1592k ? R.drawable.noti_call_white : R.drawable.noti_call_blue);
        this.a.findViewById(R.id.chat_bar).setVisibility(8);
        ((TextView) this.a.findViewById(this.f1592k ? R.id.chat_chat_right : R.id.chat_chat_left)).setText("Voice Call");
        if (this.f1592k) {
            this.f1591j.m1911C().addObserver(new C0381f(this));
        } else {
            m2552a();
        }
        TextView textView = (TextView) this.a.findViewById(this.f1592k ? R.id.chat_schat_left : R.id.chat_schat_right);
        if (textView != null) {
            textView.setText((CharSequence) this.f1591j.m1938b().m2467a());
        }
        m2562b();
    }

    private void m2562b() {
        String str = (String) this.f1591j.m1914F().m2467a();
        TextView textView = (TextView) this.a.findViewById(this.f1592k ? R.id.chat_schat_right : R.id.chat_schat_left);
        if (str.equals("MISSED")) {
            textView.setText("(Missed)");
        } else if (str.equals("REJECTED")) {
            textView.setText("(Rejected)");
        } else if (str.equals("CALLEE BUSY") || str.equals("CALLER BUSY")) {
            textView.setText("(Busy)");
        } else if (str.equals("CANCELED")) {
            textView.setText("(Cancelled)");
        } else if (str.equals("SOME ERROR")) {
            textView.setText("Error");
        } else if (str.equals("CLOSED")) {
            textView.setText("(Ended)");
        } else {
            textView.setText("(Awaiting)");
        }
    }

    public void mo332a(String str) {
        if (this.a == null) {
            return;
        }
        if (str.equals("seconds")) {
            TextView textView = (TextView) this.a.findViewById(this.f1592k ? R.id.chat_schat_left : R.id.chat_schat_right);
            if (textView != null) {
                textView.setText((CharSequence) this.f1591j.m1938b().m2467a());
            }
        } else if (str.equals("stateProperty")) {
            m2562b();
        }
    }
}
