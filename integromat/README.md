# Integromat
## Integromatとは
- 2016年サービスイン
- 様々なWebサービスの連携機能を提供
- (ほぼ)ノンコーディングで複数サービス連携が可能

## 連携できるサービス
SlackやGithubはもちろん、Office系のソフトにも対応しています。  
https://www.integromat.com/en/integrations

## Integromatの特徴
- 無料枠が大きい(1000回/月)
- 複数アプリへの同時連携が可能
- (ほぼ)ノンプラミングで利用可能
- カスタマイズがしやすい

## 使い方
ここではBacklogのWebhookを利用して、  
チケットが誰かにアサインされたらその情報をSlackに通知するScenarioを例にIntegromatの使い方を説明します。

### 1. アカウントの作成
Sign inからName,Email,Password,国を入れればOKです。
https://www.integromat.com/en/

<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readme_1.png?raw=true" height="500">

### 2. Scenarioの作成
Integromatは1つのWebサービス連携群を1Scenarioとして管理します。  
DashboardまたはScenariosから「+ Create a new scenario」を選択します。  

<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_1.png?raw=true">

### 3. モジュールの選択
「+ Create a new scenario」を選択したら、連携するWebサービスを選択します。  
今回はWebhookとSlackを利用するため、「Webhooks」と「Slack」モジュールを選択します。  
選択したら画面右上のContinueを選択します。

<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_2.png?raw=true">

### 4. モジュールの作成
Scenario作成の画面に移行するので、モジュールを作成していきます。  
1サービス = 1モジュールと考えて良いです。  
画面上でダブルクリックするとモジュールを追加できます。  

#### 4-1. Webhookモジュールの作成
空モジュールを選択し、「Webhooks」を選択します。  

<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_3.png?raw=true">

次に、「Custom webhook」を選択します。

<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_4.png?raw=true">

「Add」を選択し、任意のWebhook名を入れます。

<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readme_2.png?raw=true">

名前を入れたら自動生成されるURLをコピーします。  
このURLをWebhook側に登録することでIntegromatへの連携が可能になります。  
<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readme_3.png?raw=true" height="500">

#### 4-2. Backlogの設定
Backlogのプロジェクト設定からインテグレーションを選択し、Webhookを選択します。
<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readme_4.png?raw=true">

Webhookを追加するを選択。  
<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readme_5.png?raw=true">

任意のWebhook名(この名前はIntegromatと合わせなくてもOK)、説明を入れ、Webhook先のURLにIntegromatで自動生成されたアドレスを入れます。  
また、Webhookで通知するイベントを選択します。今回は課題の更新のみにチェックを入れています。

<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readme_6.png?raw=true" height="500">

次に、画面下部にある実行テストから「課題の更新」を選択し、「実行」を行います。  

<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readme_7.png?raw=true">

Integromatに戻ると、データストラクチャが読み込まれていることが確認できます(Successfully determined.の部分)。  

<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readme_8.png?raw=true" height="500">

#### 4-3. Slackモジュールの作成
Webhookモジュールの設定ができたら、Slackモジュールの作成を行います。  
Webhookと同じように空のモジュールを作成し、Slackを選択します。  
今回はチャンネルにメッセージを通知したいので、「Create a message」を選択します。  
<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readme_9.png?raw=true" height="500">

Addを選択し、任意のConnection名を入れます。  
<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readme_10.png?raw=true" height="500">

Continueを選択するとSlackのURLを選択する先が表示されるので連携先のSlackを選択します。  
連携先を選択したら、「Where to send the messages」で「to a selected channel」を選択し、  
Channelにメッセージを流すチャンネルを入れます。今回はbacklogチャンネルを作成したので、backlogチャンネルを設定しています。

<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readme_11.png?raw=true" height="500">

#### 4-4. メッセージの設定
Slackにどのようなメッセージを通知するのかを設定します。  
Slackモジュール選択時に表示される、「show advanced settings」を選択します。  

<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readme_12.png?raw=true">

一番下にあるMessage attachmentsで「Add an attachment」を選択します。  

<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readme_13.png?raw=true">

今回は下記のような連携通知を作成します。  

<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/gmail_7.png?raw=true">

正しくIntegromat側でBacklogのデータストラクチャが読み込まれている場合、  
入力フィールドにフォーカスを当てると挿入できるデータをIntegromat側から表示してくれます。  

<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readne_14.png?raw=true">

ここでは以下のように値を入れました。  

- デスクトップ通知時の文言  
<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readne_16.png?raw=true">

- カラー設定  
<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readne_15.png?raw=true">

- タイトルの上に出る文言  
<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readne_17.png?raw=true">

- タイトルとタイトルタップ時のリンク設定  
<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readne_18.png?raw=true">

- タイトル下の文言  
<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readne_19.png?raw=true">


他にも、アイコンの設定やフッターの設定もできます。  
Slackの通知仕様については[こちら](https://api.slack.com/docs/message-formatting)を確認してください。

### 5. フィルターの設定
フィルターを設定しない場合、BacklogのWebhookで有効にした更新内容が全て通知されます。  
特定の更新内容に絞って更新したい場合はWebhookモジュールとSlackモジュールの間にフィルターを設定します。

<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readne_20.png?raw=true">

今回は、Backlogのデータストラクチャのうち、contentフィールド内のchanges配列に「assigner」が含まれる場合のみSlackモジュールに通知を送るように設定しています。
Conditionには簡単な関数も設定することができるため、単純な条件分岐であればフィルター内に設定するだけで設定が完結します。


### 6. 通知頻度の設定
画面左下の「Run once」を選択すると、一度だけ作成したScenarioを動かすことができます。  
<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readne_22.png?raw=true">


連携に問題がなければ、Schedulingスイッチの横にある、時計マークを選択し、通知頻度を設定します。  
<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readne_21.png?raw=true">

即時通知であれば、Immediatelyを設定してください。  
あとは保存すれば設定は完了です。

## Tips
### 任意のAPIと連携させたい場合
任意のAPIと連携させたい場合はHTTPモジュールを利用します。  
単にリクエストを送信したい場合は、Make a requestで十分です。  

<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readne_23.png?raw=true">

### 1つの通知から複数の連携先へ連携させたい場合
1つのイベントから複数の連携先へ通知などを送る場合はRooterを利用します。  
通知の振り分けはFilterを使って設定します。

<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/readne_24.png?raw=true">
