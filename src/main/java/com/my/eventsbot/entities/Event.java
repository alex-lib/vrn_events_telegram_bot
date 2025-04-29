package com.my.eventsbot.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer eventId;
    @Column(name = "title")
    private String eventTitle;
    @Column(name = "date")
    private Date eventDate;
    @Column(name = "description")
    private String eventDescription;
    @Column(name = "location")
    private String eventLocation;
}
