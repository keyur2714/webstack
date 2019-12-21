import { Component, OnInit, Inject, ViewChild, AfterViewInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatPaginator, MatSort, MatTable, MatTableDataSource, MatDialogRef } from '@angular/material';
import { Registration } from '../student-entry/registration.model';
import { RegistrationService } from '../registration/registration.service';

@Component({
  selector: 'app-studnet-allocation-dialog',
  templateUrl: './studnet-allocation-dialog.component.html',
  styleUrls: ['./studnet-allocation-dialog.component.css']
})
export class StudnetAllocationDialogComponent implements OnInit,AfterViewInit {

  courseCode : string = '';  

  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: false}) sort: MatSort;
  @ViewChild(MatTable, {static: false}) table: MatTable<Registration>;
  
  @ViewChild('ref', {static : false}) ref;

  dataSource : MatTableDataSource<Registration> = new MatTableDataSource();

  //displayedColumns = ['selected','id', 'name','mobileNo','email','courseName'];
  displayedColumns = ['selected','id', 'name','mobileNo','email','courseName','finalFees','feesRemaining'];


  constructor(public dialogRef: MatDialogRef<StudnetAllocationDialogComponent>,@Inject(MAT_DIALOG_DATA) public data: any,private registrationService : RegistrationService) { 
    this.courseCode = data.courseCode;    
  }

  ngOnInit() {
    this.registrationService.getAllStudentListByCourse(this.courseCode).subscribe(
      (data : Registration[])=>{
        this.dataSource.data = data;
      }
    )    
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  apply() : void{
    console.log(this.data);
    this.data.students = this.dataSource.data.filter(obg=>obg.selected);
    console.log(this.data.students);
    console.log(this.dataSource.data);
    this.registrationService.updateStudentBatch(this.data.batchId,this.data.students).subscribe(
      (data)=>{
        console.log(data);
        this.dialogRef.close("Student Allocated Successfully.");
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
