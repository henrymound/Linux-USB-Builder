/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Font;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.io.OutputStream;
/*    */ import java.io.PrintStream;
/*    */ import java.text.DecimalFormat;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JProgressBar;
/*    */ 
/*    */ public class FormatDriveBar
/*    */   implements Runnable
/*    */ {
/*    */   Download Download;
/*    */   main main;
/*    */   EraseDrive EraseDrive;
/* 43 */   static JProgressBar CopyingProgress = new JProgressBar();
/*    */ 
/*    */   public void run()
/*    */   {
/* 49 */     CopyingProgress.setMinimum(0);
/* 50 */     CopyingProgress.setMaximum((int)(new File(main.path).length() / 1000L));
/* 51 */     CopyingProgress.setStringPainted(true);
/*    */ 
/* 53 */     JLabel DownloadProgress = new JLabel("   Copying ISO: ");
/* 54 */     JLabel SouthBlank = new JLabel("   ");
/* 55 */     JLabel SouthBlankWest = new JLabel("   ");
/* 56 */     JLabel SouthBlankEast = new JLabel("   ");
/* 57 */     JPanel CenterPanel = new JPanel();
/*    */ 
/* 59 */     main.South.setLayout(new BorderLayout());
/* 60 */     main.South.removeAll();
/* 61 */     main.South.add("East", SouthBlankEast);
/* 62 */     main.South.add("West", SouthBlankWest);
/* 63 */     main.South.add("North", DownloadProgress);
/* 64 */     main.South.add("South", SouthBlank);
/* 65 */     main.South.add("Center", CopyingProgress);
/*    */ 
/* 67 */     main.frame.remove(main.logo2);
/* 68 */     main.frame.remove(main.logo);
/* 69 */     main.frame.remove(main.scroller);
/* 70 */     main.frame.remove(main.USBscroller);
/* 71 */     main.frame.add("South", main.South);
/* 72 */     main.frame.setEnabled(false);
/* 73 */     main.frame.setEnabled(true);
/* 74 */     main.frame.setVisible(true);
/*    */ 
/* 76 */     Process ls = null;
/* 77 */     BufferedReader input = null;
/* 78 */     String line = null;
/*    */ 
/* 80 */     int percent = 0;
/*    */ 
/* 84 */     EraseDrive.Step2.setFont(EraseDrive.Step2Font.deriveFont(EraseDrive.Step2Font.getStyle()));
/* 85 */     EraseDrive.Step2.setText("Step 2: Formatting Disk (100%)");
/* 86 */     EraseDrive.Step3.setFont(EraseDrive.Step3Font.deriveFont(EraseDrive.Step3Font.getStyle() ^ 0x1));
/*    */ 
/* 88 */     DecimalFormat twoDForm = new DecimalFormat("##.##");
/*    */     try
/*    */     {
/* 92 */       System.out.println("Copying Via Terminal");
/*    */ 
/* 94 */       ls = Runtime.getRuntime().exec(new String[] { "cp", main.path, "/Volumes/LINUX" + main.DeviceRoot.toUpperCase() + "/efi/boot/boot.iso" });
/* 95 */       input = new BufferedReader(new InputStreamReader(ls.getInputStream()));
/* 96 */       File f = new File("/Volumes/LINUX" + main.DeviceRoot.toUpperCase() + "/efi/boot/boot.iso");
/* 97 */       int x = 1;
/*    */ 
/* 101 */       while (CopyingProgress.getValue() < CopyingProgress.getMaximum())
/*    */       {
/* 103 */         DownloadProgress.setText("   Copying Files: Copied " + CopyingProgress.getValue() / 1000 + "MB out of " + CopyingProgress.getMaximum() / 1000 + "MB");
/* 104 */         File j = new File("/Volumes/LINUX" + main.DeviceRoot.toUpperCase() + "/efi/boot/boot.iso");
/* 105 */         CopyingProgress.setValue((int)j.length() / 1000);
/* 106 */         EraseDrive.Step3.setText("Step 3: Copying Files (" + twoDForm.format(j.length() / 1000L / (CopyingProgress.getMaximum() / 100)) + "%)");
/*    */ 
/* 108 */         if (CopyingProgress.getValue() == CopyingProgress.getMaximum()) { Thread InstallBootLoader = new Thread(new InstallBootLoader()); InstallBootLoader.start(); break; }
/*    */       }
/*    */     }
/*    */     catch (Exception f)
/*    */     {
/*    */       try {
/* 114 */         String dest = "/Volumes/LINUX" + main.DeviceRoot.toUpperCase() + " 1/efi/boot/boot.iso";
/* 115 */         InputStream in = new FileInputStream(main.path);
/* 116 */         OutputStream out = new FileOutputStream(dest);
/* 117 */         byte[] buf = new byte[1000];
/*    */         int len;
/* 119 */         while ((len = in.read(buf)) > 0)
/*    */         {
/*    */           int len;
/* 121 */           out.write(buf, 0, len);
/* 122 */           CopyingProgress.setValue(CopyingProgress.getValue() + 1);
/* 123 */           double TotalMB = CopyingProgress.getMaximum() / 1000; twoDForm.format(TotalMB);
/* 124 */           double MBCopied = CopyingProgress.getValue() / 1000; twoDForm.format(MBCopied);
/* 125 */           EraseDrive.Step3.setText("Step 3: Copying Files (" + twoDForm.format(MBCopied / TotalMB * 100.0D) + "%)");
/* 126 */           DownloadProgress.setText("   Copying ISO: Copied " + CopyingProgress.getValue() / 1000 + "MB of " + CopyingProgress.getMaximum() / 1000 + "MB");
/*    */         }
/* 128 */         in.close();
/* 129 */         out.close();
/*    */ 
/* 131 */         Thread InstallBootLoader = new Thread(new InstallBootLoader()); InstallBootLoader.start();
/*    */       } catch (Exception e) {
/* 133 */         System.out.println("error copying iso");
/*    */         try
/*    */         {
/* 138 */           String dest = "/Volumes/LINUX" + main.DeviceRoot.toUpperCase() + "/efi/boot/boot.iso";
/* 139 */           InputStream in = new FileInputStream(main.path);
/* 140 */           OutputStream out = new FileOutputStream(dest);
/* 141 */           byte[] buf = new byte[1000];
/*    */           int len;
/* 143 */           while ((len = in.read(buf)) > 0)
/*    */           {
/*    */             int len;
/* 145 */             out.write(buf, 0, len);
/* 146 */             CopyingProgress.setValue(CopyingProgress.getValue() + 1);
/* 147 */             double TotalMB = CopyingProgress.getMaximum() / 1000; twoDForm.format(TotalMB);
/* 148 */             double MBCopied = CopyingProgress.getValue() / 1000; twoDForm.format(MBCopied);
/* 149 */             EraseDrive.Step3.setText("Step 3: Copying Files (" + twoDForm.format(MBCopied / TotalMB * 100.0D) + "%)");
/* 150 */             DownloadProgress.setText("   Copying ISO: Copied " + CopyingProgress.getValue() / 1000 + "MB of " + CopyingProgress.getMaximum() / 1000 + "MB");
/*    */           }
/* 152 */           in.close();
/* 153 */           out.close();
/*    */ 
/* 155 */           Thread InstallBootLoader = new Thread(new InstallBootLoader()); InstallBootLoader.start();
/*    */         }
/*    */         catch (Exception j)
/*    */         {
/* 159 */           main.noSpace();
/* 160 */           main.WarningInfo.setText("<html><table><td width=>Fatal error copying ISO! Could not process the file. Try a manuel transfer to the USB directory efi/boot/boot.iso.</td></table></html>");
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           /Users/henrymound/Documents/Linux USB Builder/Contents/Resources/Java/
 * Qualified Name:     FormatDriveBar
 * JD-Core Version:    0.6.2
 */