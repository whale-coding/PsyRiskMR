package com.ahu.controller;
import com.ahu.domain.Phenotype;
import com.ahu.mapper.PhenotypeMapper;
import com.ahu.service.PhenotypeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname: PhenotypeController
 * @Date: 2024/10/10 18:46
 * @Author: 聂建强
 * @Description:
 */
@RestController
@RequestMapping("/phenotype")
public class PhenotypeController {

    @Resource
    private PhenotypeService phenotypeService;
    @Resource
    private PhenotypeMapper phenotypeMapper;

    /**
     * 获取全部信息
     * @return
     */
    @RequestMapping("/getList")
    public List<Phenotype> getPhenotypeList(){
        // 查询所有
        List<Phenotype> phenotypeList = phenotypeService.list();

        return phenotypeList;
    }

    /**
     * 分页获取数据
     * @param start DataTables 请求中的起始行数
     * @param length DataTables 请求中的起始行数
     * @return
     */
    // @RequestMapping("/getListByPage")
    // public Map<String, Object> getPhenotypeListByPage(@RequestParam int start, @RequestParam int length, @RequestParam int draw,
    //                                               @RequestParam(required = false) String searchValue,
    //                                                   @RequestParam(required = false) String sortColumn,
    //                                                   @RequestParam(required = false) String sortDirection){
    //     // 计算分页的页码
    //     int page = start / length + 1;
    //
    //     // 使用 MyBatis Plus 的分页查询对象
    //     Page<Phenotype> phenotypePage = new Page<>(page, length);
    //
    //     // 使用LambdaQueryWrapper来选择特定的字段
    //     LambdaQueryWrapper<Phenotype> queryWrapper = new LambdaQueryWrapper<>();
    //     queryWrapper.select(Phenotype::getPsychiatricDisorder, Phenotype::getRiskPhenotype, Phenotype::getMethod,Phenotype::getPValue,
    //             Phenotype::getMregger, Phenotype::getOrValue,Phenotype::getIvw, Phenotype::getInterceptValue);
    //     // 处理搜索功能
    //     if (searchValue != null && !searchValue.isEmpty()) {
    //         queryWrapper.like(Phenotype::getPsychiatricDisorder, searchValue)
    //                 .or().like(Phenotype::getRiskPhenotype, searchValue)
    //                 .or().like(Phenotype::getMethod, searchValue)
    //                 .or().like(Phenotype::getPValue, searchValue)
    //                 .or().like(Phenotype::getMregger, searchValue)
    //                 .or().like(Phenotype::getOrValue, searchValue)
    //                 .or().like(Phenotype::getIvw, searchValue)
    //                 .or().like(Phenotype::getInterceptValue, searchValue);
    //     }
    //
    //     // 处理排序
    //     // queryWrapper.orderByAsc(Phenotype::getOrValue); // 降序
    //     if (sortColumn != null && !sortColumn.isEmpty() && sortDirection != null && !sortDirection.isEmpty()) {
    //         switch (sortColumn) {
    //             case "psychiatricDisorder":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(Phenotype::getPsychiatricDisorder);
    //                 } else {
    //                     queryWrapper.orderByDesc(Phenotype::getPsychiatricDisorder);
    //                 }
    //                 break;
    //             case "riskPhenotype":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(Phenotype::getRiskPhenotype);
    //                 } else {
    //                     queryWrapper.orderByDesc(Phenotype::getRiskPhenotype);
    //                 }
    //                 break;
    //             case "method":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(Phenotype::getMethod);
    //                 } else {
    //                     queryWrapper.orderByDesc(Phenotype::getMethod);
    //                 }
    //                 break;
    //             case "pValue":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(Phenotype::getPValue);
    //                 } else {
    //                     queryWrapper.orderByDesc(Phenotype::getPValue);
    //                 }
    //                 break;
    //             case "orValue":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(Phenotype::getOrValue);
    //                 } else {
    //                     queryWrapper.orderByDesc(Phenotype::getOrValue);
    //                 }
    //                 break;
    //             case "mregger":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(Phenotype::getMregger);
    //                 } else {
    //                     queryWrapper.orderByDesc(Phenotype::getMregger);
    //                 }
    //                 break;
    //             case "ivw":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(Phenotype::getIvw);
    //                 } else {
    //                     queryWrapper.orderByDesc(Phenotype::getIvw);
    //                 }
    //                 break;
    //             case "interceptValue":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(Phenotype::getInterceptValue);
    //                 } else {
    //                     queryWrapper.orderByDesc(Phenotype::getInterceptValue);
    //                 }
    //                 break;
    //             default:
    //                 // 默认排序，如果没有指定或无效的列名
    //                 queryWrapper.orderByDesc(Phenotype::getPValue);
    //                 break;
    //         }
    //     } else {
    //         // 默认排序
    //         queryWrapper.orderByDesc(Phenotype::getPValue);
    //     }
    //
    //
    //     // 执行分页查询
    //     Page<Phenotype> phenotypePageRes = phenotypeService.page(phenotypePage,queryWrapper);
    //
    //     // 准备返回数据给 DataTables
    //     Map<String, Object> result = new HashMap<>();
    //     result.put("draw", draw); // 用于 DataTables 的请求计数
    //     result.put("recordsTotal", phenotypeService.count()); // 数据库中的总记录数
    //     result.put("recordsFiltered", phenotypePageRes.getTotal()); // 过滤后的记录数
    //     result.put("data", phenotypePageRes.getRecords()); // 当前页的数据
    //
    //     return result;
    // }




