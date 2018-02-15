package net.client.by.lock.gui.p017a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Observer;
import java.util.TimeZone;
import net.client.by.lock.R;
import net.client.by.lock.p012d.C0288k;
import net.client.by.lock.p016f.C0363h;

/* compiled from: MyApp */
public abstract class C0376a implements OnClickListener, OnLongClickListener, Checkable {
    protected View f1576a = null;
    protected CheckBox f1577b = null;
    protected C0288k f1578c = null;
    protected C0363h f1579d;
    protected C0363h f1580e;
    protected int f1581f;
    protected boolean f1582g = false;
    protected boolean f1583h = false;
    protected Observer f1584i = new C0377b(this);
    private ProgressBar f1585j = null;
    private boolean f1586k = false;
    private C0379d f1587l;

    protected abstract void mo331a(Context context);

    public abstract void mo332a(String str);

    public C0376a(C0288k c0288k) {
        this.f1578c = c0288k;
        this.f1579d = new C0363h("", "time");
        this.f1580e = new C0363h(Integer.valueOf(0), "barVisibility");
        this.f1581f = 0;
        this.f1579d.addObserver(this.f1584i);
        this.f1580e.addObserver(this.f1584i);
    }

    protected void m2559b(Context context) {
    }

    public final View m2551a(Context context, boolean z) {
        if (this.f1576a == null) {
            mo331a(context);
            this.f1585j = (ProgressBar) this.f1576a.findViewById(R.id.chat_bar);
            this.f1577b = (CheckBox) this.f1576a.findViewById(R.id.chat_check);
            this.f1576a.setOnLongClickListener(this);
            this.f1576a.setOnClickListener(this);
        } else {
            m2559b(context);
        }
        this.f1586k = z;
        if (this.f1576a != null) {
            View findViewById = this.f1576a.findViewById(R.id.chat_hour);
            if (findViewById != null && (findViewById instanceof TextView)) {
                TextView textView = (TextView) findViewById;
                if (z) {
                    String B = this.f1578c.m1910B();
                    synchronized (this.f1579d) {
                        if (!B.matches("[0-9]{2}[.][0-9]{2}[.][0-9]{4} [0-9]{2}[:][0-9]{2}") || textView == null || B.equals("01.01.2970 00:00")) {
                            textView.setVisibility(8);
                        } else {
                            textView.setVisibility(0);
                        }
                    }
                } else {
                    textView.setVisibility(8);
                }
            }
        }
        m2557a(this.f1583h);
        this.f1576a.setBackgroundColor(this.f1576a.getContext().getResources().getColor(this.f1582g ? R.color.Orange : R.color.WhiteSmoke));
        return this.f1576a;
    }

    public void m2552a() {
        Object B = this.f1578c.m1910B();
        synchronized (this.f1579d) {
            if (B.matches("[0-9]{2}[.][0-9]{2}[.][0-9]{4} [0-9]{2}[:][0-9]{2}") && !((String) this.f1579d.m2467a()).equals(B)) {
                this.f1579d.m2468a(B);
            }
        }
    }

    public void m2553a(int i) {
        this.f1580e.m2468a(Integer.valueOf(i));
    }

    public void m2558b(int i) {
        this.f1581f = i;
        if (this.f1576a != null && this.f1585j != null) {
            this.f1585j.setProgress(i);
        }
    }

    private void m2550b(String str) {
        if (this.f1576a == null) {
            return;
        }
        View findViewById;
        if (str.equals("time")) {
            CharSequence format;
            String str2 = (String) this.f1579d.m2467a();
            findViewById = this.f1576a.findViewById(R.id.chat_hour);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault());
            try {
                simpleDateFormat.setTimeZone(TimeZone.getDefault());
                format = simpleDateFormat.format(simpleDateFormat.parse(str2));
            } catch (Exception e) {
                e.printStackTrace();
                Object obj = str2;
            }
            if (findViewById != null && (findViewById instanceof TextView)) {
                TextView textView = (TextView) findViewById;
                if (format.matches("[0-9]{2}[.][0-9]{2}[.][0-9]{4} [0-9]{2}[:][0-9]{2}") && !format.equals("01.01.2970 00:00")) {
                    textView.setText(format);
                }
                textView.setVisibility(this.f1586k ? 0 : 8);
            }
        } else if (str.equals("barVisibility")) {
            findViewById = this.f1576a.findViewById(R.id.chat_bar);
            if (findViewById != null) {
                findViewById.setVisibility(((Integer) this.f1580e.m2467a()).intValue());
            }
        }
    }

    public synchronized boolean isChecked() {
        return this.f1582g;
    }

    public synchronized void setChecked(boolean z) {
        this.f1582g = z;
        if (this.f1576a != null) {
            this.f1576a.setBackgroundColor(this.f1576a.getContext().getResources().getColor(this.f1582g ? R.color.Orange : R.color.WhiteSmoke));
        }
        if (this.f1577b != null) {
            this.f1577b.setChecked(z);
        }
    }

    public synchronized void toggle() {
        setChecked(!this.f1582g);
    }

    public synchronized boolean onLongClick(View view) {
        if (!this.f1583h) {
            if (this.f1587l != null) {
                this.f1587l.mo357a(true);
            }
            setChecked(true);
        }
        return true;
    }

    public synchronized void onClick(View view) {
        if (this.f1583h) {
            setChecked(!this.f1582g);
        }
    }

    public synchronized void m2557a(boolean z) {
        int i = 0;
        synchronized (this) {
            if (this.f1583h && !z) {
                setChecked(false);
            }
            this.f1583h = z;
            if (this.f1576a != null) {
                this.f1576a.setHapticFeedbackEnabled(z);
                this.f1576a.setSoundEffectsEnabled(z);
            }
            if (z) {
                setChecked(this.f1582g);
            }
            if (this.f1577b != null) {
                CheckBox checkBox = this.f1577b;
                if (!z) {
                    i = 8;
                }
                checkBox.setVisibility(i);
            }
        }
    }

    public void m2556a(C0379d c0379d) {
        this.f1587l = c0379d;
    }
}
