package com.eclair.provider1.service;

import com.sun.org.apache.regexp.internal.RE;
import lombok.Data;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: wjk
 * @date: 2020/11/29 20:04
 **/

/**
 * 提交服务的健康状态
 *
 */
@Service
public class HealthCheckService implements HealthIndicator {
    private static final String UP = "UP";
    private static final String DOWN = "DOWN";
    private final Object Lock = new Object();
    private Boolean status = true;
    public void setStatus(boolean status) {
        synchronized (Lock) {
            this.status = status;
        }
    }
    public String getStatus() {
//        if (status)
//            return UP;
//        return DOWN;
        return this.status.toString();
    }

    /**
     * 为Actuator提供健康状态
     * @return
     */
    @Override
    public Health health() {
        if(status) {
            return new Health.Builder().up().build();
        }
        return new Health.Builder().down().build();
    }
}
