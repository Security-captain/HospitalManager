package com.cssl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sdrugdictionary {

    private Integer drugId;
    private String drugName;
    private Integer unitId	;
    private String unitName;
    private Double sellingPrice;
    private Integer  areaId;
    private String areaName;
    private Integer typeId;
    private String typeName;


}
