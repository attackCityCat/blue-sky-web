package org.bs.web.service.xinx;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "web-provider")
public interface XinxService extends XinxServiceApi {
}
