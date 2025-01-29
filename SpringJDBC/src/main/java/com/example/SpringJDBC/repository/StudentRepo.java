package com.example.SpringJDBC.repository;

import com.example.SpringJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;
    public void save(Student s) {
        String query = "insert into student (id,name,marks) values(?,?,?)";

        int n=jdbc.update(query, s.getId(), s.getName(), s.getMarks());

        System.out.println(n+"rows effected");
    }

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Student> findAll() {

        String query = "select * from student";
        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

                Student s = new Student();
                s.setName(rs.getString("name"));
                s.setId(rs.getInt("id"));
                s.setMarks(rs.getInt("marks"));
                return s;
            }
        };
        return jdbc.query(query,mapper);
    }
}
