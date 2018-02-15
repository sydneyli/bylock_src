package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

/* compiled from: MyApp */
class bf {
    static long m667a() {
        return ValueAnimator.getFrameDelay();
    }

    public static void m668a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static int m666a(View view) {
        return view.getLayerType();
    }
}
