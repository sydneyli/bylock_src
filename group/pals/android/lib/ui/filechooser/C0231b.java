package group.pals.android.lib.ui.filechooser;

import group.pals.android.lib.ui.filechooser.io.IFile;
import group.pals.android.lib.ui.filechooser.utils.p010a.C0226i;

/* compiled from: MyApp */
class C0231b implements C0226i {
    final /* synthetic */ C0225a f1140a;

    C0231b(C0225a c0225a) {
        this.f1140a = c0225a;
    }

    public void mo291a(boolean z, Object obj) {
        if (z) {
            this.f1140a.f1093a.f1069J.setEnabled(this.f1140a.f1093a.f1089y.mo287e(this.f1140a.f1093a.m1741p()) != null);
            this.f1140a.f1093a.f1070K.setEnabled(true);
            this.f1140a.f1093a.f1090z.mo280a((IFile) obj);
        }
    }
}
