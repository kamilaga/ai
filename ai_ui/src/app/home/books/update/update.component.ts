import { Component, OnInit } from '@angular/core';
import { Router, RouteSegment } from '@angular/router';
import {
  AuthorService, Author,
  SeriesService, Series,
  GenreService, Genre,
  CharacterService, Character,
  PublisherService, Publisher,
  BookService, Book,
  Edition
} from '../../../shared';

@Component({
  moduleId: module.id,
  selector: 'app-update',
  templateUrl: 'update.component.html',
  styleUrls: ['update.component.css']
})
export class UpdateComponent implements OnInit {
  currentStep: number = 0;
  debugging: boolean = true;
  authorsAmountWarning: boolean = false;
  bookSavedSuccess: boolean = false;

  id: number;
  newBook: Book;
  newAuthor: Author = new Author();
  newGenre: Genre = new Genre();
  newSeries: Series = new Series();
  newCharacter: Character = new Character();
  newEdition: Edition = new Edition();
  selectedAuthor: Author;
  selectedGenre: Genre;
  selectedSeries: Series;
  selectedCharacter: Character;
  editionFormats = new Array<string>('EBOOK', 'AUDIO', 'HARDCOVER', 'PAPERBACK');

  authors: Author[] = new Array<Author>();
  series: Series[] = new Array<Series>();
  genres: Genre[] = new Array<Genre>();
  characters: Character[] = new Array<Character>();
  publishers: Publisher[] = new Array<Publisher>();
  books: Book[] = new Array<Book>();

  constructor(
    private router: Router,
    private routeSegment: RouteSegment,
    private authorService: AuthorService,
    private seriesService: SeriesService,
    private genreService: GenreService,
    private characterService: CharacterService,
    private publisherService: PublisherService,
    private bookService: BookService
  ) {
  }

  ngOnInit() {
    this.newBook = new Book();
    this.id = +this.routeSegment.getParam('id');
    this.bookService.getBook(this.id)
      .subscribe((book) => {
        this.newBook = book
        this.newEdition.format = this.editionFormats[0];
        this.authorService.getAuthors()
          .subscribe(authors => this.initAuthors(authors), (error) => console.log(error));
        this.seriesService.getSeries()
          .subscribe(series => this.initSeries(series), (error) => console.log(error));
        this.genreService.getGenres()
          .subscribe(genres => this.initGenres(genres), (error) => console.log(error));
        this.characterService.getCharacters()
          .subscribe(characters => this.initCharacters(characters), (error) => console.log(error));
        this.publisherService.getPublishers()
          .subscribe(publishers => this.initPublishers(publishers), (error) => console.log(error));
        this.bookService.getBooks()
          .subscribe(books => this.books = books, (error) => console.log(error));
      }, (error) => { console.log(error); this.router.navigate(['/books']) });
  }

  clearData() {
    this.bookSavedSuccess = false;
    this.newAuthor = new Author();
    this.newGenre = new Genre();
    this.newSeries = new Series();
    this.newCharacter = new Character();
    this.newEdition = new Edition();
    this.ngOnInit();
  }

  continue() {
    if (this.currentStep === 1 && this.newBook.authors.length < 1) {
      this.authorsAmountWarning = true;
      return;
    }
    this.authorsAmountWarning = false;
    if (this.currentStep === 7) {
      this.clearData();
    }
    this.currentStep += 1;
    if (this.currentStep > 7) {
      this.currentStep = 0;
      return;
    }
  }

  goBack() {
    this.currentStep -= 1;
  }


  initAuthors(authors: Author[]) {
    for (let author of authors) {
      if (this.newBook.authors.filter((author1) => author1.id == author.id).length > 0) {
      } else {
        this.authors.push(author);
      }
    }
    if (this.authors.length > 0) {
      this.selectedAuthor = this.authors[0];
    }
  }

  initGenres(genres: Genre[]) {
    for (let genre of genres) {
      if (this.newBook.genres.filter((genre1) => genre1.id == genre.id).length > 0) {
      } else {
        this.genres.push(genre);
      }
    }
    if (this.genres.length > 0) {
      this.selectedGenre = this.genres[0];
    }
  }

