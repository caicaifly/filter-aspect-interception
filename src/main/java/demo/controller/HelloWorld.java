package demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: filter-aspect-interception
 * @Package: demo.controller
 * @Description: note
 * @Author: xiangdc16781
 * @CreateDate: 2020-05-27 9:09
 * @UpdateUser: xiangdc16781
 * @UpdateDate: 2020-05-27 9:09
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 Hundsun Technologies Inc. All Rights Reserved
 **/
@RestController
public class HelloWorld {

    @RequestMapping("/sayHello")
    public String sayHello(){
        return "hello world!";
    }

}
