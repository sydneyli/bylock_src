package group.pals.android.lib.ui.filechooser;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import group.pals.android.lib.ui.filechooser.utils.C0276f;

/* compiled from: MyApp */
class C0247p implements TextWatcher {
    final /* synthetic */ FileChooserActivity f1162a;
    private final /* synthetic */ Button f1163b;

    C0247p(FileChooserActivity fileChooserActivity, Button button) {
        this.f1162a = fileChooserActivity;
        this.f1163b = button;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        this.f1163b.setEnabled(C0276f.m1891a(editable.toString().trim()));
    }
}
