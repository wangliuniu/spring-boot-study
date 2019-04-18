package com.springboot.mybatis.controller;

import com.springboot.mybatis.entity.Course;
import com.springboot.mybatis.service.CourseService;
import com.springboot.mybatis.util.RandomUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("http://localhost:80")
public class CourseController {
    @Resource
    private CourseService courseService;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public List<Course> selectAll() {
        return courseService.selectAll();
    }
    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    public Course getOne(@PathVariable("id") long id) {
        return courseService.getOne(id);
    }
    @RequestMapping(value = "/course/{id}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable("id") long id) {
        courseService.delete(id);
    }
    @RequestMapping(value = "/course", method = RequestMethod.POST)
    public void addCourse(@RequestBody Course course) {
        course.setCourseCode(RandomUtil.getRandomCode());
        courseService.insert(course);
    }
    @RequestMapping(value = "/course", method = RequestMethod.PUT)
    public void updateCourse(@RequestBody Course course) {
        courseService.update(course);
    }

    @RequestMapping(value = "/doing/{id}", method = RequestMethod.GET)
    public List<Course> selectDoing(@PathVariable("id") short id) {
        return courseService.selectDoing(id);
    }

    @RequestMapping(value = "/finish/{id}", method = RequestMethod.GET)
    public List<Course> selectFined(@PathVariable("id") short id) {
        return courseService.selectFined(id);
    }
}
