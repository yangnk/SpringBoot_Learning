分布式锁：需要实现的是通过restful并发调用，如果锁正在被占用则等待，如果没有才调用

1.Redisson实现分布式锁：https://github.com/yudiandemingzi/spring-boot-distributed-redisson
2.jedis配置：https://blog.csdn.net/qq_41583016/article/details/112486039
3.分布式锁的实现：https://github.com/pjmike/redis-distributed-lock/blob/master/src/main/java/com/redis/lock/aop/LockMethodAspect.java
4.Redis实现分布式锁的7种方案：https://blog.csdn.net/fengyuyeguirenenen/article/details/123752418

---
分布式缓存
功能：
1.redis实现读写删的方法；
2.实现向mysql数据库中读写数据；
3.redis+mysql实现缓存读写操作；