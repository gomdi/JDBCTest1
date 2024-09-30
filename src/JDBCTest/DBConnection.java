package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection DBConnect() {
        // DB접속 정보를 저장하기 위한 Connection 객체 con 선언
        Connection con = null;

        // DB접속 계정정보
        String user = "ICIA";       // 아이디
        String password = "1111";   // 비밀번호

        // DB접속 주소정보
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        // String url = "jdbc:oracle:thin:@192.168.0.89:1521:XE";

        /*
         *  try - catch - finally (예외처리)
         *  예외처리 : 프로그램 실행 중에 발생할 수 있는 예외적인 상황을 관리하고 대응하기 위한 방법
         *
         *  try {
         *      // 예외가 발생할 수 있는 코드
         *      // 예외가 발생하지 않으면 try 구문안에 있는 내용 실행
         *
         *  } catch(ExceptionType1 e){
         *       // ExceptionType1을 처리하는 코드
         *  }
         *
         *   } catch(ExceptionType2 e){
         *       // ExceptionType2을 처리하는 코드
         *  }
         *
         *  } finally {
         *       // 예외 발생 여부에 상관없이 항상 실행되는 코드(선택적)
         *  }
         *
         * */

        try {
            // (1) 오라클 데이터베이스 드라이버(ojdbc8)
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // (2) 오라클 데이터베이스 접속정보
            con = DriverManager.getConnection(url, user, password);
            System.out.println("접속 성공!");

        } catch (ClassNotFoundException e) {
            System.out.println("DB접속 실패 : 드라이버 로딩 실패");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("DB접속 실패 : 접속 정보 오류");
            throw new RuntimeException(e);
        }

        return con;
    }


}
