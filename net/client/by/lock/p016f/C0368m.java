package net.client.by.lock.p016f;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

/* compiled from: MyApp */
public class C0368m {
    public static String m2483a(String str) {
        String str2 = "";
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            int length = digest.length;
            String str3 = str2;
            int i = 0;
            while (i < length) {
                byte b = digest[i];
                i++;
                str3 = new StringBuilder(String.valueOf(str3)).append(String.format("%02x", new Object[]{Byte.valueOf(b)})).toString();
            }
            return str3;
        } catch (Throwable e) {
            C0365j.m2476a("SecurityUtils", e);
            return null;
        }
    }

    public static boolean m2487a(X509Certificate[] x509CertificateArr, X509Certificate[] x509CertificateArr2, X509Certificate[] x509CertificateArr3) {
        if (x509CertificateArr.length == 1) {
            return C0368m.m2486a(x509CertificateArr[0], x509CertificateArr2, x509CertificateArr3);
        }
        int i;
        C0369n[] c0369nArr = new C0369n[x509CertificateArr.length];
        for (i = 0; i < x509CertificateArr.length; i++) {
            c0369nArr[i] = new C0369n(x509CertificateArr[i]);
        }
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < x509CertificateArr.length - 1) {
            try {
                x509CertificateArr[i].checkValidity();
                int i2 = 0;
                while (i2 < x509CertificateArr.length) {
                    if (i2 != i) {
                        if (c0369nArr[i2].f1568b == null && c0369nArr[i].f1569c == null && C0368m.m2485a(x509CertificateArr[i2], x509CertificateArr[i])) {
                            c0369nArr[i2].f1568b = c0369nArr[i];
                            c0369nArr[i].f1569c = c0369nArr[i2];
                        }
                        if (c0369nArr[i2].f1569c == null && c0369nArr[i].f1568b == null && C0368m.m2485a(x509CertificateArr[i], x509CertificateArr[i2])) {
                            c0369nArr[i2].f1569c = c0369nArr[i];
                            c0369nArr[i].f1568b = c0369nArr[i2];
                        }
                    }
                    i2++;
                }
                i++;
            } catch (Throwable e) {
                C0365j.m2476a("Certificate is not valid: " + x509CertificateArr[i].getSubjectX500Principal().getName(), e);
                return false;
            } catch (CertificateNotYetValidException e2) {
                return false;
            }
        }
        C0369n c0369n = c0369nArr[0];
        while (c0369n.f1569c != null) {
            c0369n = c0369n.f1569c;
        }
        do {
            arrayList.add(c0369n.f1567a);
            c0369n = c0369n.f1568b;
        } while (c0369n != null);
        if (arrayList.size() == x509CertificateArr.length) {
            return C0368m.m2486a((X509Certificate) arrayList.get(0), x509CertificateArr2, x509CertificateArr3);
        }
        C0365j.m2476a("SecurityUtils", new CertPathValidatorException("Broken certificate chain: Unable to sort well"));
        return false;
    }

    private static boolean m2486a(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr, X509Certificate[] x509CertificateArr2) {
        if (x509CertificateArr != null) {
            for (X509Certificate a : x509CertificateArr) {
                if (C0368m.m2485a(x509Certificate, a)) {
                    return true;
                }
            }
        }
        if (x509CertificateArr2 != null) {
            for (Object equals : x509CertificateArr2) {
                if (x509Certificate.equals(equals)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean m2485a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerX500Principal().getName().equals(x509Certificate2.getSubjectX500Principal().getName())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static char[] m2488a(int i) {
        int i2 = 0;
        StringBuilder append = new StringBuilder("DEBUG_encode( ").append(i).append(" ): ");
        int i3 = i;
        while (i3 > 1048576) {
            i3 -= 1048576;
        }
        while (i3 < 0) {
            i3 += 1048576;
        }
        byte[] bArr = new byte[2];
        r4 = new byte[4];
        byte[] bArr2 = new byte[5];
        r4[0] = (byte) ((i3 >> 18) & 3);
        r4[1] = (byte) (i3 >> 10);
        r4[2] = (byte) ((i3 >> 8) & 3);
        r4[3] = (byte) i3;
        append.append(" result[0]: ").append(r4[0]).append(" result[1]: ").append(r4[1]).append(" result[2]: ").append(r4[2]).append(" result[3]: ").append(r4[3]);
        new SecureRandom().nextBytes(bArr);
        bArr[0] = (byte) (bArr[0] & 3);
        r4[0] = (byte) (r4[0] ^ bArr[0]);
        r4[1] = (byte) (r4[1] ^ bArr[1]);
        r4[2] = (byte) (r4[2] ^ bArr[0]);
        r4[3] = (byte) (r4[3] ^ bArr[1]);
        append.append(" rBits[0]: ").append(bArr[0]).append(" rBits[1]: ").append(bArr[1]).append(" result[0]: ").append(r4[0]).append(" result[1]: ").append(r4[1]).append(" result[2]: ").append(r4[2]).append(" result[3]: ").append(r4[3]);
        bArr2[0] = (byte) ((bArr[0] << 4) | (C0368m.m2482a(bArr[1], 4, true) & 63));
        bArr2[1] = (byte) (((bArr[1] << 2) | (r4[0] & 3)) & 63);
        bArr2[2] = (byte) (C0368m.m2482a(r4[1], 2, true) & 63);
        bArr2[3] = (byte) ((((r4[1] << 4) | ((r4[2] & 3) << 2)) | C0368m.m2482a(r4[3], 6, true)) & 63);
        bArr2[4] = (byte) (r4[3] & 63);
        append.append(" out[0]: ").append(bArr2[0]).append(" out[1]: ").append(bArr2[1]).append(" out[2]: ").append(bArr2[2]).append(" out[3]: ").append(bArr2[3]).append(" out[4]: ").append(bArr2[4]);
        char[] cArr = new char[5];
        while (i2 < cArr.length) {
            cArr[i2] = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890,;".charAt(bArr2[i2]);
            i2++;
        }
        append.append(" return :").append(cArr);
        return cArr;
    }

    private static byte m2482a(byte b, int i, boolean z) {
        int i2 = b & 255;
        return (byte) (z ? i2 >>> i : i2 << i);
    }

    public static String m2484a(String str, char[] cArr) {
        if (str == null || !str.contains(".")) {
            return str;
        }
        char charAt = str.charAt(str.length() - 1);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(charAt);
        int i = charAt == '>' ? 1 : 0;
        int i2 = 0;
        char c = charAt;
        int length = str.length() - 2;
        while (length >= 0) {
            int i3;
            char charAt2 = str.charAt(length);
            if (i2 != cArr.length) {
                if (charAt2 == '>') {
                    i3 = i + 1;
                } else if (charAt2 == '<') {
                    i3 = i - 1;
                } else if (i == 0 && charAt2 == '.' && r1 == ' ') {
                    i3 = i2 + 1;
                    stringBuilder.append(cArr[i2]);
                    i2 = i3;
                    i3 = i;
                }
                stringBuilder.append(charAt2);
                length--;
                i = i3;
                c = charAt2;
            }
            i3 = i;
            stringBuilder.append(charAt2);
            length--;
            i = i3;
            c = charAt2;
        }
        return stringBuilder.reverse().toString();
    }
}
