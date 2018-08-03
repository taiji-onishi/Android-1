# 課題ブランチ
https://github.com/nyanc0/Android/tree/exercise/android_knowledge/dagger

- 課題を実施する場合は、このブランチから作業用のブランチを切ってください。
- 作業はForkして行ってください。元のブランチに対してマージなどを勝手に行わないでください。

# 課題内容
## 課題
下記のオブジェクトをDaggerを使ってInjectできるようにし、  
TagDataRepositoryのコンストラクタをQiitaApi、SchedulerProviderを引数にもつコンストラクタに変更し、  
それぞれの引数のオブジェクトをコンストラクタInjectionで注入してください。

- OkHttpClient
- Retrofit
- QiitaApi

SchedulerProviderについては、すでにAppModuleでInject対象にしており、Injectできるようになっています。  
また、NetworkClientは利用しないため削除してください。  

TagDataRepository.kt
```kt
// ここに引数ありのコンストラクタでInjectできるようにする
class TagDataRepository : TagRepository {

    // 課題：
    // NetworkClientクラスを削除し、QiitaApiとSchedulerProviderを
    // TagDataRepositoryのコンストラクタでInjectして渡してください.
    // SchedulerProviderはすでにAppModuleで指定され、Injectできるようになっています.

    private val netWorkClient: NetworkClient = NetworkClient.instance
    private val qiitaApi: QiitaApi = netWorkClient.provideQiitaApi()
    private val appSchedulerProvider: SchedulerProvider = AppSchedulerProvider()

    override fun refreshTags(next: Int, perPage: Int, sortType: String): Flowable<List<TagModel>> {
      // 省略
    }
}
```
