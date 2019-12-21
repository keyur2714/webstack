import { Registration } from '../student-entry/registration.model';

export class Payment{
    constructor(public paymentId?:number,public paymentType?:string,public paymentRefNo?:string,public paymentDate?:Date,public paymentReceived ?: number,public studentId?:number){}
}