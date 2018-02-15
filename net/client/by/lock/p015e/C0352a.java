package net.client.by.lock.p015e;

/* compiled from: MyApp */
public class C0352a {
    public static String m2402a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i += 3) {
            stringBuffer.append(C0352a.m2404a(bArr, i));
        }
        return stringBuffer.toString();
    }

    protected static char[] m2404a(byte[] bArr, int i) {
        int length = (bArr.length - i) - 1;
        int i2 = length >= 2 ? 2 : length;
        int i3 = 0;
        for (int i4 = 0; i4 <= i2; i4++) {
            int i5 = bArr[i + i4];
            if (i5 < 0) {
                i5 += 256;
            }
            i3 += i5 << ((2 - i4) * 8);
        }
        char[] cArr = new char[4];
        for (i2 = 0; i2 < 4; i2++) {
            cArr[i2] = C0352a.m2400a((i3 >>> ((3 - i2) * 6)) & 63);
        }
        if (length < 1) {
            cArr[2] = '=';
        }
        if (length < 2) {
            cArr[3] = '=';
        }
        return cArr;
    }

    protected static char m2400a(int i) {
        if (i >= 0 && i <= 25) {
            return (char) (i + 65);
        }
        if (i >= 26 && i <= 51) {
            return (char) ((i - 26) + 97);
        }
        if (i >= 52 && i <= 61) {
            return (char) ((i - 52) + 48);
        }
        if (i == 62) {
            return '+';
        }
        if (i == 63) {
            return '/';
        }
        return '?';
    }

    public static byte[] m2403a(String str) {
        int length;
        int i = 0;
        for (length = str.length() - 1; str.charAt(length) == '='; length--) {
            i++;
        }
        byte[] bArr = new byte[(((str.length() * 6) / 8) - i)];
        i = 0;
        for (length = 0; length < str.length(); length += 4) {
            int a = C0352a.m2401a(str.charAt(length + 3)) + (((C0352a.m2401a(str.charAt(length)) << 18) + (C0352a.m2401a(str.charAt(length + 1)) << 12)) + (C0352a.m2401a(str.charAt(length + 2)) << 6));
            int i2 = 0;
            while (i2 < 3 && i + i2 < bArr.length) {
                bArr[i + i2] = (byte) ((a >> ((2 - i2) * 8)) & 255);
                i2++;
            }
            i += 3;
        }
        return bArr;
    }

    protected static int m2401a(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 65;
        }
        if (c >= 'a' && c <= 'z') {
            return (c - 97) + 26;
        }
        if (c >= '0' && c <= '9') {
            return (c - 48) + 52;
        }
        if (c == '+') {
            return 62;
        }
        if (c == '/') {
            return 63;
        }
        if (c == '=') {
            return 0;
        }
        return -1;
    }
}
