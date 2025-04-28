package com.example.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TB_GAME")
public class Game implements Serializable {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 80)
    private String name;
    @Column(name = "release_date", nullable = false)
    private String releaseDate;
    @Column(name = "available_systems", nullable = false, length = 250)
    private String availableSystems;
    @Column(name = "price", nullable = false, precision = 6, scale = 2)
    private BigDecimal price;
    @Column(name = "genres", nullable = false, length = 255)
    private String genres;

    public Game(){}

    public Game(String name, String releaseDate, String availableSystems, BigDecimal price, String genres) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.availableSystems = availableSystems;
        this.price = price;
        this.genres = genres;
    }

    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAvailableSystems() {
        return availableSystems;
    }

    public void setAvailableSystems(String availableSystems) {
        this.availableSystems = availableSystems;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
