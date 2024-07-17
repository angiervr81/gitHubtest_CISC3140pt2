/**Angie Rivera CISC 3130 Spring24 Wednesday Evenings
Program is to create a Linked list*/

import java.util.LinkedList;


public class WStore
{ 
   private LinkedList<Widget>inventory; 
   private double markup = 0.30; 
   private double discount = 0.0; 
   private int disCount =0; 
   
   
   public WStore()
   {
      inventory = new LinkedList<>();
      
   }
   
   public void process(String type, int quan, double price)
   {
         switch (type)
         {
            case "R":
               receipt (quan , price);
               break;
               
             case "S":
               sale (quan);
               break;
               
             case "P":
               promotion(quan);
               break; 
         
         }
   }
   
   public void receipt(int quan , double price)
   {
        inventory.add(new Widget(quan, price)); 
        System.out.println("Received "+ quan +" widgets at $" + price + " each.\n");
   
   
   }
   
   
   public void sale( int quan) 
   {
      System.out.println("\n"+quan + " widgets sold");
      
      double totalS = 0.0; 
      
      while(quan > 0 && !inventory.isEmpty())
      {
         Widget widget = inventory.getFirst(); 
         int sold = Math.min(quan, widget.quan); 
         double salePrice = widget.price * (1+markup);
         
         if (disCount > 0)
         {
            salePrice *= (1- discount);
            disCount --; 
         
         }
         
         System.out.println(sold + " at $" + String.format("%.2f" , salePrice)+ " each\t\tSales: $"+ String.format("%.2f",sold * salePrice )+"\n");
         totalS += sold * salePrice; 
         widget.quan -= sold; 
         if (widget.quan == 0 )
         {
            inventory.removeFirst(); 
            quan -= sold;
         
         }
         
         if( quan> 0)
         {
            System.out.println("Remainding of " + quan + " widgets not available.");
            System.out.println("Total Sale: $" + String.format("%.2f",totalS));
            
         }
      
      }
   
   }
   
   private void promotion(int pecentageDiscount)
   {
      discount = pecentageDiscount /100.0;
      disCount = 2; 
      System.out.println("Next 2 customers that buy will receive a " + pecentageDiscount + "% discount."); 
   }
   
   
   public void remainingInventory()
   {
      System.out.println("\n Remaining Inventory: ");
      for (Widget widget : inventory)
      {
         System.out.println(widget.quan +" widget at $" + widget.price + " each" );
         
      } 
   }
   
   public static void main(String[] args)
   {
   
      WStore store = new WStore();
      
      store.process("R", 150, 1.00);
      store.process("R", 130, 2.00);
      store.process("S", 145, 0.00);
      store.process("R", 50, 2.50);
      store.process("S", 75, 0.00);
      store.process("S", 180,0.00);
      store.process("R", 50, 4.00);
      store.process("R", 30, 5.00);
      store.process("R", 40, 5.50);
      store.process("P", 30, 0.00);
      store.process("S", 50, 0.00);
      store.process("S", 300,0.00);
      store.process("R", 50, 6.00);
      store.process("R", 255, 10.00);
      store.process("S", 60, 0.00);
      store.process("P", 50, 0.00);
      store.process("S", 100, 0.00);
      store.process("S", 70, 0.00);
      store.process("S", 174, 0.00);
      store.process("R", 40, 14.00);
      store.process("R", 75, 15.00);
      store.process("S",110, 0.00);
      store.process("R", 30, 16.00);
      store.process("R", 40, 18.00);
      
      store.remainingInventory();
   
   }
} 