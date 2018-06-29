package training.practice.com.example.yuriyuri.androidtraining

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * コンストラクタ
 */
class TestFragment3 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // TestFragment1用のレイアウトファイルからViewを生成
        return inflater.inflate(R.layout.test_fragment_3, container, false)
    }
}