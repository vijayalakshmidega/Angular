import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `Employee
  
  <table>
  <thead>
  <tr>
  <th>Code</th>
  <th>Name</th>
  <th>Gender</th>
  <th>Annual Salary</th>
  <th>Date of Birth</th>
  </tr>
  </thead>
  <tbody>
  <tr *ngFor="let emp of employees">
  <td>{{emp.code}}</td>
  <td>{{emp.name}}</td>
 <td>{{emp.gender}}</td>
 <td>{{emp.annualSalary}}</td>
 <td>{{emp.dateOfBirth}}</td>
 </tr>
 <tr *ngIf="!employees || employees.length==0">
 <td colspan="5">Employee Record Not found</td>
 </tr>
</tbody>
</table>
  `
  ,
  styles: []
})
export class AppComponent {
  title = 'Employee Details';
   employees: any=[
    {
      code: 'emp101', name: 'Raj', gender: 'Male',
      annualSalary: 5500, dateOfBirth: '25/6/1988'
      },
      {
      code: 'emp102', name: 'Keshav', gender: 'Male',
      annualSalary: 5700.95, dateOfBirth: '9/6/1982'
      },
      {
      code: 'emp103', name: 'Gunika', gender: 'Female',
      annualSalary: 5900, dateOfBirth: '12/8/1979'
      },
      {
      code: 'emp104', name: 'Ekta', gender: 'Female',
      annualSalary: 6500.826, dateOfBirth: '14/10/1980'
      }

   ];
}
