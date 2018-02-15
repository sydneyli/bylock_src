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
class C0389n implements OnClickListener {
    final /* synthetic */ C0388m f1603a;

    C0389n(C0388m c0388m) {
        this.f1603a = c0388m;
    }

    public void onClick(View view) {
        Context context = view.getContext();
        File j = this.f1603a.f1602j.m2042j();
        if (j == null || !j.exists()) {
            Toast.makeText(context, "File cannot be found", 0).show();
            return;
        }
        try {
            context.startActivity(new Intent().setDataAndType(Uri.fromFile(j), MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(j.toURI().toString()))).setAction("android.intent.action.VIEW"));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, "No handler for this type of file.", 1).show();
        }
    }
}
