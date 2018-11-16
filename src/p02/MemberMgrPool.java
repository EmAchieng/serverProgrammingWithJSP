package p02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class MemberMgrPool {
	//1.driver 로드
	//2.connection 정보 생성
	//it has to be public
	//then the name of the class
	//add try catch exception
	//get Instance method is created in the class, important in design pattern
	DBconnectionMgr pool = null;
	public MemberMgrPool() {
		try {
			pool=DBconnectionMgr.getInstance();
		} catch(Exception e) {
			System.out.println("에러: 커넥션 언어오기 실패");
			
		}
		
	}
	//3.statement 생성
	public Vector getMemberList() {
		Vector vecList= new Vector();
		Connection conn=null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			conn=pool.getConnection();
			stmt=conn.createStatement();
			String sqlQuery= "SELECT * FROM member";
			rs=stmt.executeQuery(sqlQuery);
			while(rs.next()) {
				//members
				//instance operator 
				MemberDAO memdao= new MemberDAO();
				//member variables
				memdao.setMem_id(rs.getString("id"));
				memdao.setMem_passwd(rs.getString("passwd"));
				memdao.setMem_name(rs.getString("name"));
				memdao.setMem_num1(rs.getString("mem_num1"));
				memdao.setMemb_num2(rs.getString("mem_num2"));
				memdao.setMem_email(rs.getString("e_mail"));
				memdao.setMem_phone(rs.getString("phone"));
				memdao.setMem_zipcode(rs.getString("zipcode"));
				memdao.setMem_address(rs.getString("address"));
				memdao.setMem_job(rs.getString("job"));
				
				
				vecList.add(memdao);
				
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		 return vecList;
	}

}
