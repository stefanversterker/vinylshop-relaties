package nl.novi.vinylshop.controllers;

import jakarta.validation.Valid;
import nl.novi.vinylshop.dtos.album.AlbumRequestDTO;
import nl.novi.vinylshop.dtos.album.AlbumResponseDTO;
import nl.novi.vinylshop.helpers.UrlHelper;
import nl.novi.vinylshop.services.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;
    private final UrlHelper urlHelper;


    public AlbumController(AlbumService albumService, UrlHelper urlHelper) {
        this.albumService = albumService;
        this.urlHelper = urlHelper;

    }

    @GetMapping
    public ResponseEntity<List<AlbumResponseDTO>> getAllAlbums() {
        List<AlbumResponseDTO> albums = albumService.findAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<AlbumResponseDTO> getAlbumById(@PathVariable Long id) {
        AlbumResponseDTO album = albumService.findAlbumById(id);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AlbumResponseDTO> createAlbum(@RequestBody @Valid AlbumRequestDTO albumModel) {
        AlbumResponseDTO newAlbum = albumService.createAlbum(albumModel);
        return ResponseEntity.created(urlHelper.getCurrentUrlWithId(newAlbum.getId())).body(newAlbum);
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
    }*/


}
