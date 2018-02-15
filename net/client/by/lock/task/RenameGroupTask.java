package net.client.by.lock.task;

import android.content.Context;
import net.client.by.lock.p012d.C0341g;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class RenameGroupTask extends C0448a {
    C0341g group;

    public RenameGroupTask(Context context, Object obj) {
        super(context, obj);
        this.group = (C0341g) obj;
    }

    protected String getUrl() {
        return C0371p.m2528w();
    }

    protected Document getRequest() {
        return C0354c.m2417a(this.group);
    }

    protected void restart() {
        C0332j.m2148a().m2163a(this.group);
    }
}
