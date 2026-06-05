package nl.novi.vinylshop.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Flow;

@Entity
@Table(name = "albums")
public class AlbumEntity extends BaseEntity {

    private String title;
    private int releaseYear;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publisher;

    @OneToMany(mappedBy = "album")
    private Set<StockEntity> stock_items = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "album_artist",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private Set<ArtistEntity> artists = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenreEntity genre;



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
