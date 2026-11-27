package com.norinti.spring.app.catalogo.domain;

public class User {

    private Long id;
    private String username;
    private String password;
    private String tenant;
    private String role;

    public User(String username,String password,String tenant,String role){
        this.username = username;
        this.password = password;
        this.tenant = tenant;
        this.role = role;
    }
    public User(String username,String password){
        this.username = username;
        this.password = password; 
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String userName) {
        this.username = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getTenant() {
        return tenant;
    }
    public void setTenant(String tenant) {
        this.tenant = tenant;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    
}
