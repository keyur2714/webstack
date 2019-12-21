import { Component, OnInit } from '@angular/core';
import { PaymentService } from './payment.service';
import { Registration } from '../student-entry/registration.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Payment } from './payment.model';

@Component({
  selector: 'app-manage-payments',
  templateUrl: './manage-payments.component.html',
  styleUrls: ['./manage-payments.component.css']
})
export class ManagePaymentsComponent implements OnInit {

  totalFees : number = 0;
  feesRemaining : number = 0;

  paymentForm : FormGroup = this.fb.group({
    paymentType: [null, Validators.required],
    paymentRefNo: [null, Validators.required],
    paymentDate: [null, Validators.required],
    paymentReceived: [null, Validators.required],
    student: [null, Validators.required]    
  });

  studentList : Registration[] = [];

  constructor(private paymentService : PaymentService,private fb : FormBuilder) { }

  ngOnInit() {
    this.getAllStudent();
  }

  getAllStudent() : void {
    this.paymentService.getAllStudents().subscribe(
      (data : Registration[])=>{
        this.studentList = data;
      }
    )
  }

  getFeesDetails() : void{
    let student : Registration = this.paymentForm.controls['student'].value;
    this.totalFees = student.finalFees;
    this.feesRemaining  =student.feesRemaining;
  }

  onSubmit() : void{
    if(this.paymentForm.valid){
      let payment = new Payment();
      payment = this.paymentForm.value;
      let student : Registration = this.paymentForm.controls['student'].value;
      payment.studentId = student.id;
      this.paymentService.save(payment).subscribe(
        ()=>{
          alert('Payment Updated Successfully.');      
        }
      )      
    }
    
  }
}
