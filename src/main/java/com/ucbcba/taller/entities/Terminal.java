package com.ucbcba.taller.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "terminal") //DUDA: " Por que aqui se pone esto, pero en "Location" no? "
public class Terminal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String serial;

    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "terminal", cascade = CascadeType.ALL)
    private Set<Location> locations;

    @OneToMany(mappedBy = "terminal", cascade = CascadeType.ALL)
    private Set<TerminalHistory> terminalHistories;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCategoryName() {
        return category == null ? "" : category.getName();
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getUserName() { return user == null ? "" : user.getName(); }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    public Set<TerminalHistory> getTerminalHistories() {
        return terminalHistories;
    }

    public void setTerminalHistories(Set<TerminalHistory> terminalHistories) {
        this.terminalHistories = terminalHistories;
    }

}
