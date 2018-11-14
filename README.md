# 課題ブランチ
https://github.com/nyanc0/Android/tree/answers/aac_view_model

- 課題を実施する場合は、このブランチから作業用のブランチを切ってください。
- 作業はForkして行ってください。元のブランチに対してマージなどを勝手に行わないでください。

# 課題内容
## 課題
下記のクラスをAACのViewModelを継承したクラスに変更し、TagsFragmentで利用できるようにしてください。  
Daggerを利用する必要性は必ずしもありません。

- TagsViewModel

```kt
// 課題1：ViewModelを継承させるように変更する
class TagsViewModel @Inject constructor(
        private val repository: TagRepository,
        private val appSchedulerProvider: SchedulerProvider
){

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
```
