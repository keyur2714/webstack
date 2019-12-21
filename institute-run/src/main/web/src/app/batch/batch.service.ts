import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Batch } from './batch.model';
import { Course } from '../course/course.model';
import { Trainer } from '../trainer/trainer.model';

@Injectable()
export class BatchService {

    batchApiUrl : string = 'http://localhost:8080/api/batches/list';
    batchAddUrl : string = 'http://localhost:8080/api/batches/add';

    constructor(public httpClient: HttpClient){}

    public getAllBatches() : Observable<Batch[]> {
        return this.httpClient.get<Batch[]>(this.batchApiUrl);
    }

    public getBatchById(id : number) : Observable<Batch> {
        return this.httpClient.get<Batch>(this.batchApiUrl+"/"+id);
    }

    public save(batch : Batch) : Observable<void>{
        return this.httpClient.post<void>(this.batchAddUrl,batch);
    }


}