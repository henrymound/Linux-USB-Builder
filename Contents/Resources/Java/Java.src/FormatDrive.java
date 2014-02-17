/*    */ import java.awt.BorderLayout;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.PrintStream;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class FormatDrive
/*    */   implements Runnable
/*    */ {
/*    */   public void run()
/*    */   {
/* 42 */     new main();
/* 43 */     new FormatDriveBar();
/*    */ 
/* 45 */     Process ls = null;
/* 46 */     BufferedReader input = null;
/* 47 */     String line = null;
/*    */ 
/* 49 */     File Files = new File(main.path);
/* 50 */     main.South.setLayout(new BorderLayout());
/*    */     try
/*    */     {
/* 53 */       new File("/Volumes/LINUX" + main.DeviceRoot.toUpperCase() + "/efi/boot").mkdirs();
/* 54 */       new File("/Volumes/LINUX" + main.DeviceRoot.toUpperCase() + " 1/efi/boot").mkdirs();
/* 55 */       System.out.println("Created Folders: /Volumes/LINUX" + main.DeviceRoot.toUpperCase() + " 1/efi/boot");
/* 56 */       Thread FormatDriveBar = new Thread(new FormatDriveBar()); FormatDriveBar.start();
/*    */     } catch (Exception e) {
/* 58 */       System.out.println("error creating directories");
/*    */     }
/*    */   }
/*    */ }

/* Location:           /Users/henrymound/Documents/Linux USB Builder/Contents/Resources/Java/
 * Qualified Name:     FormatDrive
 * JD-Core Version:    0.6.2
 */