package io.wiklandia.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonEventLogger {

    void log(Person person) {
        log.info("Logging person! {} ", person.getName());
    }

}
