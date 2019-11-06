/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.trade.guis.products;

import app.core.modules.constants.StoreConstants;
import app.core.trade.dtos.products.ProductEntity;
import base.data.dal.StoreProvider;
import base.guis.controls.BaseComponent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Khang
 */
public class ProductListComponent extends BaseComponent implements ActionListener {

    /**
     * Creates new form ProductListGUI
     */
    ProductEntity products[] = {new ProductEntity()};
    private JList jproductList = new JList(products);
    private StoreProvider<ProductEntity> productProvider;
    private List<ProductEntity> dataList;
    private List<ProductEntity> ds = null;

    public ProductListComponent() {
        super();
        initComponents();
        productProvider = new StoreProvider(ProductEntity.class);

        jproductList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jproductList.setCellRenderer(new ProductCellRenderer());
        //jproductList.setVisibleRowCount(4);
        JScrollPane pane = new JScrollPane(jproductList);
        pane.setPreferredSize(new Dimension(0, pane.getComponents().length * 500));
        pane.setSize(pnlListView.getWidth(), pnlListView.getHeight());
        pnlListView.setLayout(new BorderLayout());
        pnlListView.add(pane, BorderLayout.CENTER);

        //     pnlListView.add(pane);
//        add(button, BorderLayout.SOUTH);
        this.setVisible(true);
        this.btnSearch.addActionListener(this);
        
        this.loadData();

    }

    public List<ProductEntity> getSelectedItems() {
//        List<ProductEntity> selectedItems = this.jproductList.getSelectedValuesList();
//        for (ProductEntity item : selectedItems) {
//            System.out.println(item.getName());
//        }
        List<ProductEntity> resultList = this.jproductList.getSelectedValuesList();
        this.jproductList.clearSelection();
        return resultList;
    }

    public JList getJProductList() {
        return this.jproductList;
    }

    public void setDataList(List<ProductEntity> dataList) {
        this.dataList = dataList;
    }

    public List<ProductEntity> getDataList() {
        return this.dataList;
    }

    public void setArrProducts(ProductEntity[] arr) {
//        if( this.jproductList!=null && this.jproductList.getModel().getSize()>0){
//            for(int i =0;i<this.jproductList.getModel().getSize();i++){
//                  this.jproductList.remove(i);
//            }
//        }
        this.jproductList.setListData(arr);
    }
    
    public JButton getBtnSelect(){
        return this.btnSelect;
    }

//    public void loadData(){
//        try {
//            dataList = productProvider.executeToList(StoreConstants.PRODUCT_SEARCH, searchDto);
//        } catch (Exception ex) {
//            Logger.getLogger(ProductListComponent.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        if(dataList==null){
//           dataList = new ArrayList<ProductEntity>(); 
//        }
//        ProductEntity[] items = new ProductEntity[dataList.size()];
//        items = dataList.toArray(items );
//        
//        jproductList.setListData(items);
//    }
    public Future<List<ProductEntity>> fetchListAsync() throws InterruptedException {
        CompletableFuture< List<ProductEntity>> completableFuture
                = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            
            if (ds != null && ds.size() > 0) {
                ds.removeAll(ds);
                ds = null;
            }
            ProductEntity searchDto = new ProductEntity();
            searchDto.setKeyword(txtKeyword.getText());
            searchDto.setOffset(-1);
            ds = productProvider.executeToList(StoreConstants.PRODUCT_SEARCH, searchDto);
            completableFuture.complete(ds);
            return ds;
        });

        return completableFuture;
    }

    public void loadData() {
        Future<List<ProductEntity>> completableFuture;
        try {
            completableFuture = fetchListAsync();

            this.setDataList(completableFuture.get());
            if (this.getDataList() == null) {
                this.setDataList(new ArrayList<ProductEntity>());
            }
            ProductEntity[] items = new ProductEntity[dataList.size()];
            items = this.getDataList().toArray(items);
            this.setArrProducts(items);

        } catch (InterruptedException ex) {
            Logger.getLogger(ProductListComponent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(ProductListComponent.class.getName()).log(Level.SEVERE, null, ex);
        }

//        new Thread(new ComponentRunnable(this) {
//            @Override
//            public synchronized void run() {
//                ProductListComponent panelComponent = (ProductListComponent) getComponent();
//                try {
//                    ProductEntity searchDto = new ProductEntity();
//                    searchDto.setOffset(-1);
//
//                    List<ProductEntity> ds = productProvider.executeToList(StoreConstants.PRODUCT_SEARCH, searchDto);
//                    
//                    
//                    panelComponent.setDataList(ds);
//                    if (panelComponent.getDataList() == null) {
//                        panelComponent.setDataList(new ArrayList<ProductEntity>());
//                    }
//                    ProductEntity[] items = new ProductEntity[dataList.size()];
//                    items = panelComponent.getDataList().toArray(items);
//                    panelComponent.setArrProducts(items);
//
//                } catch (Exception ex) {
//                    Logger.getLogger(ProductListComponent.class.getName()).log(Level.SEVERE, null, ex);
//                } finally {
//
//                }
//
//            }
//
//        }).start();
    }

    public void setVisibleFilter(boolean isVisible) {
        this.pnlSearch.setVisible(isVisible);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSearch = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtKeyword = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        pnlListView = new javax.swing.JPanel();
        btnSelect = new javax.swing.JButton();

        jLabel1.setText("Thông tin tìm:");

        btnSearch.setText("Tìm");

        javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
        pnlSearch.setLayout(pnlSearchLayout);
        pnlSearchLayout.setHorizontalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKeyword, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
        );
        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
            .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlListViewLayout = new javax.swing.GroupLayout(pnlListView);
        pnlListView.setLayout(pnlListViewLayout);
        pnlListViewLayout.setHorizontalGroup(
            pnlListViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlListViewLayout.setVerticalGroup(
            pnlListViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
        );

        btnSelect.setText("CHỌN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlListView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlListView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlListView;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JTextField txtKeyword;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
//        int selected[] = jproductList.getSelectedIndices();
//        System.out.println("Selected Elements:  ");
//
//        for (int i = 0; i < selected.length; i++) {
//            ProductEntity element = (ProductEntity) jproductList.getModel().getElementAt(selected[i]);
//            System.out.println("  " + element.getName());
//        }
        this.loadData();
    }
}
