package group.pals.android.lib.ui.filechooser;

import group.pals.android.lib.ui.filechooser.io.IFile;

/* compiled from: MyApp */
public class av {
    private IFile f1137a;
    private boolean f1138b;
    private boolean f1139c;

    public av(IFile iFile) {
        this.f1137a = iFile;
    }

    public IFile m1810a() {
        return this.f1137a;
    }

    public boolean m1813b() {
        return this.f1138b;
    }

    public void m1811a(boolean z) {
        if (this.f1138b != z) {
            this.f1138b = z;
        }
    }

    public boolean m1814c() {
        return this.f1139c;
    }

    public void m1812b(boolean z) {
        if (this.f1139c != z) {
            this.f1139c = z;
        }
    }
}
