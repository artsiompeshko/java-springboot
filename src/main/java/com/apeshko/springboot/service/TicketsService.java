package com.apeshko.springboot.service;

import com.apeshko.springboot.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketsService {
    List<Ticket> findAll();
    Optional<Ticket> findById(int id);
    Ticket save(Ticket ticket);
    void deleteById(int id);
}
