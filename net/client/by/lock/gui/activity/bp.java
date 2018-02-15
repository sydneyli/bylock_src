package net.client.by.lock.gui.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import group.pals.android.lib.ui.filechooser.FileChooserActivity;
import group.pals.android.lib.ui.filechooser.io.localfile.LocalFile;
import net.client.by.lock.p014c.C0331i;

/* compiled from: MyApp */
class bp implements OnClickListener {
    final /* synthetic */ SelectFilesActivity f1791a;

    bp(SelectFilesActivity selectFilesActivity) {
        this.f1791a = selectFilesActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f1791a, FileChooserActivity.class);
        intent.putExtra(FileChooserActivity.f1045c, new LocalFile(C0331i.m2124a().m2132b()));
        this.f1791a.startActivityForResult(intent, 21);
    }
}
