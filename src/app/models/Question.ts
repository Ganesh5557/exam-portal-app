import { Quiz } from './Quiz'

export class Question {
    constructor(
        public content: string,
        public image: string,
        public option1: string,
        public option2: string,
        public option3: string,
        public option4: string,
        public answer: string,
        public quiz: Quiz) {

    }
}