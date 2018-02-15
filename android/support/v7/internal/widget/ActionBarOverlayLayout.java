package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v7.p006a.C0126a;
import android.support.v7.p008b.C0149c;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* compiled from: MyApp */
public class ActionBarOverlayLayout extends FrameLayout {
    static final int[] f805a = new int[]{C0149c.actionBarSize};
    private int f806b;
    private C0126a f807c;
    private final Rect f808d = new Rect(0, 0, 0, 0);

    public ActionBarOverlayLayout(Context context) {
        super(context);
        m1474a(context);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1474a(context);
    }

    private void m1474a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f805a);
        this.f806b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
    }

    public void setActionBar(C0126a c0126a) {
        this.f807c = c0126a;
    }
}
