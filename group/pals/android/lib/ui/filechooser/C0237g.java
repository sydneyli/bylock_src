package group.pals.android.lib.ui.filechooser;

import android.os.Bundle;
import group.pals.android.lib.ui.filechooser.io.IFile;
import group.pals.android.lib.ui.filechooser.utils.p010a.C0226i;

/* compiled from: MyApp */
class C0237g implements C0226i {
    final /* synthetic */ C0236f f1146a;
    private final /* synthetic */ IFile f1147b;
    private final /* synthetic */ Bundle f1148c;

    C0237g(C0236f c0236f, IFile iFile, Bundle bundle) {
        this.f1146a = c0236f;
        this.f1147b = iFile;
        this.f1148c = bundle;
    }

    public void mo291a(boolean z, Object obj) {
        if (z && this.f1147b != null && this.f1147b.isFile() && this.f1146a.f1144a.f1087w) {
            this.f1146a.f1144a.f1068I.setText(this.f1147b.getName());
        }
        Object obj2 = (this.f1148c == null || !obj.equals(this.f1148c.get(FileChooserActivity.f1057o))) ? null : 1;
        if (obj2 != null) {
            this.f1146a.f1144a.f1089y.mo288e();
            return;
        }
        this.f1146a.f1144a.f1089y.mo280a((IFile) obj);
        this.f1146a.f1144a.f1090z.mo280a((IFile) obj);
    }
}
