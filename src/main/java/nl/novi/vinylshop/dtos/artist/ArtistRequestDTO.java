package nl.novi.vinylshop.dtos.artist;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ArtistRequestDTO {

    @NotBlank(message = "Naam mag niet leeg zijn")
    private String name;

    private String biography;

    //Getters en setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
