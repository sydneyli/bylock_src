package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.View;
import android.widget.LinearLayout;

/* compiled from: MyApp */
public class NativeActionModeAwareLayout extends LinearLayout {
    private ad f857a;

    public NativeActionModeAwareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setActionModeForChildListener(ad adVar) {
        this.f857a = adVar;
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        if (this.f857a != null) {
            callback = this.f857a.mo202a(callback);
        }
        return super.startActionModeForChild(view, callback);
    }
}
