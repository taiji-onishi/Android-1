package training.practice.com.example.yuriyuri.androidtraining

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog


class TestAlertDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // DialogBuilder
        // ここではマテリアルデザインを使うためにapp.support.v7を使用
        val builder = AlertDialog.Builder(activity)  // ①
        // タイトル
        builder.setTitle("アラートダイアログのタイトル")  // ②
        // メッセージ
        builder.setMessage("メッセージ部分") // ③
        // OKボタン
        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
            // ④
            // OKボタンが押された時の処理
        })
        // Chancelボタン
        builder.setNegativeButton("Chancel", DialogInterface.OnClickListener { dialog, which ->
            // ⑤
            // Chancelボタンが押された時の処理
        })

        return builder.create()  // ⑥
    }
}