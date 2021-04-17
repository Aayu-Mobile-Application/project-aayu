package com.project.aayu.Repository;

import com.project.aayu.model.Map;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends MongoRepository<Map,Long> {

}
