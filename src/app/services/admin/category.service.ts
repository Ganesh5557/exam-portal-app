import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Category } from 'src/app/models/Category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) { }

  getAllCategory() {
    return this.http.get(`${environment.baseUrl}/category/`)
  }

  findByIdCategory(catId: number) {
    return this.http.get(`${environment.baseUrl}/category/` + catId)
  }

  addCategory(categoryModel: Category) {
    return this.http.post(`${environment.baseUrl}/category/`, categoryModel)
  }
  updateCategory(categoryModel: Category) {
    return this.http.put(`${environment.baseUrl}/category/`, categoryModel)
  }

  deletecategory(catId: number) {
    return this.http.delete(`${environment.baseUrl}/category/` + catId)
  }
}