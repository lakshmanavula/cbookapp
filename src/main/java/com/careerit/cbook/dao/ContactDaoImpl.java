package com.careerit.cbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.careerit.cbook.domain.Contact;

public class ContactDaoImpl implements ContactDao {

	private static final String SELECT_ALL_CONTACTS = "select cid,name,email,mobile from contact";
	private static final String SEARCH_BY_NAME = "select cid,name,email,mobile from contact where name like ?";
	private static final String SELECT_BY_ID = "select cid,name,email,mobile from contact where cid = ?";
	private static final String ADD_CONTACT = "insert into contact(cid,name,email,mobile) values(?,?,?,?)";
	private ConnectionUtil dbUtil = ConnectionUtil.db;

	@Override
	public int insertContact(Contact contact) {
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			con = dbUtil.getConnection();
			st = con.prepareStatement(ADD_CONTACT);
			st.setInt(1, contact.getCid());
			st.setString(2, contact.getName());
			st.setString(3, contact.getEmail());
			st.setString(4, contact.getMobile());
			st.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbUtil.close(st, con);
		}
		return contact.getCid();
	}

	@Override
	public List<Contact> selectContacts() {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Contact> list = new ArrayList<Contact>();
		try {
			con = dbUtil.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(SELECT_ALL_CONTACTS);
			while (rs.next()) {
				
				Contact contact = rowToContact(rs);
				list.add(contact);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, st, con);
		}
		
		return list;

	}

	@Override
	public Contact updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact selectContactById(int cid) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = dbUtil.getConnection();
			st = con.prepareStatement(SELECT_BY_ID);
			rs = st.executeQuery();
			if(rs.next()) {
				Contact contact = rowToContact(rs);
				return contact;
			}
		}catch (SQLException e) {
			System.out.println("While selecting contact by id :"+e);
		}finally {
			dbUtil.close(rs, st, con);
		}
		throw new ContactNotFoundException("Contact with id :"+cid+" is not found");
	}

	@Override
	public List<Contact> search(String str) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Contact> list = new ArrayList<Contact>();
		try {
			con = dbUtil.getConnection();
			st = con.prepareStatement(SEARCH_BY_NAME);
			st.setString(1, "%" + str + "%");
			System.out.println(st.toString());
			rs = st.executeQuery();
			while (rs.next()) {
				Contact contact = rowToContact(rs);
				list.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, st, con);
		}
		return list;
	}

	private Contact rowToContact(ResultSet rs) throws SQLException {
		int cid = rs.getInt("cid");
		String name = rs.getString("name");
		String email = rs.getString("email");
		String mobile = rs.getString("mobile");
		Contact contact = new Contact(cid, name, email, mobile);
		return contact;
	}

	@Override
	public boolean deleteContact(int cid) {
		// TODO Auto-generated method stub
		return false;
	}

}
