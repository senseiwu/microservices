package com.rysiekblah;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by tomek on 10/30/16.
 */
@Repository
public class EventDao {

    protected Logger logger = Logger.getLogger(EventDao.class.getName());

    private static Map<Long, Event> events = Maps.newHashMap();

    static {
        events.put(1l, new Event(1l, "UX Strategy", "Talk about product design and its strategy", "Tomasz", "Krakow"));
        events.put(2l, new Event(2l, "Scala principles", "Workshop about scala", "Michael", "Hong Kong"));
    }

    public Event getEvent(long eventId) {
        logger.info("Getting event " + eventId);
        Event tmpEvent = events.get(eventId);
        if (tmpEvent == null) {
            throw new EventNotFoundException("");
        }
        return tmpEvent;
    }

    public Event editEvent(Event event) {
        Event tmpEvent = events.get(event.getId());
        if (tmpEvent == null) {
            throw new EventNotFoundException("");
        }
        return tmpEvent.update(event);
    }

}
