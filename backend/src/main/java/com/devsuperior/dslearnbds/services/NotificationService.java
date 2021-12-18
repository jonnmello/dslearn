package com.devsuperior.dslearnbds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslearnbds.dto.NotificationDTO;
import com.devsuperior.dslearnbds.entities.Notification;
import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.NotificationRepository;

@Service
public class NotificationService {
	
	@Autowired
	private NotificationRepository repository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional(readOnly = true)
	public Page<NotificationDTO> notificationsForCurrentUser(Pageable pageable){ //retornar somente notificaçoes do usuario logado
		User user = authService.authenticated(); //user recebi autehnticated, foi no banco e recebou usario autenticado
		Page<Notification> page = repository.findByUser(user, pageable);//pagina de notification
		return page.map(x -> new NotificationDTO(x));//transformar pagina de notification em uma notificationDTO
	}         //para cada x transforma ele em notificationDTO x

}
