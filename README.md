# 課題ブランチ
https://github.com/nyanc0/Android/tree/exercise/android_knowledge/rxjava

- 課題を実施する場合は、このブランチから作業用のブランチを切ってください。
- 作業はForkして行ってください。元のブランチに対してマージなどを勝手に行わないでください。

# 課題内容
## 課題1：TagDataRepository
TagDataRepositoryのrefreshTags(next: Int, perPage: Int, sortType: String)メソッドを修正し、  
QiitaApiを使ってTag一覧を取得し、TagModelに変換して通知してください。  

- QiitaApi#getTagsから通知されるデータ：Flowable<List<Tag>>
- TagsRepository利用クラスに通知するデータ：Flowable<List<TagModel>>

Tag.kt
```kt
@JsonSerializable
data class Tag(
        @Json(name = "followers_count")
        var followersCount: Int,
        @Json(name = "icon_url")
        var tagIconImageUrl: String?,
        @Json(name = "id")
        var tagId: String,
        @Json(name = "items_count")
        var itemsCount: Int
)
```

TagModel.kt
```kt
data class TagModel(
        val followersCount: Int,
        val iconImage: String?,
        val tagId: TagId,
        val itemsCount: Int
)
```

## 課題2：TagsViewModel
TagsViewModelのloadTagListメソッドを修正して、  
TagRepositoryを使ってタグ一覧のデータを取得し、Resultオブジェクトに変換して通知するようにしてください。  
下記Result.ktクラスはDroidKaigi2018のアプリのものを参考(ほぼママ利用)させていただいています。

- TagRepositoryから通知されるデータ：Flowable<List<TagModel>>
- TagsViewModelに通知するデータ：Flowable<Result<List<TagModel>>>

Result.kt
```kt
/**
 * データ取得結果.</br>
 * ViewModelで取得したデータはこのクラスに変換してからViewに引き渡される.
 */
sealed class Result<T>(val inProgress: Boolean) {

    /**
     * データロード中
     */
    class InProgress<T> : Result<T>(true) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false
            return true
        }

        override fun hashCode(): Int = javaClass.hashCode()
    }

    /**
     * データ取得成功
     */
    data class Success<T>(var data: T) : Result<T>(false)

    /**
     * データ取得失敗
     */
    data class Failure<T>(val errorMessage: String?, val e: Throwable) : Result<T>(false)

    companion object {
        fun <T> inProgress(): Result<T> = InProgress()

        fun <T> success(data: T): Result<T> = Success(data)

        fun <T> failure(errorMessage: String, e: Throwable): Result<T> = Failure(errorMessage, e)
    }
}
```

## 課題3：TagFragment
TagFragmentのonActivityCreated内からTagsViewModel#loadTagListメソッドを呼び出し、  
タグ情報を取得してRecyclerViewに表示してください。  
データ通知に応じて、下記の挙動を行うようにしてください。  

- ロード開始通知
  - binding.progress.visibility = View.VISIBLEを呼び出し、ローディングプログレス表示を開始
- ロード完了(成功)通知
  - renderViews(list: List<TagModel>)を呼び出しリストに表示
- ロード完了(失敗)
  - トーストでエラー内容を表示(エラー内容は通知されたデータのmessageを利用すること)