  initCharacters(characters: Character[]) {
    for (let character of characters) {
      if (this.newBook.characters.filter((character1) => character1.id == character.id).length > 0) {
      } else {
        this.characters.push(character);
      }
    }
    if (this.characters.length > 0) {
      this.selectedCharacter = this.characters[0];
    }
  }

  initPublishers(publishers: Publisher[]) {
    this.publishers = publishers;
    this.newEdition.publisher = this.publishers[0];
  }

  initSeries(series: Series[]) {
    for (let serie of series) {
      if (this.newBook.series.filter((serie1) => serie1.id == serie.id).length > 0) {
      } else {
        this.series.push(serie);
      }
    }
    if (this.series.length > 0) {
      this.selectedSeries = this.series[0];
    }
  }

  addNewAuthor() {
    this.authorService.createAuthor(this.newAuthor)
      .subscribe(
      author => {
        this.newBook.authors.push(author);
        this.newAuthor = new Author();
        this.authorsAmountWarning = false;
      }, (error) => console.log(error))
  }

  addAuthor() {
    this.newBook.authors.push(this.authors.splice(this.authors.indexOf(this.selectedAuthor), 1)[0]);
    this.authorsAmountWarning = false;
  }

  removeAuthor(author: Author) {
    this.authors.push(this.newBook.authors.splice(this.newBook.authors.indexOf(author), 1)[0]);
    if (this.authors.length == 1) {
      this.selectedAuthor = this.authors[0];
    }
  }

  addNewGenre() {
    this.genreService.createGenre(this.newGenre)
      .subscribe(
      genre => {
        this.newBook.genres.push(genre);
        this.newGenre = new Genre();
      }, (error) => console.log(error))
  }

  addGenre() {
    this.newBook.genres.push(this.genres.splice(this.genres.indexOf(this.selectedGenre), 1)[0]);
  }

  removeGenre(genre: Genre) {
    this.genres.push(this.newBook.genres.splice(this.newBook.genres.indexOf(genre), 1)[0]);
    if (this.genres.length == 1) {
      this.selectedGenre = this.genres[0];
    }
  }

  addNewSeries() {
    this.seriesService.createSeries(this.newSeries)
      .subscribe(
      series => {
        this.newBook.series.push(series);
        this.newSeries = new Series();
      }, (error) => console.log(error))
  }

  addSeries() {
    this.newBook.series.push(this.series.splice(this.series.indexOf(this.selectedSeries), 1)[0]);
  }

  removeSeries(series: Series) {
    this.series.push(this.newBook.series.splice(this.newBook.series.indexOf(series), 1)[0]);
    if (this.series.length == 1) {
      this.selectedSeries = this.series[0];
    }
  }

  addNewCharacter() {
    this.characterService.createCharacter(this.newCharacter)
      .subscribe(
      character => {
        this.newBook.characters.push(character);
        this.newCharacter = new Character();
      }, (error) => console.log(error))
  }

  addCharacter() {
    this.newBook.characters.push(this.characters.splice(this.characters.indexOf(this.selectedCharacter), 1)[0]);
    if (this.characters.length != 0) {
      this.selectedCharacter = this.characters[0];
    }
  }

  removeCharacter(character: Character) {
    this.characters.push(this.newBook.characters.splice(this.newBook.characters.indexOf(character), 1)[0]);
    if (this.characters.length == 1) {
      this.selectedCharacter = this.characters[0];
    }
  }

  addNewEdition() {
    this.newBook.editions.push(this.newEdition);
    this.newEdition = new Edition();
    this.newEdition.format = this.editionFormats[0];
    this.newEdition.publisher = this.publishers[0];
  }

  removeEdition(edition: Edition) {
    this.newBook.editions.splice(this.newBook.editions.indexOf(edition), 1);
  }

  saveBook() {
    this.bookService.updateBook(this.newBook)
      .subscribe(
      book => {
        this.bookSavedSuccess = true;
        this.router.navigate(['/books'])
        console.log(book)
      },
      (error) => console.log(error)
      )
  }

  goTo(step: number) {
    if (step == 0) {
      this.clearData();
    }
    if (step == 8) {
      this.bookService.getBooks()
        .subscribe(books => this.books = books, (error) => console.log(error));
    }
    this.currentStep = step;
  }

}