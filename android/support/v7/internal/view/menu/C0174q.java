package android.support.v7.internal.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p001b.p002a.C0040a;
import android.support.v4.view.C0087n;
import android.support.v7.p008b.C0150d;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MyApp */
public class C0174q implements C0040a {
    private static final int[] f657d = new int[]{1, 4, 5, 3, 2, 0};
    CharSequence f658a;
    Drawable f659b;
    View f660c;
    private final Context f661e;
    private final Resources f662f;
    private boolean f663g;
    private boolean f664h;
    private C0133r f665i;
    private ArrayList f666j;
    private ArrayList f667k;
    private boolean f668l;
    private ArrayList f669m;
    private ArrayList f670n;
    private boolean f671o;
    private int f672p = 0;
    private ContextMenuInfo f673q;
    private boolean f674r = false;
    private boolean f675s = false;
    private boolean f676t = false;
    private boolean f677u = false;
    private ArrayList f678v = new ArrayList();
    private CopyOnWriteArrayList f679w = new CopyOnWriteArrayList();
    private C0187u f680x;

    public C0174q(Context context) {
        this.f661e = context;
        this.f662f = context.getResources();
        this.f666j = new ArrayList();
        this.f667k = new ArrayList();
        this.f668l = true;
        this.f669m = new ArrayList();
        this.f670n = new ArrayList();
        this.f671o = true;
        m1321d(true);
    }

    public C0174q m1323a(int i) {
        this.f672p = i;
        return this;
    }

    public void m1328a(af afVar) {
        this.f679w.add(new WeakReference(afVar));
        afVar.mo209a(this.f661e, this);
        this.f671o = true;
    }

