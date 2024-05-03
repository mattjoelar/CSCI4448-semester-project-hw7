package com.ooadproject.wstutorial;



//import com.ooadproject.projectmonDB.dao.MatchDao
import com.sun.security.auth.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;

public class UserHandshakeHandler extends DefaultHandshakeHandler {
    private final Logger LOG = LoggerFactory.getLogger(UserHandshakeHandler.class);
    //private MatchDao matchDao;
    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        final String randomId = UUID.randomUUID().toString();
        LOG.info("User with ID '{}' opened the page, and matchMaker is waiting for an other user to connect!", randomId);
//        try {
//            lookForMatch();
//        } catch (ExecutionException | InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return new UserPrincipal(randomId);
    }

//    public void lookForMatch() throws ExecutionException, InterruptedException {
//        String string = matchDao.findMatch().join().toString(); // Waits for two users to connect.
//        LOG.info(string);
//
//
//    }
}
