package nl.novi.vinylshop.repositories;

import nl.novi.vinylshop.entities.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository  extends JpaRepository<AlbumEntity, Long> {
}
