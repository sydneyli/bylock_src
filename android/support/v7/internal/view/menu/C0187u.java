package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p001b.p002a.C0041b;
import android.support.v4.view.C0087n;
import android.support.v4.view.ah;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

/* compiled from: MyApp */
public final class C0187u implements C0041b {
    private static String f712w;
    private static String f713x;
    private static String f714y;
    private static String f715z;
    private final int f716a;
    private final int f717b;
    private final int f718c;
    private final int f719d;
    private CharSequence f720e;
    private CharSequence f721f;
    private Intent f722g;
    private char f723h;
    private char f724i;
    private Drawable f725j;
    private int f726k = 0;
    private C0174q f727l;
    private al f728m;
    private Runnable f729n;
    private OnMenuItemClickListener f730o;
    private int f731p = 16;
    private int f732q = 0;
    private View f733r;
    private C0087n f734s;
    private ah f735t;
    private boolean f736u = false;
    private ContextMenuInfo f737v;

    public /* synthetic */ MenuItem setActionView(int i) {
        return m1392a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m1394a(view);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m1401b(i);
    }

    C0187u(C0174q c0174q, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f727l = c0174q;
        this.f716a = i2;
        this.f717b = i;
        this.f718c = i3;
        this.f719d = i4;
        this.f720e = charSequence;
        this.f732q = i5;
    }

    public boolean m1399a() {
        if ((this.f730o != null && this.f730o.onMenuItemClick(this)) || this.f727l.mo233a(this.f727l.mo238o(), (MenuItem) this)) {
            return true;
        }
        if (this.f729n != null) {
            this.f729n.run();
            return true;
        }
        if (this.f722g != null) {
            try {
                this.f727l.m1345d().startActivity(this.f722g);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        if (this.f734s == null || !this.f734s.m757f()) {
            return false;
        }
        return true;
    }

    public boolean isEnabled() {
        return (this.f731p & 16) != 0;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f731p |= 16;
        } else {
            this.f731p &= -17;
        }
        this.f727l.m1340b(false);
        return this;
    }

    public int getGroupId() {
        return this.f717b;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.f716a;
    }

    public int getOrder() {
        return this.f718c;
    }

    public int m1400b() {
        return this.f719d;
    }

    public Intent getIntent() {
        return this.f722g;
    }

    public MenuItem setIntent(Intent intent) {
        this.f722g = intent;
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.f724i;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f724i != c) {
            this.f724i = Character.toLowerCase(c);
            this.f727l.m1340b(false);
        }
        return this;
    }

