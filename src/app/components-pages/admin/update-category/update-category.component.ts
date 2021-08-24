import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CategoryService } from 'src/app/services/admin/category.service';
import { Category } from 'src/app/models/Category';

@Component({
  selector: 'app-update-category',
  templateUrl: './update-category.component.html',
  styleUrls: ['./update-category.component.css']
})
export class UpdateCategoryComponent implements OnInit {

  catId: number = 0
  category: any;
  constructor(private router: ActivatedRoute, private catSer: CategoryService) { }

  ngOnInit(): void {
    this.catId = this.router.snapshot.params.catId;
    // alert(this.catId)
    this.category = this.catSer.findByIdCategory(this.catId).subscribe(
      (data) => { this.category = data },
      error => console.error(error)

    );

  }
  formSubmit() { }



}
