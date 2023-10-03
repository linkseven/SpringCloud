package com.springcloud.controller;

//import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consume")
@Slf4j
public class ConsumeController {
    //@Resource
    //private HttpUtil httpUtil;

    @Resource
    private RestTemplate template;

    String host = "http://CLOUD-PAYMENT-SERVICE";
    @GetMapping("/get/{id}")
    public CommonResult<Payment> getOne(@PathVariable("id") Long id){
        //通过hutool工具库中的HttpUtil进行查询
        //hutool工具库主要用于测试
/*        String result = httpUtil.get(String.format("%s/payment/getPayment/%s",host, id));
        CommonResult commonResult = JSONUtil.toBean(result, CommonResult.class);*/
/*        Map<String, String> map = JSONUtil.toBean(result, Map.class);
        String entity = map.get("entity");
        Payment payment = JSONUtil.toBean(entity, Payment.class);*/

        CommonResult commonResult = template.getForObject(String.format("%s/payment/getPayment/%s", host, id), CommonResult.class);
        return commonResult;
    }

    @PostMapping("/add")
    public CommonResult addOne(@RequestBody Payment payment){
        //通过hutool工具库中的HttpUtil进行查询
        //String s = JSONUtil.toJsonStr(payment);
        //String url = String.format("%s/payment/add", host);
        //String post = httpUtil.post(url, s);
        CommonResult commonResult = template.postForObject(String.format("%s/payment/add", host), payment, CommonResult.class);
        return commonResult;
    }
}
