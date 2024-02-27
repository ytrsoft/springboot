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
public class Project extends BaseEntity {

    @Description("公司ID")
    private String brandId;

    @Description("名称")
    private String name;

    @Description("描述")
    @Column(columnDefinition = "TEXT")
    private String description;

    @Description("图标")
    @Column(columnDefinition = "TEXT")
    private String logo;

}
