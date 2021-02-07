package com.apeshko.springboot.repository;

import com.apeshko.springboot.model.Ticket;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@Tag("integration")
@DataJpaTest
class TicketsRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TicketsRepository ticketsRepository;

    @Test
    public void whenFindById_thenReturnTicket() {
        // given
        Ticket ticket = new Ticket("test");
        entityManager.persist(ticket);
        entityManager.flush();

        // when
        Ticket found = ticketsRepository.findById(ticket.getId()).orElse(null);

        // then
        assertEquals(ticket.getTitle(), found.getTitle());
    }
}