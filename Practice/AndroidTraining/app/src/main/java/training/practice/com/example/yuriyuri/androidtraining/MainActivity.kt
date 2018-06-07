package training.practice.com.example.yuriyuri.androidtraining

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // マニフェストに登録
        val explicitBtnM = findViewById<Button>(R.id.explicit_button_manifest)
        explicitBtnM.setOnClickListener {
            // 明示的Intentの生成
            val mIntent = Intent(this@MainActivity, ExplicitBroadcastReceiverManifest::class.java)
            sendBroadcast(mIntent)
        }

        // 動的に登録
        val explicitBtnD = findViewById<Button>(R.id.explicit_button_dynamic)
        explicitBtnD.setOnClickListener {
            // 明示的Intentの生成
            val mIntent = Intent(this@MainActivity, ExplicitBroadcastReceiverDynamic::class.java)
            sendBroadcast(mIntent)
        }


    }
}
