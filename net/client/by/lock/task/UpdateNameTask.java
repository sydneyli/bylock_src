package net.client.by.lock.task;

import android.content.Context;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class UpdateNameTask extends C0448a {
    String name = ((String) this.startupParameter);

    public UpdateNameTask(Context context, Object obj) {
        super(context, obj);
    }

    protected String getUrl() {
        return C0371p.m2500C();
    }

    protected Document getRequest() {
        return C0354c.m2440f(this.name);
    }

    protected void restart() {
        C0332j.m2148a().m2182e(this.name);
    }
}
