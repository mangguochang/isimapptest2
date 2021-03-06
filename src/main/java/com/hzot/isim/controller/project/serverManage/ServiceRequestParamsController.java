package com.hzot.isim.controller.project.serverManage;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hzot.isim.base.BaseController;
import com.hzot.isim.entity.service.ServiceRequestParams;
import com.hzot.isim.util.PageList;
import com.hzot.isim.util.RestResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;

/**
 * @ClassName: ServiceRequestParamsController
 * @Description: 服务基本信息-请求参数
 * @Author: lolipopjy
 * @Date: 2019-10-22 16:05
 */
@RequestMapping("/service/request")
@Controller
public class ServiceRequestParamsController extends BaseController {

    @PostMapping("list")
    @ResponseBody
    public RestResponse list(@RequestParam(value = "pageSize",defaultValue = "1")Integer pageSize,
                             @RequestParam(value = "pageNumber",defaultValue = "10")Integer pageNumber,
                             String serviceId, ServletRequest request){

        PageList pageList = new PageList();
        EntityWrapper<ServiceRequestParams> entityWrapper = new EntityWrapper<>();
        if(StringUtils.isNotBlank(serviceId)) {
            entityWrapper.eq("service_id", serviceId);
        }
        Page<ServiceRequestParams> pageInfo = serviceRequestParamsService.selectPage(new Page<>(pageNumber,pageSize),entityWrapper);
        setPageInfo(pageList,pageInfo,pageSize,pageNumber);
        //设置创建者及更新者
        setCreatorUpdater(pageInfo);
        return  RestResponse.success().setData(pageList);
    }


}
