package com.rammus.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
import com.rammus.util.VideoResult;

public interface AdminService {

    VideoResult adminLogin(String username, String password,HttpServletRequest req,HttpServletResponse resp);
}
