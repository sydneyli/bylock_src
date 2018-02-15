package android.support.v4.p000a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

/* compiled from: MyApp */
public class C0006d {
    private static final C0007e f12a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 15) {
            f12a = new C0010h();
        } else if (i >= 11) {
            f12a = new C0009g();
        } else {
            f12a = new C0008f();
        }
    }

    public static Intent m11a(ComponentName componentName) {
        return f12a.mo1a(componentName);
    }
}
