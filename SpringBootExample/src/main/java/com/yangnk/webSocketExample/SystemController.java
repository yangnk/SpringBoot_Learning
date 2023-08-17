package com.yangnk.webSocketExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
/**
 * @author yangnk
 * @desc
 * @date 2023/08/15 00:32
 **/

@RestController("web_Scoket_system")
@RequestMapping("/api/socket")
public class SystemController {

    @Autowired
    WebSocketServer socketServer;

    //推送数据接口
    @ResponseBody
    @RequestMapping("/socket/push/{name}")
    public String pushToWeb(@PathVariable String name, @RequestHeader String message) {
        Map<String,Object> result = new HashMap<>();
        socketServer.AppointSending(name, message);
        result.put("name", name);
        result.put("msg", message);
        return result.toString();
    }
}