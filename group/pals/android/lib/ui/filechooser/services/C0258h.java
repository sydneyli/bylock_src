package group.pals.android.lib.ui.filechooser.services;

import group.pals.android.lib.ui.filechooser.io.C0230a;
import group.pals.android.lib.ui.filechooser.io.IFile;
import group.pals.android.lib.ui.filechooser.io.localfile.LocalFile;
import java.io.File;
import java.io.FileFilter;
import java.util.List;

/* compiled from: MyApp */
class C0258h implements FileFilter {
    final /* synthetic */ LocalFileProvider f1195a;
    private final /* synthetic */ C0230a f1196b;
    private final /* synthetic */ List f1197c;

    C0258h(LocalFileProvider localFileProvider, C0230a c0230a, List list) {
        this.f1195a = localFileProvider;
        this.f1196b = c0230a;
        this.f1197c = list;
    }

    public boolean accept(File file) {
        IFile localFile = new LocalFile(file);
        if (this.f1196b == null || this.f1196b.mo295a(localFile)) {
            this.f1197c.add(localFile);
        }
        return false;
    }
}
