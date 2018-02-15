package net.client.by.lock.p011a;

import android.os.Process;
import net.client.by.lock.p014c.C0324b;

/* compiled from: MyApp */
public class C0304r extends Thread {
    final /* synthetic */ C0303q f1336a;

    public C0304r(C0303q c0303q) {
        this.f1336a = c0303q;
    }

    public void run() {
        Process.setThreadPriority(-16);
        while (!C0324b.f1410a.get()) {
            C0286a c0286a = new C0286a(new short[160], 0);
            c0286a.f1238b = this.f1336a.f1322b.m1999a(c0286a.f1237a, 0, 160);
            if (c0286a.f1238b != 0) {
                try {
                    this.f1336a.f1331k.put(c0286a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }
}
