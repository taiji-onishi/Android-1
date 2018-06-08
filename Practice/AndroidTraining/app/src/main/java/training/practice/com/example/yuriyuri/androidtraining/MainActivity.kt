package training.practice.com.example.yuriyuri.androidtraining

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import training.practice.com.example.yuriyuri.androidtraining.ExplicitBroadcastReceiverDynamic.Companion.BROADCAST_DYNAMIC

class MainActivity : AppCompatActivity() {

    private lateinit var explicitBroadcastReceiverDynamic : ExplicitBroadcastReceiverDynamic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val explicitBtnM = findViewById<Button>(R.id.explicit_button_manifest)
        explicitBtnM.setOnClickListener {
            // 明示的Intentの生成
            val mIntent = Intent(this@MainActivity, ExplicitBroadcastReceiverManifest::class.java)
            mIntent.putExtra("message", "明示的Intent(Manifest)")
            sendBroadcast(mIntent)
        }

        val explicitBtnD = findViewById<Button>(R.id.explicit_button_dynamic)
        explicitBtnD.setOnClickListener {
            // 暗黙的Intentの生成
            val dIntent = Intent()
            dIntent.putExtra("message", "暗黙的Intent(動的)")
            dIntent.action = BROADCAST_DYNAMIC
            sendBroadcast(dIntent)
        }

        val intentFilter = IntentFilter(BROADCAST_DYNAMIC)
        explicitBroadcastReceiverDynamic = ExplicitBroadcastReceiverDynamic()
        this.registerReceiver(explicitBroadcastReceiverDynamic, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(explicitBroadcastReceiverDynamic)
    }
}
