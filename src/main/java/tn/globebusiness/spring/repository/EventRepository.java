package tn.globebusiness.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.globebusiness.spring.entity.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
	
	
	//Event findByCategory(@Param("category")String category);
	
}
