package com.example.restwithpostgres;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "coursename", path = "coursename")
public interface CoursenameRepository extends CrudRepository<Coursename, Integer> {

}
