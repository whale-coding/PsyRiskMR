package com.ahu.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname: Phenotype
 * @Date: 2024/10/10 17:19
 * @Author: 聂建强
 * @Description: mr_res_Phenotype_all.csv 数据，对应数据库表mr_phenotype
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("mr_phenotype2")
public class Phenotype {
    @TableField("psychiatric_disorder")
    private String psychiatricDisorder;  // 精神疾病
    @TableField("risk_phenotype")
    private String riskPhenotype;  // 风险表型


    @TableField("method")
    private String method;  // 方法
    @TableField("beta")
    private Double beta;  // 参数表

    @TableField("standard_error")
    private Double standardError;  // 标准误差

    @TableField("p_value")
    private Double pValue;  // p_value值
    @TableField("or_value")
    private String orValue;  // or值

    @TableField("or_lci95")
    private String orLci;  // or_lci95值

    @TableField("or_uci95")
    private String orUci;  // or_uci95值

    @TableField("q_pvalue_mregger")
    private String mregger;  // q_pvalue_mregger

    @TableField("q_pvalue_ivw")
    private String ivw;  // q_pvalue_ivw

    @TableField("intercept_pvalue")
    private Double interceptValue;  // intercept_pvalue

}
