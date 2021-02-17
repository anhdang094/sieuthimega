import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {AddProductComponent} from './add-product.component';
import {ProductComponent} from './product.component';

const routes: Routes = [
  {
    path: '',
    data: {
      title: 'Theme'
    },
    children: [
      {
        path: 'addproduct',
        component: AddProductComponent,
        data: {
          title: 'Colors'
        }
      },
      {
        path: 'product',
        component: ProductComponent,
        data: {
          title: 'Typography'
        }
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ManagementRoutingModule {}
