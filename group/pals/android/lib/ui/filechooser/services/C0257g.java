package group.pals.android.lib.ui.filechooser.services;

import group.pals.android.lib.ui.filechooser.io.localfile.LocalFile;
import java.io.File;
import java.io.FileFilter;
import java.util.List;

/* compiled from: MyApp */
class C0257g implements FileFilter {
    final /* synthetic */ LocalFileProvider f1193a;
    private final /* synthetic */ List f1194b;

    C0257g(LocalFileProvider localFileProvider, List list) {
        this.f1193a = localFileProvider;
        this.f1194b = list;
    }

    public boolean accept(File file) {
        this.f1194b.add(new LocalFile(file));
        return false;
    }
}
