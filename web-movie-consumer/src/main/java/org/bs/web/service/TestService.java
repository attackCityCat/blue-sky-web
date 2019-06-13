package org.bs.web.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "movie-provider")
public interface TestService extends MovieService{
}
