package com.data.page.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.data.page.entity.Employee;

@Repository
public interface PageRepository extends PagingAndSortingRepository<Employee, Long>{

	@Query("FROM Employee")
	List<Employee> findAllOrderByNameAsc(Sort sort);



}
