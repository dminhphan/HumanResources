
public class Employee extends Staff implements ICalculator{
    private int OTHours;

    public Employee() {}
    // Employee Class Constructor
    public Employee(String idStaff, String nameStaff, int ageStaff, int salaryWeight, String dateStart, Department department, int dayOffQuantity, int OTHours) {
        this.idStaff = idStaff;
        this.nameStaff = nameStaff;
        this.ageStaff = ageStaff;
        this.salaryWeight = salaryWeight;
        this.dateStart = dateStart;
        m_department = department;
        this.dayOffQuantity = dayOffQuantity;
        this.OTHours = OTHours;
    }

    public int getOTHours() {
        return OTHours;
    }

    public boolean setOTHours(int OTHours) {
        if (OTHours >= 0) {
            this.OTHours = OTHours;
            return true;
        } else {
            System.err.println("Please type the Overtime Hours again!");
            return false;
        }
    }

    // Display Info Method
    @Override
    public void displayInformation() {
        System.out.println("Employee's id: " + idStaff + "; Employee's name: " + nameStaff + "; Employee's age: " + ageStaff + "; Employee's Salary Weight: " + salaryWeight + "; Employee's Starting Date: " + dateStart + "; Employee's department: " + m_department + "; Number of Day Off: " + dayOffQuantity + "; Employee's Overtime Hours: " + OTHours + ".");
        System.out.println();
    }


    // Employee Salary Calculation Method
    @Override
    public int calculateSalary() {
        return salaryWeight * 3000000 + OTHours * 200000;
    }

}
