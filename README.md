Example of Selenium/Serenity project.


Lesson 1
Testing Web Applications with Serenity. Serenity BDD. Serenity structure
links:
https://serenity-bdd.github.io/theserenitybook/latest/web-testing-in-serenity.html
https://serenity-bdd.github.io/theserenitybook/latest/page-objects.html

Serenity wrapper требует соблюдения правил структуры проекта, иначе не будет формироватся отчет
Serenity, так в проекте нам нужно использовать прослойку Steps для обработки методов классов Page.

Переинициализация клонированого проэкта с Git
Сначала нужно удалить папку git с записями истории в директории проекта (она default disabled)
C:\Users\Dell\IdeaProjects\serenity-selenium-22.07.19>git init
C:\Users\Dell\IdeaProjects\serenity-selenium-22.07.19>git remote add origin https://github.com/omkhrystenko/serenitySelenium.git
C:\Users\Dell\IdeaProjects\serenity-selenium-22.07.19>git add --all
C:\Users\Dell\IdeaProjects\serenity-selenium-22.07.19>git status
C:\Users\Dell\IdeaProjects\serenity-selenium-22.07.19>git commit -m "initial commit"

Подвязка проэкта под IDE
Нужно переинициализировать структуру залитого проекта и подключить модули, для этого
File -> Project structure -> Modules -> Проставить разметку на папки (напр. java - Test, test.java.resourсes - Test Resourсes,
main - Sources и т.д.


Home Task #1:
Implement successfulLoginTest()
- Explore documentation for Serenity PageObject and use it to implement test scenario
- Add .gitignore and README.md to your project and share it on GitHub


Lesson 2
Using cloud web and mobile testing platforms for remote test launching (f.e. BrowserStack, SauceLabs)
1)Для запуска тестов на платформе в облаке нам нужно сначала создать свой акаунт. Так как эти платформы
платные то создаем Trial вариант.
2)Заходим в свой профайл выбираем Summary - сдесь мы видим сколько времени у нас осталось для бесплатного
запуска тестов на этом аккаунте
3)В профайле открываем закладку Settings - сдесь мы можем взять ключи "Username" и "Access Key" их
потом нужно прописать в properties RemoteDriver или передать через командную строку во время запуска тестов
(разделитель - ":").
Пример:
a) С агрегацией отчета Serenity (test может не работать поэтому мы использовали verify):
mvn clean test serenity:aggregate
-Dmaven.clean.failOnError=false
-Dmaven.test.failure.ignore=true
-Dwebdriver.remote.url=https://olehxxxxxxxxxnko1:ruMfFmLKxRh6hj78A6HH@hub-cloud.browserstack.com/wd/hub
-Dwebdriver.remote.driver=chrome
-Dwebdriver.remote.os=WINDOWS
-Dwebdriver.remote.os_version=10
-Dwebdriver.remote.browserstack.debug=true
-Dchrome.switches="--no-sandbox,--ignore-certificate-errors,--homepage=about:blank,--no-first-run"

b) Без агрегации отчета Serenity
mvn clean verify
-Dwebdriver.remote.url=http://kjhghgtau1:uyiyizD67oGnPsU6RsK9N@hub-cloud.browserstack.com/wd/hub
-Dwebdriver.remote.os="WINDOWS"
-Dwebdriver.remote.os_version="10"
-Dwebdriver.remote.driver=Chrome

Собрать отчет Serenity мы можем если у нас к проекту помимо плагинов Serenity подключен плагин
"maven-surefire-plugin". Отчет генерится из папки target -> site -> serenity -> index.html.

Home Task #2
1. Complete successfulLoginTest() using serenity approach
- use structure that we initiated during the lesson
- feel free to read Serenity documentation for more examples
2. Make sure your test is running on BrowserStack
- also make sure Serenity report is generated


Lesson 3
Serenity BDD. Gherkin language in serenity.

links:
http://thucydides.info/docs/serenity-staging/

Для подключения BDD Serenity в pom файл нужно прописать dependency "net.serenity-bdd.serenity-jbehave".

