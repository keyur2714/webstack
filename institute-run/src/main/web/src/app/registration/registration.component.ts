import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { MatPaginator, MatSort, MatTable, MatTableDataSource } from '@angular/material';
import { Registration } from '../student-entry/registration.model';
import { RegistrationService } from './registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit,AfterViewInit {

  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: false}) sort: MatSort;
  @ViewChild(MatTable, {static: false}) table: MatTable<Registration>;
  
  dataSource : MatTableDataSource<Registration> = new MatTableDataSource();

  displayedColumns = ['id', 'name','mobileNo','email','registrationDate','courseName','finalFees','feesRemaining','feesStatus'];


  constructor(private registrationService : RegistrationService) { }

  ngOnInit(){
    this.getAllStudents();
  }

  getAllStudents() : void {
    this.registrationService.getAllStudentList().subscribe(
      (data) =>{
        this.dataSource.data = data;
      }
    )
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    this.table.dataSource = this.dataSource;
  }

  public doFilter = (value: string) => {
    this.dataSource.filter = value.trim().toLocaleLowerCase();
  }

}
