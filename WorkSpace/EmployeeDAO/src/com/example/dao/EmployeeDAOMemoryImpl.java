package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Employee;

public class EmployeeDAOMemoryImpl implements EmployeeDAO {
	private Employee[] employeeArray = new Employee[10];
	
	@Override
	public void add(Employee emp) throws DAOException{
		int id = emp.getId();
		try {
		if(employeeArray[id]!=null)
			throw new DAOException(id+"號員工已存在不能新增");
		employeeArray[id] = emp;
		}catch(ArrayIndexOutOfBoundsException ex) {
			throw new DAOException("員工編號需小於10", ex);
		}
		
	}

	@Override
	public void update(Employee emp)throws DAOException {
		int id=emp.getId();
		try {if(employeeArray[id]==null)
			throw new DAOException(id+"號員工不存在不能修改");
			employeeArray[id] = emp;}
	catch(ArrayIndexOutOfBoundsException ex)  {
		throw new DAOException("員工編號需小於10", ex);
	}

	
	    
	}
	

	@Override
	public void delete(int id)throws DAOException {
		try{
		employeeArray[id] = null;
	}catch(ArrayIndexOutOfBoundsException ex)  {
		throw new DAOException("員工編號需小於10", ex);}}

	@Override
	public Employee findById(int id)throws DAOException {
		try {
        return employeeArray[id];}catch(ArrayIndexOutOfBoundsException ex) {
        	throw new DAOException("員工編號需小於10", ex);
        }
	}

	@Override
	public Employee[] getAllEmployees() {
		List<Employee> emps = new ArrayList<>();
		// Iterate through the memory array and find Employee objects
		for (Employee e : employeeArray) {
			if (e != null) {
				emps.add(e);
			}
		}
		return emps.toArray(new Employee[0]);
	}

	@Override
	public void close() throws Exception {
		System.out.println("把資源關閉..");
		
	}

}
