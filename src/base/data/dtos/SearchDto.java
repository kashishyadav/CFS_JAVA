package base.data.dtos;

import base.configurations.constants.SystemConstants;

public class SearchDto {
    public SearchDto(){
        setKeyword("");
        setOffset(SystemConstants.DEFAULT_OFFSET);
        setPageSize(SystemConstants.DEFAULT_PAGESIZE);
        setSorting("");
    }
    private String keyword;
    private int offset;
    private int pageSize;
    private String sorting;

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
}
