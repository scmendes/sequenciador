package org.smendes.tasklist.repository;

import java.util.List;

import org.smendes.tasklist.entity.Tasklist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface TasklistRepository extends CrudRepository<Tasklist, Long> {

	  List<Tasklist> findByTitle(String title);

}