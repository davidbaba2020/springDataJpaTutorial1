package com.example.schoolcoursemanagementsystem.Repository;

import com.example.schoolcoursemanagementsystem.Entity.Course;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;

public interface CourseRepository extends JpaAttributeConverter<Course, Long> {
}
