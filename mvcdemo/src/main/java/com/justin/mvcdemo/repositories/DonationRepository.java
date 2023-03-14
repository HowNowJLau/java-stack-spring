package com.justin.mvcdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.justin.mvcdemo.models.Donation;

@Repository
public interface DonationRepository extends CrudRepository<Donation, Long>{

}
