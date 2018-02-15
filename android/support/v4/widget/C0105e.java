package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* compiled from: MyApp */
class C0105e extends Filter {
    C0100f f425a;

    C0105e(C0100f c0100f) {
        this.f425a = c0100f;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f425a.mo123c((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        Cursor a = this.f425a.mo121a(charSequence);
        FilterResults filterResults = new FilterResults();
        if (a != null) {
            filterResults.count = a.getCount();
            filterResults.values = a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor a = this.f425a.mo120a();
        if (filterResults.values != null && filterResults.values != a) {
            this.f425a.mo122a((Cursor) filterResults.values);
        }
    }
}
