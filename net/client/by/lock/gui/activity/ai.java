package net.client.by.lock.gui.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import net.client.by.lock.p014c.C0331i;

/* compiled from: MyApp */
class ai implements OnItemClickListener {
    final /* synthetic */ ah f1733a;

    ai(ah ahVar) {
        this.f1733a = ahVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        File file = new File(new StringBuilder(String.valueOf(C0331i.m2124a().m2132b())).append("/").append(((TextView) view).getText()).toString());
        try {
            this.f1733a.m35a(new Intent().setDataAndType(Uri.fromFile(file), MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(file.toURI().toString()))).setAction("android.intent.action.VIEW"));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this.f1733a.m47b(), "No handler for this type of file.", 1).show();
        }
    }
}
