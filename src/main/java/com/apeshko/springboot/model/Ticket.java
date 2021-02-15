package com.apeshko.springboot.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotBlank(message = "Title is required")
    private String title;

    public Ticket() {
    }

    public Ticket(@NotBlank(message = "Title is required") String title) {
        this.title = title;
    }

    public Ticket(int id, @NotBlank(message = "Title is required") String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
