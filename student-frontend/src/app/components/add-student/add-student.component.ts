import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { StudentService } from 'src/service/student.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit 
{

  regForm: FormGroup;
  constructor(private _studentService: StudentService, 
              private _fb: FormBuilder,
              private _router:Router
              ) {
    
  }
  ngOnInit(): void {
   
    this.regForm = this._fb.group(
      {
        studentId: [0],

        studentName: ['',Validators.compose([Validators.required,Validators.minLength(4),Validators.maxLength(10)])],
        studentEmail: ['',Validators.compose([Validators.required,Validators.email])],
        studentAge: ['',Validators.compose([Validators.required,Validators.min(10),Validators.max(30)])],
        password: ['',Validators.compose([Validators.required,Validators.minLength(4),Validators.maxLength(10)])]

      }
    )
    

  }
  register22()
  {

    if(this.regForm.valid)
    {
      Swal.fire({
        title: "Do you want to save the changes?",
        showDenyButton: true,
        showCancelButton: true,
        confirmButtonText: "Save",
        denyButtonText: `Don't save`
      }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed)
         {


                 console.log(this.regForm.value);
        this._studentService.addStudentRecord(this.regForm.value).subscribe(response=>
        {
          console.log(response);
          Swal.fire("Saved!", "", "success");
          this._router.navigate(['']);
        },(error)=>
        {
           console.error(error);
        })
    


         
        } 
        else if (result.isDenied) {
          Swal.fire("Changes are not saved", "", "info");
        }
      });
    }
    
  
   

      
    
      
  }

}
