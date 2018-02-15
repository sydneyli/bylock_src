package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.widget.C0115p;
import android.support.v7.p008b.C0149c;
import android.support.v7.p008b.C0154h;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: MyApp */
class C0220e extends C0115p implements OnClickListener {
    private SearchManager f1016j = ((SearchManager) this.d.getSystemService("search"));
    private SearchView f1017k;
    private SearchableInfo f1018l;
    private Context f1019m;
    private WeakHashMap f1020n;
    private boolean f1021o = false;
    private int f1022p = 1;
    private ColorStateList f1023q;
    private int f1024r = -1;
    private int f1025s = -1;
    private int f1026t = -1;
    private int f1027u = -1;
    private int f1028v = -1;
    private int f1029w = -1;

    public C0220e(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context, C0154h.abc_search_dropdown_item_icons_2line, null, true);
        this.f1017k = searchView;
        this.f1018l = searchableInfo;
        this.f1019m = context;
        this.f1020n = weakHashMap;
    }

    public void m1653a(int i) {
        this.f1022p = i;
    }

    public boolean hasStableIds() {
        return false;
    }

    public Cursor mo121a(CharSequence charSequence) {
        String obj = charSequence == null ? "" : charSequence.toString();
        if (this.f1017k.getVisibility() != 0 || this.f1017k.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor a = m1649a(this.f1018l, obj, 50);
            if (a != null) {
                a.getCount();
                return a;
            }
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m1645d(mo120a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m1645d(mo120a());
    }

    private void m1645d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null && !extras.getBoolean("in_progress")) {
        }
    }

    public void mo122a(Cursor cursor) {
        if (this.f1021o) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.mo122a(cursor);
            if (cursor != null) {
                this.f1024r = cursor.getColumnIndex("suggest_text_1");
                this.f1025s = cursor.getColumnIndex("suggest_text_2");
                this.f1026t = cursor.getColumnIndex("suggest_text_2_url");
                this.f1027u = cursor.getColumnIndex("suggest_icon_1");
                this.f1028v = cursor.getColumnIndex("suggest_icon_2");
                this.f1029w = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Throwable e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public View mo143a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View a = super.mo143a(context, cursor, viewGroup);
        a.setTag(new C0221f(a));
        return a;
    }

    public void mo274a(View view, Context context, Cursor cursor) {
        C0221f c0221f = (C0221f) view.getTag();
        int i;
        if (this.f1029w != -1) {
            i = cursor.getInt(this.f1029w);
        } else {
            i = 0;
        }
        if (c0221f.f1030a != null) {
            m1639a(c0221f.f1030a, C0220e.m1636a(cursor, this.f1024r));
        }
        if (c0221f.f1031b != null) {
            CharSequence a = C0220e.m1636a(cursor, this.f1026t);
            if (a != null) {
                a = m1644b(a);
            } else {
                a = C0220e.m1636a(cursor, this.f1025s);
            }
            if (TextUtils.isEmpty(a)) {
                if (c0221f.f1030a != null) {
                    c0221f.f1030a.setSingleLine(false);
                    c0221f.f1030a.setMaxLines(2);
                }
            } else if (c0221f.f1030a != null) {
                c0221f.f1030a.setSingleLine(true);
                c0221f.f1030a.setMaxLines(1);
            }
            m1639a(c0221f.f1031b, a);
        }
        if (c0221f.f1032c != null) {
            m1638a(c0221f.f1032c, m1646e(cursor), 4);
        }
        if (c0221f.f1033d != null) {
            m1638a(c0221f.f1033d, m1647f(cursor), 8);
        }
        if (this.f1022p == 2 || (this.f1022p == 1 && (r1 & 1) != 0)) {
            c0221f.f1034e.setVisibility(0);
            c0221f.f1034e.setTag(c0221f.f1030a.getText());
            c0221f.f1034e.setOnClickListener(this);
            return;
        }
        c0221f.f1034e.setVisibility(8);
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1017k.m1626a((CharSequence) tag);
        }
    }

    private CharSequence m1644b(CharSequence charSequence) {
        if (this.f1023q == null) {
            TypedValue typedValue = new TypedValue();
            this.d.getTheme().resolveAttribute(C0149c.textColorSearchUrl, typedValue, true);
            this.f1023q = this.d.getResources().getColorStateList(typedValue.resourceId);
        }
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f1023q, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private void m1639a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private Drawable m1646e(Cursor cursor) {
        if (this.f1027u == -1) {
            return null;
        }
        Drawable a = m1635a(cursor.getString(this.f1027u));
        return a == null ? m1648g(cursor) : a;
    }

    private Drawable m1647f(Cursor cursor) {
        if (this.f1028v == -1) {
            return null;
        }
        return m1635a(cursor.getString(this.f1028v));
    }

    private void m1638a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public CharSequence mo123c(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String a = C0220e.m1637a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.f1018l.shouldRewriteQueryFromData()) {
            a = C0220e.m1637a(cursor, "suggest_intent_data");
            if (a != null) {
                return a;
            }
        }
        if (!this.f1018l.shouldRewriteQueryFromText()) {
            return null;
        }
        a = C0220e.m1637a(cursor, "suggest_text_1");
        if (a != null) {
            return a;
        }
        return null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View a = mo143a(this.d, this.c, viewGroup);
            if (a != null) {
                ((C0221f) a.getTag()).f1030a.setText(e.toString());
            }
            return a;
        }
    }

    private Drawable m1635a(String str) {
        if (str == null || str.length() == 0 || "0".equals(str)) {
            return null;
        }
        Drawable b;
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1019m.getPackageName() + "/" + parseInt;
            b = m1643b(str2);
            if (b != null) {
                return b;
            }
            b = this.f1019m.getResources().getDrawable(parseInt);
            m1640a(str2, b);
            return b;
        } catch (NumberFormatException e) {
            b = m1643b(str);
            if (b != null) {
                return b;
            }
            b = m1642b(Uri.parse(str));
            m1640a(str, b);
            return b;
        } catch (NotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    private Drawable m1642b(Uri uri) {
        InputStream openInputStream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return m1651a(uri);
            }
            openInputStream = this.f1019m.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                return createFromStream;
            }
        } catch (NotFoundException e2) {
            throw new FileNotFoundException("Resource does not exist: " + uri);
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        } catch (Throwable th) {
            try {
                openInputStream.close();
            } catch (Throwable e4) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e4);
            }
        }
    }

    private Drawable m1643b(String str) {
        ConstantState constantState = (ConstantState) this.f1020n.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void m1640a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1020n.put(str, drawable.getConstantState());
        }
    }

    private Drawable m1648g(Cursor cursor) {
        Drawable a = m1634a(this.f1018l.getSearchActivity());
        return a != null ? a : this.d.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable m1634a(ComponentName componentName) {
        Object obj = null;
        String flattenToShortString = componentName.flattenToShortString();
        if (this.f1020n.containsKey(flattenToShortString)) {
            ConstantState constantState = (ConstantState) this.f1020n.get(flattenToShortString);
            return constantState == null ? null : constantState.newDrawable(this.f1019m.getResources());
        } else {
            Drawable b = m1641b(componentName);
            if (b != null) {
                obj = b.getConstantState();
            }
            this.f1020n.put(flattenToShortString, obj);
            return b;
        }
    }

    private Drawable m1641b(ComponentName componentName) {
        PackageManager packageManager = this.d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    public static String m1637a(Cursor cursor, String str) {
        return C0220e.m1636a(cursor, cursor.getColumnIndex(str));
    }

    private static String m1636a(Cursor cursor, int i) {
        String str = null;
        if (i != -1) {
            try {
                str = cursor.getString(i);
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            }
        }
        return str;
    }

    Drawable m1651a(Uri uri) {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.d.getPackageManager().getResourcesForApplication(authority);
            List pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    size = Integer.parseInt((String) pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                size = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (size != 0) {
                return resourcesForApplication.getDrawable(size);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    Cursor m1649a(SearchableInfo searchableInfo, String str, int i) {
        if (searchableInfo == null) {
            return null;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        String[] strArr;
        Builder fragment = new Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
            strArr = null;
        }
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }
}
