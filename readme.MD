Как легко конвертировать .java в .jar?

Сначала нужно конвертировать  (допустим: lab_1_8.java. Он содержит в себе класс lab_1_8)

нужно его конвертировать в байт-код (lab_1_8.class). Компиляция:

> ```java
> javac lab_1_8.java
> ```

> Ещё есть команда
>
> ```java
> javac --release 8 *.java
> ```
>
> Она создаёт .class совместимый с jre-8. но скоро эта команда также устареет, как и сама jre-8

Можем запустить lab_1_8.class (запускает именно .class файл, а не .java) с помощью команды:

> ```java
> java lab_1_8
> ```

Далее нужно создать lab_1_8.jar.

Для этого сначала нужно создать файл MANIFEST.MF с текстом:
Manifest-Version: 1.0
main-class: lab_1_8
class-path: out/

Эта команда ↓ берёт все файлы из папки out и создаёт с ними архив lab_1_8.jar

```java
jar -cmf MANIFEST.MF lab_1_8.jar -C out .
```

lab_1_8.jar - это имя файла, который будет создан.

Запустить lab_1_8.jar из командной строки:

> ```java
> java -jar lab_1_8.jar
> ```

java - это 20-ая версия java, а мне надо тестировать на 8 и ранее (и на 32бит версии), чтоб в ГМИ работало:


java (jdk): build 8u372-b07 ↓

>
> ```java
> "C:\Program Files\Java\jdk-8u372-b07\bin\java.exe" -jar lab_1_8.jar
> ```

java (jdk): build 1.8



java (jdk): build 1.8.0 ↓

> ```java
> "C:\Program Files (x86)\Java\jdk1.8.0\bin\java.exe" -jar lab_1_8.jar
> ```