    public char getNumericShortcut() {
        return this.f723h;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f723h != c) {
            this.f723h = c;
            this.f727l.m1340b(false);
        }
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f723h = c;
        this.f724i = Character.toLowerCase(c2);
        this.f727l.m1340b(false);
        return this;
    }

    char m1403c() {
        return this.f724i;
    }

    String m1405d() {
        char c = m1403c();
        if (c == '\u0000') {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(f712w);
        switch (c) {
            case '\b':
                stringBuilder.append(f714y);
                break;
            case '\n':
                stringBuilder.append(f713x);
                break;
            case ' ':
                stringBuilder.append(f715z);
                break;
            default:
                stringBuilder.append(c);
                break;
        }
        return stringBuilder.toString();
    }

    boolean m1408e() {
        return this.f727l.mo234b() && m1403c() != '\u0000';
    }

    public SubMenu getSubMenu() {
        return this.f728m;
    }

    public boolean hasSubMenu() {
        return this.f728m != null;
    }

    void m1396a(al alVar) {
        this.f728m = alVar;
        alVar.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f720e;
    }

    CharSequence m1395a(ai aiVar) {
        return (aiVar == null || !aiVar.mo205a()) ? getTitle() : getTitleCondensed();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f720e = charSequence;
        this.f727l.m1340b(false);
        if (this.f728m != null) {
            this.f728m.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitle(int i) {
        return setTitle(this.f727l.m1345d().getString(i));
    }

    public CharSequence getTitleCondensed() {
        return this.f721f != null ? this.f721f : this.f720e;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f721f = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f720e;
        }
        this.f727l.m1340b(false);
        return this;
    }

    public Drawable getIcon() {
        if (this.f725j != null) {
            return this.f725j;
        }
        if (this.f726k == 0) {
            return null;
        }
        Drawable drawable = this.f727l.m1343c().getDrawable(this.f726k);
        this.f726k = 0;
        this.f725j = drawable;
        return drawable;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f726k = 0;
        this.f725j = drawable;
        this.f727l.m1340b(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f725j = null;
        this.f726k = i;
        this.f727l.m1340b(false);
        return this;
    }

    public boolean isCheckable() {
        return (this.f731p & 1) == 1;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f731p;
        this.f731p = (z ? 1 : 0) | (this.f731p & -2);
        if (i != this.f731p) {
            this.f727l.m1340b(false);
        }
        return this;
    }

    public void m1398a(boolean z) {
        this.f731p = (z ? 4 : 0) | (this.f731p & -5);
    }

    public boolean m1409f() {
        return (this.f731p & 4) != 0;
    }

    public boolean isChecked() {
        return (this.f731p & 2) == 2;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f731p & 4) != 0) {
            this.f727l.m1331a((MenuItem) this);
        } else {
            m1402b(z);
        }
        return this;
    }

    void m1402b(boolean z) {
        int i;
        int i2 = this.f731p;
        int i3 = this.f731p & -3;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        this.f731p = i | i3;
        if (i2 != this.f731p) {
            this.f727l.m1340b(false);
        }
    }

    public boolean isVisible() {
        if (this.f734s == null || !this.f734s.m754c()) {
            if ((this.f731p & 8) != 0) {
                return false;
            }
            return true;
        } else if ((this.f731p & 8) == 0 && this.f734s.m755d()) {
            return true;
        } else {
            return false;
        }
    }

    boolean m1404c(boolean z) {
        int i = this.f731p;
        this.f731p = (z ? 0 : 8) | (this.f731p & -9);
        if (i != this.f731p) {
            return true;
        }
        return false;
    }

    public MenuItem setVisible(boolean z) {
        if (m1404c(z)) {
            this.f727l.m1330a(this);
        }
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f730o = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        return this.f720e.toString();
    }

    void m1397a(ContextMenuInfo contextMenuInfo) {
        this.f737v = contextMenuInfo;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.f737v;
    }

    public void m1410g() {
        this.f727l.m1339b(this);
    }

    public boolean m1411h() {
        return this.f727l.m1358p();
    }

    public boolean m1412i() {
        return (this.f731p & 32) == 32;
    }

    public boolean m1413j() {
        return (this.f732q & 1) == 1;
    }

    public boolean m1414k() {
        return (this.f732q & 2) == 2;
    }

    public void m1406d(boolean z) {
        if (z) {
            this.f731p |= 32;
        } else {
            this.f731p &= -33;
        }
    }

    public boolean m1415l() {
        return (this.f732q & 4) == 4;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.f732q = i;
                this.f727l.m1339b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public C0041b m1394a(View view) {
        this.f733r = view;
        this.f734s = null;
        if (view != null && view.getId() == -1 && this.f716a > 0) {
            view.setId(this.f716a);
        }
        this.f727l.m1339b(this);
        return this;
    }

    public C0041b m1392a(int i) {
        Context d = this.f727l.m1345d();
        m1394a(LayoutInflater.from(d).inflate(i, new LinearLayout(d), false));
        return this;
    }

    public View getActionView() {
        if (this.f733r != null) {
            return this.f733r;
        }
        if (this.f734s == null) {
            return null;
        }
        this.f733r = this.f734s.m749a((MenuItem) this);
        return this.f733r;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("Implementation should use setSupportActionProvider!");
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("Implementation should use getSupportActionProvider!");
    }

    public C0087n m1416m() {
        return this.f734s;
    }

    public C0041b mo224a(C0087n c0087n) {
        if (this.f734s != c0087n) {
            this.f733r = null;
            if (this.f734s != null) {
                this.f734s.m751a(null);
            }
            this.f734s = c0087n;
            this.f727l.m1340b(true);
            if (c0087n != null) {
                c0087n.m751a(new C0188v(this));
            }
        }
        return this;
    }

    public C0041b m1401b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        if ((this.f732q & 8) == 0 || this.f733r == null) {
            return false;
        }
        if (this.f735t == null || this.f735t.m536a(this)) {
            return this.f727l.mo235c(this);
        }
        return false;
    }

    public boolean collapseActionView() {
        if ((this.f732q & 8) == 0) {
            return false;
        }
        if (this.f733r == null) {
            return true;
        }
        if (this.f735t == null || this.f735t.m537b(this)) {
            return this.f727l.mo237d(this);
        }
        return false;
    }

    public boolean m1417n() {
        return ((this.f732q & 8) == 0 || this.f733r == null) ? false : true;
    }

    public void m1407e(boolean z) {
        this.f736u = z;
        this.f727l.m1340b(false);
    }

    public boolean isActionViewExpanded() {
        return this.f736u;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("Implementation should use setSupportOnActionExpandListener!");
    }
}
