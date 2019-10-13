/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.data.dtos;

/**
 *
 * @author Khang
 */
public class ResultDto {
    public ResultDto(){
        Result=new StringBuilder("-1").toString();
        ErrorDesc=new StringBuilder("Mới khởi tạo").toString();
    }
    String Result;
    Object Id;
    String ErrorDesc;
}
