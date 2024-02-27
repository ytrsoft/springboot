package com.ytrsoft.entity;

import lombok.*;
import org.springframework.data.rest.core.annotation.Description;

import javax.persistence.*;

@Entity
@Table()
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Address extends BaseEntity {

    @Description("公司ID")
    private String brandId;

    @Column(columnDefinition = "TEXT")
    @Description("名称")
    private String name;

    @Column(precision = 10, scale = 6)
    @Description("纬度")
    private Double latitude;

    @Column(precision = 10, scale = 6)
    @Description("经度")
    private Double longitude;

}
