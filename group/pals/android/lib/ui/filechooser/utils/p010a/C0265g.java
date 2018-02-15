package group.pals.android.lib.ui.filechooser.utils.p010a;

import android.util.Log;

/* compiled from: MyApp */
class C0265g implements Runnable {
    final /* synthetic */ C0229e f1213a;

    C0265g(C0229e c0229e) {
        this.f1213a = c0229e;
    }

    public void run() {
        if (!this.f1213a.f1125c) {
            try {
                this.f1213a.f1123a.show();
            } catch (Throwable th) {
                Log.e(C0229e.f1122f, "onPreExecute() - show dialog: " + th);
            }
        }
    }
}
