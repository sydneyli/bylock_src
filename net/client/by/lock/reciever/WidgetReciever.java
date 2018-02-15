package net.client.by.lock.reciever;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import java.util.Random;
import net.client.by.lock.R;

/* compiled from: MyApp */
public class WidgetReciever extends AppWidgetProvider {
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        for (int i : appWidgetManager.getAppWidgetIds(new ComponentName(context, WidgetReciever.class))) {
            int nextInt = new Random().nextInt(100);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_aaa);
            remoteViews.setTextViewText(R.id.update, "byLock-Random: " + String.valueOf(nextInt));
            Intent intent = new Intent(context, WidgetReciever.class);
            intent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
            intent.putExtra("appWidgetIds", iArr);
            remoteViews.setOnClickPendingIntent(R.id.update, PendingIntent.getBroadcast(context, 0, intent, 134217728));
            appWidgetManager.updateAppWidget(i, remoteViews);
        }
    }
}