Serenity BDD проект строится на базе gherkin language (GIVEN - WHEN - THEN). Для описания функционала
тест кейса в директории src -> test -> resources (для подвязки к папке test, правый клик на resources ->
Mark Directory as -> Test Resources Root) создаем пакет "story", а в нем файл "login" с разрешением
".story", Intelij предложит нам установить плагин для чтения файлов с таким разрешением из перечня
плагинов выбираем плагин Khumar. Синтаксис файла login.story должен подсвечиватся плагином.

Home Task #3:
- Install Doker for Windows
- Make sure you have privileges to run selenoid binaries

https://medium.com/@Volirik/%D0%BA%D0%B0%D0%BA-%D1%83%D1%81%D1%82%D0%B0%D0%BD%D0%BE%D0%B2%D0%B8%D1%82%D1%8C-%D0%B8-%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D1%8C-docker-%D0%BD%D0%B0-windows-1f430c82732e


Lesson 4
Docker. Selenoid.

links:
https://aerokube.com/selenoid/latest/
https://johnfergusonsmart.com/running-individual-scenarios-jbehave-cucumber-serenity-bdd/
https://github.com/aerokube/cm/releases/tag/1.6.0
https://aerokube.com/cm/latest/

Selenoid is a kind of Selenium Hub (separate utility for selenium that allows you to work remotely).
(F.e. Selenium hub is installed on separate server with linux and gives us its URL and port, and using
this data in driver properties on our computer we can run tests on selenium hub server from our computer
with Windows). Selenium hub gives us opportunity to divide code and browsers to separate computers.

Docker allows you to implement different OS virtual machines on the server where selenium hub was installed.
G.G.R. (kind of Selenoid for launching on CMD project)

- Установка Docker на Windows происходила через файл DockerToolbox.exe скачанный по ссылке которую прислали в Home Task #3
запуск доккера через иконку на рабочем столе DockerToolbox однако она не у всех заработала.

Витек устанавливал Docker с официального сайта для его установки сначала нужно зарегистрироваться на https://www.docker.com/
-> Sign In -> Create Account -> Ввести Docker ID (как бы свой ник в системе), почту и пароль. (Позже данные должны
понадобится при установке Docker)
Также нужно скачать установочный файл для своей ОС. Установка доступна из своего профайла.

Запуск докера на win10 (Коментарий Вити):

Go to Docker Settings - General
Turn on flag "Expose daemon on tcp://localhost:2375 without TLS"
Check if file present: C:\Users\loboda_v\.docker\daemon.json

