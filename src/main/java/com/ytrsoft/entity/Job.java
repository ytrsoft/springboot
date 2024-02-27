package com.ytrsoft.entity;

import lombok.*;
import org.springframework.data.rest.core.annotation.Description;

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

    @Description("公司ID")
    private String brandId;

    @Description("招聘人")
    private String bossName;

    @Description("招聘人职位")
    private String bossTitle;

    @Description("职位名称")
    private String jobName;

    @Description("薪资描述")
    private String salaryDesc;

    @Description("工作标签")
    @Column(columnDefinition = "TEXT")
    private String jobLabels;

    @Description("工作技能")
    @Column(columnDefinition = "TEXT")
    private String skills;

    @Description("工作经验")
    private String jobExperience;

    @Description("学历要求")
    private String jobDegree;

    @Description("城市名称")
    private String cityName;

    @Description("区域")
    private String areaDistrict;

    @Description("商业区")
    private String businessDistrict;

    @Description("公司简称")
    private String brandName;

    @Description("公司Logo")
    private String brandLogo;

    @Description("所属行业")
    private String brandIndustry;

    @Description("公司规模")
    private String brandScaleName;

    @Description("福利")
    private String welfareList;

    @Description("招聘需求")
    @Column(columnDefinition = "TEXT")
    private String jobDesc;

    @Description("工作地点")
    private String jobLocation;

    @Description("纬度")
    private BigDecimal latitude;

    @Description("经度")
    private BigDecimal longitude;

}
