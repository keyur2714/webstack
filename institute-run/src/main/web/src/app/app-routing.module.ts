import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { BatchComponent } from './batch/batch.component';
import { NavComponent } from './nav/nav.component';
import { BatchEntryComponent } from './batch-entry/batch-entry.component';
import { RegistrationComponent } from './registration/registration.component';
import { StudentEntryComponent } from './student-entry/student-entry.component';
import { ManagePaymentsComponent } from './manage-payments/manage-payments.component';
import { BatchDetailComponent } from './batch-detail/batch-detail.component';


const routes: Routes = [  
  {path: '', component: LoginComponent},
  {path : 'login' , component : LoginComponent},
  {path : 'home' , component : NavComponent,
    children : [
      {path : 'dashboard' , component : DashboardComponent},
      {path : 'manageBatch' , component : BatchComponent},
      {path : 'createBatch' , component : BatchEntryComponent},
      {path : 'batchDetail/:id' , component : BatchDetailComponent},
      {path : 'registration' , component : RegistrationComponent},
      {path : 'createStudent' , component : StudentEntryComponent},
      {path : 'payments' , component : ManagePaymentsComponent},
      {path : 'signout' , component : LoginComponent}
    ]    
  }    
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
