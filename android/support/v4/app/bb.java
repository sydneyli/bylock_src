package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p000a.C0003a;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: MyApp */
public class bb implements Iterable {
    private static final bd f148a;
    private final ArrayList f149b = new ArrayList();
    private final Context f150c;

    static {
        if (VERSION.SDK_INT >= 11) {
            f148a = new bf();
        } else {
            f148a = new be();
        }
    }

    private bb(Context context) {
        this.f150c = context;
    }

    public static bb m168a(Context context) {
        return new bb(context);
    }

    public bb m171a(Intent intent) {
        this.f149b.add(intent);
        return this;
    }

    public bb m169a(Activity activity) {
        Intent a;
        Intent intent = null;
        if (activity instanceof bc) {
            intent = ((bc) activity).mo153a();
        }
        if (intent == null) {
            a = af.m120a(activity);
        } else {
            a = intent;
        }
        if (a != null) {
            ComponentName component = a.getComponent();
            if (component == null) {
                component = a.resolveActivity(this.f150c.getPackageManager());
            }
            m170a(component);
            m171a(a);
        }
        return this;
    }

    public bb m170a(ComponentName componentName) {
        int size = this.f149b.size();
        try {
            Intent a = af.m121a(this.f150c, componentName);
            while (a != null) {
                this.f149b.add(size, a);
                a = af.m121a(this.f150c, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public Iterator iterator() {
        return this.f149b.iterator();
    }

    public void m172a() {
        m173a(null);
    }

    public void m173a(Bundle bundle) {
        if (this.f149b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f149b.toArray(new Intent[this.f149b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!C0003a.m8a(this.f150c, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.f150c.startActivity(intent);
        }
    }
}
