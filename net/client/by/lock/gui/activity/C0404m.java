package net.client.by.lock.gui.activity;

import android.text.Editable;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/* compiled from: MyApp */
class C0404m implements OnEditorActionListener {
    final /* synthetic */ ChatActivity f1817a;

    C0404m(ChatActivity chatActivity) {
        this.f1817a = chatActivity;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        Editable text = this.f1817a.f1628s.getText();
        if (text.length() > 0) {
            this.f1817a.f1627r.m2247a(text.toString());
            this.f1817a.f1628s.setText("");
        }
        return true;
    }
}
