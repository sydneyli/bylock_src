package group.pals.android.lib.ui.filechooser.services;

import android.os.Environment;
import group.pals.android.lib.ui.filechooser.io.C0230a;
import group.pals.android.lib.ui.filechooser.io.IFile;
import group.pals.android.lib.ui.filechooser.io.localfile.LocalFile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MyApp */
public class LocalFileProvider extends C0252a {
    private static /* synthetic */ int[] f1179a;

    static /* synthetic */ int[] m1861h() {
        int[] iArr = f1179a;
        if (iArr == null) {
            iArr = new int[C0254d.values().length];
            try {
                iArr[C0254d.DirectoriesOnly.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C0254d.FilesAndDirectories.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C0254d.FilesOnly.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            f1179a = iArr;
        }
        return iArr;
    }

    public void onCreate() {
    }

    public IFile mo316g() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        return externalStorageDirectory == null ? mo314b("/") : new LocalFile(externalStorageDirectory);
    }

    public IFile mo314b(String str) {
        return new LocalFile(str);
    }

    public List mo312a(IFile iFile) {
        if (!(iFile instanceof File) || !iFile.canRead()) {
            return null;
        }
        try {
            List arrayList = new ArrayList();
            if (((File) iFile).listFiles(new C0257g(this, arrayList)) == null) {
                return null;
            }
            return arrayList;
        } catch (Throwable th) {
            return null;
        }
    }

    public List mo313a(IFile iFile, C0230a c0230a) {
        if (!(iFile instanceof File)) {
            return null;
        }
        List arrayList = new ArrayList();
        try {
            if (((File) iFile).listFiles(new C0258h(this, c0230a, arrayList)) != null) {
                return arrayList;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public boolean mo315b(IFile iFile) {
        if (!m1855a() && iFile.getName().startsWith(".")) {
            return false;
        }
        switch (m1861h()[mo308c().ordinal()]) {
            case 1:
                if (m1856b() == null || !iFile.isFile()) {
                    return true;
                }
                return iFile.getName().matches(m1856b());
            case 2:
                return iFile.isDirectory();
            default:
                if (m1856b() == null || !iFile.isFile()) {
                    return true;
                }
                return iFile.getName().matches(m1856b());
        }
    }
}
