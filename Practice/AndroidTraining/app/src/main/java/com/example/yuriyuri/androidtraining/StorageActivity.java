package com.example.yuriyuri.androidtraining;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class StorageActivity extends AppCompatActivity {

    private final static int PERMISSION_REQUEST_CD = 500;
    private final String[] permissions = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    private EditText editText;
    private TextView filePassText;
    private TextView savedText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strage);

        if (Build.VERSION.SDK_INT >= 22) {
            if (!checkPermission()) {
                requestPermission();
            }
        } else {
            init();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (PERMISSION_REQUEST_CD == requestCode) {
            if (checkPermission()) {
                init();
            } else {
                Toast.makeText(this, "書き込み許可が必要です。設定から変更してください。", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /**
     * Permissionチェック
     */
    private boolean checkPermission() {
        int writePermission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        // すでに許可
        return writePermission == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * パーミッション許可取得
     */
    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(this, "書き込み許可が必要です。設定から変更してください。", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(this,
                    permissions,
                    PERMISSION_REQUEST_CD);
            return;
        }

        ActivityCompat.requestPermissions(this,
                permissions,
                PERMISSION_REQUEST_CD);
    }

    /**
     * viewの設定
     */
    private void init() {
        editText = findViewById(R.id.edit_text);
        Button savePrivateButton = findViewById(R.id.save_private_button);
        Button savePublicButton = findViewById(R.id.save_public_button);
        filePassText = findViewById(R.id.file_dir_text);
        savedText = findViewById(R.id.file_saved_text);
        Button readPrivateButton = findViewById(R.id.read_private_button);
        Button readPublicButton = findViewById(R.id.read_public_button);

        savePrivateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isExternalStorageAccess()) {
                    File[] dirs = getApplication().getExternalFilesDirs(null);
                    for (File dir : dirs) {
                        if (dir != null) {
                            // 外部ストレージのパスかどうか
                            if (Environment.isExternalStorageRemovable(dir)) {
                                saveData(dir);
                            }
                        }
                    }
                }
            }
        });

        savePublicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isExternalStorageAccess()) {
                    File file = new File(Environment.getExternalStoragePublicDirectory(
                            Environment.DIRECTORY_DOCUMENTS), "testDocument");
                    saveData(file);
                }
            }
        });

        readPrivateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isExternalStorageAccess()) {
                    File[] dirs = getApplication().getExternalFilesDirs(null);
                    for (File dir : dirs) {
                        if (dir != null) {
                            // 外部ストレージのパスかどうか
                            if (Environment.isExternalStorageRemovable(dir)) {
                                readData(dir);
                            }
                        }
                    }
                }
            }
        });

        readPublicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isExternalStorageAccess()) {
                    File file = new File(Environment.getExternalStoragePublicDirectory(
                            Environment.DIRECTORY_DOCUMENTS), "testDocument");
                    readData(file);
                }
            }
        });
    }

    /**
     * データを保存
     *
     * @param file File
     */
    private void saveData(File file) {
        try {
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            BufferedWriter bw = new BufferedWriter(outputStreamWriter);
            bw.write(editText.getText().toString());
            bw.flush();
            Toast.makeText(getApplicationContext(), "保存しました", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * データをロード
     *
     * @param file File
     */
    private void readData(File file) {
        String filePath = file.getAbsolutePath();
        filePassText.setText(filePath);
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF8");
            BufferedReader reader = new BufferedReader(inputStreamReader);
            savedText.setText(reader.readLine());
        } catch (Exception e) {
            savedText.setText(e.getMessage());
        }
    }

    /**
     * SDカードがマウントされているかどうか
     */
    private boolean isExternalStorageAccess() {
        boolean externalStorageAvailable;
        boolean externalStorageWriteable;

        //アクセス可能か、状態を取得
        String state = Environment.getExternalStorageState();

        if (Environment.MEDIA_MOUNTED.equals(state)) {
            //ストレージの読み書きが可能
            externalStorageAvailable = true;
            externalStorageWriteable = true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            //ストレージの読み込みが可能
            externalStorageAvailable = true;
            externalStorageWriteable = false;
        } else {
            //読み込みも書き込みもできない
            externalStorageAvailable = externalStorageWriteable = false;
        }
        return externalStorageAvailable && externalStorageWriteable;
    }

}
