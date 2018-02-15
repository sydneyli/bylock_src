package group.pals.android.lib.ui.filechooser;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import group.pals.android.lib.ui.filechooser.utils.C0276f;
import group.pals.android.lib.ui.filechooser.utils.p010a.C0263d;

/* compiled from: MyApp */
class C0246o implements OnClickListener {
    final /* synthetic */ FileChooserActivity f1160a;
    private final /* synthetic */ EditText f1161b;

    C0246o(FileChooserActivity fileChooserActivity, EditText editText) {
        this.f1160a = fileChooserActivity;
        this.f1161b = editText;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (C0276f.m1891a(this.f1161b.getText().toString().trim())) {
            if (this.f1160a.f1083s.mo314b(String.format("%s/%s", new Object[]{this.f1160a.m1741p().getAbsolutePath(), r0})).mkdir()) {
                C0263d.m1876a(this.f1160a, this.f1160a.getString(be.afc_msg_done), 0);
                this.f1160a.m1701a(this.f1160a.m1741p(), null);
                return;
            }
            C0263d.m1876a(this.f1160a, this.f1160a.getString(be.afc_pmsg_cannot_create_folder, new Object[]{r0}), 0);
            return;
        }
        C0263d.m1876a(this.f1160a, this.f1160a.getString(be.afc_pmsg_filename_is_invalid, new Object[]{r0}), 0);
    }
}
