package com.ucbcba.taller.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "terminal_history")
public class TerminalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String serial;

    private Boolean active;

    private Integer categoryId;

    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "terminal_id")
    private Terminal terminal;

    private Date dateChange;

    public TerminalHistory() {
        dateChange = new Date();
    }

    public TerminalHistory(Terminal terminal) {

        serial = terminal.getSerial();
        active = terminal.getActive();
        categoryId = terminal.getCategory().getId();
        userId = terminal.getUser().getId();
        dateChange = new Date();
    }

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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public Date getDateChange() {
        return dateChange;
    }

    public void setDateChange(Date dateChange) {
        this.dateChange = dateChange;
    }
}
