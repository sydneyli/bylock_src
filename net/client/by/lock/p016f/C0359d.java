package net.client.by.lock.p016f;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class C0359d {
    public static HttpPost m2460a(Document document, String str) {
        Throwable th;
        InputStream inputStream = null;
        Writer stringWriter = new StringWriter();
        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document), new StreamResult(stringWriter));
        HttpPost httpPost = new HttpPost(str);
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(stringWriter.toString().getBytes());
            try {
                String str2 = "";
                while (true) {
                    int read = byteArrayInputStream.read();
                    if (-1 == read) {
                        break;
                    }
                    str2 = new StringBuilder(String.valueOf(str2)).append((char) read).toString();
                }
                HttpEntity stringEntity = new StringEntity(str2);
                stringEntity.setChunked(true);
                httpPost.setEntity(stringEntity);
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return httpPost;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = inputStream;
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }
}
