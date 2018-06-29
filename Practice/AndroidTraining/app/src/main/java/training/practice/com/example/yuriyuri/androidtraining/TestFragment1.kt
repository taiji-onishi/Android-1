package training.practice.com.example.yuriyuri.androidtraining

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class TestFragment1 : Fragment() {

    // リスナー
    lateinit var clickListener: OnFragmentBtnClickListener

    /**
     * インターフェース
     */
    interface OnFragmentBtnClickListener {
        fun onFragment1ButtonClicked()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (!(context is OnFragmentBtnClickListener)) {
            throw ClassCastException("activity が OnFragmentBtnClickListener を実装していません.")
        }
        clickListener = context
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // TestFragment1用のレイアウトファイルからViewを生成
        val fragment1View = inflater!!.inflate(R.layout.test_fragment_1, container, false)

        val button = fragment1View.findViewById<View>(R.id.fragment_callback_button) as Button
        button.setOnClickListener {
            // TextViewの参照の取得
            val titleText = fragment1View.findViewById<View>(R.id.title_from_activity) as TextView
            // getArgumentsで値の取り出し
            val textFromActivity = arguments.getString("test")

            if (!TextUtils.isEmpty(textFromActivity)) {
                // TextViewへセット
                titleText.text = textFromActivity
            }
        }
        return fragment1View
    }
}