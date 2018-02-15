package group.pals.android.lib.ui.filechooser;

import android.content.Context;
import group.pals.android.lib.ui.filechooser.utils.C0276f;
import group.pals.android.lib.ui.filechooser.utils.p010a.C0229e;
import group.pals.android.lib.ui.filechooser.utils.p010a.C0263d;

/* compiled from: MyApp */
class C0249r extends C0229e {
    final /* synthetic */ C0248q f1166a;
    private Thread f1167b;
    private final boolean f1168c;
    private final /* synthetic */ av f1169d;

    C0249r(C0248q c0248q, Context context, String str, boolean z, av avVar) {
        this.f1166a = c0248q;
        this.f1169d = avVar;
        super(context, str, z);
        this.f1167b = C0276f.m1890a(avVar.m1810a(), c0248q.f1164a.f1083s, true);
        this.f1168c = avVar.m1810a().isFile();
    }

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m1833a((Void[]) objArr);
    }

    private void m1832a() {
        this.f1166a.f1164a.f1060A.m1795b(this.f1169d);
        this.f1166a.f1164a.f1060A.notifyDataSetChanged();
        this.f1166a.f1164a.m1743q();
        Context a = this.f1166a.f1164a;
        FileChooserActivity a2 = this.f1166a.f1164a;
        int i = be.afc_pmsg_file_has_been_deleted;
        Object[] objArr = new Object[2];
        objArr[0] = this.f1168c ? this.f1166a.f1164a.getString(be.afc_file) : this.f1166a.f1164a.getString(be.afc_folder);
        objArr[1] = this.f1169d.m1810a().getName();
        C0263d.m1876a(a, a2.getString(i, objArr), 0);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.f1167b.start();
    }

    protected Object m1833a(Void... voidArr) {
        while (this.f1167b.isAlive()) {
            try {
                this.f1167b.join(10);
            } catch (InterruptedException e) {
                this.f1167b.interrupt();
            }
        }
        return null;
    }

    protected void onCancelled() {
        this.f1167b.interrupt();
        if (this.f1169d.m1810a().exists()) {
            this.f1166a.f1164a.m1700a(this.f1169d);
            C0263d.m1874a(this.f1166a.f1164a, be.afc_msg_cancelled, 0);
        } else {
            m1832a();
        }
        super.onCancelled();
    }

    protected void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        if (this.f1169d.m1810a().exists()) {
            String string;
            this.f1166a.f1164a.m1700a(this.f1169d);
            Context a = this.f1166a.f1164a;
            FileChooserActivity a2 = this.f1166a.f1164a;
            int i = be.afc_pmsg_cannot_delete_file;
            Object[] objArr = new Object[2];
            if (this.f1169d.m1810a().isFile()) {
                string = this.f1166a.f1164a.getString(be.afc_file);
            } else {
                string = this.f1166a.f1164a.getString(be.afc_folder);
            }
            objArr[0] = string;
            objArr[1] = this.f1169d.m1810a().getName();
            C0263d.m1876a(a, a2.getString(i, objArr), 0);
            return;
        }
        m1832a();
    }
}
