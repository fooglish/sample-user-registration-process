Реализация прототипа процесса для саморегистрации пользователя с ручным подтверждением на стороне площадки.  
Project SDK 1.8, Camunda v.7.16.0  

Auth-service - вспомогательный сервис с базой данных, куда сохраняются данные пользователей через POST-запрос (POST http://localhost:8081/users/add). Также можно получить данные всех пользователей из БД с помощью GET http://localhost:8081/users/. 

После загрузки проекта убедитесь, что в Project Structure, в разделе Project Settings-Project, выбран Project SDK 1.8, Project language level - 8. Затем сделайте mvn package для корневой директории. Запустите класс AuthApplication, затем запустите класс Application. Процесс станет доступен по адресу http://localhost:8080. 

Доступ в камунду:  
username: admin  
password: admin

Схема процесса: user-registration-process\src\main\resources\process.bpmn

