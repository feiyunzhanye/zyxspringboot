package com.ideal.zyxspringboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.ideal.zyxspringboot.model.Algo;
import com.ideal.zyxspringboot.model.ParamsAlgo;
import com.ideal.zyxspringboot.service.AlgoService;
import com.ideal.zyxspringboot.service.ParamsAlgoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/algo")
public class AlgorithmController {
    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private AlgoService algoService;
    @Resource
    private ParamsAlgoService paramsAlgoService;
    /**
     * 传入算法id ，算法参数值
     */
    @RequestMapping("/config")
    @ResponseBody
    public String configAlgo(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String alog_name = request.getParameter("alogName");
        return null;
    }

    /**
     * 进入首页
     * */
    @RequestMapping("/home")
    public String home(Model model){
        List<Algo> algos = algoService.findAll();
        if(algos.size()>0){
            model.addAttribute("algos",algos);
        }/*else {
            model.addAttribute("algos",null);
            System.out.println("算法库为空");
        }*/
        return "macLearning/configAlgo";
    }
    /**
     * 获取单个算法
     * */
    @RequestMapping("/findById")
    @ResponseBody
    public Algo findById(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        long lid = Long.parseLong(id);
        return algoService.findById(lid);
    }
    /**
     * 获取算法的params
     * */
    @RequestMapping("/findParamsAlgosByAlgoId")
    @ResponseBody
    public List<ParamsAlgo> findParamsAlgosByAlgoId(HttpServletRequest request, HttpServletResponse response){
        String algoId = request.getParameter("id");
        long lAlgoId = Long.parseLong(algoId);
        return paramsAlgoService.findParamsAlgosByAlgoId(lAlgoId);
    }
    /**
     * 算法学习
     * */
    @PostMapping("/learn")
    @ResponseBody
    public String learn(HttpServletRequest request, HttpServletResponse response){
        String url = "http://localhost:8888"+"/algo_1";
        String algo_name = request.getParameter("algo_name");
        String params_names = request.getParameter("params_names");
        String params_values = request.getParameter("params_values");
        JSONObject postData = new JSONObject();
        postData.put("algo_name",algo_name);
        postData.put("params_names",params_names);
        postData.put("params_values",params_values);
        String jsonString = restTemplate.postForObject(url, postData, String.class);
        return jsonString;
    }
}
