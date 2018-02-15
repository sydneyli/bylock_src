package net.client.by.lock.p011a;

import android.media.AudioTrack;
import net.client.by.lock.C0322b;
import net.client.by.lock.p014c.C0324b;
import net.client.by.lock.p016f.C0358c;

/* compiled from: MyApp */
public class C0305s extends C0291e {
    public static AudioTrack f1337a;

    public C0305s() {
        int b = C0358c.m2458b();
        int c = C0358c.m2459c();
        int minBufferSize = AudioTrack.getMinBufferSize(b, 4, c);
        f1337a = new AudioTrack(0, b, 4, c, minBufferSize, 1);
        C0322b.m2076e("SourceDataLine", "@Open Bonk " + minBufferSize);
    }

    public synchronized void m1995a(short[] sArr, int i, int i2) {
        if (!C0324b.f1410a.get()) {
            try {
                f1337a.write(sArr, i, i2 / 2);
            } catch (Exception e) {
                if (C0324b.f1410a.get()) {
                }
            }
            if (!C0324b.f1410a.get()) {
                try {
                    f1337a.write(sArr, (i2 / 2) + i, i2 - (i2 / 2));
                } catch (Exception e2) {
                    if (C0324b.f1410a.get()) {
                    }
                }
                if (!C0324b.f1410a.get()) {
                    f1337a.flush();
                }
            }
        }
    }

    public void m1994a() {
        try {
            f1337a.play();
        } catch (IllegalStateException e) {
            int b = C0358c.m2458b();
            int c = C0358c.m2459c();
            int minBufferSize = AudioTrack.getMinBufferSize(b, 4, c);
            f1337a = new AudioTrack(0, b, 4, c, minBufferSize, 1);
            C0322b.m2076e("SourceDataLine", "@Start Bonk " + minBufferSize);
            f1337a.play();
        }
    }

    public synchronized void m1996b() {
        if (f1337a != null) {
            if (m1997c() && f1337a.getPlayState() == 3) {
                f1337a.stop();
            }
            f1337a.release();
            f1337a = null;
        }
    }

    public synchronized boolean m1997c() {
        boolean z = true;
        synchronized (this) {
            if (f1337a == null || f1337a.getState() != 1) {
                z = false;
            }
        }
        return z;
    }
}
