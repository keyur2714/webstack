import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTable, MatTableDataSource } from '@angular/material/table';
import { BatchDataSource, BatchItem } from './batch-datasource';
import { BatchService } from './batch.service';
import { Batch } from './batch.model';
import { DataSource } from '@angular/cdk/table';

@Component({
  selector: 'app-batch',
  templateUrl: './batch.component.html',
  styleUrls: ['./batch.component.css']  
})
export class BatchComponent implements AfterViewInit, OnInit {
  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: false}) sort: MatSort;
  @ViewChild(MatTable, {static: false}) table: MatTable<Batch>;
  
  dataSource : MatTableDataSource<Batch> = new MatTableDataSource();

  displayedColumns = ['id', 'batchName','batchTime','batchType','startDate','endDate','course','trainer'];

  constructor(private batchService : BatchService){}

  ngOnInit() {
    this.getAllBatches();
  }

  getAllBatches() : void {
    this.batchService.getAllBatches().subscribe(
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
