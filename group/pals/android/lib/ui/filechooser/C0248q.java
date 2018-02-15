package group.pals.android.lib.ui.filechooser;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: MyApp */
class C0248q implements OnClickListener {
    final /* synthetic */ FileChooserActivity f1164a;
    private final /* synthetic */ av f1165b;

    C0248q(FileChooserActivity fileChooserActivity, av avVar) {
        this.f1164a = fileChooserActivity;
        this.f1165b = avVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        Context context = this.f1164a;
        FileChooserActivity fileChooserActivity = this.f1164a;
        int i2 = be.afc_pmsg_deleting_file;
        Object[] objArr = new Object[2];
        objArr[0] = this.f1165b.m1810a().isFile() ? this.f1164a.getString(be.afc_file) : this.f1164a.getString(be.afc_folder);
        objArr[1] = this.f1165b.m1810a().getName();
        new C0249r(this, context, fileChooserActivity.getString(i2, objArr), true, this.f1165b).execute(new Void[0]);
    }
}
