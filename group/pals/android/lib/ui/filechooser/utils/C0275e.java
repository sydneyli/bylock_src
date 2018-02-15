package group.pals.android.lib.ui.filechooser.utils;

import group.pals.android.lib.ui.filechooser.io.IFile;
import group.pals.android.lib.ui.filechooser.services.C0255e;
import group.pals.android.lib.ui.filechooser.services.C0256f;
import java.util.Comparator;

/* compiled from: MyApp */
public class C0275e implements Comparator {
    private static /* synthetic */ int[] f1223c;
    private final C0256f f1224a;
    private final C0255e f1225b;

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m1888a((IFile) obj, (IFile) obj2);
    }

    static /* synthetic */ int[] m1887a() {
        int[] iArr = f1223c;
        if (iArr == null) {
            iArr = new int[C0256f.values().length];
            try {
                iArr[C0256f.SortByDate.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C0256f.SortByName.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C0256f.SortBySize.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            f1223c = iArr;
        }
        return iArr;
    }

    public C0275e(C0256f c0256f, C0255e c0255e) {
        this.f1224a = c0256f;
        this.f1225b = c0255e;
    }

    public int m1888a(IFile iFile, IFile iFile2) {
        if ((iFile.isDirectory() && iFile2.isDirectory()) || (iFile.isFile() && iFile2.isFile())) {
            int compareToIgnoreCase = iFile.getName().compareToIgnoreCase(iFile2.getName());
            switch (C0275e.m1887a()[this.f1224a.ordinal()]) {
                case 2:
                    if (iFile.length() <= iFile2.length()) {
                        if (iFile.length() < iFile2.length()) {
                            compareToIgnoreCase = -1;
                            break;
                        }
                    }
                    compareToIgnoreCase = 1;
                    break;
                    break;
                case 3:
                    if (iFile.lastModified() <= iFile2.lastModified()) {
                        if (iFile.lastModified() < iFile2.lastModified()) {
                            compareToIgnoreCase = -1;
                            break;
                        }
                    }
                    compareToIgnoreCase = 1;
                    break;
                    break;
            }
            if (this.f1225b != C0255e.Ascending) {
                compareToIgnoreCase = -compareToIgnoreCase;
            }
            return compareToIgnoreCase;
        } else if (iFile.isDirectory()) {
            return -1;
        } else {
            return 1;
        }
    }
}
