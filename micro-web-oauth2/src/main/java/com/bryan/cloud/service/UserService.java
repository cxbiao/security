package com.bryan.cloud.service;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

    List<String> queryContents(HttpServletRequest request);

}
