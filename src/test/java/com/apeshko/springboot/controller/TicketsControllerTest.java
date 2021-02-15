package com.apeshko.springboot.controller;

import com.apeshko.springboot.model.Ticket;
import com.apeshko.springboot.service.TicketsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TicketsController.class)
class TicketsControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private TicketsService ticketsService;

    @Test
    public void givenTickets_whenFindAllTickets_thenReturnJsonArray()
            throws Exception {
        // Given
        Ticket ticket = new Ticket("test");
        List<Ticket> allTickets = Arrays.asList(ticket);
        when(ticketsService.findAll()).thenReturn(allTickets);

        // then
        mvc.perform(get("/api/tickets")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is(ticket.getTitle())));
    }
}