package com.example.dao;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import com.example.model.Employee;

public class EmployeeDAOMapImpl implements EmployeeDAO {
    private Map<Integer, Employee> employees;
	//@Override
	

	public EmployeeDAOMapImpl() {
		super();
		this.employees = new TreeMap<>();
	}
	
	
	@Override
	public void add(Employee emp) throws DAOException {
		int id = emp.getId();
		if(employees.containsKey(id))
			throw new DAOException(id+"號員工已存在不能新增");
		employees.put(id, emp);
		
		}

	

	@Override
	public void update(Employee emp) throws DAOException {
		int id=emp.getId();
		if(!employees.containsKey(id))
			throw new DAOException(id+"號員工不存在不能修改");
			employees.put(id, emp);
	}

	@Override
	public void delete(int id)  {
		employees.remove(id);

	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return employees.get(id);
	}

	@Override
	public Employee[] getAllEmployees()  {
		// TODO Auto-generated method stub
		Collection<Employee> emps = employees.values();
		return emps.toArray(new Employee[emps.size()]);
	}
	
	public void close() throws Exception {
		System.out.println("關閉資源....");

	}

}
