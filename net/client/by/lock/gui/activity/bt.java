package net.client.by.lock.gui.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0342s;

/* compiled from: MyApp */
class bt implements OnClickListener {
    final /* synthetic */ SelectFriendsActivity f1795a;

    bt(SelectFriendsActivity selectFriendsActivity) {
        this.f1795a = selectFriendsActivity;
    }

    public void onClick(View view) {
        int i = 0;
        CheckedTextView checkedTextView = (CheckedTextView) view;
        boolean z = !checkedTextView.isChecked();
        C0342s c0342s = (C0342s) view.getTag();
        checkedTextView.setChecked(z);
        while (i < c0342s.m2306e().size()) {
            this.f1795a.m2632a((C0337c) ((C0342s) c0342s.m2306e().get(i)).m2305d(), z);
            i++;
        }
    }
}
