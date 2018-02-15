package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

/* compiled from: MyApp */
public class aj {
    static final am f315a;

    static {
        if (VERSION.SDK_INT >= 5) {
            f315a = new al();
        } else {
            f315a = new ak();
        }
    }

    public static int m541a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int m543b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int m542a(MotionEvent motionEvent, int i) {
        return f315a.mo59a(motionEvent, i);
    }

    public static int m544b(MotionEvent motionEvent, int i) {
        return f315a.mo60b(motionEvent, i);
    }

    public static float m545c(MotionEvent motionEvent, int i) {
        return f315a.mo61c(motionEvent, i);
    }

    public static float m547d(MotionEvent motionEvent, int i) {
        return f315a.mo62d(motionEvent, i);
    }

    public static int m546c(MotionEvent motionEvent) {
        return f315a.mo58a(motionEvent);
    }
}
