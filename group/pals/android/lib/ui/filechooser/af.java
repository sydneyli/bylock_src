package group.pals.android.lib.ui.filechooser;

import group.pals.android.lib.ui.filechooser.io.IFile;
import group.pals.android.lib.ui.filechooser.utils.p010a.C0226i;

/* compiled from: MyApp */
class af implements C0226i {
    final /* synthetic */ ae f1099a;

    af(ae aeVar) {
        this.f1099a = aeVar;
    }

    public void mo291a(boolean z, Object obj) {
        this.f1099a.f1098a.f1089y.mo278a(new ag(this));
        if (obj instanceof IFile) {
            this.f1099a.f1098a.m1701a((IFile) obj, new ah(this));
        } else if (this.f1099a.f1098a.f1089y.mo284c()) {
            this.f1099a.f1098a.f1089y.mo280a(this.f1099a.f1098a.m1741p());
            this.f1099a.f1098a.f1090z.mo280a(this.f1099a.f1098a.m1741p());
        }
    }
}
