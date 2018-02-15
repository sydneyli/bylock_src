package net.client.by.lock.gui.p017a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import net.client.by.lock.R;
import net.client.by.lock.p012d.C0347l;

/* compiled from: MyApp */
public class C0386j extends C0385k {
    C0347l f1600j;

    public C0386j(C0347l c0347l) {
        super(c0347l);
        this.f1600j = c0347l;
    }

    public void mo331a(Context context) {
        this.a = View.inflate(context, R.layout.bubble, null);
        this.a.findViewById(R.id.chat_bar).setVisibility(8);
        this.a.findViewById(R.id.right).setVisibility(8);
        ((TextView) this.a.findViewById(R.id.chat_schat_left)).setText("read");
        ((ImageView) this.a.findViewById(R.id.chat_icon_left)).setImageResource(R.drawable.noti_mail_blue);
        TextView textView = (TextView) this.a.findViewById(R.id.chat_chat_left);
        textView.setText(this.f1600j.m2319h());
        if (this.f1600j.m2333f() || ((String) this.f1600j.m1914F().m2467a()).equals("COMPLETED")) {
            textView.setTypeface(null, 0);
        } else {
            textView.setTypeface(null, 1);
        }
        m2552a();
        this.a.findViewById(R.id.left).setOnClickListener(this.l);
    }

    public void mo332a(String str) {
        if (this.a != null && str.equals("stateProperty")) {
            TextView textView = (TextView) this.a.findViewById(R.id.chat_schat_left);
            if (((String) this.f1600j.m1914F().m2467a()).equals("COMPLETED")) {
                textView.setTypeface(null, 0);
            } else {
                textView.setTypeface(null, 1);
            }
        }
    }
}
