package org.bs.web.service.llp;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "web-provider")
public interface UserService extends UserServiceApi {

}
