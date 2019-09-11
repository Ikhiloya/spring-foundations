package com.lynda.common.service;

import com.lynda.common.aspect.LoggingAspect;
import com.lynda.common.data.entity.ActivityLog;
import com.lynda.common.data.entity.Customer;
import com.lynda.common.data.repository.ActivityLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActivityLogService {
    private ActivityLogRepository activityLogRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityLogService.class);


    @Autowired
    public ActivityLogService(ActivityLogRepository activityLogRepository) {
        this.activityLogRepository = activityLogRepository;
    }

    public void saveActivityLog(String user, String message) {
        LOGGER.info("Request to save activity log");
        ActivityLog activityLog = new ActivityLog(user, message);
        activityLogRepository.save(activityLog);
    }

    public List<ActivityLog> getAll() {
        return (List<ActivityLog>) this.activityLogRepository.findAll();
    }
}
