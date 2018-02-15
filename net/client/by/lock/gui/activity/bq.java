package net.client.by.lock.gui.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MyApp */
class bq implements OnClickListener {
    final /* synthetic */ SelectFilesActivity f1792a;

    bq(SelectFilesActivity selectFilesActivity) {
        this.f1792a = selectFilesActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        this.f1792a.startActivityForResult(Intent.createChooser(intent, "Select Picture"), 19);
    }
}
