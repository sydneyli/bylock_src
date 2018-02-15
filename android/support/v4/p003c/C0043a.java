package android.support.v4.p003c;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

/* compiled from: MyApp */
public class C0043a {
    public static Creator m312a(C0045c c0045c) {
        if (VERSION.SDK_INT >= 13) {
            C0047e.m315a(c0045c);
        }
        return new C0044b(c0045c);
    }
}
