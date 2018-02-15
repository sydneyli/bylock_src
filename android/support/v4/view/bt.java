package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

/* compiled from: MyApp */
public class bt extends LayoutParams {
    public boolean f325a;
    public int f326b;
    float f327c = 0.0f;
    boolean f328d;
    int f329e;
    int f330f;

    public bt() {
        super(-1, -1);
    }

    public bt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f253a);
        this.f326b = obtainStyledAttributes.getInteger(0, 48);
        obtainStyledAttributes.recycle();
    }
}
