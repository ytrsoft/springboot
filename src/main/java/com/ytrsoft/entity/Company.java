package com.ytrsoft.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table()
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Company extends BaseEntity {
    // 关联ID
    private String brandId;
    // 公司名称
    private String corpName;
    // 法定代表人
    private String legalRep;
    // 成立日期
    @Temporal(TemporalType.DATE)
    private Date estDate;
    // 公司类型
    private String corpType;
    // 经营状态
    private String opStatus;
    // 注册资本
    private String regCapital;
    // 注册地址
    private String regAddress;
    // 营业期限开始
    @Temporal(TemporalType.DATE)
    private Date bizTermStart;
    // 营业期限结束
    @Temporal(TemporalType.DATE)
    private Date bizTermEnd;
    // 地区/省份
    @Column()
    private String region;
    // 统一社会信用代码
    @Column()
    private String uscc;
    // 批准日期
    @Column()
    @Temporal(TemporalType.DATE)
    private Date approvalDate;
    // 曾用名
    @Column()
    private String formerName;
    // 注册机关
    @Column()
    private String regAuthority;
    // 经营范围
    @Column(columnDefinition = "TEXT")
    private String bizScope;
    // 荣誉
    @Column(columnDefinition = "TEXT")
    private String honors;
    // 企业文化
    @Column(columnDefinition = "TEXT")
    private String corpCulture;
    // 人才发展
    @Column(columnDefinition = "TEXT")
    private String talentDev;
    // 发展历程
    @Column(columnDefinition = "TEXT")
    private String devHistory;
    // 福利
    @Column(columnDefinition = "TEXT")
    private String benefits;
    // 加班文化
    @Column(columnDefinition = "TEXT")
    private String overtime;
    // 工作开始时间
    @Column()
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm")
    private Date workStartTime;
    // 工作结束时间
    @Column()
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm")
    private Date workEndTime;
    // 公司图片
    @Column(columnDefinition = "TEXT")
    private String pictures;

}
