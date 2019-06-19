package org.bs.web.service.dyl;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "web-provider")
public interface TicketService {
}
