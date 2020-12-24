package com.crm.services;

import com.crm.commun.exceptions.ServiceException;
import com.crm.commun.results.Response;

public interface AuthService {
    public Response login(String username, String password, String source) throws ServiceException;
}