    /**
     * 分页获取数据,不带排序功能
     * @param start DataTables 请求中的起始行数
     * @param length DataTables 请求中的起始行数
     * @return
     */
    @RequestMapping("/getListByPage")
    public Map<String, Object> getPhenotypeListByPage(@RequestParam int start, @RequestParam int length, @RequestParam int draw,
                                                      @RequestParam(required = false) String searchValue){
        // 计算分页的页码
        int page = start / length + 1;

        // 使用 MyBatis Plus 的分页查询对象
        Page<Phenotype> phenotypePage = new Page<>(page, length);

        // 使用LambdaQueryWrapper来选择特定的字段
        LambdaQueryWrapper<Phenotype> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Phenotype::getPsychiatricDisorder, Phenotype::getRiskPhenotype, Phenotype::getMethod,Phenotype::getPValue,
                Phenotype::getMregger, Phenotype::getOrValue,Phenotype::getIvw, Phenotype::getInterceptValue);
        // 处理搜索功能
        if (searchValue != null && !searchValue.isEmpty()) {
            queryWrapper.like(Phenotype::getPsychiatricDisorder, searchValue)
                    .or().like(Phenotype::getRiskPhenotype, searchValue)
                    .or().like(Phenotype::getMethod, searchValue)
                    .or().like(Phenotype::getPValue, searchValue)
                    .or().like(Phenotype::getMregger, searchValue)
                    .or().like(Phenotype::getOrValue, searchValue)
                    .or().like(Phenotype::getIvw, searchValue)
                    .or().like(Phenotype::getInterceptValue, searchValue);
        }

        // 默认排序方式
        queryWrapper.orderByAsc(Phenotype::getPValue);

        // 执行分页查询
        Page<Phenotype> phenotypePageRes = phenotypeService.page(phenotypePage,queryWrapper);

        // 准备返回数据给 DataTables
        Map<String, Object> result = new HashMap<>();
        result.put("draw", draw); // 用于 DataTables 的请求计数
        result.put("recordsTotal", phenotypeService.count()); // 数据库中的总记录数
        result.put("recordsFiltered", phenotypePageRes.getTotal()); // 过滤后的记录数
        result.put("data", phenotypePageRes.getRecords()); // 当前页的数据

        return result;
    }


}
