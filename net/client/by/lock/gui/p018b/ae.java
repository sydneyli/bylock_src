package net.client.by.lock.gui.p018b;

import java.util.Iterator;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p014c.C0327e;

/* compiled from: MyApp */
class ae extends Thread {
    final /* synthetic */ ac f1842a;

    ae(ac acVar) {
        this.f1842a = acVar;
    }

    public void run() {
        Iterator it = C0327e.m2092c().m2106f().iterator();
        while (it.hasNext()) {
            C0337c c0337c = (C0337c) it.next();
            if (((Boolean) c0337c.m2281q().m2467a()).booleanValue()) {
                c0337c.m2282r().m2468a(Integer.valueOf(0));
            }
        }
    }
}
