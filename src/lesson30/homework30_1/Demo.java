package lesson30.homework30_1;

import lesson30.homework30_1.dao.CustomerDAO;
import lesson30.homework30_1.dao.DepartmentDAO;
import lesson30.homework30_1.dao.EmployeeDAO;
import lesson30.homework30_1.dao.ProjectDAO;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        generateData();

        Controller controller = new Controller();

        //employeesByProject
        System.out.println("\n--EmployeesByProject [Database]:");
        System.out.println(controller.employeesByProject("Database").toString());

        //projectsByEmployee
        System.out.println("\n--ProjectsByEmployee [Anton]");
        System.out.println(controller.projectsByEmployee(EmployeeDAO.getEmployeeByName("Anton", "F")));

        //employeesByDepartmentWithoutProject
        System.out.println("\n--EmployeesByDepartmentWithoutProject [DEVELOPERS]");
        System.out.println(controller.employeesByDepartmentWithoutProject(DepartmentType.DEVELOPERS));

        //employeesWithoutProject
        System.out.println("\n--EmployeesWithoutProject");
        System.out.println(controller.employeesWithoutProject());

        //employeesByTeamLead
        System.out.println("\n--EmployeesByTeamLead");
        System.out.println(controller.employeesByTeamLead(EmployeeDAO.getEmployeeByName("Miroslava", "T")));

        //teamLeadsByEmployee
        System.out.println("\n--TeamLeadsByEmployee");
        System.out.println(controller.teamLeadsByEmployee(EmployeeDAO.getEmployeeByName("Andrey", "T")));

        //employeesByProjectEmployee
        System.out.println("\n--EmployeesByProjectEmployee");
        System.out.println(controller.employeesByProjectEmployee(EmployeeDAO.getEmployeeByName("Vlad", "Z")));

        //projectsByCustomer
        System.out.println("\n--ProjectsByCustomer");
        System.out.println(controller.projectsByCustomer(CustomerDAO.getCustomerByName("AAA ltd.", "Ukraine")));

        //employeesByCustomerProjects
        System.out.println("\n--EmployeesByCustomerProjects");
        System.out.println(controller.employeesByCustomerProjects(CustomerDAO.getCustomerByName("AAA ltd.", "Ukraine")));
    }


    private static void generateData(){

        //Customers
        Customer customer1 = new Customer("AAA ltd.", "Ukraine", 2330);
        Customer customer2 = new Customer("BBB ltd.", "Armenia", 870);
        Customer customer3 = new Customer("CCC ltd.", "USA", 1000);
        Customer customer4 = new Customer("DDD ltd.", "Armenia", 9000);
        Customer customer5 = new Customer("EEE ltd.", "Ukraine", 4500);
        Customer customer6 = new Customer("FFF ltd.", "Moldova", 1200);

        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.setCustomers(customer1);
        customerDAO.setCustomers(customer2);
        customerDAO.setCustomers(customer3);
        customerDAO.setCustomers(customer4);
        customerDAO.setCustomers(customer5);
        customerDAO.setCustomers(customer6);

        //Projects
        Project project1 = new Project("Database", customer1);
        Project project2 = new Project("SocialNet", customer2);
        Project project3 = new Project("Analytic", customer2);
        Project project4 = new Project("Messenger", customer3);
        Project project5 = new Project("CRM", customer4);
        Project project6 = new Project("Casino online", customer5);

        ProjectDAO projectDAO = new ProjectDAO();
        projectDAO.setProjects(project1);
        projectDAO.setProjects(project2);
        projectDAO.setProjects(project3);
        projectDAO.setProjects(project4);
        projectDAO.setProjects(project5);
        projectDAO.setProjects(project6);

        //Departments
        Department department1 = new Department(DepartmentType.MANAGEMENT);
        Department department2 = new Department(DepartmentType.FINANCE);
        Department department3 = new Department(DepartmentType.DEVELOPERS);
        Department department4 = new Department(DepartmentType.DESIGNERS);
        Department department5 = new Department(DepartmentType.ANALYSTS);

        DepartmentDAO departmentDAO = new DepartmentDAO();
        departmentDAO.setDepartments(department1);
        departmentDAO.setDepartments(department2);
        departmentDAO.setDepartments(department3);
        departmentDAO.setDepartments(department4);
        departmentDAO.setDepartments(department5);

        //Employees
        Employee employee1 = new Employee("Andrey", "K", new Date(), Position.MANAGER, department1);
        Employee employee2 = new Employee("Orest", "M", new Date(), Position.FINANCE, department2);
        Employee employee3 = new Employee("Timofei", "N", new Date(), Position.DEVELOPER, department3);
        employee3.addProjects(project1);
        employee3.addProjects(project6);
        Employee employee4 = new Employee("Vlad", "Z", new Date(), Position.TEAM_LEAD, department3);
        employee4.addProjects(project1);
        Employee employee5 = new Employee("Anton", "F", new Date(), Position.DEVELOPER, department3);
        employee5.addProjects(project1);
        employee5.addProjects(project2);
        employee5.addProjects(project4);
        Employee employee6 = new Employee("Andrey", "T", new Date(), Position.DEVELOPER, department3);
        employee6.addProjects(project1);
        employee6.addProjects(project2);
        employee6.addProjects(project3);
        Employee employee7 = new Employee("Miroslava", "T", new Date(), Position.TEAM_LEAD, department3);
        employee7.addProjects(project2);
        employee7.addProjects(project3);
        Employee employee8 = new Employee("Margo", "R", new Date(), Position.DEVELOPER, department3);

        Employee employee9 = new Employee("Chu", "C", new Date(), Position.DESIGNER, department4);
        employee9.addProjects(project4);
        employee9.addProjects(project5);
        Employee employee10 = new Employee("test", "test", new Date(), Position.DESIGNER, department4);
        employee10.addProjects(project4);
        employee10.addProjects(project6);
        Employee employee11 = new Employee("Kote", "C", new Date(), Position.LEAD_DESIGNER, department4);
        employee11.addProjects(project4);
        employee11.addProjects(project5);
        Employee employee12 = new Employee("Sobake", "S", new Date(), Position.ANALYST, department5);
        employee12.addProjects(project1);

        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.setEmployees(employee1);
        employeeDAO.setEmployees(employee2);
        employeeDAO.setEmployees(employee3);
        employeeDAO.setEmployees(employee4);
        employeeDAO.setEmployees(employee5);
        employeeDAO.setEmployees(employee6);
        employeeDAO.setEmployees(employee7);
        employeeDAO.setEmployees(employee8);
        employeeDAO.setEmployees(employee9);
        employeeDAO.setEmployees(employee10);
        employeeDAO.setEmployees(employee11);
        employeeDAO.setEmployees(employee12);

        //Department update Employees

        department1.addEmployee(employee1);
        department2.addEmployee(employee2);
        department3.addEmployee(employee3);
        department3.addEmployee(employee4);
        department3.addEmployee(employee5);
        department3.addEmployee(employee6);
        department3.addEmployee(employee7);
        department3.addEmployee(employee8);
        department4.addEmployee(employee9);
        department4.addEmployee(employee10);
        department4.addEmployee(employee11);
        department5.addEmployee(employee12);








    }
}
