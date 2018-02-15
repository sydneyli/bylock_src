package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: MyApp */
public class C0024j extends Activity {
    final Handler f180a = new C0025k(this);
    final C0031r f181b = new C0031r();
    final C0020o f182c = new C0026l(this);
    boolean f183d;
    boolean f184e;
    boolean f185f;
    boolean f186g;
    boolean f187h;
    boolean f188i;
    boolean f189j;
    boolean f190k;
    HashMap f191l;
    ad f192m;

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f181b.m260i();
        int i3 = i >> 16;
        if (i3 != 0) {
            i3--;
            if (this.f181b.f210f == null || i3 < 0 || i3 >= this.f181b.f210f.size()) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = (Fragment) this.f181b.f210f.get(i3);
            if (fragment == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                return;
            } else {
                fragment.mo356a(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.f181b.m249c()) {
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f181b.m226a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        this.f181b.m233a(this, this.f182c, null);
        if (getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        C0028n c0028n = (C0028n) getLastNonConfigurationInstance();
        if (c0028n != null) {
            this.f191l = c0028n.f200e;
        }
        if (bundle != null) {
            ArrayList arrayList;
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            C0031r c0031r = this.f181b;
            if (c0028n != null) {
                arrayList = c0028n.f199d;
            } else {
                arrayList = null;
            }
            c0031r.m228a(parcelable, arrayList);
        }
        this.f181b.m261j();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.f181b.m238a(menu, getMenuInflater());
        if (VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        int i = 0;
        Fragment fragment = null;
        if (!"fragment".equals(str)) {
            return super.onCreateView(str, context, attributeSet);
        }
        String attributeValue = attributeSet.getAttributeValue(fragment, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0027m.f195a);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (fragment != null) {
            i = fragment.getId();
        }
        if (i == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        if (resourceId != -1) {
            fragment = this.f181b.m218a(resourceId);
        }
        if (fragment == null && string != null) {
            fragment = this.f181b.mo14a(string);
        }
        if (fragment == null && i != -1) {
            fragment = this.f181b.m218a(i);
        }
        if (C0031r.f204a) {
            Log.v("FragmentActivity", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + attributeValue + " existing=" + fragment);
        }
        if (fragment == null) {
            Fragment a = Fragment.m27a((Context) this, attributeValue);
            a.f60o = true;
            a.f68w = resourceId != 0 ? resourceId : i;
            a.f69x = i;
            a.f70y = string;
            a.f61p = true;
            a.f64s = this.f181b;
            a.m34a((Activity) this, attributeSet, a.f49d);
            this.f181b.m232a(a, true);
            fragment = a;
        } else if (fragment.f61p) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + attributeValue);
        } else {
            fragment.f61p = true;
            if (!fragment.f33C) {
                fragment.m34a((Activity) this, attributeSet, fragment.f49d);
            }
            this.f181b.m241b(fragment);
        }
        if (fragment.f39I == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.f39I.setId(resourceId);
        }
        if (fragment.f39I.getTag() == null) {
            fragment.f39I.setTag(string);
        }
        return fragment.f39I;
    }

    protected void onDestroy() {
        super.onDestroy();
        m201a(false);
        this.f181b.m269r();
        if (this.f192m != null) {
            this.f192m.m111h();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f181b.m270s();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.f181b.m239a(menuItem);
            case 6:
                return this.f181b.m246b(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.f181b.m244b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.f184e = false;
        if (this.f180a.hasMessages(2)) {
            this.f180a.removeMessages(2);
            a_();
        }
        this.f181b.m265n();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f181b.m260i();
    }

    protected void onResume() {
        super.onResume();
        this.f180a.sendEmptyMessage(2);
        this.f184e = true;
        this.f181b.m255e();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f180a.removeMessages(2);
        a_();
        this.f181b.m255e();
    }

    protected void a_() {
        this.f181b.m264m();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.f188i) {
            this.f188i = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return super.onPreparePanel(i, view, menu) | this.f181b.m237a(menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        int i = 0;
        if (this.f185f) {
            m201a(true);
        }
        Object b = m202b();
        ArrayList g = this.f181b.m258g();
        if (this.f191l != null) {
            ad[] adVarArr = new ad[this.f191l.size()];
            this.f191l.values().toArray(adVarArr);
            if (adVarArr != null) {
                int i2 = 0;
                while (i < adVarArr.length) {
                    ad adVar = adVarArr[i];
                    if (adVar.f100g) {
                        i2 = true;
                    } else {
                        adVar.m111h();
                        this.f191l.remove(adVar.f97d);
                    }
                    i++;
                }
                i = i2;
            }
        }
        if (g == null && r0 == 0 && b == null) {
            return null;
        }
        Object c0028n = new C0028n();
        c0028n.f196a = null;
        c0028n.f197b = b;
        c0028n.f198c = null;
        c0028n.f199d = g;
        c0028n.f200e = this.f191l;
        return c0028n;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable h = this.f181b.m259h();
        if (h != null) {
            bundle.putParcelable("android:support:fragments", h);
        }
    }

    protected void onStart() {
        int i = 0;
        super.onStart();
        this.f185f = false;
        this.f186g = false;
        this.f180a.removeMessages(1);
        if (!this.f183d) {
            this.f183d = true;
            this.f181b.m262k();
        }
        this.f181b.m260i();
        this.f181b.m255e();
        if (!this.f190k) {
            this.f190k = true;
            if (this.f192m != null) {
                this.f192m.m105b();
            } else if (!this.f189j) {
                this.f192m = m197a(null, this.f190k, false);
                if (!(this.f192m == null || this.f192m.f99f)) {
                    this.f192m.m105b();
                }
            }
            this.f189j = true;
        }
        this.f181b.m263l();
        if (this.f191l != null) {
            ad[] adVarArr = new ad[this.f191l.size()];
            this.f191l.values().toArray(adVarArr);
            if (adVarArr != null) {
                while (i < adVarArr.length) {
                    ad adVar = adVarArr[i];
                    adVar.m108e();
                    adVar.m110g();
                    i++;
                }
            }
        }
    }

    protected void onStop() {
        super.onStop();
        this.f185f = true;
        this.f180a.sendEmptyMessage(1);
        this.f181b.m266o();
    }

    public Object m202b() {
        return null;
    }

    public void mo155c() {
        if (VERSION.SDK_INT >= 11) {
            C0015b.m167a(this);
        } else {
            this.f188i = true;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        if (VERSION.SDK_INT >= 11) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f183d);
            printWriter.print("mResumed=");
            printWriter.print(this.f184e);
            printWriter.print(" mStopped=");
            printWriter.print(this.f185f);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f186g);
            printWriter.print(str2);
            printWriter.print("mLoadersStarted=");
            printWriter.println(this.f190k);
        } else {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f183d);
            printWriter.print("mResumed=");
            printWriter.print(this.f184e);
            printWriter.print(" mStopped=");
            printWriter.print(this.f185f);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f186g);
            printWriter.print(str2);
            printWriter.print("mLoadersStarted=");
            printWriter.println(this.f190k);
        }
        if (this.f192m != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f192m)));
            printWriter.println(":");
            this.f192m.m103a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        this.f181b.m235a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        m196a(str + "  ", printWriter, getWindow().getDecorView());
    }

