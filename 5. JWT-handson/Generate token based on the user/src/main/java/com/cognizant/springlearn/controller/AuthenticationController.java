package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String,String> authenticate(
            @RequestHeader("Authorization") String authHeader){

        LOGGER.info("Start");

        String user=getUser(authHeader);
        String token=generateJwt(user);

        Map<String,String> map=new HashMap<>();
        map.put("token",token);

        LOGGER.debug("JWT : {}",token);
        LOGGER.info("End");

        return map;
    }

    private String getUser(String authHeader){
        String encoded=authHeader.substring("Basic ".length());
        String credentials=new String(Base64.getDecoder().decode(encoded));
        return credentials.substring(0,credentials.indexOf(":"));
    }

    private String generateJwt(String user){

        JwtBuilder builder=Jwts.builder();

        builder.setSubject(user);
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date(new Date().getTime()+1200000));
        builder.signWith(SignatureAlgorithm.HS256,"secretkey");

        return builder.compact();
    }
}
