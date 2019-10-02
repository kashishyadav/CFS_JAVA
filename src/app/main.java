package app;

import app.core.guis.mains.MainWindow;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class main {
    public static void main(String[]args) throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, ClassNotFoundException {
        
            
            java.awt.EventQueue.invokeLater(new Runnable(){            
                public void run(){
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                        MainWindow mainWindow = new MainWindow ();
                        mainWindow.setVisible(true);
                    } catch (Exception ex) {
                        Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }
            });
            
//        IProductService productService = new ProductService();
//
//        PagedDto<ProductEntity> pagedDto = null;
//        ProductEntity productEntity = new ProductEntity();
//
//        try {
//            pagedDto = productService.Search(productEntity);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        for (ProductEntity product: pagedDto.getItems()
//             ) {
//            System.out.println(product.getName());
//        }
    }
}
