package android.support.v7.internal.view;

import android.content.res.TypedArray;
import android.support.v4.view.C0087n;
import android.support.v4.view.ac;
import android.support.v7.internal.view.menu.C0187u;
import android.support.v7.p008b.C0157k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: MyApp */
class C0164f {
    final /* synthetic */ C0162d f524a;
    private Menu f525b;
    private int f526c;
    private int f527d;
    private int f528e;
    private int f529f;
    private boolean f530g;
    private boolean f531h;
    private boolean f532i;
    private int f533j;
    private int f534k;
    private CharSequence f535l;
    private CharSequence f536m;
    private int f537n;
    private char f538o;
    private char f539p;
    private int f540q;
    private boolean f541r;
    private boolean f542s;
    private boolean f543t;
    private int f544u;
    private int f545v;
    private String f546w;
    private String f547x;
    private String f548y;
    private C0087n f549z;

    public C0164f(C0162d c0162d, Menu menu) {
        this.f524a = c0162d;
        this.f525b = menu;
        m1185a();
    }

    public void m1185a() {
        this.f526c = 0;
        this.f527d = 0;
        this.f528e = 0;
        this.f529f = 0;
        this.f530g = true;
        this.f531h = true;
    }

    public void m1186a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f524a.f519e.obtainStyledAttributes(attributeSet, C0157k.MenuGroup);
        this.f526c = obtainStyledAttributes.getResourceId(1, 0);
        this.f527d = obtainStyledAttributes.getInt(3, 0);
        this.f528e = obtainStyledAttributes.getInt(4, 0);
        this.f529f = obtainStyledAttributes.getInt(5, 0);
        this.f530g = obtainStyledAttributes.getBoolean(2, true);
        this.f531h = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
    }

    public void m1188b(AttributeSet attributeSet) {
        int i = 1;
        TypedArray obtainStyledAttributes = this.f524a.f519e.obtainStyledAttributes(attributeSet, C0157k.MenuItem);
        this.f533j = obtainStyledAttributes.getResourceId(2, 0);
        this.f534k = (obtainStyledAttributes.getInt(5, this.f527d) & -65536) | (obtainStyledAttributes.getInt(6, this.f528e) & 65535);
        this.f535l = obtainStyledAttributes.getText(7);
        this.f536m = obtainStyledAttributes.getText(8);
        this.f537n = obtainStyledAttributes.getResourceId(0, 0);
        this.f538o = m1181a(obtainStyledAttributes.getString(9));
        this.f539p = m1181a(obtainStyledAttributes.getString(10));
        if (obtainStyledAttributes.hasValue(11)) {
            this.f540q = obtainStyledAttributes.getBoolean(11, false) ? 1 : 0;
        } else {
            this.f540q = this.f529f;
        }
        this.f541r = obtainStyledAttributes.getBoolean(3, false);
        this.f542s = obtainStyledAttributes.getBoolean(4, this.f530g);
        this.f543t = obtainStyledAttributes.getBoolean(1, this.f531h);
        this.f544u = obtainStyledAttributes.getInt(13, -1);
        this.f548y = obtainStyledAttributes.getString(12);
        this.f545v = obtainStyledAttributes.getResourceId(14, 0);
        this.f546w = obtainStyledAttributes.getString(15);
        this.f547x = obtainStyledAttributes.getString(16);
        if (this.f547x == null) {
            i = 0;
        }
        if (i != 0 && this.f545v == 0 && this.f546w == null) {
            this.f549z = (C0087n) m1183a(this.f547x, C0162d.f516b, this.f524a.f518d);
        } else {
            if (i != 0) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            this.f549z = null;
        }
        obtainStyledAttributes.recycle();
        this.f532i = false;
    }

    private char m1181a(String str) {
        if (str == null) {
            return '\u0000';
        }
        return str.charAt(0);
    }

    private void m1184a(MenuItem menuItem) {
        boolean z = true;
        menuItem.setChecked(this.f541r).setVisible(this.f542s).setEnabled(this.f543t).setCheckable(this.f540q >= 1).setTitleCondensed(this.f536m).setIcon(this.f537n).setAlphabeticShortcut(this.f538o).setNumericShortcut(this.f539p);
        if (this.f544u >= 0) {
            ac.m525a(menuItem, this.f544u);
        }
        if (this.f548y != null) {
            if (this.f524a.f519e.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            menuItem.setOnMenuItemClickListener(new C0163e(this.f524a.f520f, this.f548y));
        }
        C0187u c0187u = menuItem instanceof C0187u ? (C0187u) menuItem : null;
        if (c0187u != null && this.f540q >= 2) {
            c0187u.m1398a(true);
        }
        if (this.f546w != null) {
            ac.m524a(menuItem, (View) m1183a(this.f546w, C0162d.f515a, this.f524a.f517c));
        } else {
            z = false;
        }
        if (this.f545v > 0) {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                ac.m526b(menuItem, this.f545v);
            }
        }
        if (this.f549z != null) {
            ac.m523a(menuItem, this.f549z);
        }
    }

    public void m1187b() {
        this.f532i = true;
        m1184a(this.f525b.add(this.f526c, this.f533j, this.f534k, this.f535l));
    }

    public SubMenu m1189c() {
        this.f532i = true;
        SubMenu addSubMenu = this.f525b.addSubMenu(this.f526c, this.f533j, this.f534k, this.f535l);
        m1184a(addSubMenu.getItem());
        return addSubMenu;
    }

    public boolean m1190d() {
        return this.f532i;
    }

    private Object m1183a(String str, Class[] clsArr, Object[] objArr) {
        try {
            return this.f524a.f519e.getClassLoader().loadClass(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable e) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
            return null;
        }
    }
}
