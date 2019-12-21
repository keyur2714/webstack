import { Injectable } from '@angular/core';
import { Registration } from '../student-entry/registration.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class RegistrationService {    
    registrationApiUrl : string = 'http://localhost:8080/api/registration/list';
    registrationAddUrl : string = 'http://localhost:8080/api/registration/add';
    registrationGetStudentsByCourseApiUrl : string = 'http://localhost:8080/api/registration/listByCourseCode';
    updateStudentBatchUrl : string = 'http://localhost:8080/api/registration/updateStudentBatch';
    registrationGetStudentsByBatchApiUrl : string = 'http://localhost:8080/api/registration/listByBatchId';
    constructor(private httpClient ?: HttpClient){}

    getAllStudentList():Observable<Registration[]>{
        return this.httpClient.get<Registration[]>(this.registrationApiUrl);
    }

    getAllStudentListByCourse(courseCode : string):Observable<Registration[]>{
        return this.httpClient.get<Registration[]>(this.registrationGetStudentsByCourseApiUrl+"/"+courseCode);
    }

    getAllStudentListByBatch(batchId : number):Observable<Registration[]>{
        return this.httpClient.get<Registration[]>(this.registrationGetStudentsByBatchApiUrl+"/"+batchId);
    }

    public save(registration : Registration) : Observable<void>{
        return this.httpClient.post<void>(this.registrationAddUrl,registration);
    }

    public updateStudentBatch(batchId : number,students : Registration[]) : Observable<any> {
        return this.httpClient.put<any>(this.updateStudentBatchUrl+"/"+batchId,students);
    }
}