package com.ytrsoft.entity;


import lombok.*;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Chinese extends BaseEntity {
    // 文字
    private Character text;
    // 拼音
    private String pinYin;
    // 声调
    private Integer tone;
}