    private static String mo154a(View view) {
        char c;
        char c2 = 'F';
        char c3 = '.';
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case 0:
                stringBuilder.append('V');
                break;
            case 4:
                stringBuilder.append('I');
                break;
            case 8:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        if (view.isFocusable()) {
            c = 'F';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isEnabled()) {
            c = 'E';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        if (view.isHorizontalScrollBarEnabled()) {
            c = 'H';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isVerticalScrollBarEnabled()) {
            c = 'V';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isClickable()) {
            c = 'C';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isLongClickable()) {
            c = 'L';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c2 = '.';
        }
        stringBuilder.append(c2);
        if (view.isSelected()) {
            c = 'S';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isPressed()) {
            c3 = 'P';
        }
        stringBuilder.append(c3);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (-16777216 & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void m196a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(C0024j.mo154a(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    m196a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    void m201a(boolean z) {
        if (!this.f186g) {
            this.f186g = true;
            this.f187h = z;
            this.f180a.removeMessages(1);
            m204d();
        }
    }

    void m204d() {
        if (this.f190k) {
            this.f190k = false;
            if (this.f192m != null) {
                if (this.f187h) {
                    this.f192m.m107d();
                } else {
                    this.f192m.m106c();
                }
            }
        }
        this.f181b.m267p();
    }

    public void m198a(Fragment fragment) {
    }

    public C0029p m205e() {
        return this.f181b;
    }

    public void startActivityForResult(Intent intent, int i) {
        if (i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }

    public void m199a(Fragment fragment, Intent intent, int i) {
        if (i == -1) {
            super.startActivityForResult(intent, -1);
        } else if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            super.startActivityForResult(intent, ((fragment.f51f + 1) << 16) + (65535 & i));
        }
    }

    void m200a(String str) {
        if (this.f191l != null) {
            ad adVar = (ad) this.f191l.get(str);
            if (adVar != null && !adVar.f100g) {
                adVar.m111h();
                this.f191l.remove(str);
            }
        }
    }

    ad m197a(String str, boolean z, boolean z2) {
        if (this.f191l == null) {
            this.f191l = new HashMap();
        }
        ad adVar = (ad) this.f191l.get(str);
        if (adVar != null) {
            adVar.m102a(this);
            return adVar;
        } else if (!z2) {
            return adVar;
        } else {
            adVar = new ad(str, this, z);
            this.f191l.put(str, adVar);
            return adVar;
        }
    }
}
