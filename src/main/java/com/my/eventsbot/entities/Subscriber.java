package com.my.eventsbot.entities;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "subscribers")
public class Subscriber {
    @Id
    @Column(name = "id")
    private Long subscriberId;
    @Column(name = "user_name")
    private String userName;
    @Nullable
    @Column(name = "is_subscribed")
    private Boolean isSubscribed;
}
