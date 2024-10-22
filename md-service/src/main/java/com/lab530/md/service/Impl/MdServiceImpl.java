package com.lab530.md.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lab530.md.domain.Md;
import com.lab530.md.mapper.MdMapper;
import com.lab530.md.service.MdService;
import org.springframework.stereotype.Service;

@Service
public class MdServiceImpl extends ServiceImpl<MdMapper, Md> implements MdService {
}
