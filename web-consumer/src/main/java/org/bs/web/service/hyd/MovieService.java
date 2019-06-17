package org.bs.web.service.hyd;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "web-provider")
public interface MovieService extends MovieServiceApi {
}
