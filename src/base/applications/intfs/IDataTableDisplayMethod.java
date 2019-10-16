/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.applications.intfs;

/**
 *
 * @author Khang
 */
public interface IDataTableDisplayMethod {
    void setPageNumberLabel(int offet, int pageCount);
    void setTotalCountLabel(int totalCount);
    void setEnableSearchButton(boolean isEnable);
}
