package net.client.by.lock.gui.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import net.client.by.lock.p012d.C0341g;
import net.client.by.lock.p014c.C0332j;

/* compiled from: MyApp */
class ap implements OnClickListener {
    final /* synthetic */ am f1742a;
    private final /* synthetic */ C0341g f1743b;
    private final /* synthetic */ EditText f1744c;

    ap(am amVar, C0341g c0341g, EditText editText) {
        this.f1742a = amVar;
        this.f1743b = c0341g;
        this.f1744c = editText;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1743b.m2302a(this.f1744c.getText().toString());
        C0332j.m2148a().m2163a(this.f1743b);
    }
}
