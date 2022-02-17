package DB;

import java.sql.Connection;

public class test {

	public static void main(String[] args) {
		Connection con = null;
		try {
			con = DBManager.getConnection();

			if (con == null) {
				System.out.println("연결 실패");
			} else if (con != null) {
				System.out.println("연결 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
