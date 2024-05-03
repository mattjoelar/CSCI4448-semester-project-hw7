package com.ooadproject.wstutorial;



import com.ooadproject.wstutorial.dto.Message;
import com.ooadproject.wstutorial.dto.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {
    // This class receives and sends the message classes

    // Specifies where to send/receive messages to/from
    @MessageMapping("/message")
    @SendTo("/topic/messages")  //Subscribers of this topic will receive the message //This sends to the messages body in the HTML
    public ResponseMessage getMessage(final Message message) throws InterruptedException {

        Thread.sleep(1000); //Simulates some computations//call server logic here!




        // HtmlUtils.htmlEscape - escapes any special characters that might be in the message
        //Return the game state to client here!
        return new ResponseMessage(HtmlUtils.htmlEscape(message.getMessageContent()));
    }

//    @MessageMapping("/private-message")
//    @SendToUser("/topic/private-messages")  //Subscribers of this topic will receive the message
//    public ResponseMessage getPrivateMessage(final Message message,
//                                             final Principal principal) throws InterruptedException {
//
//        Thread.sleep(1000); //Simulates some computations
//
//        // HtmlUtils.htmlEscape - escapes any special characters that might be in the message
//        return new ResponseMessage(HtmlUtils.htmlEscape(
//                "Sending private message to user " + principal.getName() + ":"
//                            + message.getMessageContent())
//        );
//    }
}
