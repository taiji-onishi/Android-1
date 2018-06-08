package training.practice.com.example.yuriyuri.androidtraining;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static training.practice.com.example.yuriyuri.androidtraining.ExplicitBroadcastReceiverDynamic.BROADCAST_DYNAMIC;

/**
 * Created by yuri on 2018/06/08.
 */

public class HogeActivity extends AppCompatActivity {

    private ExplicitBroadcastReceiverDynamic explicitBroadcastReceiverDynamic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        explicitBroadcastReceiverDynamic = new ExplicitBroadcastReceiverDynamic();

//        IntentFilter intentFilter = new IntentFilter(Companion.getBROADCAST_DYNAMIC());
//        this.registerReceiver(explicitBroadcastReceiverDynamic, intentFilter);
//
//        // マニフェストに登録
//        Button explicitBtnM = findViewById(R.id.explicit_button_manifest);
//        explicitBtnM.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 明示的Intentの生成
//                Intent mIntent = new Intent(getApplicationContext(), ExplicitBroadcastReceiverManifest.class);
//                mIntent.putExtra("message", "明示的Intent(Manifest)");
//                sendBroadcast(mIntent);
//            }
//        });


        Button explicitBtnD = findViewById(R.id.explicit_button_dynamic);
        explicitBtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 明示的Intentの生成
                Intent dIntent = new Intent();
                dIntent.putExtra("message", "暗黙的Intent(動的)");
                dIntent.setAction(BROADCAST_DYNAMIC);
                sendBroadcast(dIntent);
            }
        });

        IntentFilter intentFilter = new IntentFilter(BROADCAST_DYNAMIC);
        explicitBroadcastReceiverDynamic = new ExplicitBroadcastReceiverDynamic();
        this.registerReceiver(explicitBroadcastReceiverDynamic, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(explicitBroadcastReceiverDynamic);
    }
}
