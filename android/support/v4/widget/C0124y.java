package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: MyApp */
public class C0124y extends MarginLayoutParams {
    private static final int[] f443e = new int[]{16843137};
    public float f444a = 0.0f;
    boolean f445b;
    boolean f446c;
    Paint f447d;

    public C0124y() {
        super(-1, -1);
    }

    public C0124y(LayoutParams layoutParams) {
        super(layoutParams);
    }

    public C0124y(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public C0124y(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f443e);
        this.f444a = obtainStyledAttributes.getFloat(0, 0.0f);
        obtainStyledAttributes.recycle();
    }
}
