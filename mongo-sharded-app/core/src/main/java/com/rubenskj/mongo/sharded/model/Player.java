package com.rubenskj.mongo.sharded.model;

import java.time.LocalDateTime;
import java.util.List;

public class Player {

    private String id;
    private String name;
    private int age;
    private String position;
    private List<String> favoriteCharacters;
    private LocalDateTime createdAt;

    public Player() {
    }

    public Player(String id, String name, int age, String position, List<String> favoriteCharacters, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.favoriteCharacters = favoriteCharacters;
        this.createdAt = createdAt;
    }

    public Player(String name, int age, String position, List<String> favoriteCharacters) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.favoriteCharacters = favoriteCharacters;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<String> getFavoriteCharacters() {
        return favoriteCharacters;
    }

    public void setFavoriteCharacters(List<String> favoriteCharacters) {
        this.favoriteCharacters = favoriteCharacters;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
