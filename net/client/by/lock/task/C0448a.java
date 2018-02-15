package net.client.by.lock.task;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerException;
import net.client.by.lock.C0322b;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p013b.C0321n;
import net.client.by.lock.p014c.C0330h;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p016f.C0359d;
import net.client.by.lock.p016f.C0360e;
import net.client.by.lock.p016f.C0374s;
import net.client.by.lock.service.BackgroundService;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;

/* compiled from: MyApp */
public abstract class C0448a extends AsyncTask {
    public static final int CANCELLED = 3;
    public static final int FAILED = 2;
    public static final int PENDING = 0;
    public static final int RUNNING = 1;
    public static final int SUCCEEDED = 4;
    protected static int errorCount = 0;
    private static int logRequestId = 0;
    private final String TAG = "GenericTask";
    public Context ctx;
    private int logReqId = 0;
    protected HttpPost post;
    protected Object startupParameter;
    int state = 0;
    public String taskId;
    private WakeLock wakeLock;
    private WifiLock wifiLock;

    protected abstract Document getRequest();

    protected abstract String getUrl();

    protected abstract void restart();

    public C0448a(Context context, Object obj) {
        this.startupParameter = obj;
        this.ctx = context;
        this.post = null;
        initLock(context);
    }

    protected void lock() {
        try {
            this.wakeLock.acquire();
            this.wifiLock.acquire();
        } catch (Exception e) {
            C0322b.m2076e("WlanSilencer", "Error getting Lock: " + e.getMessage());
        }
    }

    protected void unlock() {
        if (this.wakeLock.isHeld()) {
            this.wakeLock.release();
        }
        if (this.wifiLock.isHeld()) {
            this.wifiLock.release();
        }
    }

