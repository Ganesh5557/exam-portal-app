import { Category } from './Category';

export class Quiz {
    constructor(
        public title: string,
        public descr: string,
        public maxQues: string,
        public maxMarks: string,
        public noOfQues: string,
        public active: boolean,
        public category: Category
    ) { }
}