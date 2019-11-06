package app.common.modules.constants;

public class StoreConstants {

    public static final String ALLCODE_LSTBYCODE = "call ALLCODE_LstByCode(:cdName)";

    public static final String PRODUCT_SEARCH = "call PRODUCT_Search(:keyword,:offset,:pageSize,:sorting,!totalCount)";

    public static final String PRODUCT_BYID = "call PRODUCT_ById(:id)";

    public static final String PRODUCT_INSORUPD
            = "call PRODUCT_InsOrUpd(:id, :code, :name, :price, :categoryId, :description, "
            + ":image, :thumbnail, :note, :status, :isDeleted, :createdDate, :createdBy, "
            + ":updatedDate, :updatedBy)";

    public static final String PRODUCTCATEGORY_SEARCH
            = "call PRODUCTCATEGORY_SEARCH(:keyword,:offset,:pageSize,:sorting,!totalCount)";
    public static final String PRODUCTCATEGORY_LST
            = "call PRODUCTCATEGORY_Lst";
    public static final String PRODUCTCATEGORY_INSORUPD
            = "call PRODUCTCATEGORY_INSORUPD(:id,:code,:name,:description,:image,:thumbnail,:isDeleted, :createdDate, :createdBy, "
            + ":updatedDate, :updatedBy)";
    public static final String PRODUCTCATEGORY_BYID = "call PRODUCTCATEGORY_ById(:id)";

    public static final String EMPLOYEE_SEARCH = "call EMPLOYEE_Search(:keyword,:offset,:pageSize,:sorting,!totalCount)";

    public static final String EMPLOYEE_BYID = "call EMPLOYEE_ById(:id)";

    public static final String EMPLOYEE_INSORUPD
            = "call EMPLOYEE_InsOrUpd(:id, :code, :name, :image, :birthday, :phoneNumber, :address, "
            + ":isDeleted, :createdDate, :createdBy, "
            + ":updatedDate, :updatedBy)";

    public static final String GOODS_SEARCH = "call GOODS_Search(:keyword,:offset,:pageSize,:sorting,!totalCount)";

    public static final String GOODS_BYID = "call GOODS_ById(:id)";

    public static final String GOODS_INSORUPD
            = "call GOODS_InsOrUpd(:id, :code, :name, :price, :categoryId, :description, "
            + ":note, :isDeleted, :createdDate, :createdBy, "
            + ":updatedDate, :updatedBy)";

    public static final String GOODSCATEGORY_SEARCH
            = "call GOODSCATEGORY_SEARCH(:keyword,:offset,:pageSize,:sorting,!totalCount)";
    public static final String GOODSCATEGORY_INSORUPD
            = "call GOODSCATEGORY_INSORUPD(:id,:code,:name,:description,:isDeleted, :createdDate, :createdBy, "
            + ":updatedDate, :updatedBy)";
    public static final String GOODSCATEGORY_BYID = "call GOODSCATEGORY_ById(:id)";

    public static final String ORDER_SEARCH
            = "call ORDER_SEARCH(:keyword,:offset,:pageSize,:sorting,!totalCount)";
    public static final String ORDER_INSORUPD
            = "call ORDER_INSORUPD(:id,:code,:name,:price, :totalPrice, :discountPercent,:fee, "
            + ":strOrderDetails, :note, :status,:isDeleted, :createdDate, :createdBy, "
            + ":updatedDate, :updatedBy)";
    public static final String ORDER_BYID = "call ORDER_BYID(:id)";

    public static final String ORDERDETAIL_SEARCH
            = "call ORDERDETAIL_SEARCH(:keyword,:offset,:pageSize,:sorting,!totalCount)";

    public static final String ORDERDETAIL_BYID = "call ORDERDETAIL_BYID(:id)";

    //system
    public static final String ALLCODE_SEARCH = "call ALLCODE_Search(:keyword,:offset,:pageSize,:sorting,!totalCount)";

    public static final String ALLCODE_BYID = "call ALLCODE_ById(:id)";

    public static final String ALLCODE_INSORUPD
            = "call ALLCODE_InsOrUpd(:id, :cdName, :cdValue, :content, :cdType)";
    
    public static final String ROLE_SEARCH = "call ROLE_Search(:keyword,:offset,:pageSize,:sorting,!totalCount)";

    public static final String ROLE_BYID = "call ROLE_ById(:id)";

    public static final String ROLE_INSORUPD
            = "call ROLE_InsOrUpd(:id, :code, :name, :isDeleted, :createdDate, :createdBy, :updatedDate, :updatedBy)";
    
    public static final String USER_SEARCH = "call USER_Search(:keyword,:offset,:pageSize,:sorting,!totalCount)";

    public static final String USER_BYID = "call USER_ById(:id)";

    public static final String USER_INSORUPD
            = "call USER_InsOrUpd(:id, :code, :userName, :password, :employeeId, :roleId, :isDeleted, :createdDate, :createdBy, :updatedDate, :updatedBy)";
   
    public static final String USER_LOGIN = "call USER_Login(:userName, :password)";
}
