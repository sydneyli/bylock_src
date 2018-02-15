package net.client.by.lock.task;

import android.content.Context;
import net.client.by.lock.C0307a;
import net.client.by.lock.p014c.C0327e;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class RemoveGroupTask extends C0448a {
    public RemoveGroupTask(Context context, Object obj) {
        super(context, obj);
    }

    protected String getUrl() {
        return C0371p.m2527v();
    }

    protected Document getRequest() {
        return C0354c.m2422b((Integer) this.startupParameter);
    }

    protected void restart() {
        C0332j.m2148a().m2174c((Integer) this.startupParameter);
    }

    protected void onPostExecute(Object[] objArr) {
        super.onPostExecute(objArr);
        if (objArr[0].equals("onSuccess")) {
            C0327e.m2092c().m2096a(((Integer) this.startupParameter).intValue());
            C0307a.f1342b.notifyDataSetChanged();
        }
    }
}
