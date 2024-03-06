import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewStudentComponent } from './components/view-student/view-student.component';
import { AddStudentComponent } from './components/add-student/add-student.component';
import { UpdateStudentComponent } from './components/update-student/update-student.component';
import { PagenotfoundComponent } from './components/pagenotfound/pagenotfound.component';

const routes: Routes = [

  {path:'',component:ViewStudentComponent},

  {path:'addStudent',component:AddStudentComponent},
  {path:'updateStudent/:id',component:UpdateStudentComponent},
  {path:'**',component:PagenotfoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
