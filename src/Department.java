public class Department {
    protected String idDepartment;
    protected String nameDepartment;
    protected int numberStaffDepartment;
    // m_department is a property of Staff class which has been created by the Department class prototype

    public Department() {}

    public Department(String idDepartment, String nameDepartment, int numberStaffDepartment) {
        this.idDepartment = idDepartment;
        this.nameDepartment = nameDepartment;
        this.numberStaffDepartment = numberStaffDepartment;
    }

    public String getIdDepartment() {
        return idDepartment;
    }

    public boolean setIdDepartment(String idDepartment) {
        if (idDepartment != null) {
            this.idDepartment = idDepartment;
            return true;
        } else {
            System.err.println("You should type something!");
            return false;
        }
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public boolean setNameDepartment(String nameDepartment) {
        if (nameDepartment != null) {
            this.nameDepartment = nameDepartment;
            return true;
        } else {
            System.err.println("You should type something!");
            return false;
        }
    }

    public int getNumberStaffDepartment() {
        return numberStaffDepartment;
    }
    // TODO Conditions for the setter
    public void setNumberStaffDepartment(int numberStaffDepartment) {
        this.numberStaffDepartment = numberStaffDepartment;
    }

    // toString() method to display information
    public String toString() {
        return "Department id: " + idDepartment + "; Department Name: " + nameDepartment + "; Number of Staff in this department: " + numberStaffDepartment + ".";
    }
}
