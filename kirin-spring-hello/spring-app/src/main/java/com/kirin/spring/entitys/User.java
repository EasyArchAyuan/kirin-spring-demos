package com.kirin.spring.entitys;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /**
     * user id.
     */
    @ExcelProperty("ID")
    private Long id;

    /**
     * username.
     */
    @ExcelProperty("Name")
    private String userName;

    /**
     * email.
     */
    @ExcelProperty("Email")
    private String email;

    /**
     * phoneNumber.
     */
    @ExcelProperty("Phone")
    private long phoneNumber;

    /**
     * description.
     */
    @ExcelProperty("Description")
    private String description;

}