package net.client.by.lock.gui.activity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import group.pals.android.lib.ui.filechooser.FileChooserActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import net.client.by.lock.C0322b;
import net.client.by.lock.R;
import net.client.by.lock.gui.p018b.an;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0341g;
import net.client.by.lock.p014c.C0326d;
import net.client.by.lock.p014c.C0327e;

/* compiled from: MyApp */
public class ContactActivity extends C0392q implements Observer {
    private C0337c f1634o;
    private ImageView f1635p;
    private TextView f1636r;
    private TextView f1637s;
    private TextView f1638t;
    private TextView f1639u;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_contact);
        this.f1634o = C0327e.m2092c().m2094a(Integer.valueOf(getIntent().getExtras().getInt("id")));
        if (this.f1634o == null) {
            finish();
            return;
        }
        this.f1635p = (ImageView) findViewById(R.id.contact_image);
        this.f1636r = (TextView) findViewById(R.id.contact_username);
        this.f1637s = (TextView) findViewById(R.id.contact_name);
        this.f1638t = (TextView) findViewById(R.id.contact_status);
        this.f1639u = (TextView) findViewById(R.id.contact_message);
        this.f1636r.setText(this.f1634o.m2229C());
        this.f1637s.setText(this.f1634o.m2231E());
        this.f1639u.setText(this.f1634o.m2283s());
        Iterator it = this.f1634o.m2241a().iterator();
        String str = "";
        while (it.hasNext()) {
            str = new StringBuilder(String.valueOf(str)).append((String) ((C0341g) C0327e.m2092c().m2101b(((Integer) it.next()).intValue()).m2305d()).m2303b().m2467a()).append(", ").toString();
        }
        if (str.length() > 2) {
            str.substring(0, str.length() - 2);
        }
        m1020f().mo196b(true);
        m1020f().mo192a((CharSequence) "");
    }

    public void onResume() {
        super.onResume();
        this.f1634o.m2282r().addObserver(this);
        m2605h();
    }

    public void onPause() {
        this.f1634o.m2282r().deleteObserver(this);
        super.onPause();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 5:
                    Iterator it = ((ArrayList) intent.getSerializableExtra(FileChooserActivity.f1056n)).iterator();
                    while (it.hasNext()) {
                        C0326d.m2089a().m2090a(this.f1634o, (File) it.next());
                    }
                    return;
                case 10:
                    if (intent != null && intent.getData() != null) {
                        Uri data = intent.getData();
                        if (data != null) {
                            Cursor query = getContentResolver().query(data, new String[]{"_data"}, null, null, null);
                            query.moveToFirst();
                            String string = query.getString(0);
                            query.close();
                            File file = new File(string);
                            an.m2728a(this, file.getPath());
                            C0326d.m2089a().m2090a(this.f1634o, file);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void m2605h() {
        switch (((Integer) this.f1634o.m2282r().m2467a()).intValue()) {
            case 0:
                this.f1638t.setText(R.string.status_offline);
                this.f1635p.setImageResource(R.drawable.big_online_0);
                return;
            case 1:
                this.f1638t.setText(R.string.status_busy);
                this.f1635p.setImageResource(R.drawable.big_online_1);
                return;
            case 2:
                this.f1638t.setText(R.string.status_away);
                this.f1635p.setImageResource(R.drawable.big_online_2);
                return;
            case 3:
                this.f1638t.setText(R.string.status_available);
                this.f1635p.setImageResource(R.drawable.big_online_3);
                return;
            default:
                return;
        }
    }

    public void update(Observable observable, Object obj) {
        C0322b.m2076e(this.q, "updated");
        if (!(obj instanceof String)) {
            return;
        }
        if (((String) obj).equals("status")) {
            m2605h();
        } else {
            C0322b.m2076e(this.q, "unknown update material#2");
        }
    }
}
