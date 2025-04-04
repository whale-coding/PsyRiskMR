package com.ahu.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname: DisorderRiskCategory
 * @Date: 2024/10/11 14:53
 * @Author: 聂建强
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("disorder_risk_category")
public class DisorderRiskCategory {

    @TableField("psychiatric_disorder")
    private String psychiatricDisorder;  // 精神疾病

    @TableField("category")
    private String category;  // 分类

    @TableField("risk_factor")
    private String riskFactor;  // 风险因素

    @TableField("source")
    private String source;  // 来源

    @TableField("method")
    private String method;  // 方法

    @TableField("p_value")
    private Double pValue;  // p_value值

    @TableField("or_value")
    private String orValue;  // or值

}
