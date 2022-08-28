package com.example.tache1.Repository;

import com.example.tache1.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAllByIdIn(List<Long> idAdd);

}
