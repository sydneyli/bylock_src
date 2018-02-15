package net.client.by.lock.task.call;

import android.app.Activity;
import android.content.Context;
import net.client.by.lock.p011a.C0289c;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p015e.C0355d;
import net.client.by.lock.p016f.C0365j;
import net.client.by.lock.p016f.C0371p;
import net.client.by.lock.task.C0448a;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class MakeCallTask extends C0448a {
    C0289c call;

    public MakeCallTask(Context context, Object obj) {
        super(context, obj);
        this.call = (C0289c) obj;
    }

    protected String getUrl() {
        return C0371p.m2521p();
    }

    protected Document getRequest() {
        if (this.call.m1962x() && C0351r.m2359i().m2394p().m2353b(this.call)) {
            return C0354c.m2413a(this.call);
        }
        return null;
    }

    protected void restart() {
        C0332j.m2148a().m2158a(this.call);
    }

    protected Object[] onSuccess(Document document) {
        String[] a = C0355d.m2447a(document, (C0289c) this.startupParameter);
        if (a == null) {
            return new String[]{"onFail"};
        }
        String str = a[0];
        String str2 = a[1];
        this.call.m1919d(a[2]);
        if (str.equalsIgnoreCase("CALLEE IS BUSY") || str.equalsIgnoreCase("CALLER IS BUSY")) {
            return new Object[]{"onSuccess", str};
        } else if (str.length() == 0) {
            return new String[]{"onFail"};
        } else {
            byte[] a2 = C0365j.m2480a(str);
            byte[] a3 = C0365j.m2480a(str2);
            if (a2 == null || a3 == null) {
                return new String[]{"onFail"};
            }
            return new Object[]{"onSuccess", a2, a3};
        }
    }

    protected void onPostExecute(Object[] objArr) {
        super.onPostExecute(objArr);
        if (!objArr[0].equals("onSuccess")) {
            this.call.m1958t();
            if (this.ctx instanceof Activity) {
                ((Activity) this.ctx).finish();
            }
        } else if (!(objArr[1] instanceof String)) {
            this.call.m1935a((byte[]) objArr[1], (byte[]) objArr[2]);
        } else if (((String) objArr[1]).equalsIgnoreCase("CALLEE IS BUSY")) {
            this.call.m1954p();
        } else if (((String) objArr[1]).equalsIgnoreCase("CALLER IS BUSY")) {
            this.call.m1953o();
        }
    }
}
