package com.sid.e2e.springboot.locationdetails.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sid.e2e.springboot.locationdetails.entities.Location;

public interface LocationRepo extends JpaRepository<Location, Long> {

	/* To use the JPA Sql, use the entity name<model name> in the sql query */
	@Query("Select loc.type,count(type) from Location loc group by loc.type order by loc.type desc")
	public List<Object[]> findTypeAndTypeCount();
}
