package com.fdifrison.producer.controller;

import com.fdifrison.producer.sender.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private final BasicSenderService basicSenderService;
    private final WorkSenderService workSenderService;
    private final FanoutSenderService fanoutSenderService;
    private final DirectSenderService directSenderService;
    private final TopicSenderService topicSenderService;

    public ProducerController(
            BasicSenderService basicSenderService,
            WorkSenderService workSenderService,
            FanoutSenderService fanoutSenderService,
            DirectSenderService directSenderService, TopicSenderService topicSenderService) {
        this.basicSenderService = basicSenderService;
        this.workSenderService = workSenderService;
        this.fanoutSenderService = fanoutSenderService;
        this.directSenderService = directSenderService;
        this.topicSenderService = topicSenderService;
    }

    @PostMapping("basic")
    public void publishBasic() {
        basicSenderService.send();
    }

    @PostMapping("work")
    public void publishWork() {
        workSenderService.send();
    }

    @PostMapping("fanout")
    public void publishFanout() {
        fanoutSenderService.send();
    }

    @PostMapping("direct")
    public void publishDirect() {
        directSenderService.send();
    }

    @PostMapping("topic")
    public void publishTopic() {
        topicSenderService.send();
    }
}
