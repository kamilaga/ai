import {
    Author,
    Edition,
    Character,
    Genre,
    Series
} from '../';
export class Book {
    id: number;
    title: string;
    description: string;

    authors: Author[];
    editions: Edition[];
    characters: Character[];
    genres: Genre[];
    series: Series[];
    constructor() {}

    initilizeArrays(){
        this.authors = new Array<Author>();
        this.editions = new Array<Edition>();
        this.characters = new Array<Character>();
        this.genres = new Array<Genre>();
        this.series = new Array<Series>();
    }
}