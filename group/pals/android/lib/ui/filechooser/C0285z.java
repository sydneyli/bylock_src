package group.pals.android.lib.ui.filechooser;

import group.pals.android.lib.ui.filechooser.io.IFile;
import group.pals.android.lib.ui.filechooser.utils.history.C0227a;

/* compiled from: MyApp */
class C0285z implements C0227a {
    final /* synthetic */ FileChooserActivity f1236a;

    C0285z(FileChooserActivity fileChooserActivity) {
        this.f1236a = fileChooserActivity;
    }

    public boolean m1899a(IFile iFile) {
        return !iFile.isDirectory();
    }
}
