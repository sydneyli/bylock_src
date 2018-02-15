package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: MyApp */
public abstract class C0115p extends C0101a {
    private int f436j;
    private int f437k;
    private LayoutInflater f438l;

    public C0115p(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f437k = i;
        this.f436j = i;
        this.f438l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View mo143a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f438l.inflate(this.f436j, viewGroup, false);
    }

    public View mo144b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f438l.inflate(this.f437k, viewGroup, false);
    }
}
