package com.ytrsoft.entity;


import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Menu extends BaseEntity {
    private String name;
}
