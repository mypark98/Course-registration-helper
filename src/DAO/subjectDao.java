package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.DBManager;
import DTO.modifyDto;
import DTO.subjectDto;

public class subjectDao {

	private subjectDao() {
	};

	private static subjectDao sDao = new subjectDao();

	public static subjectDao getInstance() {
		return sDao;
	}

	// 총 과목수 알아오는 메소드
	public int allSubjectCnt() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int count = 0;

		String sql = "SELECT count(*) FROM course_tbl";

		try {
			con = DBManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, stmt, rs);
		}
		return count;
	}

	// 과목 정보를 알아오는 메소드
	public List<subjectDto> selectSubject() {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT c.id 과목코드, c.name 과목명, c.credit 학점, l.name 담당강사, c.week 요일, c.start_hour 시작시간, c.end_end 종료시간 \r\n"
				+ "FROM course_tbl c INNER JOIN lecturer_tbl l ON c.lecturer = l.idx \r\n"
				+ "WHERE l.name IN (SELECT l.name FROM course_tbl c INNER JOIN lecturer_tbl l ON c.lecturer = l.idx\r\n"
				+ ")";

		List<subjectDto> list = new ArrayList<>();

		try {
			con = DBManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				subjectDto sDto = new subjectDto();
				sDto.setId(rs.getString(1));
				sDto.setSname(rs.getString(2));
				sDto.setCredit(rs.getInt(3));
				sDto.setName(rs.getString(4));
				sDto.setWeek(rs.getInt(5));
				sDto.setStart_hour(rs.getInt(6));
				sDto.setEnd_end(rs.getInt(7));

				list.add(sDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, stmt, rs);
		}
		return list;
	}

	// 수정할 교과목 불러오기
	public subjectDto targetSubject(String id) {
		String sql = "SELECT * FROM course_tbl WHERE id=?";

		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		subjectDto sDto = new subjectDto();

		try {
			con = DBManager.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();

			while (rs.next()) {
				sDto.setId(rs.getString("id"));
				sDto.setSname(rs.getString("name"));
				sDto.setCredit(rs.getInt("credit"));
				sDto.setName(rs.getNString("lecturer"));
				sDto.setWeek(rs.getInt("week"));
				sDto.setStart_hour(rs.getInt("start_hour"));
				sDto.setEnd_end(rs.getInt("end_end"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, psmt);
		}
		return sDto;
	}

	// 교과목 수정 메소드
	public void updateSubject(modifyDto mDto) {
		Connection con = null;
		PreparedStatement psmt = null;

		String sql = "UPDATE course_tbl SET name=?, credit=?, lecturer=?, week=?, start_hour=?, end_end=? WHERE id=?";

		try {
			con = DBManager.getConnection();
			psmt = con.prepareStatement(sql);

			psmt.setString(1, mDto.getName());
			psmt.setInt(2, mDto.getCredit());
			psmt.setString(3, mDto.getLecturer());
			psmt.setInt(4, mDto.getWeek());
			psmt.setInt(5, mDto.getStart_hour());
			psmt.setInt(6, mDto.getEnd_end());
			psmt.setString(7, mDto.getId());

			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, psmt);
		}
	}

	// 교과목 삭제 메소드
	public void deleteSubject(String id) {

		String sql = "DELETE FROM course_tbl WHERE id = ?";

		Connection con = null;
		PreparedStatement psmt = null;

		try {
			con = DBManager.getConnection();
			psmt = con.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, psmt);
		}

	}

	// 교과목 저장
	public void insertSubject(modifyDto mDto) {

		String sql = "INSERT INTO course_tbl VALUES(?, ?, ?, ?, ?, ?, ?)";

		Connection con = null;
		PreparedStatement psmt = null;

		try {
			con = DBManager.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, mDto.getId());
			psmt.setString(2, mDto.getName());
			psmt.setInt(3, mDto.getCredit());
			psmt.setString(4, mDto.getLecturer());
			psmt.setInt(5, mDto.getWeek());
			psmt.setInt(6, mDto.getStart_hour());
			psmt.setInt(7, mDto.getEnd_end());

			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, psmt);
		}

	}

}
