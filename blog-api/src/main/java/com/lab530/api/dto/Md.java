package com.lab530.api.dto;


import lombok.Data;

import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)

public class Md implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 购物车条目id
     */

    private Long id;

    /**
     * 用户id
     */
    private Long createUser;

    /**
     * 分类id
     */
    private Integer category_id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 状态 0-未完成 1-已完成
     */
    private int state;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
