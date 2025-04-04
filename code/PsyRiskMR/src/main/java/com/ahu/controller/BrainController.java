package com.ahu.controller;

import com.ahu.domain.Brain;
import com.ahu.mapper.BrainMapper;
import com.ahu.service.BrainService;
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
 * @Classname: BrainController
 * @Date: 2024/10/10 18:46
 * @Author: 聂建强
 * @Description:
 */
@RestController
@RequestMapping("/brain")
public class BrainController {

    @Resource
    private BrainService brainService;
    @Resource
    private BrainMapper brainMapper;

    /**
     * 获取全部信息
     * @return
     */
    @RequestMapping("/getList")
    public List<Brain> getBrainList(){
        // 查询所有
        List<Brain> brainList = brainService.list();

        return brainList;
    }

    /**
     * 分页获取数据,带排序功能
     * @param start DataTables 请求中的起始行数
     * @param length DataTables 请求中的起始行数
     * @return
     */
    // @RequestMapping("/getListByPage")
    // public Map<String, Object> getBrainListByPage(@RequestParam int start, @RequestParam int length, @RequestParam int draw,
    //                                               @RequestParam(required = false) String searchValue,
    //                                               @RequestParam(required = false) String sortColumn,
    //                                               @RequestParam(required = false) String sortDirection){
    //
    //     System.out.println("searchValue: " + sortColumn);
    //     System.out.println("length: " + sortDirection);
    //     // 计算分页的页码
    //     int page = start / length + 1;
    //
    //     // 使用 MyBatis Plus 的分页查询对象
    //     Page<Brain> brainPage = new Page<>(page, length);
    //
    //     // 使用LambdaQueryWrapper来选择特定的字段
    //     LambdaQueryWrapper<Brain> queryWrapper = new LambdaQueryWrapper<>();
    //     queryWrapper.select(Brain::getPsychiatricDisorder, Brain::getRiskBrainImaging, Brain::getMethod,Brain::getPValue,
    //             Brain::getMregger, Brain::getOrValue,Brain::getIvw, Brain::getInterceptValue);
    //     if (searchValue != null && !searchValue.isEmpty()) {
    //         queryWrapper.like(Brain::getPsychiatricDisorder, searchValue)
    //                 .or().like(Brain::getRiskBrainImaging, searchValue)
    //                 .or().like(Brain::getMethod, searchValue)
    //                 .or().like(Brain::getPValue, searchValue)
    //                 .or().like(Brain::getMregger, searchValue)
    //                 .or().like(Brain::getOrValue, searchValue)
    //                 .or().like(Brain::getIvw, searchValue)
    //                 .or().like(Brain::getInterceptValue, searchValue);
    //     }
    //     // 处理排序
    //     if (sortColumn != null && !sortColumn.isEmpty() && sortDirection != null && !sortDirection.isEmpty()) {
    //         switch (sortColumn) {
    //             case "psychiatricDisorder":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(Brain::getPsychiatricDisorder);
    //                 } else {
    //                     queryWrapper.orderByDesc(Brain::getPsychiatricDisorder);
    //                 }
    //                 break;
    //             case "riskBrainImaging":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(Brain::getRiskBrainImaging);
    //                 } else {
    //                     queryWrapper.orderByDesc(Brain::getRiskBrainImaging);
    //                 }
    //                 break;
    //             case "method":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(Brain::getMethod);
    //                 } else {
    //                     queryWrapper.orderByDesc(Brain::getMethod);
    //                 }
    //                 break;
    //             case "pValue":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(Brain::getPValue);
    //                 } else {
    //                     queryWrapper.orderByDesc(Brain::getPValue);
    //                 }
    //                 break;
    //             case "orValue":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(Brain::getOrValue);
    //                 } else {
    //                     queryWrapper.orderByDesc(Brain::getOrValue);
    //                 }
    //                 break;
    //             case "mregger":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(Brain::getMregger);
    //                 } else {
    //                     queryWrapper.orderByDesc(Brain::getMregger);
    //                 }
    //                 break;
    //             case "ivw":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(Brain::getIvw);
    //                 } else {
    //                     queryWrapper.orderByDesc(Brain::getIvw);
    //                 }
    //                 break;
    //             case "interceptValue":
    //                 if ("asc".equalsIgnoreCase(sortDirection)) {
    //                     queryWrapper.orderByAsc(Brain::getInterceptValue);
    //                 } else {
    //                     queryWrapper.orderByDesc(Brain::getInterceptValue);
    //                 }
    //                 break;
    //             default:
    //                 // 默认排序，如果没有指定或无效的列名
    //                 queryWrapper.orderByDesc(Brain::getPValue);
    //                 break;
    //         }
    //     } else {
    //         // 默认排序
    //         queryWrapper.orderByDesc(Brain::getPValue);
    //     }
    //
    //
    //     // 执行分页查询
    //     Page<Brain> brainPageRes = brainService.page(brainPage,queryWrapper);
    //
    //     // 准备返回数据给 DataTables
    //     Map<String, Object> result = new HashMap<>();
    //     result.put("draw", draw); // 用于 DataTables 的请求计数
    //     result.put("recordsTotal", brainService.count()); // 数据库中的总记录数
    //     result.put("recordsFiltered", brainPageRes.getTotal()); // 过滤后的记录数
    //     result.put("data", brainPageRes.getRecords()); // 当前页的数据
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
    public Map<String, Object> getBrainListByPage(@RequestParam int start, @RequestParam int length, @RequestParam int draw,
                                                  @RequestParam(required = false) String searchValue){

        // 计算分页的页码
        int page = start / length + 1;

        // 使用 MyBatis Plus 的分页查询对象
        Page<Brain> brainPage = new Page<>(page, length);

        // 使用LambdaQueryWrapper来选择特定的字段
        LambdaQueryWrapper<Brain> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Brain::getPsychiatricDisorder, Brain::getRiskBrainImaging, Brain::getMethod,Brain::getPValue,
                Brain::getMregger, Brain::getOrValue,Brain::getIvw, Brain::getInterceptValue);
        if (searchValue != null && !searchValue.isEmpty()) {
            queryWrapper.like(Brain::getPsychiatricDisorder, searchValue)
                    .or().like(Brain::getRiskBrainImaging, searchValue)
                    .or().like(Brain::getMethod, searchValue)
                    .or().like(Brain::getPValue, searchValue)
                    .or().like(Brain::getMregger, searchValue)
                    .or().like(Brain::getOrValue, searchValue)
                    .or().like(Brain::getIvw, searchValue)
                    .or().like(Brain::getInterceptValue, searchValue);
        }
        // 默认排序方式
        queryWrapper.orderByAsc(Brain::getPValue);

        // 执行分页查询
        Page<Brain> brainPageRes = brainService.page(brainPage,queryWrapper);

        // 准备返回数据给 DataTables
        Map<String, Object> result = new HashMap<>();
        result.put("draw", draw); // 用于 DataTables 的请求计数
        result.put("recordsTotal", brainService.count()); // 数据库中的总记录数
        result.put("recordsFiltered", brainPageRes.getTotal()); // 过滤后的记录数
        result.put("data", brainPageRes.getRecords()); // 当前页的数据

        return result;
    }
}
