var stompClient = null;

$(document).ready(function() {  // Executes when the page is ready
    console.log("Index page is ready");
    connect(); // Connects to new socket

    $("#send").click(function() {
        sendMessage();
    });

    $("#send-private").click(function() {
        sendPrivateMessage();
    });
});

function connect() {
    var socket = new SockJS('/our-websocket');  // Created by connect() on "/our-websocket" which is created in WebSocketConfig
    stompClient = Stomp.over(socket);  // Creates StompClient over the socket
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);

        stompClient.subscribe('/topic/messages', function (message) {  // Once socket is connected it subscribes to "/topic/messages" which is created in WebSocketConfig
            showMessage(JSON.parse(message.body).content);
        });

        stompClient.subscribe('/user/topic/private-messages', function (message) {  // Once socket is connected it subscribes to "/topic/private-messages" which is created in WebSocketConfig
                    showMessage(JSON.parse(message.body).content);
        });
    });
}

function showMessage(message) {
     $("#messages").append("<tr><td>" + message + "</td></tr>");  // When receives a message to the topic it shows the message
}

 function sendMessage() {  // Called when "Send Message" button is clicked
     console.log("sending message");
     stompClient.send("/ws/message", {}, JSON.stringify({'messageContent': $("#message").val()}));
}

function sendPrivateMessage() {  // Called when "Send Message" button is clicked
     console.log("sending private message");
     stompClient.send("/ws/private-message", {}, JSON.stringify({'messageContent': $("#private-message").val()}));
}