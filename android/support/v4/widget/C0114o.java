package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

/* compiled from: MyApp */
class C0114o {
    public static Object m938a(Context context) {
        return new EdgeEffect(context);
    }

    public static void m939a(Object obj, int i, int i2) {
        ((EdgeEffect) obj).setSize(i, i2);
    }

    public static boolean m940a(Object obj) {
        return ((EdgeEffect) obj).isFinished();
    }

    public static void m943b(Object obj) {
        ((EdgeEffect) obj).finish();
    }

    public static boolean m941a(Object obj, float f) {
        ((EdgeEffect) obj).onPull(f);
        return true;
    }

    public static boolean m944c(Object obj) {
        EdgeEffect edgeEffect = (EdgeEffect) obj;
        edgeEffect.onRelease();
        return edgeEffect.isFinished();
    }

    public static boolean m942a(Object obj, Canvas canvas) {
        return ((EdgeEffect) obj).draw(canvas);
    }
}
