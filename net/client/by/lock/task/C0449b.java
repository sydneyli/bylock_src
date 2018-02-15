package net.client.by.lock.task;

/* compiled from: MyApp */
class C0449b implements Runnable {
    final /* synthetic */ C0448a f1957a;

    C0449b(C0448a c0448a) {
        this.f1957a = c0448a;
    }

    public void run() {
        this.f1957a.post.abort();
    }
}
