package co.sang.notice.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

public class DataSource {

//	//싱글톤 : 자기자신 static 으로 만들고  :메모리에 계속 유지해라
//	private static DataSource dataSource;
//	private String driver= "oracle.jdbc.driver.OracleDriver";
//	private String url = "jdbc:oracle:thin:@localhost:1521:xe";   //물리적인 링크
//	private String user = "sang";  
//	private String password = "1234";
//	private Connection conn;
//	
//	//싱글톤: 밖에서 초기화 방지
//	private DataSource() {
//		
//	}
//	
//	//싱글톤: 밖에서 쓰고 싶을때 쓸려면 나를 써라 
//	public static DataSource getInstance() {
//		dataSource = new DataSource();
//		return dataSource;
//	}
//	
//	public Connection getConnection() {
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, user, password);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}

	// mybatis 로 연결하기
	private static SqlSessionFactory sqlSessionFactory;

	private DataSource() {
	}

	public static SqlSessionFactory getInstance() {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}
}
