package net.client.by.lock.gui.activity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.p008b.C0157k;
import android.view.View;
import android.widget.TextView;
import group.pals.android.lib.ui.filechooser.FileChooserActivity;
import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import net.client.by.lock.C0307a;
import net.client.by.lock.R;
import net.client.by.lock.p016f.C0356a;

/* compiled from: MyApp */
public class SelectFilesActivity extends C0392q {
    private static String f1704o;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_select_files);
        f1704o = null;
        findViewById(R.id.relativeLayout1).setOnClickListener(new bn(this));
        findViewById(R.id.relativeLayout2).setOnClickListener(new bo(this));
        findViewById(R.id.relativeLayout3).setOnClickListener(new bp(this));
        findViewById(R.id.relativeLayout4).setOnClickListener(new bq(this));
        View inflate = View.inflate(this, R.layout.actionbar_select_friends, null);
        m1020f().mo195b(16);
        m1020f().mo191a(inflate);
        inflate.findViewById(R.id.actionBarBack).setOnClickListener(new br(this));
        ((TextView) inflate.findViewById(R.id.actionBarTitle)).setText(R.string.attach_file);
    }

    private static File m2630i() {
        File file = new File(C0356a.m2454a());
        file.mkdirs();
        file = File.createTempFile("byLock-Captured_" + new SimpleDateFormat("yyyyMMdd_HHmmss", C0307a.f1343c).format(new Date()) + "_", ".JPG", file);
        file.mkdirs();
        f1704o = file.getAbsolutePath();
        return file;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case C0157k.ActionBar_itemPadding /*18*/:
                    m2631j();
                    return;
                case 19:
                    m2627d(intent);
                    return;
                case 20:
                    m2628e(intent);
                    return;
                case 21:
                    m2626c(intent);
                    return;
                default:
                    super.onActivityResult(i, i2, intent);
                    return;
            }
        } else if (i2 == 0) {
            setResult(0);
            finish();
        }
    }

    private void m2626c(Intent intent) {
        Intent intent2 = new Intent();
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra(FileChooserActivity.f1056n);
        Serializable arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((File) it.next()).getAbsolutePath());
        }
        intent2.putExtra("files", arrayList2);
        setResult(-1, intent2);
        finish();
    }

    private void m2627d(Intent intent) {
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            Cursor query = getContentResolver().query(data, new String[]{"_data"}, null, null, null);
            if (query != null) {
                query.moveToFirst();
                f1704o = query.getString(0);
                query.close();
                m2625b(f1704o);
            } else if (intent.getData() != null) {
                f1704o = intent.getData().getPath();
                if (f1704o != null && new File(f1704o).exists()) {
                    m2625b(f1704o);
                }
            }
        }
    }

    private void m2631j() {
        m2625b(f1704o);
    }

    private void m2628e(Intent intent) {
        setResult(-1, intent);
        finish();
    }

    private void m2625b(String str) {
        Intent intent = new Intent();
        Serializable arrayList = new ArrayList();
        arrayList.add(str);
        intent.putExtra("files", arrayList);
        setResult(-1, intent);
        finish();
    }
}
