package com.pjff.curso.springboot.error.springboot_error.models.domain;

//Vid 84
public class User {
    private Long id;
    private String name;
    private String lastname;

    // Vid 85, creamos al Role
    private Role role;

    // Creamos sus setters and gettes
    public User(Long id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    // Constructor vacio
    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Role getRole() {
        return role;
    }

    // Vid 85
    // public String getRoleName() {
    // return role.getName();
    // }
    public void setRole(Role role) {
        this.role = role;
    }

}
