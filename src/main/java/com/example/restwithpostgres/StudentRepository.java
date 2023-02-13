package com.example.restwithpostgres;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "student", path = "student")
public interface StudentRepository extends PagingAndSortingRepository<Student, Integer>, CrudRepository<Student, Integer> {

}
