package net.client.by.lock.task;

import android.content.Context;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class AddFriendToGroupTask extends C0448a {
    public AddFriendToGroupTask(Context context, Object obj) {
        super(context, obj);
    }

    protected String getUrl() {
        return C0371p.m2502E();
    }

    protected Document getRequest() {
        return C0354c.m2423b(((Integer[]) this.startupParameter)[0], ((Integer[]) this.startupParameter)[1]);
    }

    protected void restart() {
        Integer[] numArr = (Integer[]) this.startupParameter;
        C0332j.m2148a().m2154a(numArr[0], numArr[1]);
    }
}
