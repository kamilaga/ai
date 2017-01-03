import { Publisher } from '../';
export class Edition {
    id: number;
    format: string;
    ISBN: string;
    datePublished: Date;
    publisher:Publisher;

    constructor() { }
}