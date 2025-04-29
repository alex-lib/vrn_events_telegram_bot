package com.my.eventsbot.repositories;
import com.my.eventsbot.entities.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Integer> {
    Subscriber findSubscriberBySubscriberId(Long subscriberId);
    @Query("SELECT s FROM Subscriber s WHERE s.isSubscribed = true")
    List<Subscriber> findSubscribedUsers();
}
