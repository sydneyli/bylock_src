package net.client.by.lock.gui.activity;

import android.os.Bundle;
import android.support.v7.p006a.C0126a;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ToggleButton;
import net.client.by.lock.R;
import net.client.by.lock.p014c.C0331i;

/* compiled from: MyApp */
public class SettingsActivity extends C0392q {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_settings);
        findViewById(R.id.textView1).setOnClickListener(new bu(this));
        ((ToggleButton) findViewById(R.id.toggleButton1)).setChecked(C0331i.m2124a().m2142f());
        C0126a f = m1020f();
        f.mo196b(true);
        f.mo190a(17170445);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_settings, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                finish();
                return true;
            case R.id.menu_done:
                C0331i.m2124a().m2131a(((ToggleButton) findViewById(R.id.toggleButton1)).isChecked());
                finish();
                return true;
            default:
                return false;
        }
    }
}
