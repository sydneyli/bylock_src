package android.support.v7.internal.view.menu;

import android.support.v7.p007c.C0158c;
import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: MyApp */
class C0190z extends FrameLayout implements CollapsibleActionView {
    final C0158c f741a;

    C0190z(View view) {
        super(view.getContext());
        this.f741a = (C0158c) view;
        addView(view);
    }

    public void onActionViewExpanded() {
        this.f741a.mo272a();
    }

    public void onActionViewCollapsed() {
        this.f741a.mo273b();
    }

    View m1420a() {
        return (View) this.f741a;
    }
}
