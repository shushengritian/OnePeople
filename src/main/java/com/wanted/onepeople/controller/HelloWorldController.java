package com.wanted.onepeople.controller;


import com.wanted.onepeople.constants.RabbitConsts;
import com.wanted.onepeople.message.MessageStruct;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiyouquedongxing
 * @date 2018/7/23 22:34
 */
@RestController
@RequestMapping("/rabbit")
public class HelloWorldController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/direct")
    public void sendDirect() {
        rabbitTemplate.convertAndSend(RabbitConsts.DIRECT_MODE_QUEUE_ONE, new MessageStruct("直接队列消息"));
    }

    /**
     * @Description: 主题模式指定交换机，*匹配一个单词 #匹配多个单词
     * @Author fdc
     * @Date 2022/3/4 17:34
     * @param:
     * @return void
     * @UpdateDate 2022/3/4 17:34
     **/
    @GetMapping("/topic")
    public void sendTopic() {
        rabbitTemplate.convertAndSend(RabbitConsts.TOPIC_MODE_QUEUE, "1.queue", new MessageStruct("Topic队列消息"));
    }


}
