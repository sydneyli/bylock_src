package android.support.v4.p000a;

import android.content.ComponentName;
import android.content.Intent;

/* compiled from: MyApp */
class C0008f implements C0007e {
    C0008f() {
    }

    public Intent mo1a(ComponentName componentName) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setComponent(componentName);
        intent.addCategory("android.intent.category.LAUNCHER");
        return intent;
    }
}
