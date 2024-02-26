package com.ytrsoft.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table()
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Job extends BaseEntity {
    // 关联ID
    private String brandId;
    // 老板的名字
    private String bossName;
    // 老板的职位
    private String bossTitle;
    // 工作名称
    private String jobName;
    // 薪资描述
    private String salaryDesc;
    // 工作标签
    @Column(columnDefinition = "TEXT")
    private String jobLabels;
    // 需要的技能
    @Column(columnDefinition = "TEXT")
    private String skills;
    // 工作经验要求
    private String jobExperience;
    // 学历要求
    private String jobDegree;
    // 城市名称
    private String cityName;
    // 区域/行政区
    private String areaDistrict;
    // 商业区
    private String businessDistrict;
    // 品牌名称
    private String brandName;
    // 品牌logo
    private String brandLogo;
    // 品牌所在行业
    private String brandIndustry;
    // 品牌规模名称
    private String brandScaleName;
    // 福利列表
    private String welfareList;
    // 工作描述
    @Column(columnDefinition = "TEXT")
    private String jobDesc;
    // 工作地点
    private String jobLocation;
    // 纬度
    private BigDecimal latitude;
    // 经度
    private BigDecimal longitude;
}
