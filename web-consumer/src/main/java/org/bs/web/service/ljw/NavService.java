package org.bs.web.service.ljw;

import org.bs.web.serviceApi.ljw.NavServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Lenovo
 * @title: NavService
 * @projectName blueskyweb
 * @description: TODO
 * @date 2019/6/1321:00
 */
@FeignClient(value = "web-provider")
public interface NavService extends NavServiceApi {
}
