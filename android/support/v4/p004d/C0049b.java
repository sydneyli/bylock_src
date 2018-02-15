package android.support.v4.p004d;

import android.util.Log;
import java.io.Writer;

/* compiled from: MyApp */
public class C0049b extends Writer {
    private final String f243a;
    private StringBuilder f244b = new StringBuilder(128);

    public C0049b(String str) {
        this.f243a = str;
    }

    public void close() {
        m317a();
    }

    public void flush() {
        m317a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m317a();
            } else {
                this.f244b.append(c);
            }
        }
    }

    private void m317a() {
        if (this.f244b.length() > 0) {
            Log.d(this.f243a, this.f244b.toString());
            this.f244b.delete(0, this.f244b.length());
        }
    }
}
