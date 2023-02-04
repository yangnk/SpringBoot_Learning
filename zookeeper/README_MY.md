### 参考代码
- springboot整合zookeeper：https://blog.csdn.net/admin522043032/article/details/115694905

### 该项目利用swagger2来实现api管理：

`  
<dependency>
<groupId>com.github.xiaoymin</groupId>
<artifactId>knife4j-spring-boot-starter</artifactId>
<version>2.0.2</version>
</dependency>  
`

- 打开地址：http://127.0.0.1:8080/doc.html#/home
- 解决方案之‘Failed to start bean ‘documentationPluginsBootstrapper‘； nested exception is java.lang.NullPoi：https://blog.csdn.net/hadues/article/details/123753888``
- 自定义Knife4j-spring-boot-starter：https://blog.csdn.net/contact97/article/details/125101686
### 解决slf4j包冲突的问题：
- 参考文献：Error(13) 解决LoggerFactory is not a Logback LoggerContext but Logback is on the classpath：https://blog.csdn.net/qq_38225558/article/details/111823106

### 问题总结

该swagger2无法扫描com.yangnk.zookeeper.controller 下的Controller类。