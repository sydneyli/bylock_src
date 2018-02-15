package group.pals.android.lib.ui.filechooser;

import android.content.Context;
import android.os.Bundle;
import group.pals.android.lib.ui.filechooser.io.IFile;
import group.pals.android.lib.ui.filechooser.p009a.C0223a;
import group.pals.android.lib.ui.filechooser.utils.p010a.C0229e;

/* compiled from: MyApp */
class C0236f extends C0229e {
    final /* synthetic */ FileChooserActivity f1144a;
    private final /* synthetic */ Bundle f1145b;

    C0236f(FileChooserActivity fileChooserActivity, Context context, int i, boolean z, Bundle bundle) {
        this.f1144a = fileChooserActivity;
        this.f1145b = bundle;
        super(context, i, z);
    }

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m1819a((Void[]) objArr);
    }

    protected Object m1819a(Void... voidArr) {
        int i = 0;
        while (this.f1144a.f1083s == null) {
            i += 200;
            try {
                Thread.sleep(200);
                if (i >= 3000) {
                    break;
                }
            } catch (InterruptedException e) {
            }
        }
        return null;
    }

    protected void onPostExecute(Object obj) {
        IFile iFile = null;
        super.onPostExecute(obj);
        if (this.f1144a.f1083s == null) {
            this.f1144a.m1730j();
            return;
        }
        IFile iFile2;
        this.f1144a.m1718d();
        this.f1144a.m1720e();
        this.f1144a.m1722f();
        this.f1144a.m1726h();
        IFile iFile3 = this.f1145b != null ? (IFile) this.f1145b.get(FileChooserActivity.f1057o) : null;
        if (iFile3 == null) {
            iFile2 = (IFile) this.f1144a.getIntent().getParcelableExtra(FileChooserActivity.f1053k);
            if (iFile2 != null && iFile2.exists()) {
                iFile3 = iFile2.mo297a();
            }
            if (iFile3 == null) {
                iFile2 = iFile3;
            } else {
                iFile = iFile2;
                iFile2 = iFile3;
            }
        } else {
            iFile2 = iFile3;
        }
        if (iFile2 == null && C0223a.m1766f(this.f1144a)) {
            String g = C0223a.m1767g(this.f1144a);
            if (g != null) {
                iFile2 = this.f1144a.f1083s.mo314b(g);
            }
        }
        FileChooserActivity fileChooserActivity = this.f1144a;
        if (iFile2 == null || !iFile2.isDirectory()) {
            iFile2 = this.f1144a.f1085u;
        }
        fileChooserActivity.m1702a(iFile2, new C0237g(this, iFile, this.f1145b), iFile);
    }
}
