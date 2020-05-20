package com.michalgoly.util;

import com.michalgoly.business.Product;
import com.michalgoly.data.ProductDB;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class MusicStoreContextListener implements ServletContextListener {

   @Override
   public void contextInitialized(ServletContextEvent event) {
      ServletContext sContext = event.getServletContext();
      
      
      GregorianCalendar calendar = new GregorianCalendar();
      int currentYear = calendar.get(Calendar.YEAR);
      sContext.setAttribute("currentYear", currentYear);
      
      
      Product newestProduct = ProductDB.selectNewestProduct();
      sContext.setAttribute("newestProduct", newestProduct);
   }

   @Override
   public void contextDestroyed(ServletContextEvent event) {
    
   }
   
}
