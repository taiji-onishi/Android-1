# play with integromat

---

## integromat

---

### 話すこと

- integromatとは？
- サービスとの違い
- integromatの簡単な利用方法

---

### 話さないこと

- 細かい＆複雑な設定方法
- integromat以外のアカウント作成＆利用方法

---

### What is integromat?

- 2016年サービスイン
- 様々なWebサービスの連携機能を提供
- (ほぼ)コーディングなしで複数サービスとの連携が可能

---

### 例えば...

![what_is_integromat](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/what_is_integromat.png?raw=true)

---

### 利用し始めた背景

- アプリ開発チームが自由に使えるサーバーがない
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

### 作ってみたもの
1. Backlogでメンバーをアサイン
2. Slackへ通知を流す

---

### アカウント作成

- 名前、アドレス、パスワード、国を登録すればOK

![sign_in](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/sign_in.png?raw=true)

---

### 1. Scenarioの作成

- DashboardまたはScenariosから  
Create a new scenarioを選択

![webhook_1](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_1.png?raw=true)

---

### 2. Webサービスの選択

- 連携したいWebサービス名を入力して選択

![webhook_2](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_2.png?raw=true)

---

### 3. モジュール作成

![webhook_3](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_3.png?raw=true)
![webhook_4](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_4.png?raw=true)

---

### 4. モジュール作成つづき

- Addから任意の名前でWebhookを作成(IPは不要)
- saveしたら自動生成されたURLをコピー

![webhook_5](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_5.png?raw=true)
![webhook_6](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_6.png?raw=true)

---

### 5. Backlog側の設定

- プロジェクト設定＞インテグレーション＞Webhookを選択
- 任意のWebhook名を入れてSlackへ通知するイベントを選択し、IntegromatでコピーしたURLを入力

![backlog_1](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/backlog_1.png?raw=true)

---

### 6. Backlog側の設定つづき

- 実行テストで通知するイベントを一度実行

![backlog_2](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/backlog_2.png?raw=true)

---

### 7. データ形式を連携

- Re-determine data structureで  
Webhookされるデータ構成をIntegromat側に認識させる

![webhook_7](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_7.png?raw=true)
