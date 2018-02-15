package net.client.by.lock.gui.p017a;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import java.io.File;

/* compiled from: MyApp */
class C0384i implements OnClickListener {
    final /* synthetic */ C0383h f1597a;

    C0384i(C0383h c0383h) {
        this.f1597a = c0383h;
    }

    public void onClick(View view) {
        Context context = view.getContext();
        if (((String) this.f1597a.f1596j.m1914F().m2467a()).equals("COMPLETED")) {
            File j = this.f1597a.f1596j.m2042j();
            if (j == null || !j.exists()) {
                Toast.makeText(context, "File cannot be found", 0).show();
                return;
            }
            try {
                context.startActivity(new Intent().setDataAndType(Uri.fromFile(j), MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(j.toURI().toString()))).setAction("android.intent.action.VIEW"));
            } catch (ActivityNotFoundException e) {
                Toast.makeText(context, "No handler for this type of file.", 1).show();
            }
        } else if (((String) this.f1597a.f1596j.m1914F().m2467a()).equals("IN PROGRESS")) {
            Toast.makeText(context, "File is still being downloaded", 0).show();
        } else {
            Toast.makeText(context, "File download has been started", 0).show();
            this.f1597a.f1596j.m2051l();
        }
    }
}
