package com.example.oauthLogin.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

import static com.example.oauthLogin.config.SecretConstant.JASYPT_KEY;

@Configuration
public class JasyptConfig {

    @Bean(name = "jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() throws IOException {

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(JASYPT_KEY);
        config.setAlgorithm("PBEWithMD5AndDES"); // 암호화 알고리즘
        config.setKeyObtentionIterations("1000"); // 반복할 해싱 회수
        config.setPoolSize("2"); // 인스턴스 pool
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator"); // salt 생성 클래스
        config.setStringOutputType("base64"); //인코딩 방식
        encryptor.setConfig(config);
/*
        String tmpEncodeNaver = encryptor.encrypt("http://localhost:8080/login/ouath2/code/naver");
        System.out.println("Naver Callback url Encoding : " + tmpEncodeNaver);
        String tmpDecodeNaver = encryptor.decrypt(tmpEncodeNaver);
        System.out.println("Naver Callback url Decoding : " + tmpDecodeNaver);

        String tmpEncodeGoogle = encryptor.encrypt("http://localhost:8080/login/oauth2/code/google");
        System.out.println("Naver Callback url Encoding : " + tmpEncodeGoogle);
        String tmpDecodeGoogle = encryptor.decrypt(tmpEncodeGoogle);
        System.out.println("Naver Callback url Decoding : " + tmpDecodeGoogle);
 */

        return encryptor;
    }

}
