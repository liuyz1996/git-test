package com.leyou.item.conreoller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <一句话功能简述><br>
 * <>
 *
 * @author $ {USER}
 * @create $ {DATE}
 * @since 1.0.0
 */

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据父节点的id查询字节点
     * @param pid
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoriesByPid(@RequestParam(value = "pid",defaultValue = "0") Long pid){

            if (pid == null || pid < 0){
                //返回参数不合法
                return   ResponseEntity.badRequest().build();
            }
            List<Category> Categorys =  this.categoryService.queryCategoriesByPid(pid);
            //判断集合是否为空
            if (CollectionUtils.isEmpty(Categorys)){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(Categorys);

    }



}
