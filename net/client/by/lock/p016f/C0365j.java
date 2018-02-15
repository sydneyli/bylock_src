package net.client.by.lock.p016f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import net.client.by.lock.C0322b;
import net.client.by.lock.p013b.C0320l;
import net.client.by.lock.p013b.C0321n;
import org.apache.http.entity.InputStreamEntity;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class C0365j {
    public static void m2476a(String str, Throwable th) {
        String str2 = "\r\n*** START EXCEPTION *** \r\n" + new SimpleDateFormat("dd.MM.yy HH:mm:ss", Locale.getDefault()).format(new Timestamp(System.currentTimeMillis())) + "\r\n" + "Message: " + th.getMessage() + "\r\n" + "Cause: " + th.getCause() + "\r\n" + "Name: " + th.getClass().getName();
        StringBuilder stringBuilder = new StringBuilder();
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            stringBuilder.append(new StringBuilder(String.valueOf(stackTraceElement.toString())).append("\r\n").toString());
        }
        C0322b.m2076e(str, new StringBuilder(String.valueOf(str2)).append(stringBuilder.toString()).append("\r\n").append("*** END EXCEPTION ***").append("\r\n").toString());
    }

    public static String m2473a(int i) {
        if (i > 3600) {
            return String.format(Locale.getDefault(), "%02d:%02d:%02d", new Object[]{Integer.valueOf(i / 3600), Integer.valueOf((i % 3600) / 60), Integer.valueOf(i % 60)});
        }
        return String.format(Locale.getDefault(), "%02d:%02d", new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)});
    }

    public static String m2472a(double d) {
        if (d > 1024.0d) {
            double d2 = d / 1024.0d;
            if (d2 > 1024.0d) {
                if (d2 / 1024.0d > 1024.0d) {
                    return new StringBuilder(String.valueOf(String.format("%.1f", new Object[]{Double.valueOf((d2 / 1024.0d) / 1024.0d)}))).append(" GB/s").toString();
                }
                return new StringBuilder(String.valueOf(String.format("%.1f", new Object[]{Double.valueOf(d2 / 1024.0d)}))).append(" MB/s").toString();
            }
            return new StringBuilder(String.valueOf(String.format("%.1f", new Object[]{Double.valueOf(d2)}))).append(" KB/s").toString();
        }
        return new StringBuilder(String.valueOf(String.format("%.1f", new Object[]{Double.valueOf(d)}))).append(" B/s").toString();
    }

    public static boolean m2477a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        networkInfo = connectivityManager.getNetworkInfo(0);
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static byte[] m2480a(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            int digit = Character.digit(str.charAt(i), 16);
            if (digit == -1) {
                return null;
            }
            int digit2 = Character.digit(str.charAt(i + 1), 16);
            if (digit2 == -1) {
                return null;
            }
            bArr[i / 2] = (byte) ((digit << 4) + digit2);
        }
        return bArr;
    }

    public static String m2475a(byte[] bArr) {
        String str = "";
        for (int i = 0; i < bArr.length; i++) {
            str = new StringBuilder(String.valueOf(str)).append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i])})).toString();
        }
        return str;
    }

    public static boolean m2479a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr.length < i + i3 || bArr2.length < i2 + i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i + i4] != bArr2[i2 + i4]) {
                return false;
            }
        }
        return true;
    }

    public static int m2471a(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < (bArr.length - bArr2.length) + 1; i++) {
            Object obj;
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                if (bArr[i + i2] != bArr2[i2]) {
                    obj = null;
                    break;
                }
            }
            obj = 1;
            if (obj != null) {
                return i;
            }
        }
        return -1;
    }

    public static boolean m2478a(Document document, OutputStream outputStream, C0321n c0321n) {
        try {
            InputStreamEntity inputStreamEntity;
            Writer stringWriter = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document), new StreamResult(stringWriter));
            if (c0321n == null) {
                inputStreamEntity = new InputStreamEntity(new ByteArrayInputStream(stringWriter.toString().getBytes()), -1);
            } else {
                inputStreamEntity = new InputStreamEntity(new C0320l(new ByteArrayInputStream(stringWriter.toString().getBytes()), c0321n), -1);
            }
            inputStreamEntity.setChunked(true);
            inputStreamEntity.writeTo(outputStream);
            outputStream.flush();
        } catch (Throwable e) {
            C0365j.m2476a("Error in transforming xml to post", e);
        }
        return true;
    }

    public static String m2474a(long j) {
        if (j <= 0) {
            return "0 B";
        }
        int log10 = (int) (Math.log10((double) j) / Math.log10(1024.0d));
        return new StringBuilder(String.valueOf(new DecimalFormat("#,##0.#").format(((double) j) / Math.pow(1024.0d, (double) log10)))).append(" ").append(new String[]{"B", "KB", "MB", "GB", "TB"}[log10]).toString();
    }
}
