package net.client.by.lock.gui.p017a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import net.client.by.lock.R;
import net.client.by.lock.p013b.C0315h;

/* compiled from: MyApp */
public class C0388m extends C0376a {
    private C0315h f1602j;

    public C0388m(C0315h c0315h) {
        super(c0315h);
        this.f1602j = c0315h;
    }

    public void mo331a(Context context) {
        int i;
        Object obj = ((C0315h) this.c).m2060l().size() == 0 ? 1 : null;
        if (obj != null) {
            this.a = View.inflate(context, R.layout.item_mail_attachment, null);
        } else {
            this.a = TextView.inflate(context, R.layout.bubble, null);
            ((TextView) this.a.findViewById(R.id.chat_chat_right)).setText("File");
            ((ImageView) this.a.findViewById(R.id.chat_icon_right)).setImageResource(R.drawable.noti_file_white);
            this.a.findViewById(R.id.left).setVisibility(8);
            ((TextView) this.a.findViewById(R.id.chat_schat_right)).setText(this.f1602j.mo325e());
        }
        if (((String) this.f1602j.m1914F().m2467a()).equals("COMPLETED")) {
            m2552a();
            this.a.findViewById(R.id.chat_bar).setVisibility(8);
            m2553a(8);
        } else {
            ((ProgressBar) this.a.findViewById(R.id.chat_bar)).setProgress(this.f);
        }
        View view = this.a;
        if (obj != null) {
            i = R.id.file_name;
        } else {
            i = R.id.right;
        }
        view.findViewById(i).setOnClickListener(new C0389n(this));
    }

    public void mo332a(String str) {
    }
}
