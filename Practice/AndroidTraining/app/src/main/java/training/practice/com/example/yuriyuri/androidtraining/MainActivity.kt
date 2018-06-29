package training.practice.com.example.yuriyuri.androidtraining

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


class MainActivity : AppCompatActivity(), TestFragment1.OnFragmentBtnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // FragmentManagerの取得
        val fragmentManager = supportFragmentManager
        // FragmentTransactionの取得
        val fragmentTransaction = fragmentManager.beginTransaction()

        // TestFragment1に渡す値
        val bundle = Bundle()
        bundle.putString("test", "MainActivityからもらったよ")
        val testFragment1 = TestFragment1()
        // TestFragment1にセット
        testFragment1.arguments = bundle

        // コンテナにTestFragment1を挿入する
        fragmentTransaction.add(R.id.container, testFragment1)
        // 画面にFragmentを表示
        fragmentTransaction.commit()
    }

    override fun onFragment1ButtonClicked() {
        // FragmentManagerの取得
        val fragmentManager = supportFragmentManager
        // FragmentTransactionの取得
        val fragmentTransaction = fragmentManager.beginTransaction()

        // TestFragment1をTestFragment2に入れ替え
        fragmentTransaction.replace(R.id.container, TestFragment2())
        // バックスタック制御
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
