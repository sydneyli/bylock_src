package net.client.by.lock.gui.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import net.client.by.lock.p012d.C0337c;

/* compiled from: MyApp */
class bs implements OnClickListener {
    final /* synthetic */ SelectFriendsActivity f1794a;

    bs(SelectFriendsActivity selectFriendsActivity) {
        this.f1794a = selectFriendsActivity;
    }

    public void onClick(View view) {
        this.f1794a.m2632a((C0337c) view.getTag(), !((CheckedTextView) view).isChecked());
    }
}
