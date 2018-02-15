package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

/* compiled from: MyApp */
public abstract class C0101a extends BaseAdapter implements C0100f, Filterable {
    protected boolean f389a;
    protected boolean f390b;
    protected Cursor f391c;
    protected Context f392d;
    protected int f393e;
    protected C0103c f394f;
    protected DataSetObserver f395g;
    protected C0105e f396h;
    protected FilterQueryProvider f397i;

    public abstract View mo143a(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract void mo274a(View view, Context context, Cursor cursor);

    public C0101a(Context context, Cursor cursor, boolean z) {
        m828a(context, cursor, z ? 1 : 2);
    }

    void m828a(Context context, Cursor cursor, int i) {
        boolean z = true;
        if ((i & 1) == 1) {
            i |= 2;
            this.f390b = true;
        } else {
            this.f390b = false;
        }
        if (cursor == null) {
            z = false;
        }
        this.f391c = cursor;
        this.f389a = z;
        this.f392d = context;
        this.f393e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f394f = new C0103c(this);
            this.f395g = new C0104d();
        } else {
            this.f394f = null;
            this.f395g = null;
        }
        if (z) {
            if (this.f394f != null) {
                cursor.registerContentObserver(this.f394f);
            }
            if (this.f395g != null) {
                cursor.registerDataSetObserver(this.f395g);
            }
        }
    }

    public Cursor mo120a() {
        return this.f391c;
    }

    public int getCount() {
        if (!this.f389a || this.f391c == null) {
            return 0;
        }
        return this.f391c.getCount();
    }

    public Object getItem(int i) {
        if (!this.f389a || this.f391c == null) {
            return null;
        }
        this.f391c.moveToPosition(i);
        return this.f391c;
    }

    public long getItemId(int i) {
        if (this.f389a && this.f391c != null && this.f391c.moveToPosition(i)) {
            return this.f391c.getLong(this.f393e);
        }
        return 0;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f389a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f391c.moveToPosition(i)) {
            if (view == null) {
                view = mo143a(this.f392d, this.f391c, viewGroup);
            }
            mo274a(view, this.f392d, this.f391c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f389a) {
            return null;
        }
        this.f391c.moveToPosition(i);
        if (view == null) {
            view = mo144b(this.f392d, this.f391c, viewGroup);
        }
        mo274a(view, this.f392d, this.f391c);
        return view;
    }

    public View mo144b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return mo143a(context, cursor, viewGroup);
    }

    public void mo122a(Cursor cursor) {
        Cursor b = m831b(cursor);
        if (b != null) {
            b.close();
        }
    }

    public Cursor m831b(Cursor cursor) {
        if (cursor == this.f391c) {
            return null;
        }
        Cursor cursor2 = this.f391c;
        if (cursor2 != null) {
            if (this.f394f != null) {
                cursor2.unregisterContentObserver(this.f394f);
            }
            if (this.f395g != null) {
                cursor2.unregisterDataSetObserver(this.f395g);
            }
        }
        this.f391c = cursor;
        if (cursor != null) {
            if (this.f394f != null) {
                cursor.registerContentObserver(this.f394f);
            }
            if (this.f395g != null) {
                cursor.registerDataSetObserver(this.f395g);
            }
            this.f393e = cursor.getColumnIndexOrThrow("_id");
            this.f389a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.f393e = -1;
        this.f389a = false;
        notifyDataSetInvalidated();
        return cursor2;
    }

    public CharSequence mo123c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor mo121a(CharSequence charSequence) {
        if (this.f397i != null) {
            return this.f397i.runQuery(charSequence);
        }
        return this.f391c;
    }

    public Filter getFilter() {
        if (this.f396h == null) {
            this.f396h = new C0105e(this);
        }
        return this.f396h;
    }

    protected void m833b() {
        if (this.f390b && this.f391c != null && !this.f391c.isClosed()) {
            this.f389a = this.f391c.requery();
        }
    }
}
