package net.client.by.lock.task;

import android.content.Context;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class DeleteFileTransferTask extends C0448a {
    public DeleteFileTransferTask(Context context, Object obj) {
        super(context, obj);
    }

    protected String getUrl() {
        return C0371p.m2518m();
    }

    protected Document getRequest() {
        return C0354c.m2424b((String) this.startupParameter);
    }

    protected void restart() {
        C0332j.m2148a().m2179d((String) this.startupParameter);
    }
}
