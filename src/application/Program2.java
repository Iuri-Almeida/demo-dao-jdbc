package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== Test 01: department findById ====");
		Department department = departmentDao.findById(3);
		System.out.println(department);

		System.out.println("\n==== Test 02: department findAll ====");
		List<Department> listAll = departmentDao.findAll();
		for (Department d : listAll) System.out.println(d);
		
		System.out.println("\n==== Test 03: department insert ====");
		Department newDepartment = new Department(null, "Food");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n==== Test 04: department update ====");
		department = departmentDao.findById(6);
		department.setName("Cars");
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		System.out.println("\n==== Test 05: department delete ====");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		sc.close();
		
	}

}
