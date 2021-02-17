import {Component, OnInit} from '@angular/core';

@Component({
  selector : 'app-billing',
  templateUrl: '../view/billing.html'
})

export class BillingComponent implements OnInit {
  constructor() {
  }

  ngOnInit() {
  }

  paySelectOptions = [
    {id: 1, name: "Thanh toán khi nhận hàng"},
    {id: 2, name: "Momo"},
    {id: 3, name: "ZaloPay"},
    {id: 4, name: "Chuyển khoảng ngân hàng"}
  ];
  paySelectedValue = {id: 1, name: "Thanh toán khi nhận hàng"};
  currentSelectPayment: number = 1;

  changePaymentSelect(value: number) {
    this.currentSelectPayment = value;
  }

}
