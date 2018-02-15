package net.client.by.lock.task;

import android.content.Context;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class UpdatePublicMessageTask extends C0448a {
    public UpdatePublicMessageTask(Context context, Object obj) {
        super(context, obj);
    }

    protected String getUrl() {
        return C0371p.m2508c();
    }

    protected Document getRequest() {
        return C0354c.m2427c();
    }

    protected void restart() {
        C0332j.m2148a().m2173c();
    }
}
