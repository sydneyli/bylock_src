package group.pals.android.lib.ui.filechooser;

import group.pals.android.lib.ui.filechooser.io.C0230a;
import group.pals.android.lib.ui.filechooser.io.IFile;

/* compiled from: MyApp */
class C0281v implements C0230a {
    final /* synthetic */ C0260u f1230a;

    C0281v(C0260u c0260u) {
        this.f1230a = c0260u;
    }

    public boolean mo295a(IFile iFile) {
        if (this.f1230a.f1204e.f1083s.mo315b(iFile)) {
            if (this.f1230a.f1200a.size() < this.f1230a.f1204e.f1083s.mo311f()) {
                this.f1230a.f1200a.add(iFile);
            } else {
                this.f1230a.f1201b = true;
            }
        }
        return false;
    }
}
