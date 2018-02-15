package net.client.by.lock.p016f;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.os.Build.VERSION;
import android.support.v4.app.C0024j;
import android.text.ClipboardManager;

/* compiled from: MyApp */
public class C0370o {
    public static int m2489a() {
        if (C0370o.m2492a(12)) {
            return C0370o.m2496c();
        }
        return C0370o.m2493b();
    }

    private static int m2493b() {
        return 1;
    }

    @TargetApi(12)
    private static int m2496c() {
        return 3;
    }

    public static boolean m2492a(int i) {
        return i <= VERSION.SDK_INT;
    }

    public static void m2490a(C0024j c0024j) {
        if (C0370o.m2492a(11)) {
            C0370o.m2494b(c0024j);
        }
    }

    @TargetApi(13)
    private static void m2494b(C0024j c0024j) {
        c0024j.invalidateOptionsMenu();
    }

    public static void m2491a(Object obj, String str, String str2) {
        if (C0370o.m2492a(11)) {
            C0370o.m2497c(obj, str, str2);
        } else {
            C0370o.m2495b(obj, str, str2);
        }
    }

    private static void m2495b(Object obj, String str, String str2) {
        ((ClipboardManager) obj).setText(str2);
    }

    @TargetApi(11)
    private static void m2497c(Object obj, String str, String str2) {
        ((android.content.ClipboardManager) obj).setPrimaryClip(ClipData.newPlainText(str, str2));
    }
}
