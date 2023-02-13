package com.example.restwithpostgres;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "course", path = "course")
public interface CourseRepository extends CrudRepository<Course, Integer> {

}