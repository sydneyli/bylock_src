package net.client.by.lock.task;

import android.content.Context;
import net.client.by.lock.p012d.C0335b;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class DeleteChatTask extends C0448a {
    C0335b chat = ((C0335b) this.startupParameter);

    public DeleteChatTask(Context context, Object obj) {
        super(context, obj);
    }

    protected String getUrl() {
        return C0371p.m2501D();
    }

    protected Document getRequest() {
        return C0354c.m2409a(Integer.valueOf(this.chat.m1913E().m2237K()), this.chat.m2212c());
    }

    protected void restart() {
        C0332j.m2148a().m2171b(this.chat);
    }
}
