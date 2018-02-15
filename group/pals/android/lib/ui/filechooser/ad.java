package group.pals.android.lib.ui.filechooser;

import android.widget.ImageView;
import group.pals.android.lib.ui.filechooser.io.IFile;
import group.pals.android.lib.ui.filechooser.utils.p010a.C0226i;

/* compiled from: MyApp */
class ad implements C0226i {
    final /* synthetic */ ac f1097a;

    ad(ac acVar) {
        this.f1097a = acVar;
    }

    public void mo291a(boolean z, Object obj) {
        boolean z2 = true;
        if (z) {
            this.f1097a.f1096a.f1069J.setEnabled(true);
            ImageView d = this.f1097a.f1096a.f1070K;
            if (this.f1097a.f1096a.f1089y.mo289f(this.f1097a.f1096a.m1741p()) == null) {
                z2 = false;
            }
            d.setEnabled(z2);
            this.f1097a.f1096a.f1090z.mo280a((IFile) obj);
        }
    }
}
