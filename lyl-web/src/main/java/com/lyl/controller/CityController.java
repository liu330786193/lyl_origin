package com.lyl.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lyl.Node;
import com.lyl.dao.*;
import com.lyl.pojo.PubBank;
import com.lyl.pojo.PubPayCity;
import com.lyl.pojo.PubPayNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/city")
public class CityController {

    @Resource
    private ZjjzCnapsBankinfoDAO zjjzCnapsBankinfoDAO;
    @Resource
    private PubPayCityDAO pubPayCityDAO;
    @Resource
    private PubBankDAO pubBankDAO;
    @Resource
    private PubPayNodeDAO pubPayNodeDAO;


//    @ResponseBody
    @GetMapping(value = "/json")
    public void city() throws IOException {

        List<Node> nodes = new ArrayList<>();

        List<PubPayNode> list = pubPayNodeDAO.selectAll();

        list.stream().forEach(l -> {
            Node node = new Node();
            node.setLabel(l.getNodeNodename());
            node.setValue(Long.valueOf(l.getNodeNodecode()));
            nodes.add(node);
            List<PubPayCity> citys = pubPayCityDAO.selectByType(l.getNodeNodecode(), "2");
            List<Node> list1 = new ArrayList<>();
            citys.stream().forEach(c -> {
                Node node1 = new Node();
                node1.setLabel(c.getCityAreaname());
                node1.setValue(Long.valueOf(c.getCityOraareacode()));
                List<PubPayCity> cities = pubPayCityDAO.selectByTypeAndAreaCode2(l.getNodeNodecode(), "3", c.getCityTopareacode1());
                List<Node> list3 = new ArrayList<>();
                cities.stream().forEach(t -> {
                    Node node2 = new Node();
                    node2.setLabel(t.getCityAreaname());
                    node2.setValue(Long.valueOf(t.getCityOraareacode()));

                    //四级列表
                    List<PubPayCity> cities1 = pubPayCityDAO.selectByTypeAndAreaCode3(l.getNodeNodecode(), "3", c.getCityTopareacode1(),c.getCityTopareacode2());
                    List<Node> list4 = new ArrayList<>();
                    cities1.stream().forEach(s -> {
                        Node node3 = new Node();
                        node3.setLabel(t.getCityAreaname());
                        node3.setValue(Long.valueOf(t.getCityOraareacode()));
                        list4.add(node3);
                    });
                    node2.setChildren(list4);

                    list3.add(node2);
                });
                node1.setChildren(list3);
                list1.add(node1);

            });
            node.setChildren(list1);


        });
//        System.out.println("-------------");
        File file = new File("/Users/lyl/Desktop/address.txt");
//        System.out.println(JSONArray.toJSONString(nodes, SerializerFeature.DisableCircularReferenceDetect));
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(JSONArray.toJSONString(nodes, SerializerFeature.DisableCircularReferenceDetect));
        fileWriter.close();

    }


}