In PowerShall execute:
1. to create+start conteiner from images:
docker run -d                                         `
 --name selenoid                                         `
 -p 4444:4444                                            `
 -v /var/run/docker.sock:/var/run/docker.sock           `
 -v C:\Users\<user_name>\.aerokube\selenoid:/etc/selenoid/:ro                 `
 aerokube/selenoid:latest-release

2. to stop conteiner:
docker stop selenoid

3. to start conteiner:
docker start selenoid

4. to start selenoid-ui:
.\cm selenoid-ui start

5. to stop selenoid-ui:
.\cm selenoid-ui stop


- Установка Selenoid:
We use manual for install on link https://aerokube.com/selenoid/latest/ there we need to load binary
files first: Configuration Manager (link https://github.com/aerokube/cm/releases/tag/1.6.0) for Selenoid
file cm_windows_amd64.exe

a)Меняем имя скачанного файла на cm.exe и запускаем в командной строке (на win 10 - WIN + R  cmd):
> ./cm.exe selenoid start --vnc (в виндовс cm.exe selenoid start --vnc) после установки докера в ЦМД запустили скачаный эксешник через эту команду
Началось подкачивание образов доккера. Это конфигур. менеджер который 1) проверяет есть ли доккер, 2)достает образ селеноида,
команда vnc ри старте браузера дает возможность потом простматривать видео.

3)Достает образы операционных систем и браузеров (в этих образах наодится ОС Убунту и версии браузеров)
Эти образы подключаются к докеру и через докер могут взаимодействовать с селеноидом и через него с нашим кодом
cm.exe это мы переименовали скачанный файл cm_windows_amd64.exe

b)Скачиваем интерфейс для Selenoid
$ ./cm selenoid-ui start   выкачивает образы которые имеют удобный интерфейс
cm это мы переименовали скачанный файл cm_windows_amd64.exe (запускаем через коммандную строку)
Интерфейс запускается в браузере на http://localhost:8080/#/;
Команда для запуска:
docker run -d --name selenoid-ui -p 8080:8080 aerokube/selenoid-ui --selenoid-uri http://${SELENOID_HOST}:4444

В коде нужно отобразить соответствующие property и driver:

DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setBrowserName("chrome");
capabilities.setVersion("76.0");
capabilities.setCapability("enableVNC", true);
capabilities.setCapability("enableVideo", false);

RemoteWebDriver driver = new RemoteWebDriver(
    URI.create("http://localhost:4444/wd/hub").toURL(),
    capabilities
);

Или что удобнее прописать параметры запуска тестов в файле serenity.properties

serenity.project.name=Web tests.
serenity.console.colors=true
serenity.logging=VERBOSE

webdriver.driver=chrome
webdriver.remote.url=http://172.29.147.226:4444/wd/hub        - 172.29.147.226 - это локальная айпишка Коли, заместь localhost, т.е. если он на своей машине запустил Docker то мы можем через айпишник его машины конектится к нему и запускать на его машине тесты с наших машин

serenity.driver.capabilities="browserName:chrome;enableVNC:true;enableVideo:true;"

chrome.switches="--start-maximized"

Home Task #4:
Run created BDD feature for Login
- Make sure proper Jbehave plugin installed in IDEA
- Follow this article to complete home Task: https://johnfergusonsmart.com/running-individual-scenarios-jbehave-cucumber-serenity-bdd/


Lesson 5

docker ps - команда командной строки показывает запущенные в текущий момент контейнеры


selenoid ui
- раздел capabilities: в закладке select browser содержит перечень доступных браузеров
по умолчанию подтягиваются 3 браузера по 2 версии chrome, firefox, opera. Для открытия сессии выбираем нужную нам
версию браузера и нажимаем create session в разделе stats запустится контейнер с указанной версией браузера.

- раздел stats: содержит в себе открытые сессии, а также показывает какое количиство сессий еще можно открыть
(максимум 5 сесий на одной машине с доккером, если хотим открыть больше то нужно запускать еще одну машину с доккером
и на ней сможем открыть еще пять, для управления несколькими машинами с доккерами используется специальный UI,
который предусматривает возможность умравления контейнерами на нескольких машинах, а также администрирование
доступами к тому или иному количеству контейнеров разными юзерами, которые будут пытаться присоединиться к нему.)

- раздел videos - ранилище видео прохождения тестов.

В UI можно запускать автотесты через указанеие линки, напр. указаная в serenity.properties (webdriver.remote.url=http://172.29.147.226:4444/wd/hub),
а также пользоваться браузером вручную, для етого нужно в окошке сессии нажать Manual session и в открывшемся окне
нажать на синий кружок вверху окна экрана сессии (разблокировать экран для использования вручную).

Три круга - кнопки сверху экрана сессии это: красная - закрыть екран сессии; синяя - разблокировать экран для использования вручную;
зеленая - свернуть/развернуть экран сессии.
Экран сесии делится пополам, слева открывается крнтейнер с браузером и ос(которая недоступна для использования) и
справа черный экран с командами.

По умолчанию у нас загружается ОС ubuntu и браузеры по умолчанию в двух последних версиях (chrome, firefox и opera).
Как правило считается что ели тест кейсы будут проходить в браузере на одной ОС то в 95% подобных случаев они пройдут
и на других ОС, поэтому если у нас ограниченные русурсы и заказчик не насаивает на тестировании на другой ОС то тестирование
проводится на ubuntu на нужной версии браузера или же нужно дополнительно устанавливать контейнер с необходимой нам ОС

Если загруженные по умолчанию имеджи версий браузера нам не подходят и нам нужно загрузить другую нужную нам версию браузера
то нам нужно выполнить следующие действия:

- в директории юзера C:\Users\Dell\.aerokube\selenoid хранится папка browser.json в нем прописаны браузеры и их версии
для закачки селеноидом, если мы хотим закачать себе браузер соотв. версии добавляем его туда.
Чтобы его подгрузить в селеноид нам нужно выкачать этот имедж и перезапустить контейнер.
Пример с порядком действий на Unix (на Windows должно быть также + нюансы):

Add new docker image on flight:
1) nano ~/.aerokube/selenoid/browsers.json     - открываем файл на редактирование в командной строке Unix, ручками добавили новый имедж в файл browser.json "selenoid/chrome:74.0" по примеру предыдущих имеджей в файле browser.json
2) docker pull <new_image_name>                - выкачивает этот имедж (выкачивает слоями, некоторые слои могут уже быть и поэтому он его быстро выкачивает) например docker pull selenoid/chrome:74.0 --vnc если с vnc то имедж тяжелее но позволяет просматривать видео.

3) docker kill -s HUP selenoid                 - мы убиваем предыдущий контейнер селеноид и он поумолчанию хочет переустановиться. После переустановки и обновления UI он должен появится в интерфейсе селеноид
4) docker logs -f selenoid                     - если что - то не завелось можно почитать логи
5) docker inspect selenoid                     - можно зайти внутрь контейнера и посмотреть что там


Может быть ошибка:
{"status":13,"value":{"message":"create container: Cannot connect to the Docker daemon at unix:///var/run/docker.sock. Is the docker daemon running?"}}
Нужно настраивать какие-то переменные и насторйки. Коля не сказал. Сказал что погуглит.


Для запуска автотестов на докере сначала нам нужно закрыть все сесии в UI что бы были доступные места для сесии автотестов.
Также нужно подготовить файл serenity.properties

serenity.project.name=Web tests.
serenity.console.colors=true
serenity.logging=VERBOSE

webdriver.driver=chrome
webdriver.remote.url=http://172.29.147.226:4444/wd/hub        - 172.29.147.226 - это локальная айпишка Коли, заместь localhost

serenity.driver.capabilities="browserName:chrome;enableVNC:true;enableVideo:true;"

chrome.switches="--start-maximized"

После того как все готово. Просто запускаем тест и он должен отобразится в соответствующей сессии на Selenoid UI,
если открыть экран сессии то мы сможем увидеть прохождение нашего теста.

 Home Task #5:
 - Complete task from home task #4 if not completed
 - Make sure your Selenoid setup works locally on your PC 
 Note: I'll try to provide solution for docker daemon on Win
 
       
Lesson 6

Для того чтобы коректно работал запуск тестов из файлов stories необходимо установить плагин:
JBhave Support 1.53     - Plugin for stosries to run via @Metafilter via command "mvn clean verify"

В файл pom была добавлена секция <profiles>, которая позволяет запускать тесты в одном из трех режимимов(выбирается в 
разделе Maven закладка справа на краю панели) browserstack, local, selenoid (для отображения панели нужно перезагрузить Intelij): 
   <profiles>
        <profile>
            <id>local</id>
            <build>
                <plugins>
                    <plugin>
                        <artifactId>maven-failsafe-plugin</artifactId>
                        <version>${maven.failsafe.plugin.version}</version>
                        <configuration>
                            <!--To run by SerenitySites in parallel
                            <parallel>suites</parallel>
                            <threadCountSuites>2</threadCountSuites>
                            <forkCount>2</forkCount>-->
                            <includes>
                                <!--To run by testName from command line-->
                                <include>**/test/**/${test.name}.java</include>
                            </includes>
                            <systemPropertyVariables>
                                <webdriver.driver>chrome</webdriver.driver>
                                <serenity.driver.capabilities>browserName:chrome;</serenity.driver.capabilities>
                            </systemPropertyVariables>
                        </configuration>
                        <executions>
                            <execution>
                                <goals>
                                    <goal>integration-test</goal>
                                    <goal>verify</goal>
                                </goals>
                            </execution>
                        </executions>
                    </plugin>
                </plugins>
            </build>
        </profile>
        <profile>
            <id>selenoid</id>
            <build>
                <plugins>
                    <plugin>
                        <artifactId>maven-failsafe-plugin</artifactId>
                        <version>${maven.failsafe.plugin.version}</version>
                        <configuration>
                            <includes>
                                <!--To run by testName from command line-->
                                <include>**/test/**/${test.name}.java</include>
                            </includes>
                            <systemPropertyVariables>
                                <webdriver.remote.url>http://192.168.43.75:4444/wd/hub</webdriver.remote.url>
                                <!--  запуск у Коли  <webdriver.remote.url>http://172.29.147.226:4444/wd/hub</webdriver.remote.url>-->
                                <serenity.driver.capabilities>browserName:chrome;version:75.0;enableVNC:true;enableVideo:true;sessionTimeout:2m;timeZone:America/Los_Angeles;</serenity.driver.capabilities>
                            </systemPropertyVariables>
                        </configuration>
                        <executions>
                            <execution>
                                <goals>
                                    <goal>integration-test</goal>
                                    <goal>verify</goal>
                                </goals>
                            </execution>
                        </executions>
                    </plugin>
                </plugins>
            </build>
        </profile>
        <profile>
            <id>browserstack</id>
            <build>
                <plugins>
                    <plugin>
                        <artifactId>maven-failsafe-plugin</artifactId>
                        <version>${maven.failsafe.plugin.version}</version>
                        <configuration>
                            <!--To run by SerenitySites in parallel
                            <parallel>suites</parallel>
                            <threadCountSuites>2</threadCountSuites>
                            <forkCount>2</forkCount>-->
                            <includes>
                                <!--To run by testName from command line-->
                                <include>**/test/**/${test.name}.java</include>
                            </includes>
                            <systemPropertyVariables>
                                <webdriver.remote.url>https://olehxxxxxxxxxnko1:ruMfFmLKxRh6hj78A6HH@hub-cloud.browserstack.com/wd/hub</webdriver.remote.url>
                            </systemPropertyVariables>
                        </configuration>
                        <executions>
                            <execution>
                                <goals>
                                    <goal>integration-test</goal>
                                    <goal>verify</goal>
                                </goals>
                            </execution>
                        </executions>
                    </plugin>
                </plugins>
            </build>
        </profile>
    </profiles>

1) для запуска определенной версии браузера через профайл на селеноид
- содержание профайла
- запуск профайла только через IDE и через галочку в секции maven?

2)для запуска определенной версии браузера через профайл на local
- указать версию драйвера и капабилити


1)Для того чтобы сгенерировать отчет serenity после запуска не через командную строку через mvn, 
после прохождения тестов используется команда CMD: 
mvn serenity:aggregate -Dserenity.outputDirectory=C:\Users\Dell\IdeaProjects\serenity-selenium-22.07.19\target\site\serenity


Home Task #6
1. Make sure your local setup of Docker/Selenoid is working
Note: README.md should contain detailed info on how to setup selenoid on Windows.
2. Make sure local/selenoid/browserstack profiles are working on your project. 
Note: 'browserstack' profile needs to be filled with variables in pom.xml

Вопросы:
1)Как запустить профайл mvn local, selenoid, browserstack через командную строку?
2)Как на селеноид запускать разные браузеры в разных операционных системах через профайл?
3)Как передать параметры ОС и версии браузера через профайл для запуска на browserstack?
3.1)Мы передавали эти параметры при запуске на browserstack через командную строку, как нам передать эти значения
    через профайл в pom.xml?
    
mvn clean test serenity:aggregate
-Dmaven.clean.failOnError=false
-Dmaven.test.failure.ignore=true
-Dwebdriver.remote.url=https://olehxxxxxxxxxnko1:ruMfFmLKxRh6hj78A6HH@hub-cloud.browserstack.com/wd/hub
-Dwebdriver.remote.driver=chrome
-Dwebdriver.remote.os=WINDOWS
-Dwebdriver.remote.os_version=10
-Dwebdriver.remote.browserstack.debug=true
-Dchrome.switches="--no-sandbox,--ignore-certificate-errors,--homepage=about:blank,--no-first-run"


4)Какие могут быть варианты паралельного запуска на selenoid в docker контейнерах и на browserstack?
5)Как групировать тесты через @Metafilter, Как запустить один клас с @Metafilter, если их несколько через командную строку?



Вопрос, как сагрегировать отчет серенити через запуск через профайл, особенно через браузерстек


Lesson 7 missed

Тема запись нескольких Scenario в story посредством Outline

Home Task #7:
Extend login.story 2 with negative scenarios
- Add/Implement Scenario Outline for Negative login test that will remain on Login page
- Add/Implement Scenario Outline for Negative login test that will fall to Error page

Make sure all scenarios are passed.


Lesson 8

Запуск нескольких тестов стори по тегам @Metafilter("+login01 +login02")
Запустить все тесты под логином login за исключением login01 @Metafilter("+login -login01")
Если у нас есть несколько стори и они содержат сценарии с одинаковыми тегами то их можно запускать указав
этот тег @Metafilter("+smoke")
Нюанс в метатеге не должно быть пробелов, если @Metafilter("") запустит все тесты


Класов степ может быть много, можно разделить на несколько класов, можно обьединить под наследованием 
BaseStep и тп.

CommonStepDefinition тщже можно можно разделить на несколько класов, можно обьединить под наследованием 
BaseCommonStepDefinition и тп.

Запуск профайла: mvn clean verify -Plocal
Запуск через патерн в профайле. Что это за язык. - RegExp
Ссылка: regexr.com

Lesson 9
Docker - image Windows:
Настройка по ссылке https://medium.com/@aandryashin/selenium-on-windows-docker-revolution-f5a7eab205ad


Настройки Selenoid на отдельной машине:
По статье: https://medium.com/@aandryashin/selenium-on-windows-revisited-1ab8d51ccc06

1) В отдельную папку скачиваем файл selenoid.exe (для своей ОС) по ссылке: https://github.com/aerokube/selenoid/releases

2) В ту же папку скачиваем фал драйвера напр:
 - IE (IEDriverServer.exe) по ссылке https://www.seleniumhq.org/download/  (третий раздел сверху)
 - Chrome по ссылке https://chromedriver.chromium.org/downloads
 
3) Если мы используем IE то этот браузер нужно настроить вручную перед запуском. Все настройки описаны по 
ссылке: https://github.com/SeleniumHQ/selenium/wiki/InternetExplorerDriver. Основные настройки это:
- масштаб. В окне IE браузера (не Edge) -> Настройки (Шестеренка) -> Масштаб (отметить не более 100%);
- безопасность. В окне IE браузера (не Edge) -> Настройки (Шестеренка) -> Свойства браузера -> Безопасность ->
В разделе Параметры безопасности в каждом подразделе (Интернет, Местная интрасеть, Надежные сайты, Опасные сайты) 
отметить Включить защищенный режим (или убрать галочку с Влючить защищенный режим, во всех разделах должно быть одинаково).
В IE настройки только делаются в ручную или через регистр windows через скрипт.

4)Создаем файл browser.json куда прописываем браузеры и путь к драйверам, которые будем использовать при запуске тестов.
{
  "internet explorer": {
    "default": "11",
    "versions": {
      "11": {
        "image": ["D:\\Testing\\Selenoid\\IEDriverServer.exe"]
      }
    }
  },
  
    "chrome": {
    "default": "76",
    "versions": {
      "76": {
        "image": ["D:\\Testing\\Selenoid\\chromedriver.exe"]
      }
    }
  }
}
Если я добавляю браузер в этот файл то нужно перезапустить селеноид (просто перезапускаем run.bat файл)

5)Создаем run.bat файл с командой запуска selenoid:
D:\Testing\Selenoid\selenoid.exe -conf D:\Testing\Selenoid\browsers.json -disable-docker -limit 4 > D:\Testing\Selenoid\selenoid.log 2>&1
Эта команда убирает docker с порта 4444, если он запущен. Максимальное количество браузеров на одном селеноид 4.

Selenoid на отдельной машине работает подобно Selenium Server, для разграничения тестов на пользователях этой машины
смотри статью по ссылке https://medium.com/@aandryashin/selenium-on-windows-revisited-1ab8d51ccc06 раздел Going to multiple desktops

в случае если Selenoid должен запускать тесты на нескольких машинах то на них устанавливаются на каждой свой селеноид
и дальше их IP обьединяются и распределяютс через selenoid go grid router (распределение нагрузки между пользователя, передача пароля)
