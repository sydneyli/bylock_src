package net.client.by.lock.task;

import android.content.Context;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class UpdateStatusTask extends C0448a {
    Integer status;

    public UpdateStatusTask(Context context, Object obj) {
        super(context, obj);
        this.status = (Integer) obj;
    }

    protected String getUrl() {
        return C0371p.m2499B();
    }

    protected Document getRequest() {
        return C0354c.m2428c(this.status);
    }

    protected void restart() {
    }
}
