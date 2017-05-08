package com.ucbcba.taller.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_parent_id")
    private User parent;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Terminal> terminals;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private Set<User> children;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_company", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "company_id"))
    private Set<Company> companies;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public User getParent() { return parent; }

    public void setParent(User parent) { this.parent = parent; }

    public String getParentName() { return parent == null ? "" : parent.getName(); }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Terminal> getTerminals() {
        return terminals;
    }

    public void setTerminals(Set<Terminal> terminals) {
        this.terminals = terminals;
    }

    public Set<User> getChildren() { return children; }

    public void setChildren(Set<User> children) { this.children = children; }

    public Set<Company> getCompanies() { return companies; }

    public void setCompanies(Set<Company> companies) { this.companies = companies; }
}
