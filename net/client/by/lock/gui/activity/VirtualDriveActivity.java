package net.client.by.lock.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import net.client.by.lock.R;
import net.client.by.lock.gui.p018b.ao;

/* compiled from: MyApp */
public class VirtualDriveActivity extends C0392q {
    private ao f1714o;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_virtual_drive);
        this.f1714o = new ao(this);
        ((ListView) findViewById(R.id.listView1)).setAdapter(this.f1714o);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_virtual_drive, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_done:
                Intent intent = new Intent();
                intent.putExtra("virtual", this.f1714o.m2732a());
                setResult(-1, intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}
