package nl.novi.vinylshop.dtos.album;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AlbumRequestDTO {

    @NotBlank(message = "Titel mag niet leeg zijn")
    private String title;

    @NotBlank(message = "Release jaar mag niet leeg zijn")
    @Size(min = 4, max = 4)
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
