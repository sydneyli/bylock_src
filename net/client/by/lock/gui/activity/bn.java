package net.client.by.lock.gui.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import java.io.IOException;
import net.client.by.lock.gui.p018b.an;

/* compiled from: MyApp */
class bn implements OnClickListener {
    final /* synthetic */ SelectFilesActivity f1789a;

    bn(SelectFilesActivity selectFilesActivity) {
        this.f1789a = selectFilesActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            intent.putExtra("output", Uri.fromFile(SelectFilesActivity.m2630i()));
            this.f1789a.startActivityForResult(intent, 18);
        } catch (IOException e) {
            an.m2728a(this.f1789a, "Error in access to writable directory");
            this.f1789a.setResult(0);
            this.f1789a.finish();
        }
    }
}
