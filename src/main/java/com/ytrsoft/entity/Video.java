package com.ytrsoft.entity;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Video extends BaseEntity {
    private String title;
    private String thumb;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;
    private String duration;
    private String url;
}
