package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * <一句话功能简述><br>
 * <>
 *
 * @author $ {USER}
 * @create $ {DATE}
 * @since 1.0.0
 */

@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;


    /**
     * 根据查询条件分页并排序查询品牌信息
     * @param key
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @return
     */
    public PageResult<Brand> queryByandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc) {

        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        //根据name模糊查询，或者根据首字母查询
        if (StringUtil.isNotEmpty(key)){
            criteria.andLike("name", "%" + key + "%").orEqualTo("letter",key);
        }
        //添加分页条件
        PageHelper.startPage(page, rows);

        //添加排序条件
        if (StringUtils.isNotEmpty(sortBy)){
            example.setOrderByClause(sortBy+" "+(desc ? "desc" : "asc"));
        }

        List<Brand> brands = brandMapper.selectByExample(example);
        //包装成pageInfo
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);
        //包装成分页结果集
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }
}
