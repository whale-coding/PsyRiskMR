package com.ahu.controller;

import com.ahu.domain.DisorderRiskCategory;
import com.ahu.mapper.DisorderRiskCategoryMapper;
import com.ahu.service.DisorderRiskCategoryService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname: DisorderRiskCategoryController
 * @Date: 2024/10/11 14:58
 * @Author: 聂建强
 * @Description:
 */
@RestController
@RequestMapping("/disorder_risk_category")
public class DisorderRiskCategoryController {
    @Resource
    private DisorderRiskCategoryService disorderRiskCategoryService;

    @Resource
    private DisorderRiskCategoryMapper disorderRiskCategoryMapper;

    /**
     * 多条件搜索
     * @param start 分页参数
     * @param length 分页参数
     * @param draw 分页参数
     * @param disease 疾病
     * @param category 类型
     * @param riskFactor 风险因素
     * @return 结果集
     */
    // @RequestMapping("/search")
    // public Map<String, Object> getDisorderRiskCategoryList(@RequestParam int start,
    //                                                        @RequestParam int length,
    //                                                        @RequestParam int draw,
    //                                                        @RequestParam(required = false) String disease,
    //                                                        @RequestParam(required = false) String category,
    //                                                        @RequestParam(required = false) String riskFactor,
    //                                                        @RequestParam(required = false) String sortColumn,
    //                                                        @RequestParam(required = false) String sortDirection) {
    //
    //     // 使用 LambdaQueryWrapper
    //     LambdaQueryWrapper<DisorderRiskCategory> queryWrapper = new LambdaQueryWrapper<>();
    //
    //     // 动态构建查询条件
    //     if (disease != null && !disease.isEmpty()) {
    //         queryWrapper.eq(DisorderRiskCategory::getPsychiatricDisorder, disease);
    //     }
    //     if (category != null && !category.isEmpty()) {
    //         queryWrapper.eq(DisorderRiskCategory::getCategory, category);
    //     }
    //     if (riskFactor != null && !riskFactor.isEmpty()) {
    //         queryWrapper.like(DisorderRiskCategory::getRiskFactor, riskFactor);
    //     }
    //
    //     // 处理排序
    //     if (sortColumn != null && !sortColumn.isEmpty() && sortDirection != null && !sortDirection.isEmpty()) {
    //         switch (sortColumn) {
    //             case "psychiatricDisorder":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(DisorderRiskCategory::getPsychiatricDisorder);
    //                 } else {
    //                     queryWrapper.orderByDesc(DisorderRiskCategory::getPsychiatricDisorder);
    //                 }
    //                 break;
    //             case "category":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(DisorderRiskCategory::getCategory);
    //                 } else {
    //                     queryWrapper.orderByDesc(DisorderRiskCategory::getCategory);
    //                 }
    //                 break;
    //             case "riskFactor":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(DisorderRiskCategory::getRiskFactor);
    //                 } else {
    //                     queryWrapper.orderByDesc(DisorderRiskCategory::getRiskFactor);
    //                 }
    //                 break;
    //             case "source":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(DisorderRiskCategory::getSource);
    //                 } else {
    //                     queryWrapper.orderByDesc(DisorderRiskCategory::getSource);
    //                 }
    //                 break;
    //             case "method":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(DisorderRiskCategory::getMethod);
    //                 } else {
    //                     queryWrapper.orderByDesc(DisorderRiskCategory::getMethod);
    //                 }
    //                 break;
    //             case "pValue":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(DisorderRiskCategory::getPValue);
    //                 } else {
    //                     queryWrapper.orderByDesc(DisorderRiskCategory::getPValue);
    //                 }
    //                 break;
    //             case "orValue":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(DisorderRiskCategory::getOrValue);
    //                 } else {
    //                     queryWrapper.orderByDesc(DisorderRiskCategory::getOrValue);
    //                 }
    //                 break;
    //             default:
    //                 // 默认排序，如果没有指定或无效的列名
    //                 queryWrapper.orderByDesc(DisorderRiskCategory::getPValue);
    //                 break;
    //         }
    //     } else {
    //         // 默认排序
    //         queryWrapper.orderByDesc(DisorderRiskCategory::getPValue);
    //     }
    //
    //     // 计算分页的页码
    //     int page = start / length + 1;
    //
    //     // 使用 MyBatis Plus 的分页查询对象
    //     Page<DisorderRiskCategory> disorderRiskCategoryPage = new Page<>(page, length);
    //
    //     // 执行分页查询
    //     Page<DisorderRiskCategory> disorderRiskCategoryPageRes = disorderRiskCategoryService.page(disorderRiskCategoryPage, queryWrapper);
    //
    //     // 准备返回数据给 DataTables
    //     Map<String, Object> result = new HashMap<>();
    //     result.put("draw", draw);
    //     result.put("recordsTotal", disorderRiskCategoryService.count());
    //     result.put("recordsFiltered", disorderRiskCategoryPageRes.getTotal());
    //     result.put("data", disorderRiskCategoryPageRes.getRecords());
    //
    //     return result;
    // }


    /**
     * 多条件搜索，不带排序功能
     * @param start
     * @param length
     * @param draw
     * @param disease
     * @param category
     * @param riskFactor
     * @return
     */
    @RequestMapping("/search")
    public Map<String, Object> getDisorderRiskCategoryList(@RequestParam int start,
                                                           @RequestParam int length,
                                                           @RequestParam int draw,
                                                           @RequestParam(required = false) String disease,
                                                           @RequestParam(required = false) String category,
                                                           @RequestParam(required = false) String riskFactor) {

        // 使用 LambdaQueryWrapper
        LambdaQueryWrapper<DisorderRiskCategory> queryWrapper = new LambdaQueryWrapper<>();

        // 动态构建查询条件
        if (disease != null && !disease.isEmpty()) {
            queryWrapper.eq(DisorderRiskCategory::getPsychiatricDisorder, disease);
        }
        if (category != null && !category.isEmpty()) {
            queryWrapper.eq(DisorderRiskCategory::getCategory, category);
        }
        if (riskFactor != null && !riskFactor.isEmpty()) {
            queryWrapper.like(DisorderRiskCategory::getRiskFactor, riskFactor);
        }

        // 默认排序方式
        queryWrapper.orderByAsc(DisorderRiskCategory::getPValue);


        // 计算分页的页码
        int page = start / length + 1;

        // 使用 MyBatis Plus 的分页查询对象
        Page<DisorderRiskCategory> disorderRiskCategoryPage = new Page<>(page, length);

        // 执行分页查询
        Page<DisorderRiskCategory> disorderRiskCategoryPageRes = disorderRiskCategoryService.page(disorderRiskCategoryPage, queryWrapper);

        // 准备返回数据给 DataTables
        Map<String, Object> result = new HashMap<>();
        result.put("draw", draw);
        result.put("recordsTotal", disorderRiskCategoryService.count());
        result.put("recordsFiltered", disorderRiskCategoryPageRes.getTotal());
        result.put("data", disorderRiskCategoryPageRes.getRecords());

        return result;
    }


}
