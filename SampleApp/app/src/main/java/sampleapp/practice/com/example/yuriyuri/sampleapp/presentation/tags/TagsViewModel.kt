package sampleapp.practice.com.example.yuriyuri.sampleapp.presentation.tags

import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.Flowable
import sampleapp.practice.com.example.yuriyuri.model.TagModel
import sampleapp.practice.com.example.yuriyuri.sampleapp.data.repository.TagRepository
import sampleapp.practice.com.example.yuriyuri.sampleapp.presentation.Result
import sampleapp.practice.com.example.yuriyuri.sampleapp.util.SchedulerProvider
import javax.inject.Inject

/**
 * TagsFragmentのViewModel.</br>
 * TagsFragmentはこのクラスが定義するメソッドからデータ取得を行う
 */
// 課題1：ViewModelを継承させるように変更する
class TagsViewModel @Inject constructor (
        private val repository: TagRepository,
        private val appSchedulerProvider: SchedulerProvider

) :ViewModel() {
    override fun onCleared() {
        super.onCleared()
        Log.d("ViewModelTest", "SampleViewModel: onCleared is Called!!")
    }

    /**
     * タグデータを取得
     *
     * @param nextPage 何ページ目か
     */
    fun loadTagList(nextPage: Int): Flowable<Result<List<TagModel>>> {
        return repository.refreshTags(nextPage, 20, "count")
                .map {
                    Result.success(it)
                }.onErrorReturn { e -> Result.failure(e.message ?: "unknown", e) }
                .observeOn(appSchedulerProvider.ui())
                .startWith(Result.inProgress())
    }
}