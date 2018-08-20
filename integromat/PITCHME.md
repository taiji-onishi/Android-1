# play with integromat

---

## integromat

---

## 話すこと

- integromatとは？
- サービスとの違い
- integromatの簡単な利用方法

---

## 話さないこと

- 細かい＆複雑な設定方法
- integromat以外のアカウント作成＆利用方法

---

## What is integromat?

- 様々なWebサービスを連携させる
- 2016年サービスイン
- (ほぼ)コーディングなしで複数サービスとの連携が可能

---

## 例えば...

![what_is_integromat](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/what_is_integromat.png?raw=true)

---

## 似たようなサービス

![zaiper](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/zaiper.png?raw=true)
![ifttt](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/ifttt.png?raw=true)

---

## 何が違うのか？

- 無料枠が大きい(1000回/月)
- 複数アプリへの同時連携が可能
- (ほぼ)ノンプラミングで利用可能
- カスタマイズがしやすい

---

## 使ってみた

---

## 準備

---

## アカウント作成

![sign_in](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/sign_in.png?raw=true)

- 名前、アドレス、パスワード、国を登録すればOK
- 有料プランはクレジットが必要

---

## 使ってみた①：backlog連携
1. Backlogでメンバーをアサイン
2. Slackへ通知を流す

---

## ①-1. Scenarioの作成

![webhook_1](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_1.png?raw=true)

- DashboardまたはScenariosからCreate a new scenarioを選択

---

## ①-2. Webサービスの選択


![webhook_2](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_2.png?raw=true)

- 連携したいWebサービス名を入力して選択

---

## ①-3. モジュール作成

![webhook_3](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_3.png?raw=true)
![webhook_4](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_4.png?raw=true)|

---

## ①-4. モジュール作成つづき

![webhook_5](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_5.png?raw=true)
![webhook_6](https://github.com/nyanc0/Android/blob/other_knowledge/integromat/images/webhook_6.png?raw=true)

- Addから任意の名前でWebhookを作成(IPは不要)
- saveしたら自動生成されたURLをコピー
- determine data structureは失敗してOK

---

## ①-5. Backlog側の設定
