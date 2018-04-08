package sampleapp.practice.com.example.yuriyuri.sampleapp.presentation.tags

import io.reactivex.Flowable
import sampleapp.practice.com.example.yuriyuri.model.TagModel
import sampleapp.practice.com.example.yuriyuri.sampleapp.data.repository.TagDataRepository
import sampleapp.practice.com.example.yuriyuri.sampleapp.data.repository.TagRepository
import sampleapp.practice.com.example.yuriyuri.sampleapp.presentation.Result
import sampleapp.practice.com.example.yuriyuri.sampleapp.util.AppSchedulerProvider
import sampleapp.practice.com.example.yuriyuri.sampleapp.util.SchedulerProvider

/**
 * TagsFragmentのViewModel.</br>
 * TagsFragmentはこのクラスが定義するメソッドからデータ取得を行う
 */
class TagsViewModel {

    private val appSchedulerProvider: SchedulerProvider = AppSchedulerProvider()
    private val repository: TagRepository = TagDataRepository()

    /**
     * タグデータを取得
     *
     * @param nextPage 何ページ目か
     */
    fun loadTagList(nextPage: Int): Flowable<Result<List<TagModel>>>? {
        return repository.refreshTags(nextPage, 20, "count")
                .map {
                    Result.success(it)
                }.onErrorReturn { e -> Result.failure(e.message ?: "unknown", e) }
                .observeOn(appSchedulerProvider.ui())
                .startWith(Result.inProgress())
    }
}