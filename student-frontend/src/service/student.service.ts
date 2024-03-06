import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';
import { Student } from 'src/helper/Student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private API_BASE_PATH:string="http://localhost:9091/";

  constructor(private http:HttpClient) 
  {

   }

   getAllStudents():Observable<Student[]>
   {
          return this.http.get<Student[]>(this.API_BASE_PATH+'student/');
   }
   addStudentRecord(student:NgForm)
   {
       return this.http.post(this.API_BASE_PATH+'student/',student);
   }

   deleteStudentById(id:number)
   {
          return this.http.delete(this.API_BASE_PATH+'student/'+id);
   }

   getStudentById(id:number):Observable<Student>
   {
        return   this.http.get<Student>(this.API_BASE_PATH+'student/'+id);
   }
   updateStudentRecord(student:NgForm,id:number):Observable<Student>
   {
       return this.http.put<Student>(this.API_BASE_PATH+'student/'+id,student);
   }
}
