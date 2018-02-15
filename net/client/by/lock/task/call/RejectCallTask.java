package net.client.by.lock.task.call;

import android.content.Context;
import net.client.by.lock.p011a.C0289c;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p016f.C0371p;
import net.client.by.lock.task.C0448a;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class RejectCallTask extends C0448a {
    C0289c call;

    public RejectCallTask(Context context, Object obj) {
        super(context, obj);
        this.call = (C0289c) obj;
    }

    protected String getUrl() {
        return C0371p.m2523r();
    }

    protected Document getRequest() {
        return C0354c.m2426b(this.call.m1955q());
    }

    protected void restart() {
        C0332j.m2148a().m2176c((C0289c) this.startupParameter);
    }
}
