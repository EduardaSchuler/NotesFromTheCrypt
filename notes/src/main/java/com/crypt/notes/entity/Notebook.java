package com.crypt.notes.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Notebook {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "notebook", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Page> pages;

    private boolean isPublic;

    public Notebook() {
    }

    public Notebook(User user) {
        this.user = user;
        this.pages = List.of();
        this.isPublic = false;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void addPages(Page page) {
        this.pages.add(page);
    }

    public boolean isPublic() {
        return isPublic;
    }

}
