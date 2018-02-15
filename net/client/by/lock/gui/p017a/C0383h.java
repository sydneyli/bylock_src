package net.client.by.lock.gui.p017a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import net.client.by.lock.R;
import net.client.by.lock.p013b.C0314g;

/* compiled from: MyApp */
public class C0383h extends C0376a {
    private C0314g f1596j;

    public C0383h(C0314g c0314g) {
        super(c0314g);
        this.f1596j = c0314g;
    }

    public void mo331a(Context context) {
        this.a = View.inflate(context, R.layout.bubble, null);
        ((TextView) this.a.findViewById(R.id.chat_chat_left)).setText("File");
        ((ImageView) this.a.findViewById(R.id.chat_icon_left)).setImageResource(R.drawable.noti_file_blue);
        this.a.findViewById(R.id.right).setVisibility(8);
        ((TextView) this.a.findViewById(R.id.chat_schat_left)).setText(this.f1596j.mo325e());
        m2552a();
        if (((String) this.f1596j.m1914F().m2467a()).equals("COMPLETED")) {
            this.a.findViewById(R.id.chat_bar).setVisibility(8);
            m2553a(8);
        } else {
            ((ProgressBar) this.a.findViewById(R.id.chat_bar)).setProgress(this.f);
        }
        this.a.findViewById(R.id.left).setOnClickListener(new C0384i(this));
    }

    public void mo332a(String str) {
    }
}
