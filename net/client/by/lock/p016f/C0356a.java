package net.client.by.lock.p016f;

import android.os.Environment;
import java.io.File;

/* compiled from: MyApp */
public class C0356a {
    private static String f1547a = null;
    private static String f1548b = null;

    public static String m2454a() {
        if (f1548b == null) {
            f1548b = new StringBuilder(String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath())).append(File.separator).append("by-lock-images").append(File.separator).toString();
        }
        return f1548b;
    }
}
