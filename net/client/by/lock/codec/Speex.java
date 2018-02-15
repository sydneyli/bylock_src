package net.client.by.lock.codec;

/* compiled from: MyApp */
public class Speex {
    public native int decode(byte[] bArr, int i, int i2, short[] sArr, int i3);

    public native int decodeLost(short[] sArr, int i);

    public native int encode(short[] sArr, int i, int i2, byte[] bArr, int i3);

    public native int open(int i, boolean z);

    public Speex() {
        open(10, false);
    }

    public Speex(boolean z) {
        open(10, z);
    }

    static {
        System.loadLibrary("speex_jni");
    }
}
