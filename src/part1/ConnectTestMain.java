package part1;

//Transaction(TX): DB(프로그래밍)에서 분리할 수 없는 논리적인 작업 단위
//입금TX, 이체TX,  결재TX

import part1.common.JdbcUtil;

import java.sql.Connection;

//A계좌 에서 -1000  B계좌에서 update OK
//B계좌는 +1000   A계좌에서 update  ok
//commit
public class ConnectTestMain {
    public static void main(String[] args) {
        ConnectTest crud = new ConnectTest();
        crud.select();

    }
}
