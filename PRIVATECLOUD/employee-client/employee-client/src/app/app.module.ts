import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from './material.module';
import { NgFor } from '@angular/common';

import { AddemployeeComponent } from './employee/addemployee/addemployee.component';
import { ViewemployeesComponent } from './employee/viewemployees/viewemployees.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';


@NgModule({
  declarations: [
    AppComponent,
    AddemployeeComponent,
    ViewemployeesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MaterialModule,
    NgFor
  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
