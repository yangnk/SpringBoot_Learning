package com.yangnk.hfn;

import com.yangnk.hfn.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;

@RunWith(SpringRunner.class)//启动器
@SpringBootTest//加载容器
class HfnApplicationTests {

	@Autowired
	JedisPool jedisPool;

	@Test
	void test() {
		Jedis jedis = jedisPool.getResource();
		String city = RedisUtil.getValue(jedis, "city");
		System.out.println("city = " + city);
	}

	@Test
	void test1() {
		Jedis jedis = jedisPool.getResource();
		Map<String, String> map = RedisUtil.getHsetValue(jedis, "image");
		System.out.println("map = " + map);
	}

	@Test
	void test2() {
		Image1 image1 = new Image1("aaa", "bbb", "ccc");

		Jedis jedis = jedisPool.getResource();
//		Map<String, String> map = RedisUtil.getHsetValue(jedis, "image");
//		System.out.println("map = " + map);
		Long res = RedisUtil.hset(jedis, "user", image1);
	}

	static class Image1 {
		String a;
		String b;
		String c;

		public Image1(String a, String b, String c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

}
