package com.apeshko.springboot.service;

import com.apeshko.springboot.model.Ticket;
import com.apeshko.springboot.repository.TicketsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class TicketsServiceImplTest {
    @Autowired
    private TicketsService ticketsService;

    @MockBean
    private TicketsRepository ticketsRepository;

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public TicketsService ticketsService() {
            return new TicketsServiceImpl();
        }
    }

    @Test
    void whenFindById_thenReturnTicket() {
        // given
        Ticket expectedTicket = new Ticket("Test");
        when(ticketsRepository.findById(expectedTicket.getId())).thenReturn(Optional.of(expectedTicket));

        // when
        Ticket actualResult = ticketsService.findById(expectedTicket.getId()).get();

        // then
        assertEquals(expectedTicket.getTitle(), actualResult.getTitle());
    }
}