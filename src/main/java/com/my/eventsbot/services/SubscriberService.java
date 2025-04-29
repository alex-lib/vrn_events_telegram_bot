package com.my.eventsbot.services;
import com.my.eventsbot.entities.Subscriber;
import com.my.eventsbot.repositories.SubscriberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.User;

@RequiredArgsConstructor
@Service
@Slf4j
public class SubscriberService {
    private final SubscriberRepository subscriberRepository;

    public void findOrSaveSubscriber(User user) {
        Subscriber persistantSubscriber = subscriberRepository.findSubscriberBySubscriberId(user.getId());
        if (persistantSubscriber != null) {
            persistantSubscriber.setUserName(user.getUserName());
            log.info("User is found and updated - {}", user.getId());
        }

        if (persistantSubscriber == null) {
            Subscriber transientSubscriber = new Subscriber();
            transientSubscriber.setUserName(user.getUserName());
            transientSubscriber.setSubscriberId(user.getId());
            transientSubscriber.setIsSubscribed(false);
            subscriberRepository.save(transientSubscriber);
            log.info("New user is saved - {}", user.getId());
        }
    }

    public boolean subscribeUser(User user) {
        Subscriber subscriber = subscriberRepository.findSubscriberBySubscriberId(user.getId());
        boolean hasSubscription = subscriber.getIsSubscribed();
        if (!hasSubscription) {
            subscriber.setIsSubscribed(true);
            subscriberRepository.save(subscriber);
            log.info("Subscription is saved - {}", user.getId());
            return true;
        }
        log.info("Subscription isn't saved - {}", user.getId());
        return false;
    }
}


