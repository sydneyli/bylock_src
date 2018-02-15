package net.client.by.lock.gui.p018b;

import android.app.Dialog;
import android.content.Context;
import android.media.AudioRecord;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import net.client.by.lock.R;

/* compiled from: MyApp */
public class C0440x extends Dialog {
    private TextView f1921a = ((TextView) findViewById(R.id.textView3));
    private TextView f1922b = ((TextView) findViewById(R.id.textView2));
    private aa f1923c;
    private ProgressBar f1924d = ((ProgressBar) findViewById(R.id.progressBar1));
    private AudioRecord f1925e;
    private Button f1926f = ((Button) findViewById(R.id.button1));
    private Button f1927g = ((Button) findViewById(R.id.button2));

    public C0440x(Context context) {
        super(context);
        setContentView(R.layout.find_frequency_dialog);
        setTitle(R.string.fr_title);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.f1926f.setOnClickListener(new C0441y(this));
        this.f1927g.setOnClickListener(new C0442z(this));
        this.f1923c = new aa();
        this.f1923c.execute(new Void[0]);
    }
}
