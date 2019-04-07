package io.wiklandia.event;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;

@Slf4j
@Component
@AllArgsConstructor
public class PersonEventListener {

    private final PersonEventLogger personEventLogger;

    @PostPersist
    public void postPersist(Person person) {
        personEventLogger.log(person);
    }
}
