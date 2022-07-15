- jedis启动不了的原因？

pom文件redis依赖错了，正确依赖为：
		<!-- Redis -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-redis</artifactId>
			<exclusions>
				<!-- 排除lettuce包 -->
				<exclusion>
					<groupId>io.lettuce</groupId>
					<artifactId>lettuce-core</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		<!-- 添加jedis客户端 -->
		<dependency>
			<groupId>redis.clients</groupId>
			<artifactId>jedis</artifactId>
		</dependency>

参考资料：Spring Boot 2.X(六)：Spring Boot 集成 Redis：https://juejin.cn/post/6844903962504609805#heading-12

- swagger 的登录地址:http://127.0.0.1:8081/swagger-ui.html#/