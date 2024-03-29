package com.interview.api.auth;

import java.io.IOException;
import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.api.entity.User;
import com.fasterxml.jackson.core.JsonParseException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  public static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
  private AuthenticationManager authenticationManager;

  public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {

    this.authenticationManager = authenticationManager;
    setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/auth", "POST"));
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException {

    String username = obtainUsername(request);
    String password = obtainPassword(request);

    if (username == null && password == null) {
      User user = null;
      try {
        user = new ObjectMapper().readValue(request.getInputStream(), User.class);

        username = user.getUsername();
        password = user.getPassword();
      } catch (JsonParseException e) {
        e.printStackTrace();
      } catch (JsonMappingException e) {
        e.printStackTrace();

      } catch (IOException e) {
        e.printStackTrace();

      }
    }
    if (username == null) {
      username = "";
    }
    username = username.trim();

    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);

    return this.authenticationManager.authenticate(authToken);
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
      Authentication authResult) throws IOException, ServletException {

    Collection<? extends GrantedAuthority> roles = authResult.getAuthorities();

    Claims claims = Jwts.claims();
    claims.put("authorities", new ObjectMapper().writeValueAsString(roles));

    String token = Jwts.builder().setClaims(claims).setSubject(authResult.getName()).signWith(SECRET_KEY)
        .setExpiration(new Date(System.currentTimeMillis() + 3600000 * 4)).compact();

    response.addHeader("Authorization", "Bearer " + token);

    Map<String, Object> body = new HashMap<>();
    body.put("Token", token);
    // body.put("User", authResult.getPrincipal());
    // body.put("Message", "sign-in successful!");

    response.getWriter().write(new ObjectMapper().writeValueAsString(body));
    response.setStatus(200);
    response.setContentType("application/json");
  }

  @Override
  protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException failed) throws IOException, ServletException {
    Map<String, Object> body = new HashMap<>();
    body.put("Message", "Error Authentication: username or password invalid");
    body.put("error", failed.getMessage());

    response.getWriter().write(new ObjectMapper().writeValueAsString(body));
    response.setStatus(401);
    response.setContentType("application/json");
  }

}