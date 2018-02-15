package group.pals.android.lib.ui.filechooser.utils;

import group.pals.android.lib.ui.filechooser.io.IFile;
import group.pals.android.lib.ui.filechooser.services.C0251c;
import java.util.List;

/* compiled from: MyApp */
class C0277g extends Thread {
    private final /* synthetic */ IFile f1227a;
    private final /* synthetic */ boolean f1228b;
    private final /* synthetic */ C0251c f1229c;

    C0277g(IFile iFile, boolean z, C0251c c0251c) {
        this.f1227a = iFile;
        this.f1228b = z;
        this.f1229c = c0251c;
    }

    public void run() {
        m1892a(this.f1227a);
    }

    private void m1892a(IFile iFile) {
        if (!isInterrupted()) {
            if (iFile.isFile()) {
                iFile.delete();
            } else if (!iFile.isDirectory()) {
            } else {
                if (this.f1228b) {
                    try {
                        List<IFile> a = this.f1229c.mo312a(iFile);
                        if (a == null) {
                            iFile.delete();
                            return;
                        }
                        for (IFile iFile2 : a) {
                            if (!isInterrupted()) {
                                if (iFile2.isFile()) {
                                    iFile2.delete();
                                } else if (iFile2.isDirectory()) {
                                    if (this.f1228b) {
                                        m1892a(iFile2);
                                    } else {
                                        iFile2.delete();
                                    }
                                }
                            } else {
                                return;
                            }
                        }
                        iFile.delete();
                        return;
                    } catch (Throwable th) {
                        return;
                    }
                }
                iFile.delete();
            }
        }
    }
}
