package training.practice.com.example.yuriyuri.androidtraining

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.widget.TextView
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException


class AsyncTaskOkHttpGet(@SuppressLint("StaticFieldLeak") val textView: TextView) : AsyncTask<Void, Void, String>() {

    override fun doInBackground(vararg voids: Void): String? {
        var result: String? = null
        // リクエストオブジェクトの生成
        val request = Request.Builder()
                .url("http://httpbin.org/headers")
                .get()
                .build()

        // クライアントオブジェクトの生成
        val client = OkHttpClient()

        // リクエストして結果を受け取る
        try {
            val response = client.newCall(request).execute()
            result = response.body()!!.string()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return result
    }

    /**
     * onBackgroundで取得した値をtextViewにセットする。
     *
     * @param result onBackgroundの結果
     */
    override fun onPostExecute(result: String) {
        textView.text = result
    }
}