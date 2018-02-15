package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

/* compiled from: MyApp */
public class ap {
    static final as f316a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f316a = new ar();
        } else {
            f316a = new aq();
        }
    }

    public static float m568a(VelocityTracker velocityTracker, int i) {
        return f316a.mo63a(velocityTracker, i);
    }

    public static float m569b(VelocityTracker velocityTracker, int i) {
        return f316a.mo64b(velocityTracker, i);
    }
}
