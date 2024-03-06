import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from 'src/helper/Student';
import { StudentService } from 'src/service/student.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css'],
})
export class UpdateStudentComponent implements OnInit {
  studentId: number;
  regForm: FormGroup;
  student:Student;
  constructor(
    private _activateRouter: ActivatedRoute,
    private _fb: FormBuilder,
    private _router: Router,
    private _studentService: StudentService
  ) {
    this.regForm = this._fb.group({
      studentId: [0],

      studentName: ['',Validators.compose([Validators.required, Validators.minLength(4),Validators.maxLength(10),]),],
      studentEmail: ['',
        Validators.compose([Validators.required, Validators.email]), ],
      studentAge: ['',
        Validators.compose([
          Validators.required,
          Validators.min(10),
          Validators.max(30),
        ]),
      ],
      password: ['',
        Validators.compose([
          Validators.required,
          Validators.minLength(4),
          Validators.maxLength(10),
        ]),
      ],
    });
  }
  ngOnInit(): void {
    this.studentId = this._activateRouter.snapshot.params['id'];
  
    this._studentService.getStudentById(this.studentId).subscribe((res)=>
    {
         
         this.student=res;

         this.regForm = this._fb.group(
          {
            studentId: [res.studentId],
    
            studentName: [res.studentName,Validators.compose([Validators.required,Validators.minLength(4),Validators.maxLength(10)])],
            studentEmail: [res.studentEmail,Validators.compose([Validators.required,Validators.email])],
            studentAge: [res.studentAge,Validators.compose([Validators.required,Validators.min(10),Validators.max(30)])],
            password: [res.password,Validators.compose([Validators.required,Validators.minLength(4),Validators.maxLength(10)])]
    
          }
        )


    })
  }

  update22()
   {
         console.log("++++++++++",this.regForm.value);
        if(this.regForm.valid)
        {

          Swal.fire({
            title: "Do you want to update the changes?",
            showDenyButton: true,
            showCancelButton: true,
            confirmButtonText: "Update",
            denyButtonText: `Don't update`
          }).then((result) => {
            /* Read more about isConfirmed, isDenied below */
            if (result.isConfirmed) 
            {
                 this._studentService.updateStudentRecord(this.regForm.value,this.studentId).subscribe(res=>
                  {
                    console.log("--------------------",res);
                    Swal.fire("Updated!", "", "success");
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
