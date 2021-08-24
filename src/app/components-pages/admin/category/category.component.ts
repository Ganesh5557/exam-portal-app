import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin/admin.service';
import { Category } from 'src/app/models/Category';
import { CategoryService } from 'src/app/services/admin/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  categories: any;
  constructor(private catSer: CategoryService) { }

  ngOnInit(): void {
    this.getAllCategory()
  }
  getAllCategory() {
    this.catSer.getAllCategory().subscribe(
      (data) => {
        this.categories = data
      },
      (error) => {
        alert(error)

      }
    );
  }

  deleteCategory(catId: number) {
    this.catSer.deletecategory(catId).subscribe(
      data => {
        console.log(data);
        alert("deleteService called");
        this.categories = this.categories.filter((e: any) => (e.cat_id != catId))
      },
      (error) => { alert("error deleting the file") }
    );

  }


}
