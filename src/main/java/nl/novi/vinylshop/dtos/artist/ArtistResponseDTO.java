package nl.novi.vinylshop.dtos.artist;

import nl.novi.vinylshop.dtos.album.AlbumResponseDTO;

import java.util.List;

public class ArtistResponseDTO {
    private Long id;
    private String name;
    private String biography;
    private List<AlbumResponseDTO> albums;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<AlbumResponseDTO> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumResponseDTO> albums) {
        this.albums = albums;
    }
}
