import { Component } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Trainer } from '../trainer/trainer.model';
import { Course } from '../course/course.model';
import { BatchService } from '../batch/batch.service';
import { Batch } from '../batch/batch.model';

@Component({
  selector: 'app-batch-entry',
  templateUrl: './batch-entry.component.html',
  styleUrls: ['./batch-entry.component.css']
})
export class BatchEntryComponent {
  batchForm : FormGroup = this.fb.group({
    batchName: [null, Validators.required],
    batchTime: [null, Validators.required],
    batchType: [null, Validators.required],
    startDate: [null, Validators.required],
    endDate: null,
    trainer: [null, Validators.required],
    course: [null, Validators.required]    
  });

  hasUnitNumber = false;

  batchTimes = [
    "8:00 AM-10:00 AM",
    "10:00 AM-12:00 PM",
    "12:00 PM-02:00 PM",
    "12:00 PM-03:00 PM",
    "01:00 PM-03:00 PM",
    "01:00 PM-04:00 PM",
    "02:00 PM-05:00 PM",
    "02:00 PM-04:00 PM",
    "03:00 PM-05:00 PM",
    "03:00 PM-06:00 PM",
    "04:00 PM-06:00 PM"
  ];

  batchTypes = [
    "WEEKEND",
    "WEEKDAYS"
  ];

  trainerList : Trainer[] = [
    new Trainer(1,'Keyur','7387029671','keyurjava27@gmail.com','PART_TIME','PER',40,0),
    new Trainer(2,'Jatin','7387029111','jatinpython27@gmail.com','FULL_TIME','PER',100,0)
  ];

  trainerCourseList : Course[] = [    
  ];
  

  getCourseList() : void {    
    let trainer : Trainer = this.batchForm.controls['trainer'].value;    
    if(trainer.trainerName === 'Keyur'){
      this.trainerCourseList = [
        new Course(1,'ANG','Angular',13800,this.trainerList[0]),
        new Course(3,'JAVA','Java',11800,this.trainerList[0])
      ];
    }else if(trainer.trainerName === 'Jatin'){
      this.trainerCourseList = [
        new Course(2,'PYT','Python',10800,this.trainerList[1])
      ];
    }
  }

  constructor(private fb: FormBuilder,private batchService:BatchService) {}

  onSubmit() {
    console.log(this.batchForm.value);
    if(this.batchForm.valid){
      let batch : Batch = this.batchForm.value;
      let course : Course = this.batchForm.controls['course'].value;
      batch.courseId = course.courseId;
      batch.courseCode = course.courseCode;
      batch.courseName = course.courseName;
      batch.fees = course.fees;

      let trainer : Trainer = this.batchForm.controls['trainer'].value;
      batch.trainerId = trainer.trainerId;
      batch.trainerName = trainer.trainerName;
      batch.traineMobileNo = trainer.trainerMobileNo;
      batch.trainerEmail = trainer.trainerEmail;
      batch.trainerType = trainer.trainerType;
      batch.compensationType = trainer.compensationType;
      batch.percentage = trainer.percentage;
      batch.fixedPay = trainer.fixedPay;

      console.log(this.batchForm.value);
      console.log("================");
      console.log(JSON.stringify(batch));

      this.batchService.save(batch).subscribe(
        ()=>{
          alert('Batch Created Successfully.');      
        }
      )
    }
  }
}
