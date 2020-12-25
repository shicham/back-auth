package com.crm.services.impls;

import com.crm.commun.exceptions.ServiceException;
import com.crm.commun.results.Response;
import com.crm.commun.tools.DateTools;
import com.crm.commun.tools.TokenUtil;
import com.crm.domain.UserEntity;
import com.crm.forms.Registre;
import com.crm.repository.UserRepository;
import com.crm.services.RegistreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;

@Service
@Transactional(readOnly = true)
public class RegistreServiceImpl implements RegistreService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = false)
    public Response register(String username, String password, String source) throws ServiceException {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(passwordEncoder.encode(password));
        userEntity.setExpiredAt(DateTools.addMonth(LocalDate.now(),6));
        userEntity.setActivatedAt(new Date());
        userEntity.setCreatedAt(new Date());
        
        System.out.println("eeeeeeeeeee");
        userRepository.save(userEntity);
        Registre registre = new Registre();
        registre.setUsername(username);
        return new Response(registre);
    }
}
