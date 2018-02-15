package net.client.by.lock.gui.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MyApp */
class C0410t implements OnClickListener {
    final /* synthetic */ LoginActivity f1823a;

    C0410t(LoginActivity loginActivity) {
        this.f1823a = loginActivity;
    }

    public void onClick(View view) {
        this.f1823a.startActivity(new Intent(this.f1823a, RegisterActivity.class));
    }
}
