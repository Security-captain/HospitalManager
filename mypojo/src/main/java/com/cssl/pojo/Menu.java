package com.cssl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    private Integer id;
    private Integer pid;
    private String title;
    private String href;
    private Boolean spread;
    private String target;
    private String icon;
    private Integer available;

}

