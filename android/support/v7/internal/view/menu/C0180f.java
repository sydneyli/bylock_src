package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v7.p008b.C0149c;
import android.widget.ImageButton;

/* compiled from: MyApp */
class C0180f extends ImageButton implements C0166j {
    final /* synthetic */ ActionMenuPresenter f692a;

    public C0180f(ActionMenuPresenter actionMenuPresenter, Context context) {
        this.f692a = actionMenuPresenter;
        super(context, null, C0149c.actionOverflowButtonStyle);
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
    }

    public boolean performClick() {
        if (!super.performClick()) {
            playSoundEffect(0);
            this.f692a.m1237a();
        }
        return true;
    }

    public boolean mo206c() {
        return false;
    }

    public boolean mo207d() {
        return false;
    }
}
