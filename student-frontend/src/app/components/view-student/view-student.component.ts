import { Component, OnInit } from '@angular/core';
import { Student } from 'src/helper/Student';
import { StudentService } from 'src/service/student.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-view-student',
  templateUrl: './view-student.component.html',
  styleUrls: ['./view-student.component.css']
})
export class ViewStudentComponent  implements OnInit
{
   students:Student[];

    constructor(private _studentService:StudentService)
    {

    }
  ngOnInit(): void 
  {
    this.getAllStudentsRecord();
  }
  getAllStudentsRecord()
  {
        this._studentService.getAllStudents().subscribe(res=>{
             this.students=res;
             console.log(res);
        })
  }
  deleteRecord(id:number)
  {
    Swal.fire({
      title: "Do you want to delete this record?",
      showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: "Delete",
      denyButtonText: `Don't Delete`
    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) 
      {
            this._studentService.deleteStudentById(id).subscribe((response)=>
            {

              Swal.fire("Deleted!", "", "success");
              this.getAllStudentsRecord();

            })
       
      } else if (result.isDenied) {
        Swal.fire("Record is not saved", "", "info");
      }
    });
  }

}
