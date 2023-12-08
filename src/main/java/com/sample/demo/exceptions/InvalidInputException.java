package com.sample.demo.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvalidInputException extends Exception{
    private String msg;
    private Boolean success;
    private Integer code;

    public InvalidInputException(String msg, Integer code){
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public InvalidInputException(String msg){
        super(msg);
        this.msg = msg;
        this.code = code;
    }

}
