package group.pals.android.lib.ui.filechooser;

import group.pals.android.lib.ui.filechooser.io.IFile;
import group.pals.android.lib.ui.filechooser.utils.p010a.C0226i;

/* compiled from: MyApp */
class C0283x implements C0226i {
    IFile f1232a;
    final /* synthetic */ FileChooserActivity f1233b;
    private final /* synthetic */ IFile f1234c;

    C0283x(FileChooserActivity fileChooserActivity, IFile iFile) {
        this.f1233b = fileChooserActivity;
        this.f1234c = iFile;
        this.f1232a = fileChooserActivity.m1741p();
    }

    public void mo291a(boolean z, Object obj) {
        if (z) {
            this.f1233b.f1089y.mo282b(this.f1232a);
            this.f1233b.f1089y.mo280a(this.f1234c);
            this.f1233b.f1090z.mo280a(this.f1234c);
        }
    }
}
