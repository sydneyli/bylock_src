package android.support.v4.view;

import android.view.MotionEvent;

/* compiled from: MyApp */
class an {
    public static int m564a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public static int m565b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static float m566c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public static float m567d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }

    public static int m563a(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }
}
