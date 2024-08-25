package com.example.exercisejparelation.Repository;

import com.example.exercisejparelation.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

//    @Query("select a from Address a where a.address_id=?1")
//    Address findAddressesByAddress_id(Integer id);

    Address findAddressById(int id);

}
