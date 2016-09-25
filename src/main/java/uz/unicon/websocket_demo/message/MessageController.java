package uz.unicon.websocket_demo.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import uz.unicon.websocket_demo.user.CurrentUser;
import uz.unicon.websocket_demo.user.User;

@Controller
public class MessageController {

    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public void setSimpMessagingTemplate(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

//    @MessageMapping(value = "/message")
//    @SendTo(value = "/topic/notification")
//    public String message(String message) {
//        return message.toUpperCase();
//    }

    @MessageMapping(value = "/message")
    public void sendMessage(String message, @CurrentUser User user) {
        simpMessagingTemplate.convertAndSend("/user/root/queue", "salom");
    }
}
