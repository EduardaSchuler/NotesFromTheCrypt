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

    public Page() {
    }

    public Page(Long id, Notebook notebook) {
        this.id = id;
        this.notebook = notebook;
        blocks = List.of();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public List<ContentBlock> getBlocks() {
        return blocks;
    }

    public void addBlocks(ContentBlock block) {
        this.blocks.add(block);
    }

}