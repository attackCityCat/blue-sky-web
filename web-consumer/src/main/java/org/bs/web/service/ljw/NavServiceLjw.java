package org.bs.web.service.ljw;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Lenovo
 * @title: NavServiceLjw
 * @projectName blueskyweb
 * @description: TODO
 * @date 2019/6/1321:00
 */
@FeignClient(value = "web-provider")
public interface NavServiceLjw extends NavServiceApi {
}
