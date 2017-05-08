package com.ucbcba.taller.entities;

import javax.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Double lat;
    private Double ing;
    private Integer likes;

    @ManyToOne
    @JoinColumn(name = "terminal_id") //DUDA: " se llama "terminal_id" porque asi se llama el campo en la tabla "Location"? "
    private Terminal terminal;

    public Location() {
        likes = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getIng() {
        return ing;
    }

    public void setIng(Double ing) {
        this.ing = ing;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public String getTerminalSerial() {
        return terminal == null ? "" : terminal.getSerial();
    }
}