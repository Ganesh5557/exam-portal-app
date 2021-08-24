import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/models/Category';

import { CategoryService } from 'src/app/services/admin/category.service';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent implements OnInit {

  // categoryModel = {
  //   "title": "",
  //   "descr": ""
  // };
  categoryModel: Category = new Category("", "");
  constructor(private catSer: CategoryService) { }

  ngOnInit(): void { }

  formSubmit() {
    // Form validation is required

    if (this.categoryModel.title.trim() == "" || this.categoryModel.title.trim() == null) {
      alert("Please fill all the required fields");
      // this._snackBar("Please fill all the required fields", "Close", { duration: 3000 })
      return
    }


    this.catSer.addCategory(this.categoryModel).subscribe(
      (data) => {
        alert("Submitted")
        console.log(data);
      },
      (error) => { alert(error) }
    )
  }

}
