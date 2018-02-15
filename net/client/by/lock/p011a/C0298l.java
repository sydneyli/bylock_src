package net.client.by.lock.p011a;

import android.os.Process;
import java.util.concurrent.TimeUnit;
import net.client.by.lock.C0322b;
import net.client.by.lock.p014c.C0324b;

/* compiled from: MyApp */
public class C0298l extends Thread {
    final /* synthetic */ C0297k f1289a;

    public C0298l(C0297k c0297k) {
        this.f1289a = c0297k;
    }

    public void run() {
        Process.setThreadPriority(-16);
        while (!C0324b.f1410a.get()) {
            C0286a c0286a;
            try {
                int size = this.f1289a.f1286l.size();
                if (size > 1) {
                    C0322b.m2076e("ReceiverThread", "problem: " + size);
                }
                c0286a = (C0286a) this.f1289a.f1286l.poll(200, TimeUnit.MILLISECONDS);
                if (c0286a == null) {
                    continue;
                }
            } catch (InterruptedException e) {
                if (!C0324b.f1410a.get()) {
                    e.printStackTrace();
                    c0286a = null;
                } else {
                    return;
                }
            }
            if (!C0324b.f1410a.get()) {
                this.f1289a.f1276b.m1995a(c0286a.f1237a, 0, c0286a.f1238b);
                try {
                    Thread.sleep(6);
                } catch (InterruptedException e2) {
                    return;
                }
            }
            return;
        }
    }
}
