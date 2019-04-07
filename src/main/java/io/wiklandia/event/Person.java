package io.wiklandia.event;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.UUID;


@Slf4j
@Entity
@Getter
@Setter
@EntityListeners(PersonEventListener.class)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

}
