# todo
## EC2にTODOに上げた手順
* AWSのEC2に新しいインスタンスを作成
* ローカルでec2にsshで繋ぐ
* buildフォルダのlibsフォルダのjarファイルをsftpでアップロードする
* `java -jar todo-0.0.1-SNAPSHOT.jar`で実行

## 参考資料
* EC2
  * https://qiita.com/yseki_/items/81c84d78895b009c2aa6
  * https://docs.aws.amazon.com/ja_jp/corretto/latest/corretto-11-ug/amazon-linux-install.html
* MySQL
  * https://qiita.com/2no553/items/952dbb8df9a228195189
* port番号を非表示
  * http://rainbow-engine.com/access-website-onlydomain/
