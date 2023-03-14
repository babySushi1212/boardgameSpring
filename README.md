
# Usage

更新後看 Empxxx 的程式就好
Backend
* 建立範例資料庫: `.\src\main\others\data-MySQL.sql`
* 設定 properties: `.\src\main\resources\application.properties`
* 透過 `.\src\main\java\webapp\BoardGameApiApplication.java` 執行
* 測試是否打的到後端 API: `localhost:8082/emp/ls`

Frontend
* 程式在: `.\src\main\resources\static\html\open_hour.html`
  * 透過 `.\src\main\java\webapp\config\WebConfig.java
    ` mapping 到 `localhost:8082/emp`
* 測試: `localhost:8082/emp`

## Config

設定 application.properties
* 目前設定好 MySql 資料庫連線即可
```xml
server.port=8082
webapp.datasource.username=xxx
webapp.datasource.password=xxx
webapp.datasource.url=jdbc:mysql://localhost:3306/boardgameDev
```

## Folder Structure

後端程式放在 `./java/webapp/
* 下面會在再分為 pojo, repository, service, dto, controller
* 分別對應 webapp 的 `@Eneity`, `@JpaRepository`, `@Service`, `DTO`, `@RestController`

* config: 放 web config, bean config for DI
* static: 放 html, css, js
* resources: 放 .properties 設定檔
* others: 暫時放一些開發用資源，例如 .sql
```bash
main
├─java
│  └─webapp
│      ├─config
│      ├─controller
│      ├─dto
│      ├─pojo
│      ├─repository
│      └─service
├─others
└─resources
    ├─static
    │  ├─html
    │  ├─css
    │  └─js
    └─templates
```

## Spring Boot Architecture

* serice 將 POJO(在 webapp 稱為 @Eneity) 包裝為 DTO 用來傳送
```bash
View ⇆ Controller ⇆ Service ⇆ Repository ⇆ Model
```

# API We Used

### Spring-framework

* [@Bean](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Bean.html)
    * Indicates that a method produces a bean to be managed by the Spring container.  

* [@Autowired](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Autowired.html)
    * DI
    * Marks a constructor, field, setter method, or config method as to be autowired by Spring's dependency injection facilities.

### Spring Data

* [JpaRepository](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html)
    * 提供基礎的 CURD

* [@EnableJpaRepositories](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/config/EnableJpaRepositories.html)(basePackages = {"your.pkg.here"})

### Spring Web

[@RequestParam](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestParam.html)
* Annotation which indicates that a method parameter should be bound to a web request parameter.
* [some example](https://matthung0807.blogspot.com/2021/04/spring-mvc-requestparam-url.html)

[@RequestBody](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestBody.html)
* similar to RequestParam

### Others

* [ModelMapper.map](https://modelmapper.org/javadoc/#map)
    * 見文件中 ModelMapper 下的 `.map()`
    * 主要使用 modelmapper 將 POJO 對應到 DTO

* [stream API](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/package-summary.html)
    * 處理 DB 取出的 collection


# Install Spring

透過 [webapp initializer](安裝)
1. 選擇 maven, 3.0.4, jar java 17,
2. dependency: lombok, Spring Data JPA, MySql Driver, Spring Web(設定會出現在 pom.xml 中)
3. 選擇 Generate

直接透過 maven (local 要安裝 maven)
```xml
<dependency>
  <groupId>org.modelmapper</groupId>
  <artifactId>modelmapper</artifactId>
  <version>3.0.0</version>
</dependency>
```
若失敗則下載 [modelmapper](http://modelmapper.org/downloads/) .jar 並引入
* maven 沒辦法直接 add dependency - 應該是官方的問題 [issue](https://github.com/modelmapper/modelmapper/issues/684)
