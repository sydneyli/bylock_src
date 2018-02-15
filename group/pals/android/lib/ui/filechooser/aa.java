package group.pals.android.lib.ui.filechooser;

import android.view.View;
import android.view.View.OnLongClickListener;
import group.pals.android.lib.ui.filechooser.io.IFile;
import group.pals.android.lib.ui.filechooser.services.C0254d;

/* compiled from: MyApp */
class aa implements OnLongClickListener {
    final /* synthetic */ FileChooserActivity f1094a;

    aa(FileChooserActivity fileChooserActivity) {
        this.f1094a = fileChooserActivity;
    }

    public boolean onLongClick(View view) {
        if (!(C0254d.FilesOnly.equals(this.f1094a.f1083s.mo308c()) || this.f1094a.f1087w)) {
            this.f1094a.m1705a((IFile) view.getTag());
        }
        return false;
    }
}
