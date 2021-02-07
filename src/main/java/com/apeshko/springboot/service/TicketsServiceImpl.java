package com.apeshko.springboot.service;

import com.apeshko.springboot.model.Ticket;
import com.apeshko.springboot.repository.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketsServiceImpl implements TicketsService {
    @Autowired
    private TicketsRepository ticketsRepository;

    @Override
    public List<Ticket> findAll() {
        return ticketsRepository.findAll();
    }

    @Override
    public Optional<Ticket> findById(int id) {
        return ticketsRepository.findById(id);
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketsRepository.save(ticket);
    }

    @Override
    public void deleteById(int id) {
        ticketsRepository.deleteById(id);
    }
}
