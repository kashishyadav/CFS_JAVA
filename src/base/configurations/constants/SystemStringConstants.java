/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.configurations.constants;

import base.infrastructures.systems.AppContext;


/**
 *
 * @author Khang
 */
public class SystemStringConstants {

    public static final String STR_SAVE_SUCCESS = "Lưu thành công";
    public static final String STR_UPD_SUCCESS = "Cập nhật thành công";
    public static final String STR_DEL_SUCCESS = "Xóa thành công";
    public static final String STR_ADD = "Tạo mới";
    public static final String STR_EDIT = "Cập nhật";

    public static final String STR_NULL = "-- NULL --";
    public static final String STR_ERROR_EMPTY_LIST = "Danh sách rỗng";
    public static final String STR_ERROR_EMPTY_ID = "Mã không được rỗng";
    
    public static final String STR_ERROR_PASSWORD_INVALID = String.format("Mật khẩu không hợp lệ,"
            + " không được rỗng và có ít nhất %s ký tự",AppContext.getInstance().getRequiredPasswordLength());

    public static final String STR_ERROR_USERNAME_INVALID =  String.format( "Tên đăng nhập không hợp lệ. Tên đăng nhập bắt buộc không rỗng, "
            + "lớn hơn %s ký tự, và không có ký tự đặc biệt", AppContext.getInstance().getRequiredUserNameLength());
            
      public static final String STR_ERROR_LOGIN = "Đăng nhập thất bại";      
    
}
