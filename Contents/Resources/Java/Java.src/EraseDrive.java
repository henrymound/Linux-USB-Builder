/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Font;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PrintStream;
/*     */ import javax.swing.BoxLayout;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JProgressBar;
/*     */ 
/*     */ public class EraseDrive
/*     */   implements Runnable
/*     */ {
/*     */   Download Download;
/*     */   main main;
/*  68 */   String percent = "";
/*  69 */   JProgressBar EraseDrive = new JProgressBar();
/*  70 */   public static JLabel Step1 = new JLabel("Step 1: Downloading ISO (100%)");
/*  71 */   public static JLabel Step2 = new JLabel("Step 2: Formatting Disk");
/*  72 */   public static JLabel Step3 = new JLabel("Step 3: Copying Files");
/*  73 */   public static JLabel Step4 = new JLabel("Step 4: Installing Bootloader");
/*     */   public static Font Step1Font;
/*     */   public static Font Step2Font;
/*     */   public static Font Step3Font;
/*     */   public static Font Step4Font;
/*  80 */   public static JPanel CenterPanel = new JPanel();
/*     */ 
/*     */   public void run()
/*     */   {
/*  84 */     Step1Font = Step1.getFont();
/*  85 */     Step2Font = Step2.getFont();
/*  86 */     Step3Font = Step3.getFont();
/*  87 */     Step4Font = Step4.getFont();
/*     */ 
/*  89 */     this.EraseDrive.setMinimum(0);
/*  90 */     this.EraseDrive.setMaximum(999);
/*  91 */     this.EraseDrive.setStringPainted(true);
/*     */ 
/*  93 */     JLabel DownloadProgress = new JLabel("   Formatting Drive: ");
/*  94 */     JLabel SouthBlank = new JLabel("   ");
/*  95 */     JLabel SouthBlankWest = new JLabel("   ");
/*  96 */     JLabel SouthBlankEast = new JLabel("   ");
/*     */ 
/*  99 */     main.South.removeAll();
/* 100 */     main.South.setLayout(new BorderLayout());
/* 101 */     main.South.add("East", SouthBlankEast);
/* 102 */     main.South.add("West", SouthBlankWest);
/* 103 */     main.South.add("North", DownloadProgress);
/* 104 */     main.South.add("Center", this.EraseDrive);
/* 105 */     main.South.add("South", SouthBlank);
/*     */ 
/* 107 */     CenterPanel.setLayout(new BoxLayout(CenterPanel, 1));
/* 108 */     CenterPanel.add(Step1);
/* 109 */     CenterPanel.add(Step2);
/* 110 */     CenterPanel.add(Step3);
/* 111 */     CenterPanel.add(Step4);
/*     */ 
/* 113 */     main.frame.remove(main.logo2);
/* 114 */     main.frame.remove(main.logo);
/* 115 */     main.frame.remove(main.USBscroller);
/* 116 */     main.frame.remove(Download.CenterPanel);
/* 117 */     main.frame.add("Center", CenterPanel);
/* 118 */     main.frame.add("North", main.logo3);
/* 119 */     main.frame.setEnabled(false);
/* 120 */     main.frame.setEnabled(true);
/*     */     try
/*     */     {
/*     */       try
/*     */       {
/* 125 */         Step2.setFont(Step2Font.deriveFont(Step2Font.getStyle() ^ 0x1));
/* 126 */         main.frame.remove(CenterPanel);
/* 127 */         main.frame.add("Center", CenterPanel);
/* 128 */         Process ls = null; BufferedReader input = null; String line = null;
/* 129 */         ls = Runtime.getRuntime().exec(new String[] { "diskutil", "unmountDisk", main.DeviceRoot });
/* 130 */         this.EraseDrive.setValue(100);
/* 131 */         input = new BufferedReader(new InputStreamReader(ls.getInputStream()));
/* 132 */         while ((line = input.readLine()) != null)
/*     */         {
/* 134 */           if (line.startsWith("Unmount")) { int x = 0; for (int y = 100; x < y; DownloadProgress.setText("   Formatting Drive: " + line)) { this.EraseDrive.setValue(this.EraseDrive.getValue() + 1); x++; Step2.setText("Step 2: Formatting Disk (" + this.EraseDrive.getString() + ")"); }
/*     */           }
/*     */         }
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */       try
/*     */       {
/* 143 */         Process ls = null; BufferedReader input = null; String line = null;
/* 144 */         ls = Runtime.getRuntime().exec(new String[] { "diskutil", "eraseDisk", "FAT32", "LINUX" + main.DeviceRoot.toUpperCase(), main.DeviceRoot });
/* 145 */         input = new BufferedReader(new InputStreamReader(ls.getInputStream()));
/*     */ 
/* 147 */         while ((line = input.readLine()) != null)
/*     */         {
/* 149 */           System.out.println(line);
/*     */ 
/* 151 */           if (line.startsWith("Unmounting")) { int x = 100; for (int y = 150; x < y; DownloadProgress.setText("   Formatting Drive: " + line)) { this.EraseDrive.setValue(this.EraseDrive.getValue() + 1); x++; Step2.setText("Step 2: Formatting Disk (" + this.EraseDrive.getString() + ")"); } }
/* 152 */           if (line.startsWith("Creating")) { int x = 150; for (int y = 220; x < y; DownloadProgress.setText("   Formatting Drive: " + line)) { this.EraseDrive.setValue(this.EraseDrive.getValue() + 1); x++; Step2.setText("Step 2: Formatting Disk (" + this.EraseDrive.getString() + ")"); } }
/* 153 */           if (line.startsWith("Waiting")) { int x = 220; for (int y = 400; x < y; DownloadProgress.setText("   Formatting Drive: " + line)) { this.EraseDrive.setValue(this.EraseDrive.getValue() + 1); x++; Step2.setText("Step 2: Formatting Disk (" + this.EraseDrive.getString() + ")"); } }
/* 154 */           if (line.startsWith("Formatting")) { int x = 400; for (int y = 600; x < y; DownloadProgress.setText("   Formatting Drive: " + line)) { this.EraseDrive.setValue(this.EraseDrive.getValue() + 1); x++; Step2.setText("Step 2: Formatting Disk (" + this.EraseDrive.getString() + ")"); } }
/* 155 */           if (line.startsWith("Mounting")) { int x = 500; for (int y = 900; x < y; DownloadProgress.setText("   Formatting Drive: " + line)) { this.EraseDrive.setValue(this.EraseDrive.getValue() + 1); x++; Step2.setText("Step 2: Formatting Disk (" + this.EraseDrive.getString() + ")"); } }
/* 156 */           if (line.startsWith("Finished")) { int x = 600; for (int y = 999; x < y; DownloadProgress.setText("   Formatting Drive: " + line)) { this.EraseDrive.setValue(this.EraseDrive.getValue() + 1); x++; Step2.setText("Step 2: Formatting Disk (" + this.EraseDrive.getString() + ")"); } }
/* 157 */           main.frame.repaint();
/*     */         }
/*     */       } catch (Exception e) { System.out.println("error formating drive"); }
/*     */ 
/*     */ 
/* 163 */       System.out.println("Starting to creat folders");
/*     */     }
/*     */     catch (Exception localException2)
/*     */     {
/*     */     }
/*     */ 
/* 169 */     Thread FormatThread = new Thread(new FormatDrive()); FormatThread.start();
/*     */   }
/*     */ }

/* Location:           /Users/henrymound/Documents/Linux USB Builder/Contents/Resources/Java/
 * Qualified Name:     EraseDrive
 * JD-Core Version:    0.6.2
 */