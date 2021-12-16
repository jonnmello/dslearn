package com.devsuperior.dslearnbds.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.devsuperior.dslearnbds.entities.pk.EnrollmentPK;

@Entity //definindo entity
@Table (name = "tb_enrollment") //criando tabela
public class Enrollment {
	
	@EmbeddedId // coloca quando for de chave composta
	private EnrollmentPK id = new EnrollmentPK(); // nao pode esquecer  quand faz tipo da chave composta como é criado por voce com estrutura propria tem que instanciar
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant enrollMoment;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant refundMoment;
	
	private boolean available;
	private boolean onlyUpdate;
	
	public Enrollment() {
		
	}

	public Enrollment(User user,Offer offer, Instant enrollMoment, Instant refundMoment, boolean available,
			boolean onlyUpdate) {
		super();			// ele tirou o enrollmentpk id, e colocou User user e Offer offer, e mudou id.setUser(user);id.setOffer(offer);
		
		id.setUser(user);
		id.setOffer(offer);
		this.enrollMoment = enrollMoment;
		this.refundMoment = refundMoment;
		this.available = available;
		this.onlyUpdate = onlyUpdate;
	}

// ele apagou o get e set do EnrollmentPK id e vai fazer user e offer
	
	public User getStudent() {  
		return id.getUser();  //o id é do tipo EnrollmentPK e dentro dele que tem usuario
	}
	
	public void setStudent(User user) {
		id.setUser(user);
	}
	
	public Offer getOffer() {
		return id.getOffer(); //vai fazer o mesmo com offer
	}
	
	public void setOffer(Offer offer) {
		id.setOffer(offer);
	}

	public Instant getEnrollMoment() {
		return enrollMoment;
	}

	public void setEnrollMoment(Instant enrollMoment) {
		this.enrollMoment = enrollMoment;
	}

	public Instant getRefundMoment() {
		return refundMoment;
	}

	public void setRefundMoment(Instant refundMoment) {
		this.refundMoment = refundMoment;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isOnlyUpdate() {
		return onlyUpdate;
	}

	public void setOnlyUpdate(boolean onlyUpdate) {
		this.onlyUpdate = onlyUpdate;
	}

	
}
