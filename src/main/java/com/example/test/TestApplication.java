package com.example.test;

import com.alibaba.fastjson.JSONObject;
import com.caucho.hessian.client.HessianProxyFactory;
import com.yeepay.g3.facade.hermes.dto.CredentialsAuthParam;
import com.yeepay.g3.facade.hermes.dto.CredentialsValidateResultDTO;
import com.yeepay.g3.facade.hermes.facade.CredentialsFacade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.MalformedURLException;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);

    }

}
