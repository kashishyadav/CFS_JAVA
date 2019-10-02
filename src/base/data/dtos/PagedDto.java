package base.data.dtos;

import java.util.ArrayList;
import java.util.List;

public class PagedDto<T> {
    public PagedDto()
    {
        items = new ArrayList<T>();
    }
    private List<T> items;
    private int offset;
    private int pageSize;
    private int pageCount;
    private int rowCount;
    private int firstRowOnPage;
    private int lastRowOnPage;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
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

    public int getFirstRowOnPage() {
        return firstRowOnPage;
    }

    public void setFirstRowOnPage(int firstRowOnPage) {
        this.firstRowOnPage = firstRowOnPage;
    }

    public int getLastRowOnPage() {
        return lastRowOnPage;
    }

    public void setLastRowOnPage(int lastRowOnPage) {
        this.lastRowOnPage = lastRowOnPage;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getPageCount(){
        double pageCount = (double)getRowCount() / getPageSize();
        this.pageCount = (int)Math.ceil(pageCount);
        return this.pageCount;
    }
    public void setPageCount(int pageCount)
    {
        this.pageCount = pageCount;
    }
}
