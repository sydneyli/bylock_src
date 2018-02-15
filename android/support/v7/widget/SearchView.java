package android.support.v7.widget;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.C0101a;
import android.support.v7.p007c.C0158c;
import android.support.v7.p008b.C0149c;
import android.support.v7.p008b.C0151e;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.WeakHashMap;

/* compiled from: MyApp */
public class SearchView extends LinearLayout implements C0158c {
    static final C0216a f979a = new C0216a();
    private Bundle f980A;
    private Runnable f981B;
    private Runnable f982C;
    private Runnable f983D;
    private final Intent f984E;
    private final Intent f985F;
    private final WeakHashMap f986G;
    private C0218c f987b;
    private C0217b f988c;
    private OnFocusChangeListener f989d;
    private C0219d f990e;
    private OnClickListener f991f;
    private boolean f992g;
    private boolean f993h;
    private C0101a f994i;
    private View f995j;
    private View f996k;
    private View f997l;
    private ImageView f998m;
    private View f999n;
    private View f1000o;
    private SearchAutoComplete f1001p;
    private ImageView f1002q;
    private boolean f1003r;
    private CharSequence f1004s;
    private boolean f1005t;
    private boolean f1006u;
    private int f1007v;
    private boolean f1008w;
    private boolean f1009x;
    private int f1010y;
    private SearchableInfo f1011z;

    /* compiled from: MyApp */
    public class SearchAutoComplete extends AutoCompleteTextView {
        private int f977a = getThreshold();
        private SearchView f978b;

        public SearchAutoComplete(Context context) {
            super(context);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        void setSearchView(SearchView searchView) {
            this.f978b = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f977a = i;
        }

        protected void replaceText(CharSequence charSequence) {
        }

        public void performCompletion() {
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f978b.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.m1611a(getContext())) {
                    SearchView.f979a.m1631a(this, true);
                }
            }
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f978b.m1629d();
        }

        public boolean enoughToFilter() {
            return this.f977a <= 0 || super.enoughToFilter();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f978b.clearFocus();
                        this.f978b.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1011z = searchableInfo;
        if (this.f1011z != null) {
            m1621k();
            m1620j();
        }
        this.f1008w = m1615e();
        if (this.f1008w) {
            this.f1001p.setPrivateImeOptions("nm");
        }
        m1610a(m1628c());
    }

    public void setAppSearchData(Bundle bundle) {
        this.f980A = bundle;
    }

    public void setImeOptions(int i) {
        this.f1001p.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.f1001p.getImeOptions();
    }

    public void setInputType(int i) {
        this.f1001p.setInputType(i);
    }

    public int getInputType() {
        return this.f1001p.getInputType();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.f1006u || !isFocusable()) {
            return false;
        }
        if (m1628c()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.f1001p.requestFocus(i, rect);
        if (requestFocus) {
            m1610a(false);
        }
        return requestFocus;
    }

    public void clearFocus() {
        this.f1006u = true;
        setImeVisibility(false);
        super.clearFocus();
        this.f1001p.clearFocus();
        this.f1006u = false;
    }

    public void setOnQueryTextListener(C0218c c0218c) {
        this.f987b = c0218c;
    }

    public void setOnCloseListener(C0217b c0217b) {
        this.f988c = c0217b;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f989d = onFocusChangeListener;
    }

    public void setOnSuggestionListener(C0219d c0219d) {
        this.f990e = c0219d;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.f991f = onClickListener;
    }

    public CharSequence getQuery() {
        return this.f1001p.getText();
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f1004s = charSequence;
        m1620j();
    }

