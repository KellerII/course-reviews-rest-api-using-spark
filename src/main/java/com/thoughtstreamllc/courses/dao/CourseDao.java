package com.thoughtstreamllc.courses.dao;

import com.thoughtstreamllc.courses.exceptions.DaoException;
import com.thoughtstreamllc.courses.model.Course;

import java.util.List;

public interface CourseDao {
    void add(Course course) throws DaoException;

    List<Course> findAll();
}
