package com.rubenskj.mongo.core.dto;

import com.rubenskj.mongo.core.model.Player;

import java.util.List;

public class PlayerDTO {

    private String id;
    private String name;
    private int age;
    private String position;
    private List<String> favoriteCharacters;

    public PlayerDTO() {
    }

    public PlayerDTO(String id, String name, int age, String position, List<String> favoriteCharacters) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.favoriteCharacters = favoriteCharacters;
    }

    public PlayerDTO(String name, int age, String position, List<String> favoriteCharacters) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.favoriteCharacters = favoriteCharacters;
    }

    public static PlayerDTO of(Player player) {
        return new PlayerDTO(
                player.getId(),
                player.getName(),
                player.getAge(),
                player.getPosition(),
                player.getFavoriteCharacters()
        );
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

    @Override
    public String toString() {
        return "PlayerDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", favoriteCharacters=" + favoriteCharacters +
                '}';
    }
}
