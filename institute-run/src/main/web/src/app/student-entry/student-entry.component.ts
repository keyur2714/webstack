import { Component, OnInit } from '@angular/core';
import { Course } from '../course/course.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { RegistrationService } from '../registration/registration.service';
import { Registration } from './registration.model';

@Component({
  selector: 'app-student-entry',
  templateUrl: './student-entry.component.html',
  styleUrls: ['./student-entry.component.css']
})
export class StudentEntryComponent implements OnInit {

  courseList : Course[] = [
    new Course(1,'ANG','Angular',13800),
    new Course(2,'PYT','Python',10800),
    new Course(3,'JAVA','Java',10800)
  ];

  studentForm : FormGroup = this.fb.group({
    name: [null, Validators.required],
    mobileNo: [null, Validators.required],
    email: [null, Validators.required],
    course: [null, Validators.required],
    totalFees: null,
    discount: [null],
    finalFees: [null],
    registrationDate : [null]
  });
  
  constructor(private fb : FormBuilder,private registrationService : RegistrationService) { }

  ngOnInit() {
  }

  getFees() {
    let course : Course = this.studentForm.controls['course'].value;    
    this.studentForm.controls['totalFees'].setValue(course.fees);
    this.studentForm.controls['discount'].setValue(0);
    this.studentForm.controls['finalFees'].setValue(course.fees);
  }

  calculateFees() {
    let discount  = this.studentForm.controls['discount'].value;
    let totalFees = this.studentForm.controls['totalFees'].value;
    this.studentForm.controls['finalFees'].setValue(totalFees - (totalFees*discount/100));
  }


  onSubmit() {
    console.log(this.studentForm.value);
    if(this.studentForm.valid){
      let student : Registration = this.studentForm.value;
      let course : Course = this.studentForm.controls['course'].value;
      student.courseId = course.courseId;
      student.courseName = course.courseName;
      student.feesStatus = 'NOT_PAID';
      student.feesRemaining = student.finalFees;
      student.feesPaid = 0;
      this.registrationService.save(student).subscribe(
        ()=>{
          alert('Student Registered Successfully.');      
        }
      )
    }
  }

}
