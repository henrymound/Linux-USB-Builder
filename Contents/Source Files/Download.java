/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Font;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.text.DecimalFormat;
/*     */ import javax.swing.BoxLayout;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JProgressBar;
/*     */ 
/*     */ public class Download
/*     */   implements Runnable
/*     */ {
/*  39 */   public static String percent = "";
/*  40 */   public static JProgressBar ProgressDownload = new JProgressBar();
/*  41 */   public static JLabel Step1 = new JLabel("Step 1: Downloading ISO (" + percent + ")");
/*  42 */   public static JLabel Step2 = new JLabel("Step 2: Formatting Disk");
/*  43 */   public static JLabel Step3 = new JLabel("Step 3: Copying Files");
/*  44 */   public static JLabel Step4 = new JLabel("Step 4: Installing Bootloader");
/*     */   public static Font Step1Font;
/*     */   public static Font Step2Font;
/*     */   public static Font Step3Font;
/*  48 */   public static JPanel CenterPanel = new JPanel();
/*     */ 
/*     */   public void run() {
/*  51 */     new main();
/*  52 */     new FormatDrive();
/*     */ 
/*  56 */     Step1Font = Step1.getFont();
/*  57 */     Step2Font = Step2.getFont();
/*  58 */     Step3Font = Step3.getFont();
/*     */ 
/*  60 */     if (main.path.equals(main.class.getResource("ubuntu.iso").toString().replace("%20", " ").replace("file:", ""))) {
/*     */       try
/*     */       {
/*  63 */         JLabel DownloadProgress = new JLabel("   Starting Download");
/*  64 */         JLabel SouthBlank = new JLabel("   ");
/*  65 */         JLabel SouthBlankWest = new JLabel("   ");
/*  66 */         JLabel SouthBlankEast = new JLabel("   ");
/*     */ 
/*  68 */         URL url = new URL(main.URL);
/*  69 */         url.openConnection();
/*     */ 
/*  71 */         InputStream reader = url.openStream();
/*     */ 
/*  73 */         File ubuntuIso = new File(main.class.getResource("ubuntu.iso").toString().replace("%20", " ").replace("file:", ""));
/*  74 */         FileOutputStream writer = new FileOutputStream(main.class.getResource("ubuntu.iso").toString().replace("%20", " ").replace("file:", ""));
/*     */ 
/*  76 */         byte[] buffer = new byte[153600];
/*     */ 
/*  78 */         int totalBytesRead = 0;
/*     */ 
/*  80 */         int bytesRead = 0;
/*     */ 
/*  82 */         ProgressDownload.setMinimum(0);
/*  83 */         ProgressDownload.setMaximum(1000000000);
/*     */ 
/*  85 */         main.South.setLayout(new BorderLayout());
/*  86 */         main.frame.remove(main.USBscroller);
/*     */ 
/*  88 */         main.South.removeAll();
/*  89 */         main.South.add("East", SouthBlankEast);
/*  90 */         main.South.add("West", SouthBlankWest);
/*  91 */         main.South.add("North", DownloadProgress);
/*  92 */         main.South.add("Center", ProgressDownload);
/*  93 */         main.South.add("South", SouthBlank);
/*     */ 
/*  95 */         CenterPanel.setLayout(new BoxLayout(CenterPanel, 1));
/*  96 */         CenterPanel.add(Step1);
/*  97 */         CenterPanel.add(Step2);
/*  98 */         CenterPanel.add(Step3);
/*  99 */         CenterPanel.add(Step4);
/*     */ 
/* 101 */         main.frame.remove(main.logo2);
/* 102 */         main.frame.add("Center", CenterPanel);
/* 103 */         main.frame.add("North", main.logo3);
/* 104 */         main.frame.setEnabled(false);
/* 105 */         main.frame.setEnabled(true);
/* 106 */         main.frame.setSize(565, 351);
/* 107 */         main.frame.setSize(566, 350);
/* 108 */         main.frame.setVisible(true);
/* 109 */         main.frame.setDefaultCloseOperation(0);
/* 110 */         main.frame.repaint();
/*     */ 
/* 112 */         DecimalFormat twoDForm = new DecimalFormat("#.##");
/* 113 */         Step1.setFont(Step1Font.deriveFont(Step1Font.getStyle() ^ 0x1));
/*     */ 
/* 115 */         int Progress = 0;
/* 116 */         double doubleProgress = 0.0D;
/* 117 */         ProgressDownload.setStringPainted(true);
/*     */ 
/* 119 */         if (main.DeviceDouble < main.size / 1000.0D)
/*     */         {
/* 121 */           System.out.println("Not enough space on the drive");
/*     */         }
/*     */ 
/* 125 */         while ((bytesRead = reader.read(buffer)) > 0)
/*     */         {
/* 128 */           writer.write(buffer, 0, bytesRead);
/* 129 */           buffer = new byte[153600];
/*     */ 
/* 131 */           totalBytesRead += bytesRead;
/* 132 */           double totalMegaBytesRead = (int)ubuntuIso.length() / main.size / 10000.0D;
/* 133 */           String MBRead = twoDForm.format(totalMegaBytesRead);
/*     */ 
/* 135 */           percent = twoDForm.format(totalMegaBytesRead) + "%";
/*     */ 
/* 137 */           doubleProgress = totalMegaBytesRead * 10000000.0D;
/* 138 */           Progress = (int)doubleProgress;
/*     */ 
/* 141 */           DownloadProgress.setText("   Downloaded " + ubuntuIso.length() / 1000000L + "MB out of " + main.size + "MB\n ");
/*     */ 
/* 146 */           Step1.setText("Step 1: Downloading ISO (" + percent + ")        ");
/* 147 */           ProgressDownload.setValue(Progress);
/*     */         }
/* 149 */         main.frame.repaint(); main.frame.remove(ProgressDownload); main.frame.setVisible(true);
/*     */ 
/* 151 */         writer.close();
/* 152 */         reader.close();
/* 153 */         main.path = main.class.getResource("ubuntu.iso").toString().replace("%20", " ").replace("file:", "");
/* 154 */         Step1.setFont(Step1Font.deriveFont(Step1Font.getStyle() | 0x1));
/*     */       }
/*     */       catch (MalformedURLException e)
/*     */       {
/* 160 */         e.printStackTrace(); System.out.println("Error!"); } catch (IOException e) {
/* 161 */         e.printStackTrace(); System.out.println("Error!");
/*     */       }
/*     */     }
/*     */ 
/* 165 */     Thread EraseDrive = new Thread(new EraseDrive()); EraseDrive.start();
/*     */   }
/*     */ }

/* Location:           /Users/henrymound/Documents/Linux USB Builder/Contents/Resources/Java/
 * Qualified Name:     Download
 * JD-Core Version:    0.6.2
 */