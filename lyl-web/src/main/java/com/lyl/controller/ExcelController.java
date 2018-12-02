package com.lyl.controller;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.lyl.dao.UserDAO;
import com.lyl.pojo.User;
import com.lyl.response.Response;
import com.lyl.util.Excel.DefaultExcelExportUtils;
import com.lyl.util.Excel.ExcelHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.nio.ch.ThreadPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by lyl on 2016/9/18.
 */
@Controller
@RequestMapping(value = "/excel")
public class ExcelController {

    @Autowired
    private UserDAO userDAO;

    @ResponseBody
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public Response exportExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<ExcelHeader> headers = new ArrayList<ExcelHeader>();
        headers.addAll(Arrays.asList(
                new ExcelHeader("编号", "id"),
                new ExcelHeader("用户名", "username"),
                new ExcelHeader("密码", "password"),
                new ExcelHeader("用户状态", "status")
        ));

        List<User> dataList = getExcelExportData();
        try {
            DefaultExcelExportUtils.exportExcel(User.class, dataList, response);
            return Response.okNoResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.errorNoResult();
    }

    private List<User> getExcelExportData() {

        List<User> userList = userDAO.findAllUsers();
        if (CollectionUtils.isNotEmpty(userList)) {
            for (User user : userList) {
                user.setStatus(handleTradeState(user.getStatus()));
            }
        }
        return userList;
    }

    private String handleTradeState(String status) {
        //SUCCESS 支付成功,REFUND 转入退款,NOTPAY 未支付,CLOSED 已关闭,REVOKED 已撤销,USERPAYING 用户支付中,PAYERROR 支付失败
        if (status.equals("0")) {
            status = "已存在用户";
        } else if (status.equals("1")) {
            status = "已删除用户";
        }
        return status;
    }

    private void download(String path, HttpServletResponse response) {
        try {
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename="
                    + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(
                    response.getOutputStream());
            response.setContentType("application/vnd.ms-excel;charset=gb2312");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
