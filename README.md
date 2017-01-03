![WAT](http://www.ioe.wat.edu.pl/themes/ioe/images/wat.png)

### Wymagane narzędzia
1. [JDK8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
2. [NodeJs](https://nodejs.org/en/)
3. [Gradle](https://gradle.org/gradle-download/)
4. [PostgreSQL](https://www.postgresql.org/download/)

### Tworzenie bazy danych
1. [Należy stworzyć bazę dla projektu](https://www.postgresql.org/docs/current/static/manage-ag-createdb.html)
2. Zedytować plik ai_server/src/main/resources/application.yml i wpisać dane dostępowe do bazy.

### Uruchamianie serwera aplikacji
1. Z folderu ai_server uruchomić komendę 'gradle bootRun' ew. 'gradlew.bat bootRun' jeśli gradle nie jest zainstalowany

### Uruchamianie UI aplikacji
1. W pliku package.json przy pozycji 'scripts.start' wskazać adres folderu static (ai_server/src/main/resources/static)
2. Z folderu ai_ui uruchomić komendę 'npm install'
3. Z folderu ai_ui uruchomić komendę 'npm start'

**Uruchomić przeglądarkę pod adresem [http://localhost:8080](http://localhost:8080)**
