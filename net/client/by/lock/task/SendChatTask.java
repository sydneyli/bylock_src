package net.client.by.lock.task;

import android.content.Context;
import net.client.by.lock.p012d.C0335b;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p015e.C0355d;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class SendChatTask extends C0448a {
    private C0335b chat;

    public SendChatTask(Context context, Object obj) {
        super(context, obj);
        this.chat = (C0335b) obj;
    }

    protected String getUrl() {
        return C0371p.m2509d();
    }

    protected Document getRequest() {
        if (this.chat.m2216g() && C0351r.m2359i().m2394p().m2354b(this.chat)) {
            return C0354c.m2414a(this.chat);
        }
        return null;
    }

    protected void restart() {
        C0332j.m2148a().m2160a(this.chat);
    }

    protected Object[] onSuccess(Document document) {
        this.chat.m1919d(C0355d.m2453f(document));
        this.chat.m1920e("COMPLETED");
        return new String[]{"onSuccess"};
    }

    protected void onPostExecute(Object[] objArr) {
        super.onPostExecute(objArr);
        if (objArr[0].equals("onSuccess")) {
            this.chat.mo317A().m2552a();
            this.chat.mo317A().m2553a(8);
        } else if (objArr[0].equals("onException")) {
            this.chat.m1921f(((Throwable) objArr[1]).toString());
        } else if (objArr[0].equals("onFail")) {
            this.chat.m1921f((String) objArr[1]);
        }
    }
}
