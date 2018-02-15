package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

/* compiled from: MyApp */
public class ProgressBarICS extends View {
    private static final int[] f860f = new int[]{16843062, 16843063, 16843064, 16843065, 16843066, 16843067, 16843068, 16843069, 16843070, 16843071, 16843039, 16843072, 16843040, 16843073};
    int f861a;
    int f862b;
    int f863c;
    int f864d;
    Bitmap f865e;
    private int f866g;
    private int f867h;
    private int f868i;
    private int f869j;
    private int f870k;
    private boolean f871l;
    private boolean f872m;
    private Transformation f873n;
    private AlphaAnimation f874o;
    private Drawable f875p;
    private Drawable f876q;
    private Drawable f877r;
    private boolean f878s;
    private Interpolator f879t;
    private af f880u;
    private long f881v = Thread.currentThread().getId();
    private boolean f882w;
    private long f883x;
    private boolean f884y;

    /* compiled from: MyApp */
    class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new ag();
        int f858a;
        int f859b;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f858a = parcel.readInt();
            this.f859b = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f858a);
            parcel.writeInt(this.f859b);
        }
    }

    public ProgressBarICS(Context context, AttributeSet attributeSet, int i, int i2) {
        boolean z = false;
        super(context, attributeSet, i);
        m1516c();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f860f, i, i2);
        this.f878s = true;
        setMax(obtainStyledAttributes.getInt(0, this.f868i));
        setProgress(obtainStyledAttributes.getInt(1, this.f866g));
        setSecondaryProgress(obtainStyledAttributes.getInt(2, this.f867h));
        boolean z2 = obtainStyledAttributes.getBoolean(3, this.f871l);
        this.f872m = obtainStyledAttributes.getBoolean(4, this.f872m);
        Drawable drawable = obtainStyledAttributes.getDrawable(5);
        if (drawable != null) {
            setIndeterminateDrawable(m1509a(drawable));
        }
        drawable = obtainStyledAttributes.getDrawable(6);
        if (drawable != null) {
            setProgressDrawable(m1510a(drawable, false));
        }
        this.f870k = obtainStyledAttributes.getInt(7, this.f870k);
        this.f869j = obtainStyledAttributes.getInt(8, this.f869j);
        this.f861a = obtainStyledAttributes.getDimensionPixelSize(9, this.f861a);
        this.f862b = obtainStyledAttributes.getDimensionPixelSize(10, this.f862b);
        this.f863c = obtainStyledAttributes.getDimensionPixelSize(11, this.f863c);
        this.f864d = obtainStyledAttributes.getDimensionPixelSize(12, this.f864d);
        int resourceId = obtainStyledAttributes.getResourceId(13, 17432587);
        if (resourceId > 0) {
            m1520a(context, resourceId);
        }
        obtainStyledAttributes.recycle();
        this.f878s = false;
        if (this.f872m || z2) {
            z = true;
        }
        setIndeterminate(z);
    }

    private Drawable m1510a(Drawable drawable, boolean z) {
        int i = 0;
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                boolean z2;
                int id = layerDrawable.getId(i2);
                Drawable drawable2 = layerDrawable.getDrawable(i2);
                if (id == 16908301 || id == 16908303) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                drawableArr[i2] = m1510a(drawable2, z2);
            }
            Drawable layerDrawable2 = new LayerDrawable(drawableArr);
            while (i < numberOfLayers) {
                layerDrawable2.setId(i, layerDrawable.getId(i));
                i++;
            }
            return layerDrawable2;
        } else if (!(drawable instanceof BitmapDrawable)) {
            return drawable;
        } else {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (this.f865e == null) {
                this.f865e = bitmap;
            }
            Drawable shapeDrawable = new ShapeDrawable(getDrawableShape());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, TileMode.REPEAT, TileMode.CLAMP));
            if (z) {
                return new ClipDrawable(shapeDrawable, 3, 1);
            }
            return shapeDrawable;
        }
    }

    Shape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    private Drawable m1509a(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        Drawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable a = m1510a(animationDrawable.getFrame(i), true);
            a.setLevel(10000);
            animationDrawable2.addFrame(a, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    private void m1516c() {
        this.f868i = 100;
        this.f866g = 0;
        this.f867h = 0;
        this.f871l = false;
        this.f872m = false;
        this.f870k = 4000;
        this.f869j = 1;
        this.f861a = 24;
        this.f862b = 48;
        this.f863c = 24;
        this.f864d = 48;
    }

    public synchronized void setIndeterminate(boolean z) {
        if (!((this.f872m && this.f871l) || z == this.f871l)) {
            this.f871l = z;
            if (z) {
                this.f877r = this.f875p;
                m1518a();
            } else {
                this.f877r = this.f876q;
                m1521b();
            }
        }
    }

    public Drawable getIndeterminateDrawable() {
        return this.f875p;
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.f875p = drawable;
        if (this.f871l) {
            this.f877r = drawable;
            postInvalidate();
        }
    }

    public Drawable getProgressDrawable() {
        return this.f876q;
    }

    public void setProgressDrawable(Drawable drawable) {
        boolean z;
        if (this.f876q == null || drawable == this.f876q) {
            z = false;
        } else {
            this.f876q.setCallback(null);
            z = true;
        }
        if (drawable != null) {
            drawable.setCallback(this);
            int minimumHeight = drawable.getMinimumHeight();
            if (this.f864d < minimumHeight) {
                this.f864d = minimumHeight;
                requestLayout();
            }
        }
        this.f876q = drawable;
        if (!this.f871l) {
            this.f877r = drawable;
            postInvalidate();
        }
        if (z) {
            m1512a(getWidth(), getHeight());
            m1517d();
            m1514a(16908301, this.f866g, false, false);
            m1514a(16908303, this.f867h, false, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f876q || drawable == this.f875p || super.verifyDrawable(drawable);
    }

    public void postInvalidate() {
        if (!this.f878s) {
            super.postInvalidate();
        }
    }

    private synchronized void m1514a(int i, int i2, boolean z, boolean z2) {
        float f;
        if (this.f868i > 0) {
            f = ((float) i2) / ((float) this.f868i);
        } else {
            f = 0.0f;
        }
        Drawable drawable = this.f877r;
        if (drawable != null) {
            Drawable drawable2 = null;
            if (drawable instanceof LayerDrawable) {
                drawable2 = ((LayerDrawable) drawable).findDrawableByLayerId(i);
            }
            int i3 = (int) (f * 10000.0f);
            if (drawable2 != null) {
                drawable = drawable2;
            }
            drawable.setLevel(i3);
        } else {
            invalidate();
        }
    }

    private synchronized void m1513a(int i, int i2, boolean z) {
        if (this.f881v == Thread.currentThread().getId()) {
            m1514a(i, i2, z, true);
        } else {
            Runnable runnable;
            if (this.f880u != null) {
                runnable = this.f880u;
                this.f880u = null;
                runnable.m1535a(i, i2, z);
            } else {
                runnable = new af(this, i, i2, z);
            }
            post(runnable);
        }
    }

    public synchronized void setProgress(int i) {
        m1519a(i, false);
    }

    synchronized void m1519a(int i, boolean z) {
        if (!this.f871l) {
            int i2;
            if (i < 0) {
                i2 = 0;
            } else {
                i2 = i;
            }
            if (i2 > this.f868i) {
                i2 = this.f868i;
            }
            if (i2 != this.f866g) {
                this.f866g = i2;
                m1513a(16908301, this.f866g, z);
            }
        }
    }

    public synchronized void setSecondaryProgress(int i) {
        int i2 = 0;
        synchronized (this) {
            if (!this.f871l) {
                if (i >= 0) {
                    i2 = i;
                }
                if (i2 > this.f868i) {
                    i2 = this.f868i;
                }
                if (i2 != this.f867h) {
                    this.f867h = i2;
                    m1513a(16908303, this.f867h, false);
                }
            }
        }
    }

    public synchronized int getProgress() {
        return this.f871l ? 0 : this.f866g;
    }

    public synchronized int getSecondaryProgress() {
        return this.f871l ? 0 : this.f867h;
    }

    public synchronized int getMax() {
        return this.f868i;
    }

    public synchronized void setMax(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i != this.f868i) {
            this.f868i = i;
            postInvalidate();
            if (this.f866g > i) {
                this.f866g = i;
            }
            m1513a(16908301, this.f866g, false);
        }
    }

    void m1518a() {
        if (getVisibility() == 0) {
            if (this.f875p instanceof Animatable) {
                this.f882w = true;
                this.f874o = null;
            } else {
                if (this.f879t == null) {
                    this.f879t = new LinearInterpolator();
                }
                this.f873n = new Transformation();
                this.f874o = new AlphaAnimation(0.0f, 1.0f);
                this.f874o.setRepeatMode(this.f869j);
                this.f874o.setRepeatCount(-1);
                this.f874o.setDuration((long) this.f870k);
                this.f874o.setInterpolator(this.f879t);
                this.f874o.setStartTime(-1);
            }
            postInvalidate();
        }
    }

    void m1521b() {
        this.f874o = null;
        this.f873n = null;
        if (this.f875p instanceof Animatable) {
            ((Animatable) this.f875p).stop();
            this.f882w = false;
        }
        postInvalidate();
    }

    public void m1520a(Context context, int i) {
        setInterpolator(AnimationUtils.loadInterpolator(context, i));
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f879t = interpolator;
    }

    public Interpolator getInterpolator() {
        return this.f879t;
    }

    public void setVisibility(int i) {
        if (getVisibility() != i) {
            super.setVisibility(i);
            if (!this.f871l) {
                return;
            }
            if (i == 8 || i == 4) {
                m1521b();
            } else {
                m1518a();
            }
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (!this.f871l) {
            return;
        }
        if (i == 8 || i == 4) {
            m1521b();
        } else {
            m1518a();
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        if (!this.f884y) {
            if (verifyDrawable(drawable)) {
                Rect bounds = drawable.getBounds();
                int scrollX = getScrollX() + getPaddingLeft();
                int scrollY = getScrollY() + getPaddingTop();
                invalidate(bounds.left + scrollX, bounds.top + scrollY, scrollX + bounds.right, bounds.bottom + scrollY);
                return;
            }
            super.invalidateDrawable(drawable);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        m1512a(i, i2);
    }

    private void m1512a(int i, int i2) {
        int i3;
        int paddingRight = (i - getPaddingRight()) - getPaddingLeft();
        int paddingBottom = (i2 - getPaddingBottom()) - getPaddingTop();
        if (this.f875p != null) {
            int i4;
            if (this.f872m && !(this.f875p instanceof AnimationDrawable)) {
                float intrinsicWidth = ((float) this.f875p.getIntrinsicWidth()) / ((float) this.f875p.getIntrinsicHeight());
                float f = ((float) i) / ((float) i2);
                if (intrinsicWidth != f) {
                    if (f > intrinsicWidth) {
                        paddingRight = (int) (intrinsicWidth * ((float) i2));
                        i4 = (i - paddingRight) / 2;
                        i3 = paddingRight + i4;
                        paddingRight = paddingBottom;
                        paddingBottom = 0;
                    } else {
                        paddingBottom = (int) ((1.0f / intrinsicWidth) * ((float) i));
                        i4 = (i2 - paddingBottom) / 2;
                        i3 = paddingRight;
                        paddingRight = paddingBottom + i4;
                        paddingBottom = i4;
                        i4 = 0;
                    }
                    this.f875p.setBounds(i4, paddingBottom, i3, paddingRight);
                }
            }
            i4 = 0;
            i3 = paddingRight;
            paddingRight = paddingBottom;
            paddingBottom = 0;
            this.f875p.setBounds(i4, paddingBottom, i3, paddingRight);
        } else {
            i3 = paddingRight;
            paddingRight = paddingBottom;
        }
        if (this.f876q != null) {
            this.f876q.setBounds(0, 0, i3, paddingRight);
        }
    }

    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.f877r;
        if (drawable != null) {
            canvas.save();
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            long drawingTime = getDrawingTime();
            if (this.f874o != null) {
                this.f874o.getTransformation(drawingTime, this.f873n);
                float alpha = this.f873n.getAlpha();
                try {
                    this.f884y = true;
                    drawable.setLevel((int) (alpha * 10000.0f));
                    this.f884y = false;
                    if (SystemClock.uptimeMillis() - this.f883x >= 200) {
                        this.f883x = SystemClock.uptimeMillis();
                        postInvalidateDelayed(200);
                    }
                } catch (Throwable th) {
                    this.f884y = false;
                }
            }
            drawable.draw(canvas);
            canvas.restore();
            if (this.f882w && (drawable instanceof Animatable)) {
                ((Animatable) drawable).start();
                this.f882w = false;
            }
        }
    }

    protected synchronized void onMeasure(int i, int i2) {
        int i3 = 0;
        synchronized (this) {
            int max;
            Drawable drawable = this.f877r;
            if (drawable != null) {
                max = Math.max(this.f861a, Math.min(this.f862b, drawable.getIntrinsicWidth()));
                i3 = Math.max(this.f863c, Math.min(this.f864d, drawable.getIntrinsicHeight()));
            } else {
                max = 0;
            }
            m1517d();
            setMeasuredDimension(resolveSize(max + (getPaddingLeft() + getPaddingRight()), i), resolveSize(i3 + (getPaddingTop() + getPaddingBottom()), i2));
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m1517d();
    }

    private void m1517d() {
        int[] drawableState = getDrawableState();
        if (this.f876q != null && this.f876q.isStateful()) {
            this.f876q.setState(drawableState);
        }
        if (this.f875p != null && this.f875p.isStateful()) {
            this.f875p.setState(drawableState);
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f858a = this.f866g;
        savedState.f859b = this.f867h;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.f858a);
        setSecondaryProgress(savedState.f859b);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f871l) {
            m1518a();
        }
    }

    protected void onDetachedFromWindow() {
        if (this.f871l) {
            m1521b();
        }
        if (this.f880u != null) {
            removeCallbacks(this.f880u);
        }
        super.onDetachedFromWindow();
    }
}
