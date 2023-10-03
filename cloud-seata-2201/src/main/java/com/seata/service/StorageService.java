package com.seata.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("cloud-seata-storage")
public interface StorageService {

}
