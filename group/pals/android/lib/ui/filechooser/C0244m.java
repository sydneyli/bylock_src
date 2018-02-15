package group.pals.android.lib.ui.filechooser;

import android.view.View;
import android.view.View.OnClickListener;
import group.pals.android.lib.ui.filechooser.io.IFile;

/* compiled from: MyApp */
class C0244m implements OnClickListener {
    final /* synthetic */ FileChooserActivity f1156a;

    C0244m(FileChooserActivity fileChooserActivity) {
        this.f1156a = fileChooserActivity;
    }

    public void onClick(View view) {
        if (view.getTag() instanceof IFile) {
            this.f1156a.m1707a((IFile) view.getTag());
        }
    }
}
