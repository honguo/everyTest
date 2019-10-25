package com.example.test;

import com.alibaba.fastjson.JSONObject;
import com.caucho.hessian.client.HessianProxyFactory;
import com.yeepay.g3.facade.hermes.dto.CredentialsAuthParam;
import com.yeepay.g3.facade.hermes.dto.CredentialsValidateResultDTO;
import com.yeepay.g3.facade.hermes.facade.CredentialsFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

    @Test
    public void contextLoads() {
    }
//
//    @Test
//    public void test() throws Exception {
//
//        HessianProxyFactory proxyFactory = new HessianProxyFactory();
//        CredentialsFacade facade = (CredentialsFacade) proxyFactory.create(CredentialsFacade.class, "http://ycetest.yeepay.com:30119/hermes-hessian/hessian/CredentialsFacade");
//
//        for (int i = 0; i < 100; i++) {
//            CredentialsAuthParam cap = new CredentialsAuthParam.CredentialsAuthParamBuilder()
//                    .setSystemCode("employee-boss")
//                    .setUserId("minglei.wen")
//                    .setValidationCode("625352")
//                    .setIp("192.168.0.1")
//                    .createCredentialsAuthParam();
//            CredentialsValidateResultDTO rs = facade.validateCredentials(cap);
//            System.out.println(JSONObject.toJSON(rs));
//            Thread.sleep(1000L);
//        }
//    }

}
