package android.support.v4.p004d;

/* compiled from: MyApp */
public class C0050c {
    private static final Object f245a = new Object();
    private boolean f246b;
    private int[] f247c;
    private Object[] f248d;
    private int f249e;

    public C0050c() {
        this(10);
    }

    public C0050c(int i) {
        this.f246b = false;
        int d = C0050c.m320d(i);
        this.f247c = new int[d];
        this.f248d = new Object[d];
        this.f249e = 0;
    }

    private void m319c() {
        int i = this.f249e;
        int[] iArr = this.f247c;
        Object[] objArr = this.f248d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f245a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                }
                i2++;
            }
        }
        this.f246b = false;
        this.f249e = i2;
    }

    public int m321a() {
        if (this.f246b) {
            m319c();
        }
        return this.f249e;
    }

    public int m322a(int i) {
        if (this.f246b) {
            m319c();
        }
        return this.f247c[i];
    }

    public Object m323b(int i) {
        if (this.f246b) {
            m319c();
        }
        return this.f248d[i];
    }

    public void m324b() {
        int i = this.f249e;
        Object[] objArr = this.f248d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f249e = 0;
        this.f246b = false;
    }

    static int m318c(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    static int m320d(int i) {
        return C0050c.m318c(i * 4) / 4;
    }
}
