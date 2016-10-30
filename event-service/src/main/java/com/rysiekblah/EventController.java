package com.rysiekblah;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tomek on 10/30/16.
 */

@RestController
public class EventController {

    protected Logger logger = Logger.getLogger(EventController.class.getName());

    @Autowired
    private AccountServiceClient accountServiceClient;

    @Autowired
    private EventDao eventDao;

//    @RequestMapping("event/account/{accountId}")
//    public String getRole(@PathVariable("accountId") String accountId) {
//        String role = accountServiceClient.getRoleForEvent(accountId);
//        logger.info("Account: " + accountId + " has Role: " + role);
//        return role;
//    }

    @RequestMapping("event/{eventId}")
    public Event getEvent(@PathVariable Long eventId) {
        if (eventDao == null) {
            logger.warning("Event DAO is null");
            return null;
        }
        logger.info("Call DAO for eventId: " + eventId);
        return eventDao.getEvent(eventId);
    }

    @RequestMapping(value = "event/update", method = RequestMethod.POST)
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
        logger.info("Update event " + event);
        String role = accountServiceClient.getRoleForEvent(event.getAdmin(), event.getId());
        logger.info("ROLE : " + role);
        if(!role.equals("2")) {
            throw new EventAccessPermissionDenied("Access denied");
        }
        return new ResponseEntity<Event>(eventDao.editEvent(event), HttpStatus.OK);
    }

    /*
    * In this case eventId is null
    * */
    @RequestMapping("event/failed/{eventId}")
    public Event getEventFAILED(Long eventId) {
        if (eventDao == null) {
            logger.warning("Event DAO is null");
            return null;
        }
        logger.info("Call DAO for eventId: " + eventId);
        return eventDao.getEvent(eventId);
    }
}
