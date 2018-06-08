package training.practice.com.example.yuriyuri.androidtraining

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.text.TextUtils
import android.widget.Toast

/**
 * Created by yuri on 2018/06/08.
 */

class ExplicitBroadcastReceiverDynamic : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // Actionにbroadcast_dynamicが指定されている場合にトーストを表示する
        if (TextUtils.equals(BROADCAST_DYNAMIC, intent.action)) {
            val message = intent.getStringExtra("message")
            val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
            toast.view.setBackgroundColor(Color.BLUE)
            toast.show()
        }
    }

    companion object {
        const val BROADCAST_DYNAMIC = "broadcast_dynamic"
    }
}
