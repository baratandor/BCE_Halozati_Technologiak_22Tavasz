package edu.corvinus.ZH2_02.service;

import javax.servlet.http.HttpServletRequest;

public interface RequestService
{
    String getClientIPAddress(HttpServletRequest request);
}
