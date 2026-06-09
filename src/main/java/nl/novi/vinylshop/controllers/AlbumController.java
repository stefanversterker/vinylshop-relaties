package nl.novi.vinylshop.controllers;

import jakarta.validation.Valid;
import nl.novi.vinylshop.dtos.album.AlbumExtendedResponseDto;
import nl.novi.vinylshop.dtos.album.AlbumRequestDTO;
import nl.novi.vinylshop.dtos.album.AlbumResponseDTO;
import nl.novi.vinylshop.dtos.artist.ArtistResponseDTO;
import nl.novi.vinylshop.helpers.UrlHelper;
import nl.novi.vinylshop.services.AlbumService;
import nl.novi.vinylshop.services.ArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;
    private final UrlHelper urlHelper;
    private final ArtistService artistService;


    public AlbumController(AlbumService albumService,
                           UrlHelper urlHelper,
                           ArtistService artistService) {
        this.albumService = albumService;
        this.urlHelper = urlHelper;
        this.artistService = artistService;

    }

    @GetMapping
    public ResponseEntity<List<AlbumResponseDTO>> getAllAlbums() {
        List<AlbumResponseDTO> albums = albumService.findAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumExtendedResponseDto> getAlbumById(@PathVariable Long id) {
        AlbumExtendedResponseDto album = albumService.findAlbumById(id);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @GetMapping("/{id}/artists")
    public ResponseEntity<List<ArtistResponseDTO>> linkArtist(@PathVariable Long id){
        List<ArtistResponseDTO> artists = artistService.getArtistsForAlbum(id);
        return ResponseEntity.ok(artists);
    }

    @PostMapping
    public ResponseEntity<AlbumResponseDTO> createAlbum(@RequestBody @Valid AlbumRequestDTO albumModel) {
        AlbumResponseDTO newAlbum = albumService.createAlbum(albumModel);
        return ResponseEntity.created(urlHelper.getCurrentUrlWithId(newAlbum.getId())).body(newAlbum);
    }

    @PostMapping("/{albumId}/artists/{artistId}")
    public ResponseEntity<Void> linkArtist(
            @PathVariable Long albumId,
            @PathVariable Long artistId) {

        albumService.linkArtist(albumId, artistId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlbumResponseDTO> updateAlbum(@PathVariable Long id, @RequestBody @Valid AlbumRequestDTO albumModel) {
        AlbumResponseDTO updatedAlbum = albumService.updateAlbum(id, albumModel);;
        return new ResponseEntity<>(updatedAlbum, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{albumId}/artists/{artistId}")
    public ResponseEntity<Void> unlinkArtist(
            @PathVariable Long albumId,
            @PathVariable Long artistId) {

        albumService.unlinkArtist(albumId, artistId);
        return ResponseEntity.ok().build();
    }

}
