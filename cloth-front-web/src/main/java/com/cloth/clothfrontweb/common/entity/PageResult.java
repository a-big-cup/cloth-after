package com.cloth.clothfrontweb.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/*
*分页
 * {
 *     ”success“：
 *      'code':
 *      'message':
     * data:{
     *  tatal:总条数
     * rows:  列数
    * }
 * }
*
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private Long total;
    private List<T> rows;
}
