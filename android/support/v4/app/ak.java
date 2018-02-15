package android.support.v4.app;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

/* compiled from: MyApp */
class ak extends FrameLayout {
    static ViewGroup m143a(View view) {
        ViewGroup akVar = new ak(view.getContext());
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            akVar.setLayoutParams(layoutParams);
        }
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        akVar.addView(view);
        return akVar;
    }

    public ak(Context context) {
        super(context);
    }

    protected void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }
}
