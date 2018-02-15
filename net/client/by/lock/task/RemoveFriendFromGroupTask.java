package net.client.by.lock.task;

import android.content.Context;
import net.client.by.lock.p014c.C0327e;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class RemoveFriendFromGroupTask extends C0448a {
    public RemoveFriendFromGroupTask(Context context, Object obj) {
        super(context, obj);
    }

    protected String getUrl() {
        return C0371p.m2503F();
    }

    protected Document getRequest() {
        return C0354c.m2429c(((Integer[]) this.startupParameter)[0], ((Integer[]) this.startupParameter)[1]);
    }

    protected void onPostExecute(Object[] objArr) {
        super.onPostExecute(objArr);
        if (objArr[0].equals("onSuccess")) {
            C0327e.m2092c().m2103b(((Integer[]) this.startupParameter)[0], ((Integer[]) this.startupParameter)[1]);
        }
    }

    protected void restart() {
        C0332j.m2148a().m2168b(((Integer[]) this.startupParameter)[0], ((Integer[]) this.startupParameter)[1]);
    }
}
