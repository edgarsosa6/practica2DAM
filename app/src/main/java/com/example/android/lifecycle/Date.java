package com.example.android.lifecycle;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import java.util.Calendar;

public class Date extends IntentService
{

    private Handler handler;

    public Date()
    {
        super("Date");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        handler = new Handler();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        Calendar calendar = Calendar.getInstance();
        String myDate = calendar.getTime().toString();
        showText(myDate);
    }

    private void showText(final String text)
    {
        handler.post(new Runnable()
        {
            @Override
            public void run()
            {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
            }
        });
    }

}
