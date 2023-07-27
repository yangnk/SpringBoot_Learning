com.yangnk.RedisExample 的参考地址：
    Spring Boot 2.X(六)：Spring Boot 集成 Redis:https://juejin.cn/post/6844903962504609805#heading-10


使用devTool可以热部署springboot，不需要重启即可生效，配置方法为：

`

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
`

springboot使用actuator可以做端口监控，可以查看容器中的bean、mapping还是环境变量等，配置方法为：
`

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

`
还需要在 application.properties 中配置：
        management.endpoint.metrics.enabled=true
        management.endpoints.web.exposure.include=*