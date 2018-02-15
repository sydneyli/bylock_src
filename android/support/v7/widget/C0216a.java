package android.support.v7.widget;

import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

/* compiled from: MyApp */
class C0216a {
    private Method f1012a;
    private Method f1013b;
    private Method f1014c;
    private Method f1015d;

    C0216a() {
        try {
            this.f1012a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
            this.f1012a.setAccessible(true);
        } catch (NoSuchMethodException e) {
        }
        try {
            this.f1013b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
            this.f1013b.setAccessible(true);
        } catch (NoSuchMethodException e2) {
        }
        try {
            this.f1014c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
            this.f1014c.setAccessible(true);
        } catch (NoSuchMethodException e3) {
        }
        try {
            this.f1015d = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
            this.f1015d.setAccessible(true);
        } catch (NoSuchMethodException e4) {
        }
    }

    void m1630a(AutoCompleteTextView autoCompleteTextView) {
        if (this.f1012a != null) {
            try {
                this.f1012a.invoke(autoCompleteTextView, new Object[0]);
            } catch (Exception e) {
            }
        }
    }

    void m1632b(AutoCompleteTextView autoCompleteTextView) {
        if (this.f1013b != null) {
            try {
                this.f1013b.invoke(autoCompleteTextView, new Object[0]);
            } catch (Exception e) {
            }
        }
    }

    void m1631a(AutoCompleteTextView autoCompleteTextView, boolean z) {
        if (this.f1014c != null) {
            try {
                this.f1014c.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
            }
        }
    }
}
