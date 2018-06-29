package training.practice.com.example.yuriyuri.androidtraining

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

/**
 * コンストラクタ
 */
class TestFragment2 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val fragment2View = inflater.inflate(R.layout.test_fragment_2, container, false)

        // ボタンの参照の取得
        val button = fragment2View.findViewById<View>(R.id.call_fragment3_button) as Button
        button.setOnClickListener {
            // FragmentManagerの取得
            val fragmentManager = activity.supportFragmentManager
            // FragmentTransactionの取得
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, TestFragment3())
            // バックスタック制御
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        return fragment2View
    }
}