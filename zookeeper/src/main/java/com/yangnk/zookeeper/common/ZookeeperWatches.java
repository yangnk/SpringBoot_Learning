package com.yangnk.zookeeper.common;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.zookeeper.data.Stat;

public class ZookeeperWatches {

    private CuratorFramework client;

    public ZookeeperWatches(CuratorFramework client) {
        this.client = client;
    }

    public void znodeWatcher() throws Exception {
        NodeCache nodeCache = new NodeCache(client, "/node");
        nodeCache.start();
        nodeCache.getListenable().addListener(new NodeCacheListener() {

            @Override
            public void nodeChanged() throws Exception {
                System.out.println("=======节点改变===========");
                String path = nodeCache.getPath();
                String currentDataPath = nodeCache.getCurrentData().getPath();
                String currentData = new String(nodeCache.getCurrentData().getData());
                Stat stat = nodeCache.getCurrentData().getStat();
                System.out.println("path:"+path);
                System.out.println("currentDataPath:"+currentDataPath);
                System.out.println("currentData:"+currentData);
            }
        });

        System.out.println("节点监听注册完成");
    }

    public void znodeChildrenWatcher() throws Exception {
        PathChildrenCache pathChildrenCache = new PathChildrenCache(client, "/node",true);
        pathChildrenCache.start();
        pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {

            @Override
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                System.out.println("=======节点子节点改变===========");
                PathChildrenCacheEvent.Type type = event.getType();
                String childrenData = new String(event.getData().getData());
                String childrenPath = event.getData().getPath();
                Stat childrenStat = event.getData().getStat();

                System.out.println("子节点监听类型："+type);
                System.out.println("子节点路径："+childrenPath);
                System.out.println("子节点数据："+childrenData);
                System.out.println("子节点元数据："+childrenStat);

            }
        });

        System.out.println("子节点监听注册完成");
    }
}

