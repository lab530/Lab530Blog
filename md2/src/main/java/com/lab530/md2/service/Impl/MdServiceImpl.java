package com.lab530.md2.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lab530.md2.domain.Md;
import com.lab530.md2.mapper.MdMapper;
import com.lab530.md2.service.MdService;
import org.springframework.stereotype.Service;

@Service
public class MdServiceImpl extends ServiceImpl<MdMapper, Md> implements MdService {
}
