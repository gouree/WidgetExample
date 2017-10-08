package com.example.gouree.widgetexample;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Created by omsai on 08/10/2017.
 */

public class WidgetsDemo extends AppWidgetProvider
{

    //ONUPDATE METHOD
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
    {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        for(int i=0;i<appWidgetIds.length;i++)
        {
            //store the id in currentwidgetid
            int currentWidgetId = appWidgetIds[i];

            //store url to be opened in url variable
            String url ="http://www.acadgild.com";

            //create an intent and add flags, set data to url
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse(url));

            //use a pending intent
            PendingIntent pendingIntent =PendingIntent.getActivity(context,0,intent,0);


            //remote view , on click of button start -->pending intent open url
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.widget_view);

            remoteViews.setOnClickPendingIntent(R.id.button,pendingIntent);

            appWidgetManager.updateAppWidget(currentWidgetId,remoteViews);


        }
    }
}
