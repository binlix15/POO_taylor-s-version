package models;

import java.util.Arrays;

public class Album {
    private int id;
    private String name;
    private int year;
    private String[] singles;      // los 3 sencillos del album
    private boolean rerecorded;    // true si tiene Taylor's Version, false si no
    private boolean favorite;      // true si es de mis favoritos

    public Album(int id, String name, int year, String[] singles, boolean rerecorded, boolean favorite) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.singles = singles;
        this.rerecorded = rerecorded;
        this.favorite = favorite;
    }

    public Album() {
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", singles=" + Arrays.toString(singles) +
                ", rerecorded=" + rerecorded +
                ", favorite=" + favorite +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String[] getSingles() {
        return singles;
    }

    public void setSingles(String[] singles) {
        this.singles = singles;
    }

    public boolean isRerecorded() {
        return rerecorded;
    }

    public void setRerecorded(boolean rerecorded) {
        this.rerecorded = rerecorded;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}