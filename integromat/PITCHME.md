# Let's play with integromat

---

## integromat
https://www.integromat.com/en/

---

### 話すこと

- integromatとは？
- 他サービスとの違い
- 簡単な利用方法

---

### 話さないこと

- 細かい設定方法
- その他のアカウント作成＆利用方法

---

### What is integromat?

- 2016年サービスイン
- 様々なWebサービスの連携機能を提供
- (ほぼ)ノンコーディングで複数サービス連携が可能

---

### 例えば...

![what_is_integromat](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/what_is_integromat.png?raw=true)

---

### 利用し始めた背景

- 自由に使えるサーバーがない
- インフラ構築の知識もない
- 改善のための工数がそれほど取れない  

#### @color[orange](環境構築不要＆開発工数がかからない)

---

### 似たようなサービス

![zaiper](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/zaiper.png?raw=true)  
![ifttt](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/ifttt.png?raw=true)

---

### 何が違うのか？

- 無料枠が大きい(1000回/月)
- 複数アプリへの同時連携が可能
- (ほぼ)ノンプラミングで利用可能
- カスタマイズがしやすい

---

### 作ったもの
1. Backlogでメンバーをアサイン
2. Slackへ通知を流す

---

### 1. Scenarioの作成

---

### 1-1. DashboardまたはScenariosから<br>Create a new scenarioを選択

![webhook_1](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_1.png?raw=true)

---

### 1-2. Webサービスの選択

![webhook_2](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_2.png?raw=true)

---

### 2. モジュールの作成
モジュール = 連携するサービス

---

### 2-1. Webhookモジュールの作成

![webhook_3](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_3.png?raw=true)
![webhook_4](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_4.png?raw=true)

---

### 2-2. URLを取得

![webhook_5](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_5.png?raw=true)
![webhook_6](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_6.png?raw=true)

---

### 2-3. WebhookにURLを設定

![backlog_1](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/backlog_1.png?raw=true)

---

### 2-4. integromatにデータ形式を反映

![backlog_2](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/backlog_2.png?raw=true)
![webhook_7](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_7.png?raw=true)

---

### 2-5. Slackモジュールの作成
<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/slack_1.png?raw=true" height="600">

---

### 2-6. メッセージの設定
![slack_2](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/slack_2.png?raw=true)

---

### 完成！！
![slack_3](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/slack_3.png?raw=true)

---

### Webookの連携であれば非常に簡単

---

### 作ったもの：その2

1. Gmailで特定のメールを受け取る
2. 本文のエンコード＆加工
2. Slackに内容を連携

---

### 全体像

![gmail_0](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/gmail_0.png?raw=true)

---

### Gmailを受け取って
![gmail_1](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/gmail_1.png?raw=true)

---

### Jsonを作成しAPIへ

![gmail_2](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/gmail_2.png?raw=true)

---

### 加工して

![gmail_3](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/gmail_3.png?raw=true)

---

### パース

![gmail_4](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/gmail_4.png?raw=true)

---

### 送信元別にSlackへ通知

![gmail_5](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/gmail_5.png?raw=true)

---

### 完成形

![gmail_7](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/gmail_7.png?raw=true)

---

### 3. Jsonの作成とパース

---

### 3-1. 作成
- フィールド名にデータを紐づければOK

<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/gmail_8.png?raw=true" height="600">

---

### 3-2. パース
- データストラクチャとデータを選択すればOK

<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/gmail_9.png?raw=true" height="600">

---

### 4. APIの作成

1. Jsonを受け取る
2. エンコード
3. 特定のURLの抜き出し
4. Slack通知用に文字数をカット
5. 新たなJsonを作成して返す

---

### ここもサーバレスでやりたい

---

### Azure Functions
- サーバー構築不要
- 枠内であれば無料で利用可能
- JS,C#,F#で作成可能

---

### 4-1. 関数の作成

![gmail_10](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/gmail_10.png?raw=true)

---

### 4-2. APIURLと連携するデータを選択すればOK

<img src="https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/gmail_11.png?raw=true" height="600">

---

### 5. Rooterによる振り分け
- フィルターを設定することで複数のサービスに同時通知可能
- 連携するサービスに制限なし
- 簡単な関数も設定可能

---

### 5-1. 送信元でフィルターを設定

![gmail_12](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/gmail_12.png?raw=true)

---

Rooterによって通知振り分けができている  
![gmail_7](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/gmail_7.png?raw=true)

---

### もう少し詳しい使い方
リンク貼る予定

---

Thank you.
