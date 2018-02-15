package net.client.by.lock.gui.activity;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MyApp */
class C0406o implements OnClickListener {
    final /* synthetic */ ChatActivity f1819a;

    C0406o(ChatActivity chatActivity) {
        this.f1819a = chatActivity;
    }

    public void onClick(View view) {
        Editable text = this.f1819a.f1628s.getText();
        if (text.length() > 0) {
            this.f1819a.f1627r.m2247a(text.toString());
            this.f1819a.f1628s.setText("");
        }
    }
}
