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
public class Address extends BaseEntity {
    // 关联ID
    private String brandId;
    // 地址名称
    @Column(columnDefinition = "TEXT")
    private String name;
    // 纬度
    @Column(precision = 10, scale = 6)
    private Double latitude;
    // 经度
    @Column(precision = 10, scale = 6)
    private Double longitude;
}
