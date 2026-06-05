package nl.novi.vinylshop.dtos.album;

import jakarta.validation.constraints.*;

public class AlbumRequestDTO {

    @NotBlank(message = "Titel mag niet leeg zijn")
    private String title;

    @NotNull(message = "Release jaar mag niet leeg zijn")
    @Min(1900)
    @Max(2100)
    private int releaseYear;

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
