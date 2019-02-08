package net.mahdirazavi.companydashboard.controller;


import net.mahdirazavi.companydashboard.model.Course;
import net.mahdirazavi.companydashboard.model.CourseConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestEndpoints {

    @Value("${default.course.name}")
    private String name;

    @Value("${default.course.chapterCount}")
    private int chapterCount;

    @Autowired
    private CourseConfiguration courseConfiguration;

    @RequestMapping("/defaultcourse")
    public Course getDefaultEndpoint() {
        return new Course(this.name, this.chapterCount);
    }

    @RequestMapping("/defaultfullcourse")
    public Map<String, String> getDefaultFullEndpoint() {

        Map<String, String> result = new HashMap<>();
        result.put("name", courseConfiguration.getName());
        result.put("author", courseConfiguration.getAuthor());
        result.put("chapterCount", courseConfiguration.getChapterCount() + "");
        result.put("rating", courseConfiguration.getRating() + "");

        return result;
    }

    @RequestMapping("/course")
    public Course getEndpoint(@RequestParam(value = "name", defaultValue = "Spring Boot", required = false) String name,
                              @RequestParam(value = "chapterCount", defaultValue = "2", required = false) int chapterCount) {
        return new Course(name, chapterCount);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/course")
    public String saveCourse(@RequestBody Course course) {

        return "your course " + course.getName() + " with " + course.getChapterCount() + " has saved successfully.";
    }
}
