package com.crypt.notes.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Page {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @ManyToOne
    private Notebook notebook;

    @OneToMany(mappedBy = "page", cascade = CascadeType.ALL)
    private List<ContentBlock> blocks;
}