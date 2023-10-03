package springcloud.controller;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import jdk.jfr.ContentType;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/consul")
public class ConsulController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/getId")
    public CommonResult<Payment> getId(){
        log.info("server port:" + port + " uuid: " + UUID.randomUUID().toString());
        return new CommonResult<>(200, "ok");
    }

    @PostMapping("/upload")
    public void uploadMessage(@RequestParam("uploadFile") MultipartFile multipartFile, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Workbook workbook;
        Sheet sheet;
        Cell cell1,cell2,cell3,cell4,cell5;
        JSONArray jsons = new JSONArray();

        log.info(multipartFile.getName());
        //
        try {
            InputStream inputStream = multipartFile.getInputStream();
            //FileOutputStream outputStream = new FileOutputStream("D:/" + multipartFile.getOriginalFilename());
            workbook = Workbook.getWorkbook(inputStream);
            sheet = workbook.getSheet(0);
            for(int i = 1; i < sheet.getRows(); i++) {
                //循环读出每一数据格的数据
                //sheet.getCell(列，行);
                cell1 = sheet.getCell(0 , i);
                cell2 = sheet.getCell(1 , i);
                cell3 = sheet.getCell(2 , i);
                cell4 = sheet.getCell(3 , i);
                cell5 = sheet.getCell(4 , i);
                //每一行创建一个JSONObject对象
                JSONObject object = new JSONObject();
                object.put("项目", cell1.getContents());
                object.put("行次", cell2.getContents());
                object.put("本月数", cell3.getContents());
                object.put("本期金额", cell4.getContents());
                object.put("上期金额", cell5.getContents());
                //加入json队列
                jsons.add(object);
                System.out.println(jsons.toJSONString());
                workbook.close();
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
        if (multipartFile.getOriginalFilename() == null){
            log.info("文件为空");
        }
        log.info(multipartFile.getOriginalFilename());
/*        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1){
            outputStream.write(bytes, 0, len);
        }*/
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        log.info("=======" + contextPath + "+++++++" + requestURI);
    }
}
