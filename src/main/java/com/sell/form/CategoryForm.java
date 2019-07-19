//create by howard in 20190515
package com.sell.form;

import lombok.Data;

@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}