package JDBCTest;

import java.sql.*;

public class CRUD {

    /*
        C(Create) : 생성
        R(Read)   : 조회
        U(Update) : 수정
        D(Delete) : 삭제

        CREATE TABLE JDBCT(
            DATA1   NVARCHAR2(100),
            DATA2   NUMBER
        );

     */

    // DB에 접속하기 위한 Connection 객체 con 생성
    Connection con;

    // Java에서 작성한 sql문을 DB로 전달하기 위한 Statement 객체 stmt 생성
    Statement stmt;

    // DB에서 실행된 결과를 저장하는 ResultSet 객체 rs 생성
    ResultSet rs;

    // [1] DB에 접속하기 위한 메소드
    public void connect(){
        con = DBConnection.DBConnect();
    }

    // [2] C : DB에 데이터를 저장하기 위한 메소드
    public void insert(){
        // (2) SQL문 작성
        String sql = "INSERT INTO JDBCT VALUES('Java', 21)";
        String cud = "insert";

        CUD(sql, cud);
    }

    // [3] R : DB에 있는 데이터를 조회하기 위한 메소드
    public void select(){
        try {
            // (1) 화면준비
            stmt = con.createStatement();

            // (2) SQL문 작성
            String sql = "SELECT * FROM JDBCT";

            // (3) 실행 결과를 담기 위한 변수 rs
            rs = stmt.executeQuery(sql);
            // 검색한 결화글 담기 위한 변수 rs(ResultSet타입)
            // rs에 결과를 담을때는 stmt.executeQuery(sql)을 사용한다.

            // insert(C), update(U), delete(D) => stmt.executeUpdate(sql) : int result

            // (4) 실행결과
            while(rs.next()){
                System.out.println("DATA1 : " + rs.getString(1) + ", DATA2 : " + rs.getInt(2));
            }
            // rs.getString(1) : 1 => 첫번째 컬럼, getString() => 컬럼의 데이터 타입이 문자열(NVARCHAR2) 일때
            // rs.getInt(2)    : 2 => 두번째 컬럼, getInt() => 컬럼의 데이터 타입이 정수형(NUNMBER) 일때, 실수형일땐 getDouble()사용
            // rs.next() : boolean 타입, 데이터의 갯수만큼 반복문을 실행한다.
            // 데이터가 존재하면 true, 존재하지 않으면 false
            // ex) 데이터가 5개 존재하면 5번동안 true, 6번째부터 false 값을 갖게 된다.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // U : DB에 있는 데이터를 수정하기 위한 메소드
    public void update(){
        // (2)
        String sql = "UPDATE JDBCT SET DATA2 = 17 WHERE DATA1 = 'Java'";
        String cud = "update";

        CUD(sql, cud);
    }


    // [4] D : DB에 있는 데이터를 삭제하기 위한 메소드
    public void delete(){
        // (2)
        String sql = "DELETE FROM JDBCT WHERE DATA2 = 17";
        String cud = "delete";
        CUD(sql, cud);
    }

    public void CUD(String sql, String cud){
        try {
            // (1) 화면준비
            stmt = con.createStatement();

            // (3) 실행
            int result = stmt.executeUpdate(sql);

            // (4) 결과
            if(result > 0){
                System.out.println(cud + " 성공!");
            } else {
                System.out.println(cud + " 실패!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // [6] DB접속 해제
    public void close(){
        try {
            con.close();
            System.out.println("DB접속 해제!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // [7] selectEMP
    public void selectEMP(){
        try {
            // (1)
            stmt = con.createStatement();

            // (2)
            String sql = "SELECT * FROM EMP";

            // (3)
            rs = stmt.executeQuery(sql);

            // (4)
            while(rs.next()){
                System.out.print("EMPNO : " + rs.getInt(1));
                System.out.print(" \t|\t ENAME : " + rs.getString(2));
                System.out.print(" \t|\t JOB : " + rs.getString(3));
                System.out.print(" \t|\t MGR : " + rs.getInt(4));
                System.out.print(" \t|\t HIREDATE : " + rs.getDate(5));
                System.out.print(" \t|\t SAL : " + rs.getInt(6));
                System.out.print(" \t|\t COMM : " + rs.getInt(7));
                System.out.print(" \t|\t DEPTNO : " + rs.getInt(8));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}









