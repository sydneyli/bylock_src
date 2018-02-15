package group.pals.android.lib.ui.filechooser;

import android.content.Context;
import android.os.Build.VERSION;
import group.pals.android.lib.ui.filechooser.p009a.C0223a;
import group.pals.android.lib.ui.filechooser.utils.C0271a;
import group.pals.android.lib.ui.filechooser.utils.p010a.C0229e;

/* compiled from: MyApp */
class C0243l extends C0229e {
    private static /* synthetic */ int[] f1154b;
    final /* synthetic */ FileChooserActivity f1155a;

    C0243l(FileChooserActivity fileChooserActivity, Context context, int i, boolean z) {
        this.f1155a = fileChooserActivity;
        super(context, i, z);
    }

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m1830a((Void[]) objArr);
    }

    static /* synthetic */ int[] m1829a() {
        int[] iArr = f1154b;
        if (iArr == null) {
            iArr = new int[am.values().length];
            try {
                iArr[am.Grid.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[am.List.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            f1154b = iArr;
        }
        return iArr;
    }

    protected void onPreExecute() {
        super.onPreExecute();
        switch (C0243l.m1829a()[C0223a.m1757a(this.f1155a).ordinal()]) {
            case 1:
                C0223a.m1758a(this.f1155a, am.Grid);
                break;
            case 2:
                C0223a.m1758a(this.f1155a, am.List);
                break;
        }
        this.f1155a.m1722f();
        if (VERSION.SDK_INT >= 11) {
            C0271a.m1882a(this.f1155a);
        }
        this.f1155a.m1728i();
    }

    protected Object m1830a(Void... voidArr) {
        return null;
    }
}
