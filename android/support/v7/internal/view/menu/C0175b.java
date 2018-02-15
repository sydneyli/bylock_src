package android.support.v7.internal.view.menu;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* compiled from: MyApp */
class C0175b implements TransformationMethod {
    final /* synthetic */ ActionMenuItemView f683a;
    private Locale f684b;

    public C0175b(ActionMenuItemView actionMenuItemView) {
        this.f683a = actionMenuItemView;
        this.f684b = actionMenuItemView.getContext().getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        return charSequence != null ? charSequence.toString().toUpperCase(this.f684b) : null;
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }
}
