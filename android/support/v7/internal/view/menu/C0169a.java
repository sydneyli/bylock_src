package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p001b.p002a.C0041b;
import android.support.v4.view.C0087n;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

/* compiled from: MyApp */
public class C0169a implements C0041b {
    private final int f617a;
    private final int f618b;
    private final int f619c;
    private final int f620d;
    private CharSequence f621e;
    private CharSequence f622f;
    private Intent f623g;
    private char f624h;
    private char f625i;
    private Drawable f626j;
    private int f627k = 0;
    private Context f628l;
    private OnMenuItemClickListener f629m;
    private int f630n = 16;

    public /* synthetic */ MenuItem setActionView(int i) {
        return m1273a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m1275a(view);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m1276b(i);
    }

    public C0169a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f628l = context;
        this.f617a = i2;
        this.f618b = i;
        this.f619c = i3;
        this.f620d = i4;
        this.f621e = charSequence;
    }

    public char getAlphabeticShortcut() {
        return this.f625i;
    }

    public int getGroupId() {
        return this.f618b;
    }

    public Drawable getIcon() {
        return this.f626j;
    }

    public Intent getIntent() {
        return this.f623g;
    }

    public int getItemId() {
        return this.f617a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f624h;
    }

    public int getOrder() {
        return this.f620d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f621e;
    }

    public CharSequence getTitleCondensed() {
        return this.f622f;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f630n & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f630n & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f630n & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f630n & 8) == 0;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f625i = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f630n = (z ? 1 : 0) | (this.f630n & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f630n = (z ? 2 : 0) | (this.f630n & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f630n = (z ? 16 : 0) | (this.f630n & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f626j = drawable;
        this.f627k = 0;
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f627k = i;
        this.f626j = this.f628l.getResources().getDrawable(i);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f623g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f624h = c;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f629m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f624h = c;
        this.f625i = c2;
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f621e = charSequence;
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f621e = this.f628l.getResources().getString(i);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f622f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.f630n = (z ? 0 : 8) | (this.f630n & 8);
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public C0041b m1275a(View view) {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public C0041b m1273a(int i) {
        throw new UnsupportedOperationException();
    }

    public C0041b mo224a(C0087n c0087n) {
        throw new UnsupportedOperationException();
    }

    public C0041b m1276b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }
}
