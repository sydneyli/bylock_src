package net.client.by.lock.task.call;

import android.content.Context;
import net.client.by.lock.p011a.C0289c;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p016f.C0371p;
import net.client.by.lock.task.C0448a;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class CloseCallTask extends C0448a {
    byte[] callId;

    public CloseCallTask(Context context, Object obj) {
        super(context, obj);
        this.callId = ((C0289c) obj).m1955q();
    }

    protected String getUrl() {
        return C0371p.m2525t();
    }

    protected Document getRequest() {
        return C0354c.m2435d(this.callId);
    }

    protected void restart() {
        C0332j.m2148a().m2183e((C0289c) this.startupParameter);
    }
}