    public void m1338b(af afVar) {
        Iterator it = this.f679w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            af afVar2 = (af) weakReference.get();
            if (afVar2 == null || afVar2 == afVar) {
                this.f679w.remove(weakReference);
            }
        }
    }

    private void m1319c(boolean z) {
        if (!this.f679w.isEmpty()) {
            m1348f();
            Iterator it = this.f679w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                af afVar = (af) weakReference.get();
                if (afVar == null) {
                    this.f679w.remove(weakReference);
                } else {
                    afVar.mo214c(z);
                }
            }
            m1349g();
        }
    }

    private boolean m1318a(al alVar) {
        if (this.f679w.isEmpty()) {
            return false;
        }
        Iterator it = this.f679w.iterator();
        boolean z = false;
        while (it.hasNext()) {
            boolean z2;
            WeakReference weakReference = (WeakReference) it.next();
            af afVar = (af) weakReference.get();
            if (afVar == null) {
                this.f679w.remove(weakReference);
                z2 = z;
            } else if (z) {
                z2 = z;
            } else {
                z2 = afVar.mo211a(alVar);
            }
            z = z2;
        }
        return z;
    }

    public void mo231a(C0133r c0133r) {
        this.f665i = c0133r;
    }

    private MenuItem m1315a(int i, int i2, int i3, CharSequence charSequence) {
        int d = C0174q.m1320d(i3);
        MenuItem c0187u = new C0187u(this, i, i2, i3, d, charSequence, this.f672p);
        if (this.f673q != null) {
            c0187u.m1397a(this.f673q);
        }
        this.f666j.add(C0174q.m1314a(this.f666j, d), c0187u);
        m1340b(true);
        return c0187u;
    }

    public MenuItem add(CharSequence charSequence) {
        return m1315a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return m1315a(0, 0, 0, this.f662f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m1315a(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m1315a(i, i2, i3, this.f662f.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f662f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C0187u c0187u = (C0187u) m1315a(i, i2, i3, charSequence);
        al alVar = new al(this.f661e, this, c0187u);
        c0187u.m1396a(alVar);
        return alVar;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f662f.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f661e.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            Intent intent2;
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[resolveInfo.specificIndex];
            }
            Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent4 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent4;
            }
        }
        return size;
    }

    public void removeItem(int i) {
        m1317a(m1337b(i), true);
    }

    public void removeGroup(int i) {
        int c = m1342c(i);
        if (c >= 0) {
            int size = this.f666j.size() - c;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || ((C0187u) this.f666j.get(c)).getGroupId() != i) {
                    m1340b(true);
                } else {
                    m1317a(c, false);
                    i2 = i3;
                }
            }
            m1340b(true);
        }
    }

    private void m1317a(int i, boolean z) {
        if (i >= 0 && i < this.f666j.size()) {
            this.f666j.remove(i);
            if (z) {
                m1340b(true);
            }
        }
    }

    public void clear() {
        if (this.f680x != null) {
            mo237d(this.f680x);
        }
        this.f666j.clear();
        m1340b(true);
    }

    void m1331a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f666j.size();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem2 = (C0187u) this.f666j.get(i);
            if (menuItem2.getGroupId() == groupId && menuItem2.m1409f() && menuItem2.isCheckable()) {
                menuItem2.m1402b(menuItem2 == menuItem);
            }
        }
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f666j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0187u c0187u = (C0187u) this.f666j.get(i2);
            if (c0187u.getGroupId() == i) {
                c0187u.m1398a(z2);
                c0187u.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f666j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            boolean z3;
            C0187u c0187u = (C0187u) this.f666j.get(i2);
            if (c0187u.getGroupId() == i && c0187u.m1404c(z)) {
                z3 = true;
            } else {
                z3 = z2;
            }
            i2++;
            z2 = z3;
        }
        if (z2) {
            m1340b(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f666j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0187u c0187u = (C0187u) this.f666j.get(i2);
            if (c0187u.getGroupId() == i) {
                c0187u.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((C0187u) this.f666j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            C0187u c0187u = (C0187u) this.f666j.get(i2);
            if (c0187u.getItemId() == i) {
                return c0187u;
            }
            if (c0187u.hasSubMenu()) {
                MenuItem findItem = c0187u.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public int m1337b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C0187u) this.f666j.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public int m1342c(int i) {
        return m1322a(i, 0);
    }

    public int m1322a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((C0187u) this.f666j.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public int size() {
        return this.f666j.size();
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.f666j.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m1327a(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.f663g = z;
        m1340b(false);
    }

    private static int m1320d(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < f657d.length) {
            return (f657d[i2] << 16) | (65535 & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    boolean mo232a() {
        return this.f663g;
    }

    private void m1321d(boolean z) {
        boolean z2 = true;
        if (!(z && this.f662f.getConfiguration().keyboard != 1 && this.f662f.getBoolean(C0150d.abc_config_showMenuShortcutsWhenKeyboardPresent))) {
            z2 = false;
        }
        this.f664h = z2;
    }

    public boolean mo234b() {
        return this.f664h;
    }

    Resources m1343c() {
        return this.f662f;
    }

    public Context m1345d() {
        return this.f661e;
    }

    boolean mo233a(C0174q c0174q, MenuItem menuItem) {
        return this.f665i != null && this.f665i.mo176a(c0174q, menuItem);
    }

    public void m1347e() {
        if (this.f665i != null) {
            this.f665i.mo168a(this);
        }
    }

    private static int m1314a(ArrayList arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((C0187u) arrayList.get(size)).m1400b() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = m1327a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = m1336a(a, i2);
        }
        if ((i2 & 2) != 0) {
            m1333a(true);
        }
        return z;
    }

    void m1332a(List list, int i, KeyEvent keyEvent) {
        boolean a = mo232a();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f666j.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0187u c0187u = (C0187u) this.f666j.get(i2);
                if (c0187u.hasSubMenu()) {
                    ((C0174q) c0187u.getSubMenu()).m1332a(list, i, keyEvent);
                }
                char alphabeticShortcut = a ? c0187u.getAlphabeticShortcut() : c0187u.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000' && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (a && alphabeticShortcut == '\b' && i == 67)) && c0187u.isEnabled())) {
                    list.add(c0187u);
                }
            }
        }
    }

    C0187u m1327a(int i, KeyEvent keyEvent) {
        ArrayList arrayList = this.f678v;
        arrayList.clear();
        m1332a(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (C0187u) arrayList.get(0);
        }
        boolean a = mo232a();
        for (int i2 = 0; i2 < size; i2++) {
            C0187u c0187u = (C0187u) arrayList.get(i2);
            char alphabeticShortcut = a ? c0187u.getAlphabeticShortcut() : c0187u.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return c0187u;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return c0187u;
            }
            if (a && alphabeticShortcut == '\b' && i == 67) {
                return c0187u;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return m1336a(findItem(i), i2);
    }

    public boolean m1336a(MenuItem menuItem, int i) {
        C0187u c0187u = (C0187u) menuItem;
        if (c0187u == null || !c0187u.isEnabled()) {
            return false;
        }
        boolean z;
        boolean a = c0187u.m1399a();
        C0087n m = c0187u.m1416m();
        if (m == null || !m.m758g()) {
            z = false;
        } else {
            z = true;
        }
        boolean expandActionView;
        if (c0187u.m1417n()) {
            expandActionView = c0187u.expandActionView() | a;
            if (!expandActionView) {
                return expandActionView;
            }
            m1333a(true);
            return expandActionView;
        } else if (c0187u.hasSubMenu() || z) {
            m1333a(false);
            if (!c0187u.hasSubMenu()) {
                c0187u.m1396a(new al(m1345d(), this, c0187u));
            }
            al alVar = (al) c0187u.getSubMenu();
            if (z) {
                m.m752a((SubMenu) alVar);
            }
            expandActionView = m1318a(alVar) | a;
            if (expandActionView) {
                return expandActionView;
            }
            m1333a(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                m1333a(true);
            }
            return a;
        }
    }

    final void m1333a(boolean z) {
        if (!this.f677u) {
            this.f677u = true;
            Iterator it = this.f679w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                af afVar = (af) weakReference.get();
                if (afVar == null) {
                    this.f679w.remove(weakReference);
                } else {
                    afVar.mo210a(this, z);
                }
            }
            this.f677u = false;
        }
    }

    public void close() {
        m1333a(true);
    }

    void m1340b(boolean z) {
        if (this.f674r) {
            this.f675s = true;
            return;
        }
        if (z) {
            this.f668l = true;
            this.f671o = true;
        }
        m1319c(z);
    }

    public void m1348f() {
        if (!this.f674r) {
            this.f674r = true;
            this.f675s = false;
        }
    }

    public void m1349g() {
        this.f674r = false;
        if (this.f675s) {
            this.f675s = false;
            m1340b(true);
        }
    }

    void m1330a(C0187u c0187u) {
        this.f668l = true;
        m1340b(true);
    }

    void m1339b(C0187u c0187u) {
        this.f671o = true;
        m1340b(true);
    }

    ArrayList m1350h() {
        if (!this.f668l) {
            return this.f667k;
        }
        this.f667k.clear();
        int size = this.f666j.size();
        for (int i = 0; i < size; i++) {
            C0187u c0187u = (C0187u) this.f666j.get(i);
            if (c0187u.isVisible()) {
                this.f667k.add(c0187u);
            }
        }
        this.f668l = false;
        this.f671o = true;
        return this.f667k;
    }

    public void m1351i() {
        if (this.f671o) {
            Iterator it = this.f679w.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2;
                WeakReference weakReference = (WeakReference) it.next();
                af afVar = (af) weakReference.get();
                if (afVar == null) {
                    this.f679w.remove(weakReference);
                    i2 = i;
                } else {
                    i2 = afVar.mo215g() | i;
                }
                i = i2;
            }
            if (i != 0) {
                this.f669m.clear();
                this.f670n.clear();
                ArrayList h = m1350h();
                int size = h.size();
                for (int i3 = 0; i3 < size; i3++) {
                    C0187u c0187u = (C0187u) h.get(i3);
                    if (c0187u.m1412i()) {
                        this.f669m.add(c0187u);
                    } else {
                        this.f670n.add(c0187u);
                    }
                }
            } else {
                this.f669m.clear();
                this.f670n.clear();
                this.f670n.addAll(m1350h());
            }
            this.f671o = false;
        }
    }

    ArrayList m1352j() {
        m1351i();
        return this.f669m;
    }

    ArrayList m1353k() {
        m1351i();
        return this.f670n;
    }

    public void clearHeader() {
        this.f659b = null;
        this.f658a = null;
        this.f660c = null;
        m1340b(false);
    }

    private void m1316a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources c = m1343c();
        if (view != null) {
            this.f660c = view;
            this.f658a = null;
            this.f659b = null;
        } else {
            if (i > 0) {
                this.f658a = c.getText(i);
            } else if (charSequence != null) {
                this.f658a = charSequence;
            }
            if (i2 > 0) {
                this.f659b = c.getDrawable(i2);
            } else if (drawable != null) {
                this.f659b = drawable;
            }
            this.f660c = null;
        }
        m1340b(false);
    }

    protected C0174q m1326a(CharSequence charSequence) {
        m1316a(0, charSequence, 0, null, null);
        return this;
    }

    protected C0174q m1324a(Drawable drawable) {
        m1316a(0, null, 0, drawable, null);
        return this;
    }

    protected C0174q m1325a(View view) {
        m1316a(0, null, 0, null, view);
        return this;
    }

    public CharSequence m1354l() {
        return this.f658a;
    }

    public Drawable m1355m() {
        return this.f659b;
    }

    public View m1356n() {
        return this.f660c;
    }

    public C0174q mo238o() {
        return this;
    }

    boolean m1358p() {
        return this.f676t;
    }

    public boolean mo235c(C0187u c0187u) {
        boolean z = false;
        if (!this.f679w.isEmpty()) {
            m1348f();
            Iterator it = this.f679w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                af afVar = (af) weakReference.get();
                if (afVar == null) {
                    this.f679w.remove(weakReference);
                    z = z2;
                } else {
                    z = afVar.mo212a(this, c0187u);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m1349g();
            if (z) {
                this.f680x = c0187u;
            }
        }
        return z;
    }

    public boolean mo237d(C0187u c0187u) {
        boolean z = false;
        if (!this.f679w.isEmpty() && this.f680x == c0187u) {
            m1348f();
            Iterator it = this.f679w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                af afVar = (af) weakReference.get();
                if (afVar == null) {
                    this.f679w.remove(weakReference);
                    z = z2;
                } else {
                    z = afVar.mo213b(this, c0187u);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m1349g();
            if (z) {
                this.f680x = null;
            }
        }
        return z;
    }

    public C0187u m1359q() {
        return this.f680x;
    }
}
