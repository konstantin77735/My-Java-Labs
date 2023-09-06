## Как легко конвертировать .java в .jar?

Сначала нужно конвертировать, допустим, ComputerConfiguration.java.
Он содержит в себе два класса:

1. public class ComputerConfiguration (это главный класс, потому что public)
2. class PC (это не основной класс, но он используется в ComputerConfiguration) )

Нужно конвертировать ComputerConfiguration.java в байт-код, т.е. в файл с расширение .class.

Компиляция с учётом обратной совместимости с 1.8-версией Java ↓

> ```java
> javac --release 8 ComputerConfiguration.java
> ```

> Просто компиляция, без обратной совместимости ↓
>
> ```java
> javac ComputerConfiguration.java 
> ```

---

### *Мы может протестировать наши .class-файлы (необязательно)

Можем запустить ComputerConfiguration.class (запускает именно .class файл, а не .java) с помощью команды:

> ```java
> java ComputerConfiguration
> ```

P.S. ***Если в*** Вашем** *проекте было несколько классов, то***, соответственно, ***будет создано несколько .class-файлов***.
Значит в одном классе мог использоваться другой класс.
***Поэтому при запуске .class-файлы*** в консоли ***с помощью команды java ComputerConfiguration программа может выдать ошибку.
Это нормально.***
Ваша задача: *из всех .class-файлов создать один .jar-файл, который потом будет конвертирован в .exe-файл.*

---

### Создадим .jar-файл

Для этого нужно создать файл MANIFEST.MF (название капсом) с текстом:
Manifest-Version: 1.0
Main-Class: ComputerConfiguration
class-path: ./

Main-Class: тот класс, который имеет модификатор доступа public. Такой будет только один
class-path: это где находятся .class-файлы, ./ - текущая

Эта команда ↓ берёт файлы ComputerConfiguration.class PC.class и создаётс с ними файл MyProgram.jar

```java
jar cvfm MyProgram.jar MANIFEST.MF ComputerConfiguration.class PC.class
```

---

### Протестируем .jar-файл на совместимость с jdk 1.8

Запустим MyProgram.jar из командной строки с помощью java.exe из jdk1.8.0 (его нужно скачать):

> ```java
> "C:\Program Files (x86)\Java\jdk1.8.0\bin\java.exe" -jar lab_1_8.jar
> ```

Если всё работает, то можно конвертировать .jar в .exe-файл

---

### *Тесты для других версий (это необязательно)

Для той версии, которая в Вашей системе по умолчанию прописана Path (обычно это одна из последних версий) ↓

> ```java
> java -jar MyProgram.jar 
> ```

java - это 20-ая версия java, а мне надо тестировать на 8 и ранее (и на 32бит версии), чтоб в ГМИ работало:

Можем проверить для версии build 8u372-b07 (у меня она установлена) ↓

java (jdk): build 8u372-b07 ↓

> ```java
> "C:\Program Files\Java\jdk-8u372-b07\bin\java.exe" -jar lab_1_8.jar
> ```

---

Конвертируем .jar-файл в .exe:

Перейдём на сайт: https://genuinecoder.com/online-converter/jar-to-exe/
Выберем наш .jar-файл
Выберем: Header type: console (в нашем случае это консольное приложение),
Minimum JRE version: 1.8.0 (т.к. мы подгоняем под эту версию, т.к. она в ГМИ установлена)
Wrap jar within EXE  должен быть включён
*необязательно можно выбрать картинку-иконку с расширением .ico

Нажать "Generate EXE"
После генерации нажать "Download Converted Jar"

---

P.S. Если при запуска скачанного файла вылезает окно "Windows Defender предотвратил запуск неизвестного приложения",
то можно нажать "Подробнее" и там нажать "Выполнить в любом случае"
