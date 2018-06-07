package training.practice.com.example.yuriyuri.androidtraining;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.widget.Toast;

/**
 * Created by yuri on 2018/06/08.
 */

public class ExplicitBroadcastReceiverDynamic extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra("message");
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.getView().setBackgroundColor(Color.BLUE);
        toast.show();
    }
}
