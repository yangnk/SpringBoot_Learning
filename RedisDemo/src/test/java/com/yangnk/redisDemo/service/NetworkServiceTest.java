package com.yangnk.redisDemo.service;

import com.yangnk.redisDemo.entity.Network;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * NetworkService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>六月 7, 2022</pre>
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class NetworkServiceTest {
    @Autowired
    NetworkService networkService;

    @Test
    public void testSelectByPrimaryKey() throws Exception {
        networkService.selectByPrimaryKey(1);
    }

    @Test
    public void testddNetwork() throws Exception {
        Network network = new Network();
        network.setId(4);
        network.setNetwork("172.0.0.4/24");
        networkService.addNetwork(network);
    }


} 
