package training.practice.com.example.yuriyuri.androidtraining

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.widget.Toast

class ExplicitBroadcastReceiverManifest : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val message = intent.getStringExtra("message")
        val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        toast.view.setBackgroundColor(Color.RED)
        toast.show()
    }
}