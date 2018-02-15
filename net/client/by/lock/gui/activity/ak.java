package net.client.by.lock.gui.activity;

import android.os.FileObserver;
import java.io.File;
import java.util.Arrays;
import net.client.by.lock.p014c.C0331i;

/* compiled from: MyApp */
class ak extends FileObserver {
    public ak() {
        super(C0331i.m2124a().m2132b(), 960);
    }

    public void onEvent(int i, String str) {
        if (i <= 2048) {
            File file = new File(C0331i.m2124a().m2132b());
            ah.f1732T.clear();
            ah.f1732T.addAll(Arrays.asList(file.list()));
            if (ah.f1729Q != null) {
                ah.f1729Q.post(new al(this));
            }
        }
    }
}
