package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

/* compiled from: MyApp */
public class C0095v {
    static final C0096z f343a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f343a = new C0099y();
        } else {
            f343a = new C0097w();
        }
    }

    public static boolean m766a(KeyEvent keyEvent, int i) {
        return f343a.mo117a(keyEvent.getMetaState(), i);
    }

    public static boolean m765a(KeyEvent keyEvent) {
        return f343a.mo118b(keyEvent.getMetaState());
    }

    public static void m767b(KeyEvent keyEvent) {
        f343a.mo116a(keyEvent);
    }
}
