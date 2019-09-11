package com.lynda.common.data.repository;

import com.lynda.common.data.entity.ActivityLog;
import com.lynda.common.data.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepository extends CrudRepository<ActivityLog, String> {

}
