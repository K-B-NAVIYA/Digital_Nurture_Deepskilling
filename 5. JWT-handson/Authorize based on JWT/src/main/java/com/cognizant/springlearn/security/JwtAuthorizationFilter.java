package com.cognizant.springlearn.security;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import org.slf4j.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import io.jsonwebtoken.*;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter{
 private static final Logger LOGGER=LoggerFactory.getLogger(JwtAuthorizationFilter.class);
 public JwtAuthorizationFilter(AuthenticationManager authenticationManager){
  super(authenticationManager);
  LOGGER.info("Start");
  LOGGER.debug("{}",authenticationManager);
 }
 @Override
 protected void doFilterInternal(HttpServletRequest req,HttpServletResponse res,FilterChain chain)throws IOException,ServletException{
  LOGGER.info("Start");
  String header=req.getHeader("Authorization");
  LOGGER.debug(header);
  if(header==null||!header.startsWith("Bearer ")){ chain.doFilter(req,res); return; }
  UsernamePasswordAuthenticationToken auth=getAuthentication(req);
  SecurityContextHolder.getContext().setAuthentication(auth);
  chain.doFilter(req,res);
  LOGGER.info("End");
 }
 private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request){
  String token=request.getHeader("Authorization");
  if(token!=null){
   try{
    Jws<Claims> jws=Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token.replace("Bearer ",""));
    String user=jws.getBody().getSubject();
    LOGGER.debug(user);
    if(user!=null) return new UsernamePasswordAuthenticationToken(user,null,new ArrayList<>());
   }catch(JwtException ex){ return null; }
  }
  return null;
 }
}
