package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.p008b.C0157k;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: MyApp */
public class C0165s extends TextView {
    public C0165s(Context context) {
        this(context, null);
    }

    public C0165s(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0165s(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0157k.CompatTextView, i, 0);
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        if (z) {
            setTransformationMethod(new C0210t(context));
        }
    }
}
