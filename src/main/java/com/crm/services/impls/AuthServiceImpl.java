package com.crm.services.impls;

import com.crm.commun.exceptions.ServiceException;
import com.crm.commun.results.Response;
import com.crm.commun.tools.DateTools;
import com.crm.commun.tools.TokenUtil;
import com.crm.domain.UserEntity;
import com.crm.domain.UserTokenEntity;
import com.crm.forms.LoginError;
import com.crm.forms.LoginSuccess;
import com.crm.repository.UserRepository;
import com.crm.repository.UserTokenRepository;
import com.crm.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserTokenRepository userTokenRepository;
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private PasswordEncoder userPasswordEncoder;
    @Override
    @Transactional(readOnly = false)
    public Response login(String username, String password, String source) throws ServiceException {
        String lowercaseLogin = username.toLowerCase();
        UserEntity userFromDatabase;

        if(lowercaseLogin.contains("@")) {
            userFromDatabase = userRepository.findByEmail(lowercaseLogin);
        } else {
            userFromDatabase = userRepository.findByUsernameCaseInsensitive(lowercaseLogin);
        }
        if (userFromDatabase == null) {
            return new Response(new LoginError(username,Set.of("username.not.found")));
        } else if (userFromDatabase.getActivatedAt() == null || DateTools.before(userFromDatabase.getActivatedAt(), new Date(),DateTools.FORMAT_YYYYMMDD)) {
            return new Response(new LoginError(username,Set.of("account.inactive")));
        } else if (userFromDatabase.getActivatedAt() != null && DateTools.before(userFromDatabase.getExpiredAt(), LocalDate.now(),DateTools.FORMAT_YYYYMMDD)) {
            return new Response(new LoginError(username,Set.of("account.expired")));
        } else if (userFromDatabase.getDeletedAt() != null) {
            return new Response(new LoginError(username,Set.of("account.deleted")));
        } else if(userFromDatabase.getAuthorities().isEmpty()) {
            return new Response(new LoginError(username,Set.of("account.no.rules")));
        } else if(userPasswordEncoder.matches(userFromDatabase.getPassword(),userPasswordEncoder.encode(password))){
            return new Response(new LoginError(username,Set.of("password.incorrect")));
        }
        // generate Token
        UserTokenEntity userTokenEntity = new UserTokenEntity();
        userTokenEntity.setExpireAt(new Date());
        userTokenEntity.setUsername(username);
        userTokenEntity.setToken(tokenUtil.createToken(username));
        userTokenRepository.save(userTokenEntity);
        // set last login
        userFromDatabase.setLastLogin(new Date());
        userRepository.save(userFromDatabase);
        // result
        LoginSuccess loginSuccess = new LoginSuccess();
        loginSuccess.setUsername(username);
        loginSuccess.setExpireAt(DateTools.toStr(userTokenEntity.getExpireAt(),DateTools.YYYY_MM_DD));
        loginSuccess.setToken(userTokenEntity.getToken());
        return new Response(loginSuccess);
    }
}
