package net.client.by.lock.task.call;

import android.content.Context;
import net.client.by.lock.p011a.C0289c;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0353b;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p015e.C0355d;
import net.client.by.lock.p016f.C0371p;
import net.client.by.lock.task.C0448a;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class AnswerCallTask extends C0448a {
    C0289c call;

    public AnswerCallTask(Context context, Object obj) {
        super(context, obj);
        this.call = (C0289c) obj;
    }

    protected String getUrl() {
        return C0371p.m2522q();
    }

    protected Document getRequest() {
        return C0354c.m2419a(this.call.m1955q());
    }

    protected void restart() {
        C0332j.m2148a().m2170b((C0289c) this.startupParameter);
    }

    protected Object[] onSuccess(Document document) {
        String[] b = C0355d.m2449b(document, (C0289c) this.startupParameter);
        if (b == null) {
            return new String[]{"onFail"};
        }
        this.call.m1936a(C0353b.m2406a(b[0]), C0353b.m2406a(b[1]), C0353b.m2406a(b[2]), Integer.parseInt(b[3]));
        return new Object[]{"onSuccess"};
    }

    protected void onPostExecute(Object[] objArr) {
        super.onPostExecute(objArr);
        if (!objArr[0].equals("onSuccess")) {
            this.call.m1958t();
        }
    }
}
