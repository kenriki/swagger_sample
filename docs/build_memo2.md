# ビルドツール(2) maven / gradle  について

## mavenとは

> Mavenは Javaベースのプロジェクトの構築と管理に使用できるツールである。`Apache Ant`に代わるものとして作られた。`pom.xml`ファイルは、`Maven`でのプロジェクトの構成の中核である。プロジェクトをビルドするために必要な情報の大部分を含む単一の構成ファイルだ。`pom.xml` を効果的に使用するためにすべての複雑さを理解する必要はない。

### Maven プロジェクトの作成
> 次のコマンドで、雛形となるプロジェクトを作成できる。

```pom.xml
$ mvn archetype:generate -DgroupId=org.tkr.app -DartifactId=hello-world -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```

> プロジェクトを作成すると、テンプレートになる pom.xml と src ディレクトリとソースコードを作成する。


## gradleとは
> Gradleは、ビルドの自動化と多言語開発のサポートに重点を置いたビルドツールだ。Gradleは、Java、Scala、Android、C/C++、Groovyなどの複数の言語とプラットフォームにわたるビルド自動化をサポートする、そして、IDEである Eclipse、IntelliJ、Jenkins などに統合されている。


### Gradle の実行方法
> Gradleはタスクを追加できる。そして、次のコマンドは、タスクのリストは追加されたものを含めて表示する。

