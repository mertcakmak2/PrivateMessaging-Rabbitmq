package com.springdata.privatemessage.Consumers;

import com.springdata.privatemessage.Config.RabbitMqConfig;
import com.springdata.privatemessage.Entities.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageListener {

    private final SimpMessagingTemplate messagingTemplate;

    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void consumeMessageFromQueue(Message message){
        System.out.println("Message => "+ message.toString());
        messagingTemplate.convertAndSendToUser(
                String.valueOf(message.getRecipientId()) ,"/queue/messages", message  );
    }

}