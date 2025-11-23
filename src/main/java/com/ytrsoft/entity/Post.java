package com.ytrsoft.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Post extends BaseEntity {
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String region;

    private String age;

    private String score;

    private String price;

    private String service;

    private String wechat;

    private String phone;

    private String qq;

    private String menuId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private List<Image> images;
}
