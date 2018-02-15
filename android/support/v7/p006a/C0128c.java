package android.support.v7.p006a;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.p008b.C0157k;
import android.util.AttributeSet;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: MyApp */
public class C0128c extends MarginLayoutParams {
    public int f448a;

    public C0128c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f448a = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0157k.ActionBarLayout);
        this.f448a = obtainStyledAttributes.getInt(0, -1);
        obtainStyledAttributes.recycle();
    }

    public C0128c(int i, int i2, int i3) {
        super(i, i2);
        this.f448a = -1;
        this.f448a = i3;
    }

    public C0128c(int i) {
        this(-2, -1, i);
    }
}
