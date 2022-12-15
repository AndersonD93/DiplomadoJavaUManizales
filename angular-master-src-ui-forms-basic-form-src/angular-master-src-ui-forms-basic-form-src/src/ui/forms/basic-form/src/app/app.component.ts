import { Component } from "@angular/core";
import { FormControl } from "@angular/forms";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent {
  title = "basic-form";
  email = new FormControl("ikerlandajuela@gmail.com"); // <----

  _name: string;

  get name(): string {
    return this._name;
  }

  set name(newName: string) {
    console.log(newName);
    this._name = newName;
  }

  updateEmail() {
    this.email.setValue("ikernaix@gmail.com");
    this._name = "Iker";
  }
}
