# ビルドツール(1) make / ant  について

## makeコマンド

1. プログラムのビルド作業を自動化する

2. コンパイル、リンク、インストール等のルールを記述したテキストファイル (Makefile) に従って、これらの作業を実行する

3.  C/C++言語だけでなく、Java言語にも適用することができる。

> 構成ファイル: Makefile, makefile

> ディレクトリ構造は、特に決まっていない。わかりやすくするために、実行モジュールごと、または、ライブラリごとで、ディレクトリが作成される。

> makeの構成ファイルで、生成したいオブジェクト: ソースコード または 生成したいオブジェクト: 中間ファイル を書いて、２行目は TAB で字下げして、コンパイラを指定する。 その後のマクロ記号は ソースとなるコードで置き換えられる。

```Makefile

HelloWorld.class: HelloWorld.java
    javac $<

```

> 最もシンプルなJavaのソースコード


```java

public class HelloWorld {
      public static void main(String[] args) {
                System.out.println("Hello World");
                    }
}

```

> 材料となるファイルのリスト、コンパイル実行、プログラム実行を順番に実行した例である。

```vim

$ ls
HelloWorld.java Makefile

$ make
javac HelloWorld.java

$ java HelloWorld
Hello World

```

-------------------------

## Ant コマンド

> AntはJavaで書かれたプログラムで、Javaアプリケーションのコンパイル、アセンブル、テスト、および実行を可能にする多数の組み込みタスクを提供する。AntはJavaクラスを使用して拡張できる。構成ファイルはXMLベースで、タスクを呼び出す。


> 構成ファイル: `build.xml`
> コマンドのインストール: $ `brew install ant`

``` vim
.
├── build.xml
└── src
    └exm
            └─ HelloWorld.java
```

> 構成ファイルでは、target としてタスクを記述、そして、前提となる depend を作成する


### build.xml

```xml
<project name="HelloWorld" basedir="." default="main">
  <property name="src.dir"     value="src"/>
  <property name="build.dir"   value="build"/>
  <property name="classes.dir" value="${build.dir}/classes"/>
  <property name="jar.dir"     value="${build.dir}/jar"/>
  <property name="main-class"  value="tkr.HelloWorld"/>

  <target name="clean">
    <delete dir="${build.dir}"/>
  </target>

  <target name="compile">
    <mkdir dir="${classes.dir}"/>
    <javac srcdir="${src.dir}" destdir="${classes.dir}"/>
  </target>

  <target name="jar" depends="compile">
    <mkdir dir="${jar.dir}"/>
    <jar destfile="${jar.dir}/${ant.project.name}.jar" basedir="${classes.dir}">
      <manifest>
        <attribute name="Main-Class" value="${main-class}"/>
      </manifest>
    </jar>
  </target>

  <target name="run" depends="jar">
    <java jar="${jar.dir}/${ant.project.name}.jar" fork="true"/>
  </target>

  <target name="clean-build" depends="clean,jar"/>
  <target name="main" depends="clean,run"/>

</project>
```

```java
package tkr;

public class HelloWorld {
      public static void main(String[] args) {
                System.out.println("Hello World");
                    }
}

```

> ant によるコンパイルの実行

```vim

$ ant compile
Buildfile: /Users/xxx/web-apl/test-ant/build.xml

compile:
    [mkdir] Created dir: /Users/maho/web-apl/test-ant/build/classes
        [javac] /Users/maho/web-apl/test-ant/build.xml:14: warning: 'includeantruntime' was not set, defaulting to build.sysclasspath=last; set to false for repeatable builds
            [javac] Compiling 1 source file to /Users/maho/web-apl/test-ant/build/classes

            BUILD SUCCESSFUL
            Total time: 0 seconds

```


> ant によるJavaコードの実行

```vim

maho:test-ant maho$ ant run
Buildfile: /Users/maho/web-apl/test-ant/build.xml

compile:
    [javac] /Users/maho/web-apl/test-ant/build.xml:14: warning: 'includeantruntime' was not set, defaulting to build.sysclasspath=last; set to false for repeatable builds

    jar:
        [mkdir] Created dir: /Users/maho/web-apl/test-ant/build/jar
              [jar] Building jar: /Users/maho/web-apl/test-ant/build/jar/HelloWorld.jar

              run:
                   [java] Hello World

                   BUILD SUCCESSFUL
                   Total time: 0 seconds

```

> ant によって Jarファイルを作成して、実行する。

```vim

$ ant jar
Buildfile: /Users/maho/web-apl/test-ant/build.xml

compile:
    [javac] /Users/maho/web-apl/test-ant/build.xml:14: warning: 'includeantruntime' was not set, defaulting to build.sysclasspath=last; set to false for repeatable builds

    jar:

    BUILD SUCCESSFUL
    Total time: 0 seconds

    $ tree
    .
    ├── build
    │   ── classes
    │   │   ── tkr
    │   │       ── HelloWorld.class
    │   └── jar
           └─ HelloWorld.jar
           ├─ build.xml
           └─ src
               ── tkr
                       └── HelloWorld.java

                       6 directories, 4 files

                       $ java -jar build/jar/HelloWorld.jar 
                       Hello World
```

# 参考

[ウィキペディア Apache Ant](https://ja.wikipedia.org/wiki/Apache_Ant)  

[Ant プロジェクト ホームページ](http://ant.apache.org/)  

[Ant ソースコード](https://git-wip-us.apache.org/repos/asf?p=ant.git)  

[Tutorial: Hello World with Apache Ant](https://ant.apache.org/manual/tutorial-HelloWorldWithAnt.html)  


