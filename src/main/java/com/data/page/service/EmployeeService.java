package com.data.page.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.data.page.entity.Employee;
import com.data.page.repository.PageRepository;

@Service
public class EmployeeService {
	
	@Autowired
	PageRepository pageRepository;
    
	public List<Employee> findPaginate(int pageNo, int pageSize,String sortBy, String sortDir) {
		
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Employee> posts = pageRepository.findAll(pageable);
      
//        List<Employee> listOfPosts = posts.getContent();

//        List<PostDto> content= listOfPosts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());    
//		PageRequest paging = PageRequest.of(pageNo, pageSize,Sort.by("name").descending());
//		Page<Employee> paged=pageRepository.findAll(paging);
		
		return posts.toList();
	}

//	public List<Employee> findAllOrderByName() {
//		List<Employee> response=(List<Employee>)pageRepository.findAllOrderByNameAsc(Sort.by(Sort.Direction.ASC,"name"));
//		return response ;
//	}
//
//	public List<Employee> findAllOrderByNames() {
//		List<Employee> response=(List<Employee>)pageRepository.findAllOrderByNameAsc(Sort.by(Sort.Direction.DESC,"name"));
//		return response;
//	}

}
