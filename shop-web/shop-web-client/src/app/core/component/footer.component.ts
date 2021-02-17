import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {HomePageService} from "../../service/homepage.service";
import {BsModalService, ModalDirective} from "ngx-bootstrap";

@Component({
  selector: 'app-footer',
  styleUrls: ['../style/core.css'],
  templateUrl: '../view/footer.html'
})

export class FooterComponent implements OnInit {

  @ViewChild('feedbackModal') feedbackModal: ModalDirective;
  feedbackForm: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder, private homePageService: HomePageService, private modalService: BsModalService) {
  }

  ngOnInit() {
    this.feedbackForm = this.formBuilder.group({
      content: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
    });
  }

  // convenience getter for easy access to form fields
  get f() {
    return this.feedbackForm.controls;
  }

  onSubmit() {
    this.submitted = true;
    if (this.feedbackForm.invalid) {
      return;
    }
    this.homePageService.postFeedback(this.feedbackForm.getRawValue()).then(result => {
      this.feedbackForm.reset();
      this.showFeedbackModal();
    });
  }

  showFeedbackModal(): void {
    this.feedbackModal.show();
  }

  hideFeedbackModal(): void {
    this.feedbackModal.hide();
  }

}
