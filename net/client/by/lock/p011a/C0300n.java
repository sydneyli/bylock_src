package net.client.by.lock.p011a;

import android.os.Process;
import net.client.by.lock.p014c.C0324b;

/* compiled from: MyApp */
public class C0300n extends Thread {
    final /* synthetic */ C0299m f1301a;

    public C0300n(C0299m c0299m) {
        this.f1301a = c0299m;
    }

    public void run() {
        Process.setThreadPriority(-16);
        while (!C0324b.f1410a.get()) {
            try {
                C0287b a = this.f1301a.f1298i.m1970a();
                this.f1301a.f1291b.m1995a(a.m1906b(), a.m1907c(), a.m1908d());
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
