package com.yangnk.zookeeper.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/zookeeper",method = RequestMethod.POST)
@Api(tags = {"zookeeper的测试类"})
public class ZookeeperController {

    @Resource(name = "curatorClient")
    private CuratorFramework client;
    @Value("${zookeeper.curator.namespace}")
    String namespace;

    @RequestMapping("/createZnode")
    @ApiOperation("zookeeper测试---递归创建节点")
    @ApiOperationSupport(author = "lsx",order = 1)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "path", value = "路径", required = true, paramType = "query"),
            @ApiImplicitParam(name = "data", value = "值", required = false, paramType = "query"),
    })
    public String createZnode(String path,@RequestParam(defaultValue = "")String data){
        path = "/"+path;
        List<ACL> aclList = new ArrayList<>();
        Id id = new Id("world", "anyone");
        aclList.add(new ACL(ZooDefs.Perms.ALL, id));
        try {
            client.create()
                    .creatingParentsIfNeeded()  //没有父节点时 创建父节点
                    .withMode(CreateMode.PERSISTENT)  //节点类型
                    .withACL(aclList)   //配置权限
                    .forPath(path, data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return "节点创建失败"+e.getMessage();
        }
        return "节点创建成功";
    }

    @RequestMapping("/createAsyncZnode")
    @ApiOperation("zookeeper测试---异步递归创建节点")
    @ApiOperationSupport(author = "lsx",order = 2)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "path", value = "路径", required = true, paramType = "query"),
            @ApiImplicitParam(name = "data", value = "值", required = false, paramType = "query"),
    })
    public String createAsyncZnode(String path,@RequestParam(defaultValue = "")String data){
        String paths = "/"+path;
        try {
            client.create()
                    .creatingParentsIfNeeded()
                    .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                    //异步回调   增删改都有异步方法
                    .inBackground(new BackgroundCallback() {

                        @Override
                        public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                            System.out.println("异步回调--获取权限:"+client.getACL().forPath(paths));
                            System.out.println("异步回调--获取数据:"+new String(client.getData().forPath(paths)));
                            System.out.println("异步回调--获取事件名称:"+event.getName());
                            System.out.println("异步回调--获取事件类型:"+event.getType());
                        }
                    })
                    .forPath(paths, data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return "节点创建失败"+e.getMessage();
        }
        return "节点创建成功";
    }

    @RequestMapping("/selectZnode")
    @ApiOperation("zookeeper测试---查看节点和元数据")
    @ApiOperationSupport(author = "lsx",order = 3)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "path", value = "路径", required = true, paramType = "query"),
    })
    public JSONObject selectZnode(String path){
        JSONObject jsonObject = new JSONObject();
        String namespace = "/"+this.namespace;
        Stat stat;
        try {
            stat = client.checkExists().forPath(path);
            if (stat == null) {
                jsonObject.put("error", "不存在该节点");
            }
            String dataString = new String(client.getData().forPath(path));
            jsonObject.put(namespace+path, dataString);
            jsonObject.put("stat", stat);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return jsonObject;
    }
    @RequestMapping("/selectChildrenZnode")
    @ApiOperation("zookeeper测试---查看子节点和数据")
    @ApiOperationSupport(author = "lsx",order = 4)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "path", value = "路径", required = true, paramType = "query"),
    })
    public Map<String,String> selectChildrenZnode(String path){
        Map<String, String> map = new HashMap<>();
        String namespace = "/"+this.namespace;
        try {
            List<String> list = client.getChildren().forPath(path);
            for (String s : list) {
                String dataString = new String(client.getData().forPath(path+"/"+s));
                map.put(namespace+path+"/"+s, dataString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    @RequestMapping("/setData")
    @ApiOperation("zookeeper测试---设置数据")
    @ApiOperationSupport(author = "lsx",order = 5)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "path", value = "路径", required = true, paramType = "query"),
            @ApiImplicitParam(name = "data", value = "数据", required = true, paramType = "query"),
            @ApiImplicitParam(name = "version", value = "版本号(-1时  版本号不起作用)", required = true, paramType = "query"),
    })
    public JSONObject setData(String path,String data,Integer version) {
        JSONObject jsonObject = new JSONObject();
        try {
            Stat stat = client.setData().withVersion(version).forPath(path, data.getBytes());
            jsonObject.put("success", "修改成功");
            jsonObject.put("version", stat.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("error", "修改失败:"+e.getMessage());
            return jsonObject;
        }
        return jsonObject;
    }

    @RequestMapping("/delete")
    @ApiOperation("zookeeper测试---删除节点")
    @ApiOperationSupport(author = "lsx",order = 6)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "path", value = "路径", required = true, paramType = "query"),
            @ApiImplicitParam(name = "version", value = "版本号(-1时  版本号不起作用)", required = true, paramType = "query"),
            @ApiImplicitParam(name = "isRecursive", value = "是否递归删除 1是 0否  默认为0", required = false, paramType = "query"),
    })
    public JSONObject delete(String path,Integer version,@RequestParam(defaultValue = "0")Integer isRecursive) {
        JSONObject jsonObject = new JSONObject();
        try {
            if (isRecursive == 1) {
                client.delete().deletingChildrenIfNeeded().withVersion(version).forPath(path);
            }else {
                client.delete().withVersion(version).forPath(path);
            }
            jsonObject.put("success", "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("error", "删除失败:"+e.getMessage());
            return jsonObject;
        }
        return jsonObject;
    }

    @SuppressWarnings("finally")
    @RequestMapping("/transactionDisabled")
    @ApiOperation("zookeeper测试---测试事务(不开启事务)")
    @ApiOperationSupport(author = "lsx",order = 7)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "createPath", value = "创建的路径", required = true, paramType = "query"),
            @ApiImplicitParam(name = "createData", value = "创建的数据", required = true, paramType = "query"),
            @ApiImplicitParam(name = "setPath", value = "修改数据的路径", required = true, paramType = "query"),
            @ApiImplicitParam(name = "setData", value = "修改的数据", required = true, paramType = "query"),
    })
    public String transactionDisabled(String createPath,String createData,String setPath,String setData) {

        try {
            //创建一个新的路径
            client.create().withMode(CreateMode.PERSISTENT).forPath(createPath,createData.getBytes());
            //修改一个没有的数据  让其报错
            client.setData().forPath(setPath, setData.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return "执行完成";
        }

    }

    @SuppressWarnings({ "deprecation", "finally" })
    @RequestMapping("/transactionEnabled")
    @ApiOperation("zookeeper测试---测试事务(开启事务)")
    @ApiOperationSupport(author = "lsx",order = 8)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "createPath", value = "创建的路径", required = true, paramType = "query"),
            @ApiImplicitParam(name = "createData", value = "创建的数据", required = true, paramType = "query"),
            @ApiImplicitParam(name = "setPath", value = "修改数据的路径", required = true, paramType = "query"),
            @ApiImplicitParam(name = "setData", value = "修改的数据", required = true, paramType = "query"),
    })
    public String transactionEnabled(String createPath,String createData,String setPath,String setData) {
        try {
            client.inTransaction()
                    .create().withMode(CreateMode.PERSISTENT).forPath(createPath,createData.getBytes())
                    .and()
                    .create().withMode(CreateMode.PERSISTENT).forPath(createPath,createData.getBytes())
                    .and().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return "执行完成";
        }

    }

    @RequestMapping("/InterProcessMutexUse")
    @ApiOperation("zookeeper测试---测试可重入排它锁")
    @ApiOperationSupport(author = "lsx",order = 8)
    public String InterProcessMutexUse() throws Exception{
        System.out.println("排它锁测试");
        InterProcessMutex lock = new InterProcessMutex(client, "/lock");
        System.out.println("占有锁中");
        lock.acquire(20L,TimeUnit.SECONDS);
        System.out.println("执行操作中");
        for (int i = 0; i < 20; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(i);
        }
        lock.release();
        return "锁已释放";
    }

    @RequestMapping("/interProcessReadWriteLockUseWrite")
    @ApiOperation("zookeeper测试---测试读写锁--写锁")
    @ApiOperationSupport(author = "lsx",order = 9)
    public String interProcessReadWriteLockUseWrite() throws Exception {
        System.out.println("写锁");
        // 分布式读写锁
        InterProcessReadWriteLock lock = new InterProcessReadWriteLock(client, "/lock");
        // 开启两个进程测试，观察到写写互斥，特性同排它锁
        System.out.println("获取锁中");
        lock.writeLock().acquire();
        System.out.println("操作中");
        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(i);
        }
        lock.writeLock().release();
        return "释放写锁";
    }

    @RequestMapping("/interProcessReadWriteLockUseRead")
    @ApiOperation("zookeeper测试---测试读写锁--读锁")
    @ApiOperationSupport(author = "lsx",order = 10)
    public String interProcessReadWriteLockUseRead() throws Exception {
        System.out.println("读锁");
        // 分布式读写锁
        InterProcessReadWriteLock lock = new InterProcessReadWriteLock(client, "/lock");
        // 开启两个进程测试，观察得到读读共享，两个进程并发进行，注意并发和并行是两个概念，(并发是线程启动时间段不一定一致，并行是时间轴一致的)
        // 再测试两个进程，一个读，一个写，也会出现互斥现象
        System.out.println("获取锁中");
        lock.readLock().acquire();
        System.out.println("操作中");
        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(i);
        }
        lock.readLock().release();
        return "释放读锁";
    }
}

