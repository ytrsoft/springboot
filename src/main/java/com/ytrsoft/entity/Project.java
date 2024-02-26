package com.ytrsoft.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table()
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Project extends BaseEntity {
    // 关联ID
    private String brandId;
    // 项目名称
    private String name;
    // 项目描述
    @Column(columnDefinition = "TEXT")
    private String description;
    // 项目logo
    @Column(columnDefinition = "TEXT")
    private String logo;
}
