package net.client.by.lock.p011a;

import android.os.Process;
import net.client.by.lock.p014c.C0324b;

/* compiled from: MyApp */
public class C0302p extends Thread {
    final /* synthetic */ C0301o f1320a;

    public C0302p(C0301o c0301o) {
        this.f1320a = c0301o;
    }

    public void run() {
        Process.setThreadPriority(-16);
        while (!C0324b.f1410a.get()) {
            C0286a c0286a = new C0286a(new short[1600], 0);
            c0286a.f1238b = this.f1320a.f1303b.m1999a(c0286a.f1237a, 0, 1600);
            if (c0286a.f1238b != 0) {
                try {
                    this.f1320a.f1315n.put(c0286a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(6);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            } else {
                return;
            }
        }
    }
}
