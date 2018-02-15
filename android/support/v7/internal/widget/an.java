package android.support.v7.internal.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

/* compiled from: MyApp */
class an implements ListAdapter, SpinnerAdapter {
    private SpinnerAdapter f920a;
    private ListAdapter f921b;

    public an(SpinnerAdapter spinnerAdapter) {
        this.f920a = spinnerAdapter;
        if (spinnerAdapter instanceof ListAdapter) {
            this.f921b = (ListAdapter) spinnerAdapter;
        }
    }

    public int getCount() {
        return this.f920a == null ? 0 : this.f920a.getCount();
    }

    public Object getItem(int i) {
        return this.f920a == null ? null : this.f920a.getItem(i);
    }

    public long getItemId(int i) {
        return this.f920a == null ? -1 : this.f920a.getItemId(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return getDropDownView(i, view, viewGroup);
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return this.f920a == null ? null : this.f920a.getDropDownView(i, view, viewGroup);
    }

    public boolean hasStableIds() {
        return this.f920a != null && this.f920a.hasStableIds();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f920a != null) {
            this.f920a.registerDataSetObserver(dataSetObserver);
        }
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f920a != null) {
            this.f920a.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f921b;
        if (listAdapter != null) {
            return listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    public boolean isEnabled(int i) {
        ListAdapter listAdapter = this.f921b;
        if (listAdapter != null) {
            return listAdapter.isEnabled(i);
        }
        return true;
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public boolean isEmpty() {
        return getCount() == 0;
    }
}
