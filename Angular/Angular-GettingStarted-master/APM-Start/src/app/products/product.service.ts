import { HttpClient, HttpErrorResponse , HttpHeaders  } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, throwError } from "rxjs";
import { catchError , tap } from "rxjs/operators"; 
import { IProduct } from "./product";

const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Method':'get',
      'Authorization': 'Basic ' + btoa('user:R@dheR@dhe09')
    })
  };
@Injectable({
    providedIn : 'root'
})
export class ProductService{

    private productUrl = 'http://localhost:8080/getProductsList';
    constructor(private http : HttpClient){

    }
    getProducts() : Observable<IProduct[]>{
        return this.http.get<IProduct[]>(this.productUrl,httpOptions).pipe(
            tap(data => console.log('All',JSON.stringify(data))),
            catchError(this.handleError)
        );
    }
    private handleError(err:HttpErrorResponse){

        let errMsg = '';
        if(err.error instanceof ErrorEvent){
            errMsg = `An error occured: ${err.error.message}`;
        }else{
            errMsg = `Server returned code :${err.status}, error msg is : ${err.message}`;
        }
        console.log(errMsg);
        return throwError(errMsg);
    }

    

}