package com.ytrsoft.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.rest.core.annotation.Description;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table()
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Company extends BaseEntity {

    @Description("公司ID")
    private String brandId;

    @Description("公司名称")
    private String corpName;

    @Description("法定代表人")
    private String legalRep;

    @Description("成立日期")
    @Temporal(TemporalType.DATE)
    private Date estDate;

    @Description("公司类型")
    private String corpType;

    @Description("经营状态")
    private String opStatus;

    @Description("注册资本")
    private String regCapital;

    @Description("注册地址")
    private String regAddress;

    @Description("营业期限开始")
    @Temporal(TemporalType.DATE)
    private Date bizTermStart;

    @Description("营业期限结束")
    @Temporal(TemporalType.DATE)
    private Date bizTermEnd;

    @Description("地区")
    private String region;

    @Description("统一社会信用代码")
    private String uscc;

    @Description("批准日期")
    @Temporal(TemporalType.DATE)
    private Date approvalDate;

    @Description("曾用名")
    private String formerName;

    @Description("注册机关")
    private String regAuthority;

    @Description("经营范围")
    @Column(columnDefinition = "TEXT")
    private String bizScope;

    @Description("荣誉")
    @Column(columnDefinition = "TEXT")
    private String honors;

    @Description("企业文化")
    @Column(columnDefinition = "TEXT")
    private String corpCulture;

    @Description("人才发展")
    @Column(columnDefinition = "TEXT")
    private String talentDev;

    @Description("发展历程")
    @Column(columnDefinition = "TEXT")
    private String devHistory;

    @Description("福利")
    @Column(columnDefinition = "TEXT")
    private String benefits;

    @Description("加班文化")
    @Column(columnDefinition = "TEXT")
    private String overtime;

    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm")
    @Description("工作开始时间")
    private Date workStartTime;

    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm")
    @Description("工作结束时间")
    private Date workEndTime;

    @Description("公司图片")
    @Column(columnDefinition = "TEXT")
    private String pictures;
}
