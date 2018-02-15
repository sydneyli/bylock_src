package net.client.by.lock.gui.activity;

import android.support.v7.p007c.C0136b;
import android.support.v7.p007c.C0142a;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import net.client.by.lock.R;

/* compiled from: MyApp */
class C0407p implements C0136b {
    final /* synthetic */ ChatActivity f1820a;

    private C0407p(ChatActivity chatActivity) {
        this.f1820a = chatActivity;
    }

    public boolean mo186a(C0142a c0142a, MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.actionmod_select_all:
                this.f1820a.f1633x.m2706a();
                break;
            case R.id.actionmod_copy:
                Toast.makeText(this.f1820a.getBaseContext(), R.string.copied, 1).show();
                this.f1820a.f1633x.m2709b();
                c0142a.mo201b();
                break;
            case R.id.actionmod_delete:
                this.f1820a.f1633x.m2710b(false);
                c0142a.mo201b();
                break;
        }
        return false;
    }

    public boolean mo185a(C0142a c0142a, Menu menu) {
        this.f1820a.getMenuInflater().inflate(R.menu.actionmod_chat, menu);
        return true;
    }

    public void mo184a(C0142a c0142a) {
        if (c0142a.equals(this.f1820a.f1626p)) {
            this.f1820a.f1633x.mo357a(false);
        }
    }

    public boolean mo187b(C0142a c0142a, Menu menu) {
        return false;
    }
}
