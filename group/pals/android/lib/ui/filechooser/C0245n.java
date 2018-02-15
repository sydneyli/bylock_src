package group.pals.android.lib.ui.filechooser;

import android.app.AlertDialog;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import group.pals.android.lib.ui.filechooser.utils.C0278h;

/* compiled from: MyApp */
class C0245n implements OnEditorActionListener {
    final /* synthetic */ FileChooserActivity f1157a;
    private final /* synthetic */ EditText f1158b;
    private final /* synthetic */ AlertDialog f1159c;

    C0245n(FileChooserActivity fileChooserActivity, EditText editText, AlertDialog alertDialog) {
        this.f1157a = fileChooserActivity;
        this.f1158b = editText;
        this.f1159c = alertDialog;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        C0278h.m1893a(this.f1157a, this.f1158b.getWindowToken());
        this.f1159c.getButton(-1).performClick();
        return true;
    }
}
