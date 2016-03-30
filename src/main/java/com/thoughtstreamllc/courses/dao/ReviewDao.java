package com.thoughtstreamllc.courses.dao;

import com.thoughtstreamllc.courses.exceptions.DaoException;
import com.thoughtstreamllc.courses.model.Review;

import java.util.List;

public interface ReviewDao {
    void add(Review review) throws DaoException;

    List<Review> findAll();

    List<Review> findByCourseId(int courseId);
}
