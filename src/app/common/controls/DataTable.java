/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.common.controls;


import base.configurations.enums.PagingModes;
import base.data.entities.EntitySearchBase;
import base.guis.controls.BaseComponent;
import base.guis.controls.BaseEditPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khang
 */
public class DataTable extends BaseComponent implements ActionListener {

    /** Creates new form DataTableCustom */
    private BaseEditPanel editPanel;    
    private int idColumn = 1;
    private PagingModes CUR_PAGING_MODE;
    private int currentPage = 1;
    private int lastPage = 1;
    private String strPageNumber="1/1";
        
    public void setIdColumn(int idColumn){
        this.idColumn=idColumn;
    }
    public int getIdColumn(){ return this.idColumn;}
    
    public DataTable() {
        initComponents();
        lbPageNumber.setHorizontalAlignment(SwingConstants.CENTER);
        lbPageNumber.setText(strPageNumber);
        this.CUR_PAGING_MODE = PagingModes.DEFAULT;
         
        
        getTable().addMouseListener(_onMouseAdapter());
        btnSearch.addActionListener(this);
        btnNext.addActionListener(this);
        btnPrevious.addActionListener(this);
        btnFirst.addActionListener(this);
        btnLast.addActionListener(this);
    }

      public void setEditPanel(BaseEditPanel editPanel){
       this.editPanel = editPanel;
   }
  
   public JTable getTable(){
       return this.table;
   } 
   
   
   
   public void removeAllData(){
      DefaultTableModel tableModel =  (DefaultTableModel) getTable().getModel();
      if (tableModel.getRowCount() > 0) {
                    for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
                        tableModel.removeRow(i);
                    }
        }  
   }
   
     @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==btnSearch){           
          this.CUR_PAGING_MODE = PagingModes.DEFAULT;         
        }else if(e.getSource()==btnNext){           
          this.CUR_PAGING_MODE = PagingModes.NEXT;  
        }else if(e.getSource()==btnLast){           
           this.CUR_PAGING_MODE = PagingModes.LAST;    
        }else if(e.getSource()==btnPrevious){           
           this.CUR_PAGING_MODE = PagingModes.PREVIOUS;     
        }else if(e.getSource()==btnFirst){           
          this.CUR_PAGING_MODE = PagingModes.FIRST;    
        }
        this.onResetSearch();   
        System.gc();
    }
    
    private MouseAdapter _onMouseAdapter(){
        return new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            int row = getTable().getSelectedRow();
           
            int id = (int) getTable().getValueAt(row, getIdColumn());
           //  System.out.println(id);             
                      
            editPanel.setCurrentObj(editPanel.getById(id));
            editPanel.bindingModelToView();
            
            }
        }; 
    }
    
    public void onResetSearch(){
        EntitySearchBase searchDto =  ((EntitySearchBase) this.editPanel.getFilterObj());
        setUpOffsetByMode(searchDto);
          try{
               btnSearch.setEnabled(false);        
               this.editPanel.refreshEditForm();
               searchDto.setKeyword(txtKeyword.getText());               
           }catch(Exception ex){
               ex.printStackTrace();
           }finally{
              this.editPanel.search(); 
               btnSearch.setEnabled(true);
               
               setPageNumberLabel(searchDto.getOffset(),searchDto.getPageCount());
               System.gc();
           }
    }
    
    private void setPageNumberLabel(int offet, int pageCount){
       
        if(pageCount>0){
            currentPage = offet/pageCount + 1;
            if(currentPage>pageCount) currentPage = pageCount;
            lastPage = pageCount;
        }else{
            currentPage = 1;
            lastPage = 1;
        }
        strPageNumber = String.format("%s/%s", currentPage,lastPage);   
        lbPageNumber.setText(strPageNumber);
    }
    
    private void setUpOffsetByMode(EntitySearchBase searchDto){
         int size = searchDto.getPageSize();
        int curPage = searchDto.getOffset()/size; 
        int pageCount = searchDto.getPageCount();
       
        
        switch(this.CUR_PAGING_MODE){
            case NEXT:
            {
                int nextPageNum = curPage+1>= pageCount ? pageCount-1:curPage+1;
                //System.out.println(nextPageNum);
                searchDto.setOffset(nextPageNum*size);
                break;
            }
            case PREVIOUS:
            {
                int previousPageNum = curPage-1<0 ? 0:curPage-1;
                searchDto.setOffset(previousPageNum*size);
            }
            case FIRST:
            {
                searchDto.setOffset(0);   
                break;
            }
            case LAST:
            {
                int lastPage = pageCount>0?pageCount-1:0;
                searchDto.setOffset(lastPage*size);  
                break;
            }
            default:
                break;
        }
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSearch = new javax.swing.JButton();
        txtKeyword = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lbPageNumber = new javax.swing.JLabel();
        btnFirst = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new base.guis.controls.core.TableCustom();

        setPreferredSize(new java.awt.Dimension(463, 234));

        btnSearch.setText("Tìm kiếm");

        txtKeyword.setToolTipText("Nhập thông tin tìm kiếm");

        lbPageNumber.setText("0/0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbPageNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbPageNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        btnFirst.setText("<<");

        btnPrevious.setText("<");
        btnPrevious.setMaximumSize(new java.awt.Dimension(65, 25));

        btnLast.setText(">>");

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(txtKeyword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFirst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNext))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbPageNumber;
    private base.guis.controls.core.TableCustom table;
    private javax.swing.JTextField txtKeyword;
    // End of variables declaration//GEN-END:variables

}
