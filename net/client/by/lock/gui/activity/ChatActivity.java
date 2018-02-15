package net.client.by.lock.gui.activity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.C0024j;
import android.support.v7.p006a.C0126a;
import android.support.v7.p007c.C0142a;
import android.support.v7.p008b.C0157k;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import group.pals.android.lib.ui.filechooser.FileChooserActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import net.client.by.lock.R;
import net.client.by.lock.gui.p018b.C0417a;
import net.client.by.lock.gui.p018b.an;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p013b.C0312d;
import net.client.by.lock.p013b.C0319k;
import net.client.by.lock.p014c.C0325c;
import net.client.by.lock.p014c.C0327e;
import net.client.by.lock.p014c.C0330h;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p016f.C0363h;
import net.client.by.lock.p016f.C0365j;
import net.client.by.lock.p016f.C0370o;

/* compiled from: MyApp */
public class ChatActivity extends C0392q implements Observer {
    public ListView f1625o;
    C0142a f1626p;
    private C0337c f1627r;
    private EditText f1628s;
    private C0312d f1629t;
    private InputMethodManager f1630u;
    private C0126a f1631v;
    private C0407p f1632w;
    private C0417a f1633x;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_chat);
        if (getIntent() == null) {
            finish();
        } else if (getIntent().hasExtra("id")) {
            int i = getIntent().getExtras().getInt("id");
            this.f1627r = C0327e.m2092c().m2094a(Integer.valueOf(i));
            if (this.f1627r == null) {
                an.m2728a(this, "Friend with id: " + i + " could not be found.");
                finish();
                return;
            }
            this.f1625o = (ListView) findViewById(R.id.chat_log);
            this.f1628s = (EditText) findViewById(R.id.chat_input_text);
            this.f1628s.setOnEditorActionListener(new C0404m(this));
            this.f1630u = (InputMethodManager) getSystemService("input_method");
            this.f1625o.setOnTouchListener(new C0405n(this));
            findViewById(R.id.chat_send).setOnClickListener(new C0406o(this));
            this.f1633x = this.f1627r.m2239M();
            this.f1633x.m2707a(this);
            this.f1625o.setAdapter(this.f1633x);
            this.f1631v = m1020f();
            this.f1631v.mo196b(true);
            this.f1631v.mo198d(true);
            this.f1631v.mo192a(this.f1627r.m2233G());
            this.f1631v.mo190a(17170445);
            this.f1632w = new C0407p();
        } else {
            finish();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_chat, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                finish();
                return true;
            case R.id.menu_lock:
                m2601p();
                return true;
            case R.id.menu_call:
                m2596k();
                return true;
            case R.id.menu_file:
                m2599n();
                return true;
            case R.id.menu_mail:
                m2598m();
                return true;
            case R.id.menu_profile:
                m2597l();
                return true;
            case R.id.menu_clear_history:
                m2600o();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C0325c.m2086a().m2087a(this);
        if (i2 == -1) {
            switch (i) {
                case 5:
                    Iterator it = ((ArrayList) intent.getSerializableExtra(FileChooserActivity.f1056n)).iterator();
                    while (it.hasNext()) {
                        this.f1627r.m2245a((File) it.next());
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
                            this.f1627r.m2245a(new File(string));
                            return;
                        }
                        return;
                    }
                    return;
                case 14:
                    ArrayList integerArrayListExtra = intent.getIntegerArrayListExtra("selected");
                    ArrayList arrayList = new ArrayList();
                    Iterator it2 = integerArrayListExtra.iterator();
                    while (it2.hasNext()) {
                        C0337c a = C0327e.m2092c().m2094a(Integer.valueOf(((Integer) it2.next()).intValue()));
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                    C0332j.m2148a().m2159a(this.f1629t, arrayList);
                    return;
                case C0157k.ActionBar_progressBarPadding /*17*/:
                    m2595d(intent);
                    return;
                case 22:
                    m2593c(intent);
                    return;
                default:
                    return;
            }
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("id", this.f1627r.m2237K());
    }

    protected void onPause() {
        try {
            this.f1627r.m2275k();
            this.f1627r.m2281q().deleteObserver(this);
            C0351r.m2359i().m2398t().deleteObserver(this);
            this.f1627r.m2288x().deleteObserver(this);
            this.f1627r.m2282r().deleteObserver(this);
            this.f1630u.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            if (isFinishing()) {
                C0327e.m2092c().deleteObserver(this);
                this.f1633x = null;
            }
        } catch (Throwable e) {
            C0365j.m2476a(this.q + "ChatActivity", e);
        }
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        if (C0391a.m2578b()) {
            Intent intent = new Intent(this, CallActivity.class);
            intent.addFlags(131072);
            startActivity(intent);
            return;
        }
        C0330h.m2111a().m2118b(this.f1627r, 1);
        C0330h.m2111a().m2118b(this.f1627r, 2);
        C0330h.m2111a().m2118b(this.f1627r, 3);
        C0330h.m2111a().m2118b(this.f1627r, 4);
        setTitle(new StringBuilder(String.valueOf((String) C0351r.m2359i().m2381f().m2467a())).append("   :   ").append((String) C0351r.m2359i().m2393o().m2467a()).toString());
        this.f1627r.m2281q().addObserver(this);
        this.f1627r.m2288x().addObserver(this);
        this.f1627r.m2282r().addObserver(this);
        C0351r.m2359i().m2398t().addObserver(this);
        C0327e.m2092c().addObserver(this);
        this.f1627r.m2274j();
        C0370o.m2490a((C0024j) this);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.f1627r == null) {
            return false;
        }
        int i;
        MenuItem item = menu.getItem(0);
        MenuItem item2 = menu.getItem(1);
        String str = (String) this.f1627r.m2288x().m2467a();
        if (str.equals("NK")) {
            item.setVisible(false);
            item.setEnabled(false);
        } else if (str.equals("KWCS")) {
            item.setVisible(true);
            item.setEnabled(true);
            item.setIcon(R.drawable.action_lock_2);
        } else if (str.equals("KWIS")) {
            item.setVisible(true);
            item.setEnabled(true);
            item.setIcon(R.drawable.action_lock_3);
        } else if (str.equals("KWOS")) {
            item.setVisible(true);
            item.setEnabled(true);
            item.setIcon(R.drawable.action_lock_1);
        }
        if (((Boolean) this.f1627r.m2281q().m2467a()).booleanValue()) {
            item2.setEnabled(true);
        } else {
            item2.setEnabled(false);
        }
        switch (((Integer) this.f1627r.m2282r().m2467a()).intValue()) {
            case 0:
                i = R.drawable.action_call_0;
                break;
            case 1:
                i = R.drawable.action_call_1;
                break;
            case 2:
                i = R.drawable.action_call_2;
                break;
            case 3:
                i = R.drawable.action_call_3;
                break;
            default:
                i = R.drawable.action_call;
                break;
        }
        item2.setIcon(i);
        return true;
    }

    private void m2593c(Intent intent) {
        Intent intent2 = new Intent(this, MainActivity.class);
        intent2.putExtras(intent.getExtras());
        intent2.addFlags(131072);
        startActivity(intent2);
        finish();
    }

    private void m2595d(Intent intent) {
        ArrayList stringArrayListExtra = intent.getStringArrayListExtra("files");
        if (stringArrayListExtra != null) {
            Iterator it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                this.f1627r.m2245a(new File((String) it.next()));
            }
        }
        stringArrayListExtra = intent.getStringArrayListExtra("virtual");
        if (stringArrayListExtra != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f1627r);
            Iterator it2 = stringArrayListExtra.iterator();
            while (it2.hasNext()) {
                C0332j.m2148a().m2159a(C0319k.m2069b().m2073b((String) it2.next()), arrayList);
            }
        }
    }

    private void m2596k() {
        Intent intent = new Intent(this, CallActivity.class);
        intent.putExtra("id", this.f1627r.m2237K());
        this.f1627r.m2262c();
        startActivityForResult(intent, 12477);
    }

    private void m2597l() {
        Intent intent = new Intent(this, ContactActivity.class);
        intent.putExtra("id", this.f1627r.m2237K());
        startActivityForResult(intent, 12477);
    }

    private void m2598m() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("id", this.f1627r.m2237K());
        intent.putExtra("mail", true);
        intent.addFlags(131072);
        startActivity(intent);
        finish();
    }

    private void m2599n() {
        startActivityForResult(new Intent(this, SelectFilesActivity.class), 17);
    }

    private void m2600o() {
        this.f1633x.m2710b(true);
    }

    private void m2601p() {
        Intent intent = new Intent(this, ValidateActivity.class);
        intent.putExtra("id", this.f1627r.m2237K());
        startActivityForResult(intent, 12477);
    }

    public C0337c m2602h() {
        return this.f1627r;
    }

    public void update(Observable observable, Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.equals("status") || str.equals("onlineProperty") || str.equals("verificationStateProperty")) {
                C0370o.m2490a((C0024j) this);
            } else if (!str.equals("isConnected")) {
            } else {
                if (((Boolean) ((C0363h) observable).m2467a()).booleanValue() && !((Boolean) C0351r.m2359i().m2398t().m2470b()).booleanValue()) {
                    this.f1627r.m2278n().addObserver(this);
                    this.f1627r.m2281q().addObserver(this);
                } else if (!((Boolean) ((C0363h) observable).m2467a()).booleanValue() && ((Boolean) C0351r.m2359i().m2398t().m2470b()).booleanValue()) {
                    this.f1627r.m2278n().deleteObserver(this);
                    this.f1627r.m2281q().deleteObserver(this);
                }
            }
        } else if ((observable instanceof C0327e) && C0327e.m2092c().m2094a(Integer.valueOf(this.f1627r.m2237K())) == null) {
            finishActivity(12477);
            finishActivity(17);
            an.m2728a(this, new StringBuilder(String.valueOf(this.f1627r.m2233G())).append(" has removed.").toString());
            finish();
        }
    }

    public int m2603i() {
        return this.f1627r.m2237K();
    }

    public void m2604j() {
        this.f1626p = m1005a(this.f1632w);
    }
}
