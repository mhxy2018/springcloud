package com.grg.common.utils;

import com.grg.common.distributed.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author ycqi1
 * @description 人脸算法ID
 * @date 2019/8/31
 */
@Service
@Scope("singleton")
public class IdBean {

	private static int workerId;
	private static int datacenterId;

	@Value("${SnowflakeIdWorker.workerId}")
	public static void setWorkerId(int workerId) {
		IdBean.workerId = workerId;
    }

	@Value("${SnowflakeIdWorker.datacenterId}")
    public static void setDatacenterId(int datacenterId) {
		IdBean.datacenterId = datacenterId;
    }

    private static final SnowflakeIdWorker idWorker = new SnowflakeIdWorker(workerId, datacenterId);


    public Long makeUserId(){
        Long nextId = idWorker.nextId();
        return nextId;
    }

}
