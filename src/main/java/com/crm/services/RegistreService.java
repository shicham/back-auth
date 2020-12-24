package com.crm.services;

import com.crm.commun.exceptions.ServiceException;
import com.crm.commun.results.Response;

public interface RegistreService {
    public Response register(String username, String password, String source) throws ServiceException;
}
