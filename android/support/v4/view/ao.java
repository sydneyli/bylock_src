package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: MyApp */
public abstract class ao {
    private DataSetObservable f233a = new DataSetObservable();

    public abstract boolean mo22a(View view, Object obj);

    public abstract int mo346b();

    public void mo20a(ViewGroup viewGroup) {
        m279a((View) viewGroup);
    }

    public Object mo18a(ViewGroup viewGroup, int i) {
        return m275a((View) viewGroup, i);
    }

    public void mo21a(ViewGroup viewGroup, int i, Object obj) {
        m280a((View) viewGroup, i, obj);
    }

    public void mo24b(ViewGroup viewGroup, int i, Object obj) {
        m287b((View) viewGroup, i, obj);
    }

    public void mo23b(ViewGroup viewGroup) {
        m286b((View) viewGroup);
    }

    public void m279a(View view) {
    }

    public Object m275a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public void m280a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void m287b(View view, int i, Object obj) {
    }

    public void m286b(View view) {
    }

    public Parcelable mo17a() {
        return null;
    }

    public void mo19a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public int m273a(Object obj) {
        return -1;
    }

    public void m277a(DataSetObserver dataSetObserver) {
        this.f233a.registerObserver(dataSetObserver);
    }

    public void m285b(DataSetObserver dataSetObserver) {
        this.f233a.unregisterObserver(dataSetObserver);
    }

    public float m290c(int i) {
        return 1.0f;
    }
}
