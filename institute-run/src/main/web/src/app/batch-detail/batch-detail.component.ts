import { Component, OnInit, ViewChild } from '@angular/core';
import { BatchService } from '../batch/batch.service';
import { ActivatedRoute } from '@angular/router';
import { Batch } from '../batch/batch.model';
import { MatDialog, MatPaginator, MatSort, MatTable, MatTableDataSource } from '@angular/material';
import { StudnetAllocationDialogComponent } from '../studnet-allocation-dialog/studnet-allocation-dialog.component';
import { Registration } from '../student-entry/registration.model';
import { RegistrationService } from '../registration/registration.service';

@Component({
  selector: 'app-batch-detail',
  templateUrl: './batch-detail.component.html',
  styleUrls: ['./batch-detail.component.css']
})
export class BatchDetailComponent implements OnInit {

  loading : boolean = true;
  batch : Batch = new Batch();
  batchId : number = 0;
  students : Registration[] = [];
  
  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: false}) sort: MatSort;
  @ViewChild(MatTable, {static: false}) table: MatTable<Registration>;
  
  @ViewChild('ref', {static : false}) ref;

  dataSource : MatTableDataSource<Registration> = new MatTableDataSource();

  displayedColumns = ['id', 'name','mobileNo','email','courseName','finalFees','feesRemaining'];

  constructor(private batchService:BatchService,private registrationService : RegistrationService,private activatedRoute : ActivatedRoute,public dialog: MatDialog) {}

  ngOnInit() {
    this.batchId = this.activatedRoute.snapshot.params.id;
    this.getBatchDetail(this.batchId);
  } 

  getBatchDetail(batchId : number) : void{
    this.batchService.getBatchById(batchId).subscribe(
      (batch : Batch)=>{
        this.batch = batch;
        if(this.batch.id > 0){
          this.getStudentsByBatchId(batchId);
        }        
      }
    )
  }
    
  getStudentsByBatchId(batchId : number) : void {
    this.registrationService.getAllStudentListByBatch(batchId).subscribe(
      (data : Registration[])=>{
        this.dataSource.data = data;
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
        this.table.dataSource = this.dataSource;
        this.loading = false;
      }
    )
  }

  allocateStudents(batchId,courseCode) : void{
    
    const dialogRef = this.dialog.open(StudnetAllocationDialogComponent, {
      width: '650px',
      data: {batchId: batchId, courseCode : courseCode,students : this.students}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed: '+result);      
      this.getStudentsByBatchId(batchId);
    });

    
  }

  
  
}
