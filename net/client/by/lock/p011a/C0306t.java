package net.client.by.lock.p011a;

import android.media.AudioRecord;
import net.client.by.lock.C0322b;
import net.client.by.lock.p014c.C0324b;
import net.client.by.lock.p014c.C0331i;
import net.client.by.lock.p016f.C0358c;

/* compiled from: MyApp */
public class C0306t extends C0291e {
    public static AudioRecord f1338a;
    private int f1339b;
    private short[] f1340c;

    public C0306t() {
        this.f1339b = 8000;
        this.f1340c = null;
        this.f1339b = C0331i.m2124a().m2137d();
        int c = C0358c.m2459c();
        int minBufferSize = AudioRecord.getMinBufferSize(this.f1339b, 16, c) * 4;
        f1338a = new AudioRecord(1, this.f1339b, 16, c, minBufferSize);
        C0322b.m2076e("TargetDataLine", "@Open Bonk " + minBufferSize);
    }

    public synchronized int m1999a(short[] sArr, int i, int i2) {
        if (this.f1339b != 8000) {
            i2 = m1998b(sArr, i, i2);
        } else {
            int i3 = 0;
            int i4 = i2;
            do {
                if (C0324b.f1410a.get()) {
                    i2 = 0;
                    break;
                }
                try {
                    int read = f1338a.read(sArr, i + i3, i4);
                    if (read <= 0) {
                        C0322b.m2076e("TargetDataLine", "Number of samples are wrong: " + read + " remaining: " + i4);
                    }
                    i3 += read;
                } catch (Exception e) {
                    if (C0324b.f1410a.get()) {
                        i2 = 0;
                        break;
                    }
                }
                i4 = i2 - i3;
            } while (i4 > 0);
        }
        return i2;
    }

    private int m1998b(short[] sArr, int i, int i2) {
        int i3 = this.f1339b / 8000;
        if (this.f1340c == null || this.f1340c.length != i2 * i3) {
            this.f1340c = new short[(i2 * i3)];
        }
        int i4 = i2 * i3;
        int i5 = 0;
        while (!C0324b.f1410a.get()) {
            try {
                i5 += f1338a.read(this.f1340c, i + i5, i4);
            } catch (Exception e) {
                if (C0324b.f1410a.get()) {
                    return 0;
                }
            }
            i4 = (i2 * i3) - i5;
            if (i4 <= 0) {
                for (i5 = 0; i5 < i2; i5++) {
                    if (C0324b.f1410a.get()) {
                        return 0;
                    }
                    sArr[i5 + i] = this.f1340c[i3 * i5];
                }
                return i2;
            }
        }
        return 0;
    }

    public void m2000a() {
        try {
            f1338a.startRecording();
        } catch (IllegalStateException e) {
            int c = C0358c.m2459c();
            f1338a = new AudioRecord(1, this.f1339b, 16, c, AudioRecord.getMinBufferSize(this.f1339b, 16, c) * 4);
            f1338a.startRecording();
        }
    }

    public synchronized void m2001b() {
        if (f1338a != null) {
            if (m2002c() && f1338a.getRecordingState() == 3) {
                f1338a.stop();
            }
            f1338a.release();
            f1338a = null;
        }
    }

    public synchronized boolean m2002c() {
        boolean z = true;
        synchronized (this) {
            if (f1338a == null || f1338a.getState() != 1) {
                z = false;
            }
        }
        return z;
    }
}
