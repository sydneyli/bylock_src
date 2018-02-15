package net.client.by.lock.gui.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MyApp */
class bo implements OnClickListener {
    final /* synthetic */ SelectFilesActivity f1790a;

    bo(SelectFilesActivity selectFilesActivity) {
        this.f1790a = selectFilesActivity;
    }

    public void onClick(View view) {
        this.f1790a.startActivityForResult(new Intent(this.f1790a, VirtualDriveActivity.class), 20);
    }
}
