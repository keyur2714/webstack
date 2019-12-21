import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Registration } from '../student-entry/registration.model';
import { Payment } from './payment.model';

@Injectable()
export class PaymentService {

    

    paymentApiUrl : string = 'http://localhost:8080/api/registration/listByFeesStatus';
    paymentAddUrl : string = 'http://localhost:8080/api/payments/add';
    
    constructor(public httpClient: HttpClient){}

    public getAllStudents() : Observable<Registration[]> {
        return this.httpClient.get<Registration[]>(this.paymentApiUrl+"/PAID");
    }

    public save(payment : Payment) : Observable<void>{
        return this.httpClient.post<void>(this.paymentAddUrl,payment);
    }
}