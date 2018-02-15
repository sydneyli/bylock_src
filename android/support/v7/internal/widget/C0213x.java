package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.p008b.C0149c;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ListAdapter;
import android.widget.ListView;

/* compiled from: MyApp */
class C0213x extends ListView {
    private boolean f973a;
    private boolean f974b;

    public C0213x(Context context, boolean z) {
        super(context, null, C0149c.dropDownListViewStyle);
        this.f974b = z;
        setCacheColorHint(0);
    }

    public boolean isInTouchMode() {
        return (this.f974b && this.f973a) || super.isInTouchMode();
    }

    public boolean hasWindowFocus() {
        return this.f974b || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.f974b || super.isFocused();
    }

    public boolean hasFocus() {
        return this.f974b || super.hasFocus();
    }

    final int m1608a(int i, int i2, int i3, int i4, int i5) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        listPaddingBottom += listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int i6 = 0;
        View view = null;
        int i7 = 0;
        int count = adapter.getCount();
        int i8 = 0;
        while (i8 < count) {
            View view2;
            listPaddingTop = adapter.getItemViewType(i8);
            if (listPaddingTop != i7) {
                int i9 = listPaddingTop;
                view2 = null;
                i7 = i9;
            } else {
                view2 = view;
            }
            view = adapter.getView(i8, view2, this);
            listPaddingTop = view.getLayoutParams().height;
            if (listPaddingTop > 0) {
                listPaddingTop = MeasureSpec.makeMeasureSpec(listPaddingTop, 1073741824);
            } else {
                listPaddingTop = MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, listPaddingTop);
            if (i8 > 0) {
                listPaddingTop = listPaddingBottom + dividerHeight;
            } else {
                listPaddingTop = listPaddingBottom;
            }
            listPaddingTop += view.getMeasuredHeight();
            if (listPaddingTop < i4) {
                if (i5 >= 0 && i8 >= i5) {
                    i6 = listPaddingTop;
                }
                i8++;
                listPaddingBottom = listPaddingTop;
            } else if (i5 < 0 || i8 <= i5 || i6 <= 0 || listPaddingTop == i4) {
                return i4;
            } else {
                return i6;
            }
        }
        return listPaddingBottom;
    }
}
