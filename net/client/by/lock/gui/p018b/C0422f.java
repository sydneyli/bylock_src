package net.client.by.lock.gui.p018b;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import java.io.File;

/* compiled from: MyApp */
class C0422f implements OnClickListener {
    private final /* synthetic */ File f1878a;
    private final /* synthetic */ Dialog f1879b;

    C0422f(File file, Dialog dialog) {
        this.f1878a = file;
        this.f1879b = dialog;
    }

    public void onClick(View view) {
        this.f1878a.delete();
        this.f1879b.dismiss();
    }
}
