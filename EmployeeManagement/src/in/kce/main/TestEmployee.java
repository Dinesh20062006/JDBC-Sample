package in.kce.main;

import java.util.ArrayList;
import java.util.Scanner;

import in.kce.bean.Employee;
import in.kce.service.EmployeeService;

public class TestEmployee {
public static void main(String[] args) {
	//switch for menu
	System.out.println("Employee Management\n"
			+ "1. Store Employee\n"
			+ "2. Update Employee\n"
			+ "3. Fetch one Employee\n"
			+ "4. Fetch All Employee\n"
			+ "5. Delete Employee\n"
			+ "6. Exit");
	Scanner sc=new Scanner(System.in);
	
	while(true)
	{
		System.out.print("Enter the choise : ");
	int option=sc.nextInt();
	switch (option) {
	case 1: {
		System.out.print("Enter the Employee ID : ");
		int empId=sc.nextInt();
		System.out.print("\nEnter the Employee Name : ");
		String empName=sc.next();
		System.out.print("\nEnter the Employee Designation : ");
		String designation =sc.next();
		
		EmployeeService employeeService=new EmployeeService();
		boolean result=employeeService.saveEmployee(empId, empName, designation);
		if(result) {
			System.out.println("Employee Data inserted successfully !!\n");
		}
		else
		{
			System.out.println("Error in inserting employee data");
		}
		break;
	}
	
	case 2: {
		System.out.print("Enter the Updated Employee ID : ");
		int empId=sc.nextInt();
		System.out.print("Enter the Updated Employee Name : ");
		String empName=sc.next();
		System.out.print("Enter the Updated Employee Designation : ");
		String designation =sc.next();
		
		EmployeeService employeeService=new EmployeeService();
        boolean result = employeeService.updateEmployee(empId, empName, designation);
        if(result) {
			System.out.println("Employee Data updated successfully !!\n");
		}
		else
		{
			System.out.println("Error in updating employee data");
		}
        break;
	}
	
	case 5:{
		System.out.print("Enter the  Employee ID to be deleted : ");
		int empId=sc.nextInt();
		
		EmployeeService employeeService=new EmployeeService();
        boolean result = employeeService.deleteEmployee(empId);
        if(result) {
			System.out.println("Employee Data deleted successfully !!\n");
		}
		else
		{
			System.out.println("Error in deleting employee data");
		}
        break;
	}
	
	case 3:{
		System.out.print("Enter the  Employee ID to be fetched: ");
		int empId=sc.nextInt();
		
		EmployeeService employeeService=new EmployeeService();
		Employee emp = employeeService.getEmployee(empId);
		System.out.println("Employee details :");
		System.out.println("Employee ID :"+emp.getEmpId());
		System.out.println("Employee Name :"+emp.getEmpName());
		System.out.println("Employee Designation :"+emp.getDesignation());
		System.out.println("\n");
		break;
	}
	
	case 4:{
		System.out.print("Employee details: ");
		
		EmployeeService employeeService=new EmployeeService();
		ArrayList<Employee> employee = new ArrayList<>();
		employee = employeeService.getAllEmployees();
		
		for(Employee emp:employee)
		{
			System.out.println("Employee details :");
			System.out.println("Employee ID :"+emp.getEmpId());
			System.out.println("Employee Name :"+emp.getEmpName());
			System.out.println("Employee Designation :"+emp.getDesignation());
			System.out.println("\n");

		}
		System.out.println("\n");

		break;
	}
	case 6 :{
		System.out.print("Exiting........... ");
        return;
	}
	default:
		throw new IllegalArgumentException("Unexpected value: " + option);
	}
}
}
}
