package org.bs.web.service.rjf;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "web-provider")
public interface OrderService extends OrderServiceApi{
}
