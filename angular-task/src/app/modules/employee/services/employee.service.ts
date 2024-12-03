import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StorageService } from 'src/app/auth/services/storage/storage.service';

const BASIC_URL = "http://localhost:8080/";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }

    private createAuthorizationHeader(): HttpHeaders {
      //const token = StorageService.getToken();
      return new HttpHeaders().set(
        'Authorization', ' Bearer ' + StorageService.getToken()
    );
  }

  getEmployeeTaskById():Observable<any>{
    return this.http.get(BASIC_URL + "api/employee/tasks", {
      headers:this.createAuthorizationHeader()
    })
  }

  updateStatus(id: number, status: String):Observable<any>{
    return this.http.get(BASIC_URL + `api/employee/task/${id}/${status}`, {
      headers:this.createAuthorizationHeader()
    })
  }

  getTaskById(id: number): Observable<any>{
    return this.http.get(BASIC_URL + "api/employee/task/" + id, {
      headers: this.createAuthorizationHeader()
    })
  }

  createComment(id: number, content: string): Observable<any>{
      const params = {
        content: content
      }
      return this.http.post(BASIC_URL + "api/employee/task/comment/" + id, null, {
        params: params,
        headers: this.createAuthorizationHeader()
    })
  }

  getCommentsByTask(id: number): Observable<any>{
    return this.http.get(BASIC_URL + "api/employee/comments/" + id, {
      headers: this.createAuthorizationHeader()
    })
  }
}
