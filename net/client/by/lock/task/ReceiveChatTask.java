package net.client.by.lock.task;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import net.client.by.lock.p012d.C0335b;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p015e.C0355d;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class ReceiveChatTask extends C0448a {
    private C0337c friend;

    public ReceiveChatTask(Context context, Object obj) {
        super(context, obj);
        this.friend = (C0337c) obj;
    }

    protected String getUrl() {
        return C0371p.m2510e();
    }

    protected Document getRequest() {
        return C0354c.m2415a(this.friend);
    }

    protected void restart() {
        C0332j.m2148a().m2177c(this.friend);
    }

    protected Object[] onSuccess(Document document) {
        ArrayList a = C0355d.m2442a(document, (C0337c) this.startupParameter);
        return new Object[]{"onSuccess", a};
    }

    protected void onPostExecute(Object[] objArr) {
        super.onPostExecute(objArr);
        if (objArr[0].equals("onSuccess")) {
            C0337c c0337c = (C0337c) this.startupParameter;
            Iterator it = ((ArrayList) objArr[1]).iterator();
            while (it.hasNext()) {
                c0337c.m2260b((C0335b) it.next());
            }
            c0337c.m2255b();
        }
    }
}
