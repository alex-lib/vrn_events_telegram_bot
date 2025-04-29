package com.my.eventsbot.services;
import com.my.eventsbot.bot.EventsBot;
import com.my.eventsbot.entities.Event;
import com.my.eventsbot.entities.Subscriber;
import com.my.eventsbot.repositories.EventRepository;
import com.my.eventsbot.repositories.SubscriberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class EventService {
    private final EventRepository eventRepository;
    private final SubscriberRepository subscriberRepository;
    private final EventsBot eventBot;
    private Date currentDate = new Date();
    private static final int CHECK_INTERVAL_DAYS = 1;

    @Scheduled(fixedRate = CHECK_INTERVAL_DAYS, initialDelay = CHECK_INTERVAL_DAYS)
    public void notifySubscribers() {
        List<Subscriber> subscribers = subscriberRepository.findSubscribedUsers();
        for (Subscriber subscriber : subscribers) {
            List<Event> events = getNewEvents();
        }
    }
    public List<Event> getNewEvents() {
        try {
            URI uri = new URI("https://afisha.yandex.ru/voronezh");
        } catch (URISyntaxException e) {
            log.error("Error occurred while creating URI", e);
        }
        return List.of();
    }


}
