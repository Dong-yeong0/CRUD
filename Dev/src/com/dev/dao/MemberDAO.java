package com.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dev.vo.MemberVO;

public class MemberDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	private static MemberDAO dao = new MemberDAO();

	private MemberDAO() {

	}

	public static MemberDAO getInstance() {
		return dao;
	}

	// 연결처리 Connection 객체
	private void connect() {
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// resource 반환
	public void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 전체 리스트
	public List<MemberVO> listMember() {
		connect();
		String sql = "select * from member_b order by id";
		List<MemberVO> list = new ArrayList<>();
		MemberVO member = null;
		try {
			psmt = conn.prepareStatement(sql); // psmt 객체
			rs = psmt.executeQuery();
			while (rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setMail(rs.getString("mail"));
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 회원 삭제
	public void deleteMember(String id) {
		connect();
		String sql = "delete from member_b where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			int n = psmt.executeUpdate();
			System.out.println("삭제완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// update
	public void updateMember(MemberVO member) {
		connect();
		String sql = "update member_b set password = ?, name = ?, mail = ? where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getPasswd());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getMail());
			psmt.setString(4, member.getId());

			int n = psmt.executeUpdate();
			if (n != 0) {
				System.out.println("업데이트 완료");
			} else {
				System.out.println("실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	// 한건조회
	public MemberVO searchMember(String id) {
		connect();
		String sql = "select * from member_b where ID = ?";
		MemberVO member = null;
		try {
			psmt = conn.prepareStatement(sql); // psmt 객체
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setMail(rs.getString("mail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return member;
	}

	// DB 처리 기능.
	public void insertMember(MemberVO member) {
		connect();
		String sql = "insert into member_b(id, name, password, mail) values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getPasswd());
			psmt.setString(4, member.getMail());
			int n = psmt.executeUpdate();
			if (n != 0) {
				System.out.println(n + "건 입력 완료");
			} else {
				System.out.println("입력실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
}
