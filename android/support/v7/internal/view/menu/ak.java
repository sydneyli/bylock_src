package android.support.v7.internal.view.menu;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.p001b.p002a.C0040a;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* compiled from: MyApp */
class ak extends C0171m implements C0040a {
    ak(Menu menu) {
        super(menu);
    }

    public MenuItem add(CharSequence charSequence) {
        return m1277a(((Menu) this.a).add(charSequence));
    }

    public MenuItem add(int i) {
        return m1277a(((Menu) this.a).add(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m1277a(((Menu) this.a).add(i, i2, i3, charSequence));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m1277a(((Menu) this.a).add(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return m1278a(((Menu) this.a).addSubMenu(charSequence));
    }

    public SubMenu addSubMenu(int i) {
        return m1278a(((Menu) this.a).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return m1278a(((Menu) this.a).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return m1278a(((Menu) this.a).addSubMenu(i, i2, i3, i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = null;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        }
        int addIntentOptions = ((Menu) this.a).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = m1277a(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    public void removeItem(int i) {
        m1281b(i);
        ((Menu) this.a).removeItem(i);
    }

    public void removeGroup(int i) {
        m1280a(i);
        ((Menu) this.a).removeGroup(i);
    }

    public void clear() {
        m1279a();
        ((Menu) this.a).clear();
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((Menu) this.a).setGroupCheckable(i, z, z2);
    }

    public void setGroupVisible(int i, boolean z) {
        ((Menu) this.a).setGroupVisible(i, z);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((Menu) this.a).setGroupEnabled(i, z);
    }

    public boolean hasVisibleItems() {
        return ((Menu) this.a).hasVisibleItems();
    }

    public MenuItem findItem(int i) {
        return m1277a(((Menu) this.a).findItem(i));
    }

    public int size() {
        return ((Menu) this.a).size();
    }

    public MenuItem getItem(int i) {
        return m1277a(((Menu) this.a).getItem(i));
    }

    public void close() {
        ((Menu) this.a).close();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((Menu) this.a).performShortcut(i, keyEvent, i2);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((Menu) this.a).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((Menu) this.a).performIdentifierAction(i, i2);
    }

    public void setQwertyMode(boolean z) {
        ((Menu) this.a).setQwertyMode(z);
    }
}
