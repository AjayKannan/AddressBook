package com.moo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.moo.entity.ContactEntity;

public interface  ContactRepository extends JpaRepository<ContactEntity, Long>{

	@Query("SELECT c FROM ContactEntity c WHERE UPPER(c.surname) = UPPER(?1)")
	List<ContactEntity> getEmployeeBySurName(String surname);
}
