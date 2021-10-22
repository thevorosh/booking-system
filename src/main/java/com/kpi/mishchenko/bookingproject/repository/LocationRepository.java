package com.kpi.mishchenko.bookingproject.repository;

import com.kpi.mishchenko.bookingproject.entity.LocationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<LocationEntity, Long> {

}
