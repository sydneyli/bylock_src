package android.support.v7.internal.view.menu;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p001b.p002a.C0041b;
import android.support.v4.view.C0087n;
import android.support.v7.p007c.C0158c;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

/* compiled from: MyApp */
class C0172w extends C0171m implements C0041b {
    private final boolean f635b;
    private boolean f636c;

    C0172w(MenuItem menuItem, boolean z) {
        super(menuItem);
        this.f636c = menuItem.isVisible();
        this.f635b = z;
    }

    C0172w(MenuItem menuItem) {
        this(menuItem, true);
    }

    public int getItemId() {
        return ((MenuItem) this.a).getItemId();
    }

    public int getGroupId() {
        return ((MenuItem) this.a).getGroupId();
    }

    public int getOrder() {
        return ((MenuItem) this.a).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((MenuItem) this.a).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((MenuItem) this.a).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((MenuItem) this.a).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((MenuItem) this.a).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((MenuItem) this.a).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((MenuItem) this.a).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((MenuItem) this.a).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((MenuItem) this.a).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((MenuItem) this.a).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((MenuItem) this.a).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((MenuItem) this.a).setShortcut(c, c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((MenuItem) this.a).setNumericShortcut(c);
        return this;
    }

    public char getNumericShortcut() {
        return ((MenuItem) this.a).getNumericShortcut();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((MenuItem) this.a).setAlphabeticShortcut(c);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((MenuItem) this.a).getAlphabeticShortcut();
    }

    public MenuItem setCheckable(boolean z) {
        ((MenuItem) this.a).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((MenuItem) this.a).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((MenuItem) this.a).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((MenuItem) this.a).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        if (this.f635b) {
            this.f636c = z;
            if (m1288c()) {
                return this;
            }
        }
        return m1285a(z);
    }

    public boolean isVisible() {
        return ((MenuItem) this.a).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((MenuItem) this.a).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((MenuItem) this.a).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((MenuItem) this.a).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return m1278a(((MenuItem) this.a).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((MenuItem) this.a).setOnMenuItemClickListener(onMenuItemClickListener != null ? new aa(this, onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((MenuItem) this.a).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((MenuItem) this.a).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((MenuItem) this.a).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof C0158c) {
            view = new C0190z(view);
        }
        ((MenuItem) this.a).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((MenuItem) this.a).setActionView(i);
        View actionView = ((MenuItem) this.a).getActionView();
        if (actionView instanceof C0158c) {
            ((MenuItem) this.a).setActionView(new C0190z(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((MenuItem) this.a).getActionView();
        if (actionView instanceof C0190z) {
            return ((C0190z) actionView).m1420a();
        }
        return actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((MenuItem) this.a).setActionProvider(actionProvider);
        if (actionProvider != null && this.f635b) {
            m1288c();
        }
        return this;
    }

    public ActionProvider getActionProvider() {
        return ((MenuItem) this.a).getActionProvider();
    }

    public boolean expandActionView() {
        return ((MenuItem) this.a).expandActionView();
    }

    public boolean collapseActionView() {
        return ((MenuItem) this.a).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((MenuItem) this.a).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((MenuItem) this.a).setOnActionExpandListener(onActionExpandListener);
        return this;
    }

    public C0041b mo224a(C0087n c0087n) {
        ((MenuItem) this.a).setActionProvider(c0087n != null ? mo229b(c0087n) : null);
        return this;
    }

    public C0087n m1286b() {
        C0173x c0173x = (C0173x) ((MenuItem) this.a).getActionProvider();
        return c0173x != null ? c0173x.f637a : null;
    }

    C0173x mo229b(C0087n c0087n) {
        return new C0173x(this, c0087n);
    }

    final boolean m1288c() {
        if (!this.f636c) {
            return false;
        }
        C0087n b = m1286b();
        if (b == null || !b.m754c() || b.m755d()) {
            return false;
        }
        m1285a(false);
        return true;
    }

    final MenuItem m1285a(boolean z) {
        return ((MenuItem) this.a).setVisible(z);
    }
}
