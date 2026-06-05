package nl.novi.vinylshop.services;

import jakarta.persistence.EntityNotFoundException;
import nl.novi.vinylshop.dtos.genre.GenreRequestDTO;
import nl.novi.vinylshop.dtos.genre.GenreResponseDTO;
import nl.novi.vinylshop.entities.GenreEntity;
import nl.novi.vinylshop.exceptions.RecordNotFoundException;
import nl.novi.vinylshop.mappers.GenreDTOMapper;
import nl.novi.vinylshop.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    private final GenreRepository genreRepository;
    private final GenreDTOMapper genreDTOMapper;


    public GenreService(GenreRepository genreRepository, GenreDTOMapper genreDTOMapper) {
        this.genreRepository = genreRepository;
        this.genreDTOMapper = genreDTOMapper;
    }

    public List<GenreResponseDTO> findAllGenres() {
        return genreDTOMapper.mapToDto(genreRepository.findAll());
    }

    public GenreResponseDTO findGenreById(Long id) throws EntityNotFoundException {
        nl.novi.vinylshop.entities.GenreEntity genreEntity = getGenreEntity(id);
        return genreDTOMapper.mapToDto(genreEntity);
    }

    public GenreResponseDTO createGenre(GenreRequestDTO genreDTO) {
        GenreEntity genreEntity = genreDTOMapper.mapToEntity(genreDTO);
        genreEntity = genreRepository.save(genreEntity);
        return genreDTOMapper.mapToDto(genreEntity);
    }

    public GenreResponseDTO updateGenre(Long id, GenreRequestDTO requestDto) throws EntityNotFoundException {
        GenreEntity existingGenreEntity = getGenreEntity(id);

        existingGenreEntity.setName(requestDto.getName());
        existingGenreEntity.setDescription(requestDto.getDescription());

        existingGenreEntity = genreRepository.save(existingGenreEntity);
        return genreDTOMapper.mapToDto(existingGenreEntity);
    }

    private GenreEntity getGenreEntity(Long id) {
        GenreEntity existingGenreEntity = genreRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Genre " + id +" not found"));
        return existingGenreEntity;
    }

    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }

//    Deze methode wordt niet gebruikt, maar dienst als alternatief voorbeeld voor de "getGenreEntity"-methode
    private GenreEntity getGenreById(Long id){
        Optional<GenreEntity> genreEntityOptional = genreRepository.findById(id);

//        Een if-statement waar je expliciet de Optional.isPresent() of Optional.isEmpty() checkt, is één variant om met de optional om te gaan.
        if(genreEntityOptional.isPresent()){
            return genreEntityOptional.get();
        } else {
            throw new RecordNotFoundException("Genre " + id +" not found");
        }
    }
}
