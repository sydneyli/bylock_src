package group.pals.android.lib.ui.filechooser.utils.p010a;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

/* compiled from: MyApp */
public abstract class C0229e extends AsyncTask {
    public static final String f1122f = C0229e.class.getName();
    private final ProgressDialog f1123a;
    private int f1124b;
    private boolean f1125c;
    private Throwable f1126d;

    public C0229e(Context context, String str, boolean z) {
        this.f1124b = 500;
        this.f1125c = false;
        this.f1123a = new ProgressDialog(context);
        this.f1123a.setMessage(str);
        this.f1123a.setIndeterminate(true);
        this.f1123a.setCancelable(z);
        if (z) {
            this.f1123a.setCanceledOnTouchOutside(true);
            this.f1123a.setOnCancelListener(new C0264f(this));
        }
    }

    public C0229e(Context context, int i, boolean z) {
        this(context, context.getString(i), z);
    }

    protected void onPreExecute() {
        new Handler().postDelayed(new C0265g(this), (long) m1805b());
    }

    protected void onPostExecute(Object obj) {
        m1801a();
    }

    protected void onCancelled() {
        m1801a();
        super.onCancelled();
    }

    private void m1801a() {
        this.f1125c = true;
        try {
            this.f1123a.dismiss();
        } catch (Throwable th) {
            Log.e(f1122f, "doFinish() - dismiss dialog: " + th);
        }
    }

    public int m1805b() {
        return this.f1124b;
    }

    protected void m1804a(Throwable th) {
        this.f1126d = th;
    }
}
