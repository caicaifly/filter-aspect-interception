package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: filter-aspect-interception
 * @Package: demo
 * @Description: note
 * @Author: xiangdc16781
 * @CreateDate: 2020-05-27 9:04
 * @UpdateUser: xiangdc16781
 * @UpdateDate: 2020-05-27 9:04
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 Hundsun Technologies Inc. All Rights Reserved
 **/
@SpringBootApplication
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class,args);
    }
}
