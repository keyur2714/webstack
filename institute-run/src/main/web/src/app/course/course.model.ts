import { Trainer } from '../trainer/trainer.model';

export class Course{
    constructor(public courseId ?: number,public courseCode ?: string, public courseName?:string, public fees?: number,public trainer?: Trainer){}
}