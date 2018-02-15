package net.client.by.lock.gui.p018b;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import net.client.by.lock.p016f.C0366k;
import net.client.by.lock.p016f.C0367l;

/* compiled from: MyApp */
class C0438v implements TextWatcher {
    private final /* synthetic */ Button f1913a;
    private final /* synthetic */ EditText f1914b;
    private final /* synthetic */ String[] f1915c;

    C0438v(Button button, EditText editText, String[] strArr) {
        this.f1913a = button;
        this.f1914b = editText;
        this.f1915c = strArr;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        C0367l a = C0366k.m2481a(editable.toString());
        if (a == C0367l.SECURE) {
            this.f1913a.setEnabled(a == C0367l.SECURE);
            this.f1914b.setError(null);
            return;
        }
        this.f1914b.setError(this.f1915c[a.ordinal()]);
    }
}
