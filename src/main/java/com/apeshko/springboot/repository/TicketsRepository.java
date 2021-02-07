package com.apeshko.springboot.repository;

import com.apeshko.springboot.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsRepository extends JpaRepository<Ticket, Integer> {
}
