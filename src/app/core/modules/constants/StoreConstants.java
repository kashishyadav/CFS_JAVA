package app.core.modules.constants;

public class StoreConstants {
    public static String PRODUCT_SEARCH(){
        return "call PRODUCT_Search(:keyword,:offset,:pageSize,:sorting)";
    }
    public static String PRODUCT_BYID(){
        return "call PRODUCT_ById(:id)";
    }
    public static String PRODUCT_INSORUPD(){
        return "call PRODUCT_InsOrUpd(:id, :code, :name, :price, :categoryId, :description, " +
                ":image, :thumbnail, :note, :status, :isDeleted, :createdDate, :createdBy, " +
                ":updatedDate, :updatedBy)";
    }
}
