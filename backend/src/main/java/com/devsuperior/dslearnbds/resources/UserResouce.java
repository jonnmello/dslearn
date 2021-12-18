package com.devsuperior.dslearnbds.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslearnbds.dto.UserDTO;
import com.devsuperior.dslearnbds.services.UserService;

@RestController //para indicar que é um controlador rest
@RequestMapping(value = "/users") //para indicar o valor
public class UserResouce {
	
	@Autowired
	private UserService service; //injetar um service
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id){
		
		UserDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

}
