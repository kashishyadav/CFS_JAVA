package base.data.entities;

import base.configurations.constants.SystemConstants;

public class EntitySearchBase extends EntityBase {
    public EntitySearchBase(){
        setKeyword("");
        setOffset(SystemConstants.DEFAULT_OFFSET);
        setPageSize(SystemConstants.DEFAULT_PAGESIZE);
        setSorting("");
        
        
    }

    protected String keyword;
    protected int offset;
    protected int pageSize;
    protected String sorting;
    private int pageCount;
    private int totalCount;
//    private int firstRowOnPage;
//    private int lastRowOnPage;


    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSorting() {
        return sorting;
    }

    public void setSorting(String sorting) {
        this.sorting = sorting;
    }
    
    public int getFirstRowOnPage() {
        return 0;
    }

//    public void setFirstRowOnPage(int firstRowOnPage) {
//        this.firstRowOnPage = firstRowOnPage;
//    }

    public int getLastRowOnPage() {
        return getTotalCount()-1;
    }

//    public void setLastRowOnPage(int lastRowOnPage) {
//        this.lastRowOnPage = lastRowOnPage;
//    }
//    
    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    
    
    public int getPageCount(){
        double pageCount = (double)getTotalCount() / getPageSize();
        this.pageCount = (int)Math.ceil(pageCount);
        return this.pageCount;
    }
    public void setPageCount(int pageCount)
    {
        this.pageCount = pageCount;
    }
}
