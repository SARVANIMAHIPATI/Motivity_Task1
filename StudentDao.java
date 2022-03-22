package com.motivity2;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insertStudent(Student student) {
		String query = "insert into student(id,name,city,phoneNum) values(?,?,?,?)";
		int r = jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity(),
				student.getPhoneNum());
		return r;
	}

	public int deleteStudent(Student student) {
		String query1 = "delete from student where id=?";
		int r = jdbcTemplate.update(query1, student.getId());
		return r;
	}

	public int updateNameStudent(Student student) {
		String query2 = "update student set name=? where id=?";
		int r = jdbcTemplate.update(query2, student.getName(), student.getId());
		return r;
	}

	public int updateCityStudent(Student student) {
		String query2 = "update student set city=? where id=?";
		int r = jdbcTemplate.update(query2, student.getCity(), student.getId());
		return r;
	}

	public int updatePhoneNumStudent(Student student) {
		String query2 = "update student set phoneNum=? where id=?";
		int r = jdbcTemplate.update(query2, student.getPhoneNum(), student.getId());
		return r;
	}

	public List<Student> selectStudent(Student student) {
		String query3 = "select * from student";
		List<Student> students = jdbcTemplate.query(query3, new BeanPropertyRowMapper<Student>(Student.class));
		return students;
	}
}