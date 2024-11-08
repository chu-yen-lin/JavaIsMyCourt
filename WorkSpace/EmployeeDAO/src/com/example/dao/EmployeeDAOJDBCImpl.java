package com.example.dao;

import java.sql.*;
import java.util.ArrayList;

import com.example.model.Employee;

public class EmployeeDAOJDBCImpl implements EmployeeDAO {
private Connection conn;

	EmployeeDAOJDBCImpl() {
		super();
		String url = "jdbc:mysql://localhost:3306/EmployeeDB";
		String user = "root";
		String pwd = "pETER2600";
		try {
		conn= DriverManager.getConnection(url,user,pwd);}
		catch(SQLException ex) {
			System.err.print("資料庫連線失敗,無法提供服務");
			System.exit(0);
		}
}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
conn.close();
	}

	@Override
	public void add(Employee emp) throws DAOException {
		String sql ="INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)";
        try(PreparedStatement pstmt= conn.prepareStatement(sql)){
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getLastName());
			pstmt.setDate(4, new java.sql.Date(emp.getBirthDate().getTime()));
			pstmt.setFloat(5, emp.getSalary());
			int result = pstmt.executeUpdate();
			if (result != 1)
				throw new DAOException("員工新增失敗");
		} catch (SQLException ex) {
			throw new DAOException("資料庫發生錯誤", ex);
		}
	}

	@Override
	public void update(Employee emp) throws DAOException {
		String sql = "UPDATE Employee SET FirstName=?,LastName=?,BirthDate=?,Salary=? WHERE Id=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, emp.getFirstName());
			pstmt.setString(2, emp.getLastName());
			pstmt.setDate(3, new java.sql.Date(emp.getBirthDate().getTime()));
			pstmt.setFloat(4, emp.getSalary());
			pstmt.setInt(5, emp.getId());
			if (pstmt.executeUpdate() != 1)
				throw new DAOException("員工更新失敗");
		} catch (SQLException ex) {
			throw new DAOException("資料庫更新發生錯誤", ex);
		}
	}

	@Override
	public void delete(int id) throws DAOException {
		String sql ="DELETE FROM Employee WHERE id=?";
		try(PreparedStatement pstmt= conn.prepareStatement(sql)){
			pstmt.setInt(1,id);
			
			if(pstmt.executeUpdate()!=1)
				throw new DAOException("員工刪除失敗");
		}catch(SQLException ex) {
			throw new DAOException("資料庫刪除發生錯誤", ex);
		}
	}

	@Override
	public Employee findById(int id) throws DAOException {
		String query = "SELECT * FROM Employee WHERE Id=?";
		Employee emp=null;
		try(PreparedStatement psmt = conn.prepareStatement(query)){
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				int i = rs.getInt("ID");
				String fn = rs.getString("FIRSTNAME");
				String ln = rs.getString("LASTNAME");
				Date bd = rs.getDate("BIRTHDATE");
				float sa = rs.getFloat("SALARY");
				emp = new Employee(i, fn, ln, bd, sa);
			}
			return emp;
		}catch(SQLException ex) {
        	throw new DAOException("資料庫查詢發生錯誤", ex);
        }
		
	}

	@Override
	public Employee[] getAllEmployees() throws DAOException {
		String query = "SELECT * FROM Employee";
		ArrayList<Employee> emps = new ArrayList<>();
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				emps.add(new Employee(rs.getInt("ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
						rs.getDate("BIRTHDATE"), rs.getFloat("SALARY")));
			}
			return emps.toArray(new Employee[emps.size()]);
		} catch (SQLException ex) {
			throw new DAOException("資料庫查詢發生錯誤", ex);
		}
		
			
		
		
	}

}
