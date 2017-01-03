package com.mas.config;

import com.mas.domain.model.*;
import com.mas.domain.model.Character;
import com.mas.domain.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class DBInit {

    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private SeriesRepository seriesRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ReaderRepository readerRepository;

    @PostConstruct
    public void init() {
        addAuthors();
        addCharacters();
        addGenres();
        addSeries();
        addPublishers();
        addBooks();
    }

    private void addAuthors() {
        Author a1 = new Author("Terry", "Pratchett", "http://discworld.com/");
        authorRepository.save(a1);
        Author a2 = new Author("J. R. R.", "Tolkien", "http://www.tolkiensociety.org/");
        authorRepository.save(a2);
    }


    private void addCharacters() {
        Character c1 = new Character("Rincewind", "Rincewind has been an important character since the Discworld series started. He is a polite yet cowardly wizard with (almost) no magical ability and whose ambition in life is simply to continue having a life. He has been on many adventures, but almost entirely by accident. He is however gifted with languages, speaking several including Chimeran, Vanglemesht, Sumtri, Black Oroogu, High Borogravian and beTrobi.");
        characterRepository.save(c1);
    }

    private void addGenres() {
        Genre g1 = new Genre("Fantasy");
        Genre g2 = new Genre("Science-Fiction");
        genreRepository.save(g1);
        genreRepository.save(g2);
    }

    private void addSeries() {
        Series s1 = new Series("Discworld");
        seriesRepository.save(s1);
    }

    private void addPublishers() {
        Publisher p1 = new Publisher("Colin Smythe", "http://www.colinsmythe.co.uk/");
        publisherRepository.save(p1);
    }

    private void addBooks(){
        Book b1 = new Book("The Colour of Magic", "The main character is an incompetent and cynical wizard named Rincewind. He involuntarily becomes a guide to the rich but naive tourist from the Agatean Empire, Twoflower. Forced to flee the city of Ankh-Morpork to escape a terrible fire caused by a bartender who misunderstood the concept of insurance, which Twoflower told him about, they begin on a journey across the Disc. Unknown to them, their journey is controlled by the Gods playing a board game. Rincewind and Twoflower are controlled by the Lady and are pitted against the champions of Zephyrus, the god of slight breezes, Fate, and Offler the Crocodile God in the game supervised by Blind Io, an obvious take on Thor/Zeus/Jupiter.");
        b1.getAuthors().add(authorRepository.findByLastName("Pratchett").get(0));
        Publisher p1 = publisherRepository.findAll().get(0);
        Edition edition = new Edition(Edition.Format.PAPERBACK, "12345345", LocalDate.now(), p1);
        b1.getEditions().add(edition);
        edition.setBook(b1);
        b1.getCharacters().add(characterRepository.findAll().get(0));
        b1.getGenres().addAll(genreRepository.findAll());
        b1.getSeries().add(seriesRepository.findAll().get(0));
        bookRepository.save(b1);
    }

}