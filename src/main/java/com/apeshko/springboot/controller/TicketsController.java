package com.apeshko.springboot.controller;

import com.apeshko.springboot.model.Ticket;
import com.apeshko.springboot.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/tickets")
public class TicketsController {
    @Autowired
    private TicketsService ticketsService;

    @GetMapping("")
    List<Ticket> findAll() {
        return ticketsService.findAll();
    }

    @GetMapping("/{id}")
    Ticket findById(@PathVariable("id") int id) {
        Ticket ticket = ticketsService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ticket;
    }

    @PostMapping("")
    Ticket create(@Valid @RequestBody Ticket ticket) {
        return ticketsService.save(ticket);
    }

    @PutMapping("/{id}")
    Ticket save(@Valid @RequestBody Ticket ticket, @PathVariable("id") int id) {
        ticket.setId(id);

        return ticketsService.save(ticket);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") int id) {
        try {
            ticketsService.deleteById(id);
        } catch (DataAccessException dataAccessException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }


        return;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }
}
