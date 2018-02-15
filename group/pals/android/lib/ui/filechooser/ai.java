package group.pals.android.lib.ui.filechooser;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import group.pals.android.lib.ui.filechooser.utils.C0278h;

/* compiled from: MyApp */
class ai implements OnEditorActionListener {
    final /* synthetic */ FileChooserActivity f1102a;

    ai(FileChooserActivity fileChooserActivity) {
        this.f1102a = fileChooserActivity;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        C0278h.m1893a(this.f1102a, this.f1102a.f1068I.getWindowToken());
        this.f1102a.f1067H.performClick();
        return true;
    }
}
