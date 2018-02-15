package group.pals.android.lib.ui.filechooser;

import android.content.Context;
import android.widget.TextView;
import group.pals.android.lib.ui.filechooser.io.IFile;
import group.pals.android.lib.ui.filechooser.utils.C0275e;
import group.pals.android.lib.ui.filechooser.utils.p010a.C0226i;
import group.pals.android.lib.ui.filechooser.utils.p010a.C0229e;
import group.pals.android.lib.ui.filechooser.utils.p010a.C0263d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: MyApp */
class C0260u extends C0229e {
    List f1200a;
    boolean f1201b = false;
    int f1202c = -1;
    String f1203d;
    final /* synthetic */ FileChooserActivity f1204e;
    private final /* synthetic */ IFile f1205g;
    private final /* synthetic */ IFile f1206h;
    private final /* synthetic */ C0226i f1207i;

    C0260u(FileChooserActivity fileChooserActivity, Context context, int i, boolean z, IFile iFile, IFile iFile2, C0226i c0226i) {
        this.f1204e = fileChooserActivity;
        this.f1205g = iFile;
        this.f1206h = iFile2;
        this.f1207i = c0226i;
        super(context, i, z);
        this.f1203d = fileChooserActivity.m1741p() != null ? fileChooserActivity.m1741p().getAbsolutePath() : null;
    }

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m1870a((Void[]) objArr);
    }

    protected Object m1870a(Void... voidArr) {
        try {
            if (this.f1205g.isDirectory() && this.f1205g.canRead()) {
                this.f1200a = new ArrayList();
                this.f1204e.f1083s.mo313a(this.f1205g, new C0281v(this));
            } else {
                this.f1200a = null;
            }
            if (this.f1200a != null) {
                Collections.sort(this.f1200a, new C0275e(this.f1204e.f1083s.mo309d(), this.f1204e.f1083s.mo310e()));
                int i;
                if (this.f1206h != null && this.f1206h.exists() && this.f1206h.mo297a().mo298a(this.f1205g)) {
                    for (i = 0; i < this.f1200a.size(); i++) {
                        if (((IFile) this.f1200a.get(i)).mo298a(this.f1206h)) {
                            this.f1202c = i;
                            break;
                        }
                    }
                } else if (this.f1203d != null && this.f1203d.length() >= this.f1205g.getAbsolutePath().length()) {
                    for (i = 0; i < this.f1200a.size(); i++) {
                        IFile iFile = (IFile) this.f1200a.get(i);
                        if (iFile.isDirectory() && this.f1203d.startsWith(iFile.getAbsolutePath())) {
                            this.f1202c = i;
                            break;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            m1804a(th);
            cancel(false);
        }
        return null;
    }

    protected void onCancelled() {
        super.onCancelled();
        C0263d.m1874a(this.f1204e, be.afc_msg_cancelled, 0);
    }

    protected void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        if (this.f1200a == null) {
            C0263d.m1876a(this.f1204e, this.f1204e.getString(be.afc_pmsg_cannot_access_dir, new Object[]{this.f1205g.getName()}), 0);
            if (this.f1207i != null) {
                this.f1207i.mo291a(false, this.f1205g);
                return;
            }
            return;
        }
        this.f1204e.m1723g();
        for (IFile avVar : this.f1200a) {
            this.f1204e.f1060A.m1791a(new av(avVar));
        }
        this.f1204e.f1060A.notifyDataSetChanged();
        TextView y = this.f1204e.f1066G;
        int i = (this.f1201b || this.f1204e.f1060A.isEmpty()) ? 0 : 8;
        y.setVisibility(i);
        if (this.f1201b) {
            this.f1204e.f1066G.setText(this.f1204e.getString(be.afc_pmsg_max_file_count_allowed, new Object[]{Integer.valueOf(this.f1204e.f1083s.mo311f())}));
        } else if (this.f1204e.f1060A.isEmpty()) {
            this.f1204e.f1066G.setText(be.afc_msg_empty);
        }
        this.f1204e.f1065F.post(new C0282w(this));
        this.f1204e.m1713b(this.f1205g);
        if (this.f1207i != null) {
            this.f1207i.mo291a(true, this.f1205g);
        }
    }
}
