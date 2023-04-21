package com.example.restwithpostgres;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins="*", allowedHeaders="*")
//For development use * (wildcard) but for actually deploying use correct origin - http://xyz.com


@RepositoryRestResource(collectionResourceRel = "student", path = "student")
public interface StudentRepository extends PagingAndSortingRepository<Student, Integer>, CrudRepository<Student, Integer> {
    @Query("select s from Student s where s.address like '%swansea'")
    List<Student> findStudentsFromSwansea();

    @Query("select s from Student s where s.address like '%swansea' and lower(s.name) like lower(concat('%', :name,'%')) ")
    List<Student> findStudentsFromSwanseaByName(@Param("name") String name);
}
