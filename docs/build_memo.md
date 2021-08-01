# �r���h�c�[��(1) make / ant  �ɂ���

## make�R�}���h

1. �v���O�����̃r���h��Ƃ�����������

2. �R���p�C���A�����N�A�C���X�g�[�����̃��[�����L�q�����e�L�X�g�t�@�C�� (Makefile) �ɏ]���āA�����̍�Ƃ����s����

3.  C/C++���ꂾ���łȂ��AJava����ɂ��K�p���邱�Ƃ��ł���B

> �\���t�@�C��: Makefile, makefile

> �f�B���N�g���\���́A���Ɍ��܂��Ă��Ȃ��B�킩��₷�����邽�߂ɁA���s���W���[�����ƁA�܂��́A���C�u�������ƂŁA�f�B���N�g�����쐬�����B

> make�̍\���t�@�C���ŁA�����������I�u�W�F�N�g: �\�[�X�R�[�h �܂��� �����������I�u�W�F�N�g: ���ԃt�@�C�� �������āA�Q�s�ڂ� TAB �Ŏ��������āA�R���p�C�����w�肷��B ���̌�̃}�N���L���� �\�[�X�ƂȂ�R�[�h�Œu����������B

```Makefile

HelloWorld.class: HelloWorld.java
    javac $<

```

> �ł��V���v����Java�̃\�[�X�R�[�h


```java

public class HelloWorld {
      public static void main(String[] args) {
                System.out.println("Hello World");
                    }
}

```

> �ޗ��ƂȂ�t�@�C���̃��X�g�A�R���p�C�����s�A�v���O�������s�����ԂɎ��s������ł���B

```vim

$ ls
HelloWorld.java Makefile

$ make
javac HelloWorld.java

$ java HelloWorld
Hello World

```

-------------------------

## Ant �R�}���h

> Ant��Java�ŏ����ꂽ�v���O�����ŁAJava�A�v���P�[�V�����̃R���p�C���A�A�Z���u���A�e�X�g�A����ю��s���\�ɂ��鑽���̑g�ݍ��݃^�X�N��񋟂���BAnt��Java�N���X���g�p���Ċg���ł���B�\���t�@�C����XML�x�[�X�ŁA�^�X�N���Ăяo���B


> �\���t�@�C��: `build.xml`
> �R�}���h�̃C���X�g�[��: $ `brew install ant`

``` vim
.
������ build.xml
������ src
    ��exm
            ���� HelloWorld.java
```

> �\���t�@�C���ł́Atarget �Ƃ��ă^�X�N���L�q�A�����āA�O��ƂȂ� depend ���쐬����


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

> ant �ɂ��R���p�C���̎��s

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


> ant �ɂ��Java�R�[�h�̎��s

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

> ant �ɂ���� Jar�t�@�C�����쐬���āA���s����B

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
    ������ build
    ��   ���� classes
    ��   ��   ���� tkr
    ��   ��       ���� HelloWorld.class
    ��   ������ jar
           ���� HelloWorld.jar
           ���� build.xml
           ���� src
               ���� tkr
                       ������ HelloWorld.java

                       6 directories, 4 files

                       $ java -jar build/jar/HelloWorld.jar 
                       Hello World
```

# �Q�l

[�E�B�L�y�f�B�A Apache Ant](https://ja.wikipedia.org/wiki/Apache_Ant)  

[Ant �v���W�F�N�g �z�[���y�[�W](http://ant.apache.org/)  

[Ant �\�[�X�R�[�h](https://git-wip-us.apache.org/repos/asf?p=ant.git)  

[Tutorial: Hello World with Apache Ant](https://ant.apache.org/manual/tutorial-HelloWorldWithAnt.html)  


