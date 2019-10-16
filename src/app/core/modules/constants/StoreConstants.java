package app.core.modules.constants;

public class StoreConstants {
    public static String ALLCODE_LSTBYCODE(){
        return "call ALLCODE_LstByCode(:cdName)";
    }
    
    public static String PRODUCT_SEARCH(){
        return "call PRODUCT_Search(:keyword,:offset,:pageSize,:sorting,!totalCount)";
    }
    public static String PRODUCT_BYID(){
        return "call PRODUCT_ById(:id)";
    }
    public static String PRODUCT_INSORUPD(){
        return "call PRODUCT_InsOrUpd(:id, :code, :name, :price, :categoryId, :description, " +
                ":image, :thumbnail, :note, :status, :isDeleted, :createdDate, :createdBy, " +
                ":updatedDate, :updatedBy)";
    }
    
    public static String PRODUCTCATEGORY_SEARCH(){
        return "call PRODUCTCATEGORY_SEARCH(:keyword,:offset,:pageSize,:sorting,!totalCount)";
    }
     public static String PRODUCTCATEGORY_LST(){
        return "call PRODUCTCATEGORY_Lst";
    }
}
