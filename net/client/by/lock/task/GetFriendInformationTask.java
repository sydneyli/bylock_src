package net.client.by.lock.task;

import android.content.Context;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p015e.C0355d;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class GetFriendInformationTask extends C0448a {
    Integer userId;

    public GetFriendInformationTask(Context context, Object obj) {
        super(context, obj);
        this.userId = (Integer) obj;
    }

    protected String getUrl() {
        return C0371p.m2513h();
    }

    protected Document getRequest() {
        return C0354c.m2408a(this.userId);
    }

    protected Object[] onSuccess(Document document) {
        C0355d.m2443a(document, Boolean.valueOf(false));
        return new String[]{"onSuccess"};
    }

    protected void restart() {
        C0332j.m2148a().m2153a(this.userId);
    }
}
