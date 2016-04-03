package com.thoughtstreamllc.courses;

import com.google.gson.Gson;
import com.thoughtstreamllc.courses.dao.CourseDao;
import com.thoughtstreamllc.courses.dao.Sql2oCourseDao;
import com.thoughtstreamllc.courses.model.Course;
import org.sql2o.Sql2o;

import static spark.Spark.after;
import static spark.Spark.post;
import static spark.Spark.get;

public class Api {
    public static void main(String[] args) {
        Sql2o sql2o = new Sql2o("jdbc:h2:~/reviews.db;INIT=RUNSCRIPT from 'classpath:db/init.sql'");
        CourseDao courseDao = new Sql2oCourseDao((sql2o));
        Gson gson = new Gson();

        post("/courses", "application/json", (request, response) -> {
            Course course = gson.fromJson(request.body(), Course.class);
            courseDao.add(course);
            response.status(201);
            return course;
        }, gson::toJson);

        get("/courses", "application/json",
                (request, response) -> courseDao.findAll(), gson::toJson);

        after((request, response) -> {
            response.type("application/json");
        });
    }
}
