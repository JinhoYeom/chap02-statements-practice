package com.greedy.emp;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.greedy.model.dto.EmployeeDTO;

public class EmployeeDAO {
	
	/* 구현 조건
	 * 1. Connection 생성은 JDBC 템플릿 사용
	 * 2. query문은 xml 파일로 분리
	 * 3. 쿼리문에 값을 전달해야 하는 경우는 PreparedStatement,  
	 *    아닌 경우는 Statement 사용
	 * 4. 한 행 정보는 DTO에 담아 출력, 여러 행 정보는 ArrayList에 담아 출력
	 * */

	public void findOneEmpByEmpId(String empId) {
		
		/*  사번으로 직원정보 조회 후 EmployeeDTO에 담아 출력*/
		
		Connection con = getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<EmployeeDTO> empList = null;
		
//		String query = "SELECT * FROM EMPLOYEE WHERE EMP_NAME LIKE ? || '%'";
		Properties prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("src/com/greedy/emp/employee-query.xml"));
			
			String query = prop.getProperty("selectEmployee");
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, empId);
			
			rset = pstmt.executeQuery();
			
			empList = new ArrayList<>();
			
			while(rset.next()) {
				
				EmployeeDTO row = new EmployeeDTO();
				
				row.setEmpID(rset.getString("EMP_ID"));
				row.setEmpName(rset.getString("EMP_NAME"));
				row.setEmpNO(rset.getString("EMP_NO"));
				row.setEmail(rset.getString("EMAIL"));
				row.setPhone(rset.getString("PHONE"));
				row.setDeptCode(rset.getString("DEPT_CODE"));
				row.setJobCode(rset.getString("JOB_CODE"));
				row.setSalary(rset.getInt("SALARY"));
				row.setBonus(rset.getDouble("BONUS"));
				row.setManagerId(rset.getString("MANAGER_ID"));
				row.setHireDate(rset.getDate("HIRE_DATE"));
				row.setEntDate(rset.getDate("ENT_DATE"));
				row.setEntYn(rset.getString("ENT_YN"));
				
				empList.add(row);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(con);
		}
		
		for(EmployeeDTO emp : empList) {
			System.out.println(emp);
		}
		

	}

}
