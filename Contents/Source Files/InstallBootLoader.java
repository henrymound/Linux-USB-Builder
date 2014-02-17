/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Font;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.net.URL;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JProgressBar;
/*     */ 
/*     */ public class InstallBootLoader
/*     */   implements Runnable
/*     */ {
/*     */   main main;
/*     */   EraseDrive EraseDrive;
/*     */ 
/*     */   public void run()
/*     */   {
/*  70 */     JProgressBar InstallLoaderProgress = new JProgressBar();
/*  71 */     InstallLoaderProgress.setMinimum(0);
/*  72 */     InstallLoaderProgress.setMaximum(1000);
/*  73 */     InstallLoaderProgress.setStringPainted(true);
/*     */ 
/*  75 */     JLabel DownloadProgress = new JLabel("   Installing EFI Bootloader: bootX64.efi");
/*  76 */     JLabel SouthBlank = new JLabel("   ");
/*  77 */     JLabel SouthBlankWest = new JLabel("   ");
/*  78 */     JLabel SouthBlankEast = new JLabel("   ");
/*  79 */     JPanel CenterPanel = new JPanel();
/*     */ 
/*  81 */     main.South.removeAll();
/*  82 */     main.South.setLayout(new BorderLayout());
/*  83 */     main.South.add("East", SouthBlankEast);
/*  84 */     main.South.add("West", SouthBlankWest);
/*  85 */     main.South.add("North", DownloadProgress);
/*  86 */     main.South.add("South", SouthBlank);
/*  87 */     main.South.add("Center", InstallLoaderProgress);
/*     */ 
/*  89 */     EraseDrive.Step3.setFont(EraseDrive.Step3Font.deriveFont(EraseDrive.Step3Font.getStyle()));
/*  90 */     EraseDrive.Step3.setText("Step 3: Copying Files (100%)");
/*  91 */     EraseDrive.Step4.setFont(EraseDrive.Step4Font.deriveFont(EraseDrive.Step4Font.getStyle() ^ 0x1));
/*     */ 
/*  93 */     System.out.println("Starting to copy bootloader");
/*     */ 
/*  95 */     main.frame.setEnabled(false);
/*  96 */     main.frame.setEnabled(true);
/*  97 */     main.frame.setVisible(true);
/*     */     try
/*     */     {
/* 101 */       String dest = "/Volumes/LINUX" + main.DeviceRoot.toUpperCase() + " 1/efi/boot/bootX64.efi";
/* 102 */       InputStream in = new FileInputStream(main.class.getResource("bootX64.efi").toString().replace("%20", " ").replace("file:", ""));
/* 103 */       OutputStream out = new FileOutputStream(dest);
/* 104 */       System.out.println(main.class.getResource("bootX64.efi").toString().replace("%20", " ").replace("file:", ""));
/* 105 */       int x = 0;
/* 106 */       int y = 400;
/*     */ 
/* 108 */       for (; x < y; 
/* 113 */         Thread.sleep(3L))
/*     */       {
/* 110 */         InstallLoaderProgress.setValue(InstallLoaderProgress.getValue() + 1);
/* 111 */         x++;
/* 112 */         EraseDrive.Step4.setText("Step 4: Installing Bootloader (" + InstallLoaderProgress.getString() + ")");
/* 113 */         Thread.currentThread();
/*     */       }
/*     */ 
/* 117 */       byte[] buf = new byte[1000];
/*     */       int len;
/* 119 */       while ((len = in.read(buf)) > 0)
/*     */       {
/*     */         int len;
/* 120 */         out.write(buf, 0, len);
/*     */       }
/*     */ 
/* 123 */       in.close();
/* 124 */       out.close();
/*     */ 
/* 126 */       x = 400;
/* 127 */       y = 1000;
/*     */ 
/* 129 */       for (; x < y; 
/* 134 */         Thread.sleep(1L))
/*     */       {
/* 131 */         InstallLoaderProgress.setValue(InstallLoaderProgress.getValue() + 1);
/* 132 */         x++;
/* 133 */         EraseDrive.Step4.setText("Step 4: Installing Bootloader (" + InstallLoaderProgress.getString() + ")");
/* 134 */         Thread.currentThread();
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 138 */       System.out.println("error copying bootloader");
/*     */       try
/*     */       {
/* 142 */         String dest = "/Volumes/LINUX" + main.DeviceRoot.toUpperCase() + "/efi/boot/bootX64.efi";
/* 143 */         InputStream in = new FileInputStream(main.class.getResource("bootX64.efi").toString().replace("%20", " ").replace("file:", ""));
/* 144 */         OutputStream out = new FileOutputStream(dest);
/*     */ 
/* 146 */         int x = 0;
/* 147 */         int y = 400;
/*     */ 
/* 149 */         for (; x < y; 
/* 154 */           Thread.sleep(3L))
/*     */         {
/* 151 */           InstallLoaderProgress.setValue(InstallLoaderProgress.getValue() + 1);
/* 152 */           x++;
/* 153 */           EraseDrive.Step4.setText("Step 4: Installing Bootloader (" + InstallLoaderProgress.getString() + ")");
/* 154 */           Thread.currentThread();
/*     */         }
/*     */ 
/* 158 */         byte[] buf = new byte[1000];
/*     */         int len;
/* 160 */         while ((len = in.read(buf)) > 0)
/*     */         {
/*     */           int len;
/* 161 */           out.write(buf, 0, len);
/*     */         }
/*     */ 
/* 164 */         in.close();
/* 165 */         out.close();
/*     */ 
/* 167 */         x = 400;
/* 168 */         y = 1000;
/*     */ 
/* 170 */         for (; x < y; 
/* 175 */           Thread.sleep(1L))
/*     */         {
/* 172 */           InstallLoaderProgress.setValue(InstallLoaderProgress.getValue() + 1);
/* 173 */           x++;
/* 174 */           EraseDrive.Step4.setText("Step 4: Installing Bootloader (" + InstallLoaderProgress.getString() + ")");
/* 175 */           Thread.currentThread();
/*     */         }
/*     */       }
/*     */       catch (Exception j) {
/* 179 */         System.out.println("error copying bootloader");
/*     */       }
/*     */     }
/* 181 */     System.out.println("Copied bootloader");
/* 182 */     Thread LastScreen = new Thread(new LastScreen()); LastScreen.start();
/*     */   }
/*     */ }

/* Location:           /Users/henrymound/Documents/Linux USB Builder/Contents/Resources/Java/
 * Qualified Name:     InstallBootLoader
 * JD-Core Version:    0.6.2
 */