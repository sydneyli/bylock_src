package group.pals.android.lib.ui.filechooser;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import group.pals.android.lib.ui.filechooser.io.IFile;

/* compiled from: MyApp */
class C0259t implements OnClickListener {
    final /* synthetic */ FileChooserActivity f1198a;
    private final /* synthetic */ IFile f1199b;

    C0259t(FileChooserActivity fileChooserActivity, IFile iFile) {
        this.f1198a = fileChooserActivity;
        this.f1199b = iFile;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1198a.m1705a(this.f1199b);
    }
}
