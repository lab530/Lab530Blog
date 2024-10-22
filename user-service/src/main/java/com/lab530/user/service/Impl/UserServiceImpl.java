package com.lab530.user.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lab530.common.exception.BadRequestException;
import com.lab530.common.exception.BizIllegalException;
import com.lab530.common.exception.ForbiddenException;
import com.lab530.common.utils.UserContext;
import com.lab530.user.config.JwtProperties;
import com.lab530.user.domain.dto.LoginFormDTO;
import com.lab530.user.domain.po.User;
import com.lab530.user.domain.vo.UserLoginVO;
import com.lab530.user.enums.UserStatus;
import com.lab530.user.mapper.UserMapper;
import com.lab530.user.service.IUserService;
import com.lab530.user.utils.JwtTool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final PasswordEncoder passwordEncoder;

    private final JwtTool jwtTool;

    private final JwtProperties jwtProperties;

    @Override
    public UserLoginVO login(LoginFormDTO loginDTO) {
        // 1.数据校验
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        // 2.根据用户名或手机号查询
        User user = lambdaQuery().eq(User::getUsername, username).one();
        Assert.notNull(user, "用户名错误");
        // 3.校验是否禁用
        if (user.getStatus() == UserStatus.FROZEN) {
            throw new ForbiddenException("用户被冻结");
        }
        // 4.校验密码
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadRequestException("用户名或密码错误");
        }
        // 5.生成TOKEN
        String token = jwtTool.createToken(user.getId(), jwtProperties.getTokenTTL());
        // 6.封装VO返回
        UserLoginVO vo = new UserLoginVO();
        vo.setUserId(user.getId());
        vo.setUsername(user.getUsername());
        vo.setToken(token);
        return vo;
    }


}
