package com.crypt.notes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;

@Entity
public class ContentBlock {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private BlockType type;

    @Lob
    private String content;

    @OneToOne
    private Page page;

    public ContentBlock() {
    }

    public ContentBlock(BlockType type, Page page) {
        this.type = type;
        this.page = page;
    }

    public Long getId() {
        return id;
    }

    public BlockType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public Page getPage() {
        return page;
    }

    public void addContent(String content) {
        this.content = content;
    }

}

