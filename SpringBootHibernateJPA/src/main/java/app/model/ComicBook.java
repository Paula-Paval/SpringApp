package app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="comicbook")
public class ComicBook {
    @Id
    private Integer id;
    private String series;
    private Integer number;

    public ComicBook() {
    }

    public ComicBook(String series, Integer number) {
        this.series = series;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ComicBook{" +
                "id=" + id +
                ", series='" + series + '\'' +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComicBook comicBook = (ComicBook) o;
        return Objects.equals(id, comicBook.id) && Objects.equals(series, comicBook.series) && Objects.equals(number, comicBook.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, series, number);
    }
}
