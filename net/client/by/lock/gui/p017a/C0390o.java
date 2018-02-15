package net.client.by.lock.gui.p017a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import net.client.by.lock.R;
import net.client.by.lock.p012d.C0348n;

/* compiled from: MyApp */
public class C0390o extends C0385k {
    private C0348n f1604j;

    public C0390o(C0348n c0348n) {
        super(c0348n);
        this.f1604j = c0348n;
    }

    public void mo331a(Context context) {
        this.a = View.inflate(context, R.layout.bubble, null);
        this.a.findViewById(R.id.left).setVisibility(8);
        if (((String) this.f1604j.m1914F().m2467a()).equals("COMPLETED")) {
            this.a.findViewById(R.id.chat_bar).setVisibility(8);
            m2552a();
        }
        ((TextView) this.a.findViewById(R.id.chat_schat_right)).setText("read");
        ((ImageView) this.a.findViewById(R.id.chat_icon_right)).setImageResource(R.drawable.noti_mail_white);
        ((TextView) this.a.findViewById(R.id.chat_chat_right)).setText(this.f1604j.m2319h());
        this.a.findViewById(R.id.right).setOnClickListener(this.l);
    }

    public void mo332a(String str) {
        if (((String) this.f1604j.m1914F().m2467a()).equals("COMPLETED")) {
            this.a.findViewById(R.id.chat_bar).setVisibility(8);
            m2552a();
        }
    }
}