    public CharSequence getQueryHint() {
        if (this.f1004s != null) {
            return this.f1004s;
        }
        if (this.f1011z == null) {
            return null;
        }
        int hintId = this.f1011z.getHintId();
        if (hintId != 0) {
            return getContext().getString(hintId);
        }
        return null;
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f992g != z) {
            this.f992g = z;
            m1610a(z);
            m1620j();
        }
    }

    public void setIconified(boolean z) {
        if (z) {
            m1622l();
        } else {
            m1623m();
        }
    }

    public boolean m1628c() {
        return this.f993h;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f1003r = z;
        m1610a(m1628c());
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f1005t = z;
        if (this.f994i instanceof C0220e) {
            ((C0220e) this.f994i).m1653a(z ? 2 : 1);
        }
    }

    public void setSuggestionsAdapter(C0101a c0101a) {
        this.f994i = c0101a;
        this.f1001p.setAdapter(this.f994i);
    }

    public C0101a getSuggestionsAdapter() {
        return this.f994i;
    }

    public void setMaxWidth(int i) {
        this.f1007v = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.f1007v;
    }

    protected void onMeasure(int i, int i2) {
        if (m1628c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.f1007v <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.f1007v, size);
                    break;
                }
            case 0:
                if (this.f1007v <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.f1007v;
                    break;
                }
            case 1073741824:
                if (this.f1007v > 0) {
                    size = Math.min(this.f1007v, size);
                    break;
                }
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0151e.abc_search_view_preferred_width);
    }

    private void m1610a(boolean z) {
        boolean z2;
        boolean z3 = true;
        int i = 8;
        this.f993h = z;
        int i2 = z ? 0 : 8;
        if (TextUtils.isEmpty(this.f1001p.getText())) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f995j.setVisibility(i2);
        m1613b(z2);
        View view = this.f999n;
        if (z) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        view.setVisibility(i2);
        ImageView imageView = this.f1002q;
        if (!this.f992g) {
            i = 0;
        }
        imageView.setVisibility(i);
        m1618h();
        if (z2) {
            z3 = false;
        }
        m1614c(z3);
        m1617g();
    }

    private boolean m1615e() {
        if (this.f1011z == null || !this.f1011z.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f1011z.getVoiceSearchLaunchWebSearch()) {
            intent = this.f984E;
        } else if (this.f1011z.getVoiceSearchLaunchRecognizer()) {
            intent = this.f985F;
        }
        if (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
            return false;
        }
        return true;
    }

    private boolean m1616f() {
        return (this.f1003r || this.f1008w) && !m1628c();
    }

    private void m1613b(boolean z) {
        int i = 8;
        if (this.f1003r && m1616f() && hasFocus() && (z || !this.f1008w)) {
            i = 0;
        }
        this.f996k.setVisibility(i);
    }

    private void m1617g() {
        int i = 8;
        if (m1616f() && (this.f996k.getVisibility() == 0 || this.f1000o.getVisibility() == 0)) {
            i = 0;
        }
        this.f997l.setVisibility(i);
    }

    private void m1618h() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.f1001p.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.f992g || this.f1009x)) {
            i = 0;
        }
        ImageView imageView = this.f998m;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        this.f998m.getDrawable().setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
    }

    private void m1619i() {
        post(this.f982C);
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.f982C);
        post(this.f983D);
        super.onDetachedFromWindow();
    }

    private void setImeVisibility(boolean z) {
        if (z) {
            post(this.f981B);
            return;
        }
        removeCallbacks(this.f981B);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    void m1626a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f1011z == null) {
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private int getSearchIconId() {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(C0149c.searchViewSearchIcon, typedValue, true);
        return typedValue.resourceId;
    }

    private CharSequence m1612b(CharSequence charSequence) {
        if (!this.f992g) {
            return charSequence;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.append(charSequence);
        Drawable drawable = getContext().getResources().getDrawable(getSearchIconId());
        int textSize = (int) (((double) this.f1001p.getTextSize()) * 1.25d);
        drawable.setBounds(0, 0, textSize, textSize);
        spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
        return spannableStringBuilder;
    }

    private void m1620j() {
        if (this.f1004s != null) {
            this.f1001p.setHint(m1612b(this.f1004s));
        } else if (this.f1011z != null) {
            CharSequence charSequence = null;
            int hintId = this.f1011z.getHintId();
            if (hintId != 0) {
                charSequence = getContext().getString(hintId);
            }
            if (charSequence != null) {
                this.f1001p.setHint(m1612b(charSequence));
            }
        } else {
            this.f1001p.setHint(m1612b((CharSequence) ""));
        }
    }

    private void m1621k() {
        int i = 1;
        this.f1001p.setThreshold(this.f1011z.getSuggestThreshold());
        this.f1001p.setImeOptions(this.f1011z.getImeOptions());
        int inputType = this.f1011z.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1011z.getSuggestAuthority() != null) {
                inputType = (inputType | 65536) | 524288;
            }
        }
        this.f1001p.setInputType(inputType);
        if (this.f994i != null) {
            this.f994i.mo122a(null);
        }
        if (this.f1011z.getSuggestAuthority() != null) {
            this.f994i = new C0220e(getContext(), this, this.f1011z, this.f986G);
            this.f1001p.setAdapter(this.f994i);
            C0220e c0220e = (C0220e) this.f994i;
            if (this.f1005t) {
                i = 2;
            }
            c0220e.m1653a(i);
        }
    }

    private void m1614c(boolean z) {
        int i;
        if (this.f1008w && !m1628c() && z) {
            i = 0;
            this.f996k.setVisibility(8);
        } else {
            i = 8;
        }
        this.f1000o.setVisibility(i);
    }

    private void m1622l() {
        if (!TextUtils.isEmpty(this.f1001p.getText())) {
            this.f1001p.setText("");
            this.f1001p.requestFocus();
            setImeVisibility(true);
        } else if (!this.f992g) {
        } else {
            if (this.f988c == null || !this.f988c.m1633a()) {
                clearFocus();
                m1610a(true);
            }
        }
    }

    private void m1623m() {
        m1610a(false);
        this.f1001p.requestFocus();
        setImeVisibility(true);
        if (this.f991f != null) {
            this.f991f.onClick(this);
        }
    }

    void m1629d() {
        m1610a(m1628c());
        m1619i();
        if (this.f1001p.hasFocus()) {
            m1624n();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m1619i();
    }

    public void mo273b() {
        clearFocus();
        m1610a(true);
        this.f1001p.setImeOptions(this.f1010y);
        this.f1009x = false;
    }

    public void mo272a() {
        if (!this.f1009x) {
            this.f1009x = true;
            this.f1010y = this.f1001p.getImeOptions();
            this.f1001p.setImeOptions(this.f1010y | 33554432);
            this.f1001p.setText("");
            setIconified(false);
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.f1001p.setText(charSequence);
        this.f1001p.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    private void m1624n() {
        f979a.m1630a(this.f1001p);
        f979a.m1632b(this.f1001p);
    }

    static boolean m1611a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
