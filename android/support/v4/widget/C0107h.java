package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: MyApp */
public class C0107h extends MarginLayoutParams {
    public int f426a = 0;
    float f427b;
    boolean f428c;
    boolean f429d;

    public C0107h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f347a);
        this.f426a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
    }

    public C0107h(int i, int i2) {
        super(i, i2);
    }

    public C0107h(C0107h c0107h) {
        super(c0107h);
        this.f426a = c0107h.f426a;
    }

    public C0107h(LayoutParams layoutParams) {
        super(layoutParams);
    }

    public C0107h(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }
}
