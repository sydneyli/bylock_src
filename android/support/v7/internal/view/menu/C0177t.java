package android.support.v7.internal.view.menu;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v7.p008b.C0154h;
import android.support.v7.p008b.C0156j;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

/* compiled from: MyApp */
public class C0177t implements OnClickListener, OnDismissListener, OnKeyListener, ag {
    private C0174q f685a;
    C0185o f686b;
    private AlertDialog f687c;
    private ag f688d;

    public C0177t(C0174q c0174q) {
        this.f685a = c0174q;
    }

    public void m1369a(IBinder iBinder) {
        C0174q c0174q = this.f685a;
        Builder builder = new Builder(c0174q.m1345d());
        this.f686b = new C0185o(C0154h.abc_list_menu_item_layout, C0156j.Theme_AppCompat_CompactMenu_Dialog);
        this.f686b.m1382a((ag) this);
        this.f685a.m1328a(this.f686b);
        builder.setAdapter(this.f686b.m1380a(), this);
        View n = c0174q.m1356n();
        if (n != null) {
            builder.setCustomTitle(n);
        } else {
            builder.setIcon(c0174q.m1355m()).setTitle(c0174q.m1354l());
        }
        builder.setOnKeyListener(this);
        this.f687c = builder.create();
        this.f687c.setOnDismissListener(this);
        LayoutParams attributes = this.f687c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f687c.show();
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.f687c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.f687c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.f685a.m1333a(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f685a.performShortcut(i, keyEvent, 0);
    }

    public void m1368a() {
        if (this.f687c != null) {
            this.f687c.dismiss();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f686b.mo210a(this.f685a, true);
    }

    public void mo169a(C0174q c0174q, boolean z) {
        if (z || c0174q == this.f685a) {
            m1368a();
        }
        if (this.f688d != null) {
            this.f688d.mo169a(c0174q, z);
        }
    }

    public boolean mo179b(C0174q c0174q) {
        if (this.f688d != null) {
            return this.f688d.mo179b(c0174q);
        }
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f685a.m1336a((C0187u) this.f686b.m1380a().getItem(i), 0);
    }
}
