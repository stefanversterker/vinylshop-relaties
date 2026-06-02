package nl.novi.vinylshop.dtos.artist;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ArtistRequestDTO {

    @NotBlank(message = "Naam mag niet leeg zijn")
    private String name;

    @Size(max = 255, message = "Bio mag niet langer zijn dan 255 karakters")
    private String biography;

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
