package com.devsuperior.dslearnbds.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslearnbds.dto.NotificationDTO;
import com.devsuperior.dslearnbds.services.NotificationService;

@RestController //para indicar que é um controlador rest
@RequestMapping(value = "/notifications") //para indicar o valor
public class NotificationResouce {
	
	@Autowired
	private NotificationService service; //injetar um service
	
	@GetMapping
	public ResponseEntity<Page<NotificationDTO>> notificationsForCurrentUser( Pageable pageable){
		Page<NotificationDTO> page = service.notificationsForCurrentUser(pageable);
		return ResponseEntity.ok().body(page);
	}

}