    private void initLock(Context context) {
        this.wifiLock = ((WifiManager) context.getSystemService("wifi")).createWifiLock(1, "GenericTaskWifiLock");
        this.wakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "GenericTaskWakeLock");
    }

    public boolean cancelTask(boolean z) {
        if (this.post != null && z) {
            new Thread(new C0449b(this)).start();
        }
        return super.cancel(z);
    }

    public void execute() {
        this.state = 1;
        if (VERSION.SDK_INT >= 11) {
            startNew();
        } else {
            startOld();
        }
    }

    private void startOld() {
        super.execute(new Object[0]);
    }

    @TargetApi(11)
    private void startNew() {
        executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }

    protected void onPostExecute(Object[] objArr) {
        C0332j.m2148a().m2155a(this.taskId);
        unlock();
    }

    protected final void onCancelled() {
        this.state = 3;
        genericOnCancel();
        unlock();
    }

    protected Object[] doInBackground(Object... objArr) {
        lock();
        Process.setThreadPriority(-8);
        try {
            Document call = call();
            if (!isCancelled()) {
                return genericOnSuccess(call);
            }
            this.state = 3;
            return null;
        } catch (Throwable e) {
            e.printStackTrace();
            if (!isCancelled()) {
                return genericOnException(e);
            }
            this.state = 3;
            return null;
        }
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    protected Document call() {
        HttpsURLConnection a;
        OutputStream outputStream;
        Exception e;
        Throwable th;
        InputStream inputStream = null;
        C0321n c0321n = new C0321n();
        StringBuffer stringBuffer = new StringBuffer();
        String str = "";
        try {
            Document request = getRequest();
            String url = getUrl();
            int i = logRequestId;
            logRequestId = i + 1;
            this.logReqId = i;
            C0374s.m2548a(this.logReqId + " request " + url, request);
            this.post = C0359d.m2460a(request, url);
            a = C0360e.m2462a(url, this.ctx);
            try {
                new Thread(new C0450c(Thread.currentThread(), a)).start();
                outputStream = a.getOutputStream();
                try {
                    int read;
                    this.post.getEntity().writeTo(outputStream);
                    BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
                    inputStream = a.getInputStream();
                    basicHttpEntity.setContent(inputStream);
                    Reader inputStreamReader = new InputStreamReader(inputStream);
                    C0322b.m2077i("XmlUtils", this.logReqId + " response start " + url);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        read = bufferedReader.read();
                        if (read < 0) {
                            break;
                        }
                        stringBuffer.append((char) read);
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    for (read = 0; read < stringBuffer2.length(); read += 1000) {
                        int length;
                        String str2 = "XmlUtils";
                        if (read + 1000 > stringBuffer2.length()) {
                            length = stringBuffer2.length();
                        } else {
                            length = read + 1000;
                        }
                        C0322b.m2078v(str2, stringBuffer2.substring(read, length));
                    }
                    C0322b.m2077i("XmlUtils", this.logReqId + " response end " + url);
                    if (stringBuffer2.length() == 0) {
                        throw new TransformerException("response null!");
                    }
                    Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(stringBuffer2)));
                    if (a != null) {
                        a.disconnect();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (c0321n != null) {
                        c0321n.close();
                    }
                    return parse;
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                outputStream = null;
                try {
                    C0322b.m2077i("XmlUtils", this.logReqId + " response exception: " + e.toString());
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.disconnect();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (c0321n != null) {
                        c0321n.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
                if (a != null) {
                    a.disconnect();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (c0321n != null) {
                    c0321n.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            outputStream = null;
            a = null;
            C0322b.m2077i("XmlUtils", this.logReqId + " response exception: " + e.toString());
            throw e;
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
            a = null;
            if (a != null) {
                a.disconnect();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (c0321n != null) {
                c0321n.close();
            }
            throw th;
        }
    }

    private boolean generalCheck(Document document) {
        if (document == null || document.getDocumentElement() == null || document.getDocumentElement().getNodeName() == null) {
            C0322b.m2076e("GenericTask", "null doc ");
            return false;
        } else if (document.getDocumentElement().getNodeName().equalsIgnoreCase("response")) {
            Element documentElement = document.getDocumentElement();
            String attribute = documentElement.getAttribute("id");
            if (!C0351r.m2359i().m2395q() || (this instanceof LoginTask)) {
                if (attribute.length() > 0) {
                    C0351r.m2359i().m2375c(attribute);
                } else {
                    NodeList elementsByTagName = documentElement.getElementsByTagName("error");
                    if (elementsByTagName == null || elementsByTagName.getLength() == 0) {
                        C0330h.m2111a().m2114a("Bad packet: no id! ERROR_" + getClass().getName());
                        return false;
                    }
                }
            } else if (!attribute.equalsIgnoreCase(C0351r.m2359i().m2388j())) {
                C0322b.m2076e("GenericTask", "id " + attribute);
                C0322b.m2076e("GenericTask", "Session.getInstance().getSessionId() " + C0351r.m2359i().m2388j());
                C0330h.m2111a().m2114a("Bad packet: id unmatch! ERROR_" + getClass().getName());
                return false;
            }
            return true;
        } else {
            C0330h.m2111a().m2114a("Bad packet: no response! ERROR_" + getClass().getName());
            return false;
        }
    }

    protected Object[] genericOnSuccess(Document document) {
        try {
            if (BackgroundService.m2756a().m2776c()) {
                BackgroundService.m2756a().m2774a(false);
            }
        } catch (Exception e) {
            C0322b.m2079w("GenericTask OnSuccess", "BG Service instance: " + e.getMessage());
        }
        try {
            if (generalCheck(document)) {
                NodeList elementsByTagName = document.getDocumentElement().getElementsByTagName("error");
                if (elementsByTagName == null || elementsByTagName.getLength() <= 0) {
                    this.state = 4;
                    errorCount = 0;
                    if (!isCancelled()) {
                        return onSuccess(document);
                    }
                    this.state = 3;
                    return null;
                }
                this.state = 2;
                return genericOnFailAtServer(elementsByTagName.item(0).getTextContent());
            }
            this.state = 2;
            return genericOnFailAtServer("package check failed");
        } catch (Throwable e2) {
            C0322b.m2076e("GenericTask OnSuccess Exception!<" + getClass().getName() + ">", ": " + e2.getMessage());
            return genericOnException(e2);
        }
    }

    protected synchronized Object[] genericOnException(Throwable th) {
        Object[] onException;
        this.state = 2;
        if ((th instanceof TransformerException) || (th instanceof SAXParseException)) {
            C0330h.m2111a().m2122e();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            C0322b.m2076e("GenericTask", "errorCount : " + errorCount);
            if ((this instanceof GetRosterEventTask) || (this instanceof LoginTask)) {
                onException = onException(th);
            }
        }
        errorCount++;
        if (errorCount >= 3) {
            errorCount = 0;
            C0330h.m2111a().m2114a("Cannot connect server, check your internet connection.");
        } else if (C0351r.m2359i().m2395q()) {
            restart();
        }
        onException = onException(th);
        return onException;
    }

    protected void genericOnCancel() {
        C0332j.m2148a().m2155a(this.taskId);
        unlock();
        onCancel();
    }

    private Object[] genericOnFailAtServer(String str) {
        if (str.contains("SessionExpiredException") || str.contains("SessionClosedException")) {
            C0351r.m2358a(false);
            if (!getClass().equals(LogoutTask.class)) {
                C0330h.m2111a().m2114a(new StringBuilder(String.valueOf(str)).append(" ERROR_").append(getClass().getName()).toString());
            }
        }
        return onFailAtServer(str);
    }

    protected Object[] onSuccess(Document document) {
        return new Object[]{"onSuccess", document};
    }

    protected Object[] onException(Throwable th) {
        return new Object[]{"onException", th};
    }

    protected void onCancel() {
    }

    protected Object[] onFailAtServer(String str) {
        C0330h.m2111a().m2114a(new StringBuilder(String.valueOf(str)).append(" ERROR_").append(getClass().getName()).toString());
        return new Object[]{"onFail", str};
    }

    public int getState() {
        return this.state;
    }
}
