package android.support.v7.p006a;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: MyApp */
class C0140m implements Callback {
    final Callback f469a;
    final /* synthetic */ C0139l f470b;

    public C0140m(C0139l c0139l, Callback callback) {
        this.f470b = c0139l;
        this.f469a = callback;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f469a.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f469a.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f469a.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f469a.dispatchTrackballEvent(motionEvent);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f469a.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f469a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public View onCreatePanelView(int i) {
        return this.f469a.onCreatePanelView(i);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.f469a.onCreatePanelMenu(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.f469a.onPreparePanel(i, view, menu);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return this.f469a.onMenuOpened(i, menu);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.f469a.onMenuItemSelected(i, menuItem);
    }

    public void onWindowAttributesChanged(LayoutParams layoutParams) {
        this.f469a.onWindowAttributesChanged(layoutParams);
    }

    public void onContentChanged() {
        this.f469a.onContentChanged();
    }

    public void onWindowFocusChanged(boolean z) {
        this.f469a.onWindowFocusChanged(z);
    }

    public void onAttachedToWindow() {
        this.f469a.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        this.f469a.onDetachedFromWindow();
    }

    public void onPanelClosed(int i, Menu menu) {
        this.f469a.onPanelClosed(i, menu);
    }

    public boolean onSearchRequested() {
        return this.f469a.onSearchRequested();
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f469a.onWindowStartingActionMode(callback);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f469a.onActionModeStarted(actionMode);
        this.f470b.m1093a(actionMode);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f469a.onActionModeFinished(actionMode);
        this.f470b.m1101b(actionMode);
    }
}
