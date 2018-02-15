package net.client.by.lock.gui.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MyApp */
class br implements OnClickListener {
    final /* synthetic */ SelectFilesActivity f1793a;

    br(SelectFilesActivity selectFilesActivity) {
        this.f1793a = selectFilesActivity;
    }

    public void onClick(View view) {
        this.f1793a.onBackPressed();
    }
}
