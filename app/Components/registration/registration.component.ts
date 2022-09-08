import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'registration-component',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  AllData={
    fullName:"",
    emailId:"",
    password:"",
    dob:"",
    address:""
  };
  doSubmitForm(){
    console.log("function called");
  console.log(this.AllData);
  
    
  }
}
