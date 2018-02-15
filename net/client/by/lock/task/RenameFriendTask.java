package net.client.by.lock.task;

import android.content.Context;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class RenameFriendTask extends C0448a {
    C0337c friend;

    public RenameFriendTask(Context context, Object obj) {
        super(context, obj);
        this.friend = (C0337c) obj;
    }

    protected String getUrl() {
        return C0371p.m2514i();
    }

    protected Document getRequest() {
        return C0354c.m2425b(this.friend);
    }

    protected void restart() {
        C0332j.m2148a().m2161a(this.friend);
    }
}
