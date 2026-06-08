package nl.novi.vinylshop.dtos.album;

import jakarta.validation.constraints.*;

public class AlbumRequestDTO {

    @NotBlank(message = "Titel mag niet leeg zijn")
    @Size(min = 3, max = 100)
    private String title;

    @Min(1877)
    @Max(2100)
    private int releaseYear;

    private Long genreId;

    private Long publisherId;

    //Getters en setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
