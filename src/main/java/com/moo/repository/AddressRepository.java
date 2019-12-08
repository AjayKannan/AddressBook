package com.moo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.moo.entity.AddressEntity;

public interface  AddressRepository extends JpaRepository<AddressEntity, Long>{

	@Query("SELECT a FROM AddressEntity a WHERE a.contactIdFk = ?1")
	List<AddressEntity> getAddressByContactId(Long contactId);
}
