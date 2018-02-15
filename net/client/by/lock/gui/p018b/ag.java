package net.client.by.lock.gui.p018b;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import net.client.by.lock.C0322b;

/* compiled from: MyApp */
public class ag implements SensorEventListener {
    private SensorManager f1850a;
    private Sensor f1851b;
    private ah f1852c = null;

    public ag(Context context) {
        context.getApplicationContext();
        this.f1850a = (SensorManager) context.getSystemService("sensor");
        this.f1851b = this.f1850a.getDefaultSensor(8);
    }

    public void m2724a() {
        this.f1852c = null;
        if (!Build.MANUFACTURER.contains("HTC") && !Build.MANUFACTURER.contains("htc") && !Build.MANUFACTURER.contains("Htc")) {
            if (this.f1851b == null) {
                C0322b.m2076e("ProximityListener", "No registered proximity sensor found!");
                return;
            }
            C0322b.m2076e("ProximityListener", "Proximity stop");
            this.f1850a.unregisterListener(this, this.f1851b);
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        C0322b.m2076e("ProximityListener", "onAccuracyChanged");
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        boolean z = false;
        C0322b.m2076e("ProximityListener", "mProximitySensor.getMaximumRange(): " + this.f1851b.getMaximumRange());
        C0322b.m2076e("ProximityListener", "Long/Short: " + sensorEvent.values[0]);
        if (this.f1852c != null) {
            synchronized (this.f1852c) {
                ah ahVar = this.f1852c;
                if (sensorEvent.values[0] != this.f1851b.getMaximumRange() && sensorEvent.values[0] <= 5.0f) {
                    z = true;
                }
                ahVar.mo333a(z);
            }
        }
    }
}
