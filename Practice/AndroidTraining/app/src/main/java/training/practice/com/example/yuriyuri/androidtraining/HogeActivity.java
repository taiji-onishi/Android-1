package training.practice.com.example.yuriyuri.androidtraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by yuri on 2018/06/08.
 */

public class HogeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // マニフェストに登録
        Button explicitBtnM = findViewById(R.id.explicit_button_manifest);
        explicitBtnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 明示的Intentの生成
                Intent mIntent = new Intent(getApplicationContext(), ExplicitBroadcastReceiverManifest.class);
                sendBroadcast(mIntent);
            }
        });

        // 動的に登録
        Button explicitBtnD = findViewById(R.id.explicit_button_dynamic);
        explicitBtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 明示的Intentの生成
                Intent mIntent = new Intent(getApplicationContext(), ExplicitBroadcastReceiverDynamic.class);
                sendBroadcast(mIntent);
            }
        });
    }
}
