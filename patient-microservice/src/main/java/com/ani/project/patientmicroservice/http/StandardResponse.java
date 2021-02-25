package com.ani.project.patientmicroservice.http;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponse<T> {

    private T body;
    private String msg;
    private String sts;
}
