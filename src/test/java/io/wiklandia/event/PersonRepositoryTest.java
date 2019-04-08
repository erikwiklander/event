package io.wiklandia.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {

    @MockBean
    private PersonEventLogger personEventLogger;

    @Autowired
    private PersonRepository personRepository;

    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void test() {
        Person p = new Person();
        p.setName("Name");
        personRepository.save(p);

        ArgumentCaptor<Person> capture = ArgumentCaptor.forClass(Person.class);
        verify(personEventLogger).log(capture.capture());

        assertThat(capture.getValue().getName()).isEqualTo("Name");
    }


}