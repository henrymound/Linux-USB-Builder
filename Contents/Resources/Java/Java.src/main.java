/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Container;
/*     */ import java.awt.Desktop;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.Scanner;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JEditorPane;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.event.ListSelectionEvent;
/*     */ import javax.swing.event.ListSelectionListener;
/*     */ 
/*     */ public class main
/*     */   implements ListSelectionListener, ActionListener
/*     */ {
/*  33 */   public static double size = 0.0D;
/*     */   public static double DeviceDouble;
/*     */   public static double DeviceDouble1;
/*     */   public static double DeviceDouble2;
/*     */   public static double DeviceDouble3;
/*     */   public static double DeviceDouble4;
/*     */   public static double DeviceDouble5;
/*     */   public static double DeviceDouble6;
/*     */   public static double DeviceDouble7;
/*     */   public static double DeviceDouble8;
/*     */   public static double DeviceDouble9;
/*     */   public static double DeviceDouble10;
/*  46 */   public static boolean Internet = true;
/*  47 */   public static boolean openFile = false;
/*     */ 
/*  49 */   public static JFrame NoSpace = new JFrame("");
/*  50 */   static JFrame frame = new JFrame("Ubuntu USB Creator");
/*     */   JFrame AlertFrame;
/*  53 */   static String LogoPath = new File(main.class.getResource("Logo.png").getFile()).toString();
/*  54 */   static String LogoScreen2Path = new File(main.class.getResource("LogoScreen2.png").getFile()).toString();
/*  55 */   static String LogoScreen3Path = new File(main.class.getResource("LogoScreen3.png").getFile()).toString();
/*  56 */   static String WarningLogoPath = new File(main.class.getResource("WarningLogo.png").getFile()).toString();
/*     */ 
/*  58 */   static ImageIcon LogoScreen2 = new ImageIcon(LogoScreen2Path.replace("%20", " "));
/*  59 */   static ImageIcon LogoScreen3 = new ImageIcon(LogoScreen3Path.replace("%20", " "));
/*  60 */   static ImageIcon WarningLogo = new ImageIcon(WarningLogoPath.replace("%20", " "));
/*  61 */   static ImageIcon Logo = new ImageIcon(LogoPath.replace("%20", " "));
/*     */ 
/*  63 */   public static JButton BackSecondPage = new JButton("Previous");
/*  64 */   public static JButton BackThirdPage = new JButton("Previous");
/*  65 */   public static JButton NextFirstPage = new JButton("Next");
/*  66 */   public static JButton NextSecondPage = new JButton("Next");
/*  67 */   public static JButton ExitButton = new JButton("Ok");
/*  68 */   JButton DoErase = new JButton("Erase");
/*  69 */   JButton DontErase = new JButton("Don't Erase");
/*  70 */   JButton Done = new JButton("Done!");
/*  71 */   JButton NextSelectVersion = new JButton("Next");
/*  72 */   public JButton LocalISO = new JButton("Local Image...");
/*     */ 
/*  74 */   JFileChooser ChooseISO = new JFileChooser();
/*     */ 
/*  76 */   public static JPanel South = new JPanel();
/*  77 */   static JPanel SouthPanel = new JPanel();
/*     */ 
/*  79 */   public static JLabel logo = new JLabel(Logo);
/*  80 */   public static JLabel logo2 = new JLabel(LogoScreen2);
/*  81 */   public static JLabel logo3 = new JLabel(LogoScreen3);
/*  82 */   public static JLabel blankLeft = new JLabel("    ");
/*  83 */   public static JLabel blankRight = new JLabel("    ");
/*  84 */   public static JLabel middleFirst = new JLabel("                                                                                           ");
/*  85 */   public static JLabel middleSecond = new JLabel("                                                                                           ");
/*  86 */   public static JLabel blank = new JLabel("                                                                                                                    ");
/*  87 */   static JLabel WarningInfo = new JLabel();
/*  88 */   static JLabel BlankRight = new JLabel("   ");
/*  89 */   static JLabel WarningIcon = new JLabel(WarningLogo);
/*  90 */   JLabel middle = new JLabel("                                                                                   ");
/*     */ 
/*  93 */   public static String[] UbuntuVersions = { 
/*  95 */     "------------------------Ubuntu Derivatives 32/64 bit------------------------", 
/*  96 */     "Ubuntu", 
/*  97 */     "Xubuntu", 
/*  98 */     "Kubuntu", 
/*  99 */     "Lubuntu", 
/* 100 */     "Mythbuntu", 
/* 101 */     "---------------------Other Linux 32/64 bit (Experimental)--------------------", 
/* 102 */     "Arch Linux", 
/* 103 */     "BackTrack", 
/* 104 */     "Fedora", 
/* 105 */     "Gentoo", 
/* 106 */     "Linux Mint", 
/* 107 */     "PCLinuxOS", 
/* 108 */     "Puppy Linux" };
/*     */   public static String[] USBDevices;
/*     */   public static String Device;
/* 115 */   public static String URL = "";
/*     */   public static String DeviceRoot;
/*     */   public static String path;
/*     */   String OS;
/* 119 */   static JLabel NorthBlank = new JLabel("      ");
/*     */   public static String Version;
/*     */   public static Scanner DrivesScanner;
/*     */   public static Scanner DrivesScanners;
/* 125 */   public static JList SelectOS = new JList(UbuntuVersions);
/*     */   public static JList SelectUSB;
/*     */   JList VersionsList;
/*     */   JList SelectO;
/* 130 */   public static JScrollPane scroller = new JScrollPane(SelectOS);
/*     */   public static JScrollPane VersionsScroller;
/*     */   public static JScrollPane USBscroller;
/*     */   public static File file;
/*     */   public static JScrollPane scrolle;
/* 136 */   public static JEditorPane CouldNotConnect = new JEditorPane();
/* 137 */   public static JScrollPane NoInternetPane = new JScrollPane(CouldNotConnect);
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 142 */     ScanUSB Scanner = new ScanUSB();
/*     */ 
/* 144 */     new main().buildGui();
/* 145 */     Scanner.ScanDrives();
/*     */   }
/*     */ 
/*     */   public void buildGui()
/*     */   {
/* 151 */     BorderLayout BorderLayout = new BorderLayout();
/*     */ 
/* 153 */     this.NextSelectVersion.setEnabled(false);
/*     */ 
/* 155 */     South.add(new OpenFile().openButton);
/* 156 */     South.add(this.middle);
/* 157 */     South.add(this.NextSelectVersion);
/*     */ 
/* 159 */     frame.setDefaultCloseOperation(3);
/* 160 */     frame.setSize(566, 350);
/* 161 */     frame.getContentPane().add("North", logo);
/* 162 */     frame.getContentPane().add("South", South);
/* 163 */     frame.getContentPane().add("East", blankLeft);
/* 164 */     frame.getContentPane().add("West", blankRight);
/* 165 */     frame.setLocationRelativeTo(null);
/*     */ 
/* 167 */     scroller.setVerticalScrollBarPolicy(22);
/* 168 */     scroller.setHorizontalScrollBarPolicy(31);
/*     */ 
/* 170 */     SelectOS.setVisibleRowCount(5);
/* 171 */     SelectOS.setSelectionMode(0);
/* 172 */     SelectOS.addListSelectionListener(this);
/*     */ 
/* 174 */     NextFirstPage.setEnabled(false);
/* 175 */     NextSecondPage.setEnabled(false);
/*     */ 
/* 177 */     String url = "http://google.com";
/*     */     try {
/* 179 */       JEditorPane htmlPane = new JEditorPane(url); System.out.println("Internet Connection Established"); frame.getContentPane().add("Center", scroller);
/*     */     } catch (IOException ioe) {
/* 181 */       System.out.println("Could not connect to internet."); frame.getContentPane().add("Center", NoInternetPane); Internet = false;
/* 182 */       CouldNotConnect.setEditable(false);
/*     */       try { CouldNotConnect.setPage(LastScreen.class.getResource("noInternet.html")); } catch (Exception f) { System.out.println("Could not find file!"); }
/*     */ 
/*     */     }
/*     */ 
/* 187 */     frame.setResizable(false);
/* 188 */     frame.setVisible(true);
/*     */ 
/* 190 */     this.NextSelectVersion.addActionListener(this);
/* 191 */     NextFirstPage.addActionListener(this);
/* 192 */     NextSecondPage.addActionListener(this);
/* 193 */     BackSecondPage.addActionListener(this);
/* 194 */     BackThirdPage.addActionListener(this);
/*     */   }
/*     */ 
/*     */   public void valueChanged(ListSelectionEvent lse)
/*     */   {
/* 200 */     if (!lse.getValueIsAdjusting())
/*     */     {
/* 202 */       Object source = lse.getSource();
/*     */ 
/* 204 */       if (source == SelectOS)
/*     */       {
/* 206 */         String selection = (String)SelectOS.getSelectedValue();
/* 207 */         this.OS = selection;
/*     */ 
/* 209 */         if (this.OS.startsWith("-------")) this.NextSelectVersion.setEnabled(false);
/*     */ 
/* 211 */         if (!this.OS.startsWith("-------"))
/*     */         {
/* 213 */           NextFirstPage.setEnabled(true);
/* 214 */           this.NextSelectVersion.setEnabled(true);
/*     */ 
/* 216 */           System.out.println(this.OS);
/*     */         }
/*     */       }
/*     */ 
/* 220 */       if (source == SelectUSB)
/*     */       {
/* 222 */         String selection = (String)SelectUSB.getSelectedValue();
/* 223 */         NextSecondPage.setEnabled(true);
/* 224 */         Device = selection;
/* 225 */         System.out.println(Device);
/*     */ 
/* 227 */         if (Device.endsWith("1")) { DeviceDouble = DeviceDouble1; DeviceRoot = "disk1"; System.out.println(DeviceRoot + " = deviceRoot"); }
/* 228 */         if (Device.endsWith("2")) { DeviceDouble = DeviceDouble2; DeviceRoot = "disk2"; System.out.println(DeviceRoot + " = deviceRoot"); }
/* 229 */         if (Device.endsWith("3")) { DeviceDouble = DeviceDouble3; DeviceRoot = "disk3"; System.out.println(DeviceRoot + " = deviceRoot"); }
/* 230 */         if (Device.endsWith("4")) { DeviceDouble = DeviceDouble4; DeviceRoot = "disk4"; System.out.println(DeviceRoot + " = deviceRoot"); }
/* 231 */         if (Device.endsWith("5")) { DeviceDouble = DeviceDouble5; DeviceRoot = "disk5"; System.out.println(DeviceRoot + " = deviceRoot"); }
/* 232 */         if (Device.endsWith("6")) { DeviceDouble = DeviceDouble6; DeviceRoot = "disk6"; System.out.println(DeviceRoot + " = deviceRoot"); }
/* 233 */         if (Device.endsWith("7")) { DeviceDouble = DeviceDouble7; DeviceRoot = "disk7"; System.out.println(DeviceRoot + " = deviceRoot"); }
/* 234 */         if (Device.endsWith("8")) { DeviceDouble = DeviceDouble8; DeviceRoot = "disk8"; System.out.println(DeviceRoot + " = deviceRoot"); }
/* 235 */         if (Device.endsWith("9")) { DeviceDouble = DeviceDouble9; DeviceRoot = "disk9"; System.out.println(DeviceRoot + " = deviceRoot"); }
/* 236 */         if (Device.endsWith("10")) { DeviceDouble = DeviceDouble10; DeviceRoot = "disk10"; System.out.println(DeviceRoot + " = deviceRoot"); }
/* 237 */         System.out.println(DeviceDouble);
/*     */       }
/*     */ 
/* 242 */       if (source == this.VersionsList)
/*     */       {
/* 246 */         System.out.println(this.VersionsList.getSelectedValue());
/* 247 */         Version = (String)this.VersionsList.getSelectedValue();
/* 248 */         NextFirstPage.setEnabled(true);
/* 249 */         this.NextSelectVersion.setEnabled(true);
/* 250 */         getSize();
/* 251 */         System.out.println(URL);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void actionPerformed(ActionEvent e)
/*     */   {
/* 266 */     Object source = e.getSource();
/*     */ 
/* 268 */     if (source == ExitButton)
/*     */     {
/* 270 */       System.exit(0);
/*     */     }
/*     */ 
/* 275 */     if (source == LastScreen.DonateButton) {
/*     */       try
/*     */       {
/* 278 */         Desktop desktop = Desktop.getDesktop(); URI uri = new URI("https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=HDGGMPYMWMTHL"); desktop.browse(uri); } catch (Exception f) {
/* 279 */         System.err.println(f.getMessage());
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 284 */     if (source == BackSecondPage)
/*     */     {
/* 286 */       frame.remove(VersionsScroller);
/* 287 */       frame.remove(blankRight);
/* 288 */       frame.add("Center", scroller);
/* 289 */       frame.add("West", blankRight);
/* 290 */       South.removeAll();
/* 291 */       South.add(new OpenFile().openButton);
/* 292 */       South.add(this.middle);
/* 293 */       South.add(this.NextSelectVersion);
/* 294 */       this.NextSelectVersion.setEnabled(false);
/* 295 */       this.NextSelectVersion.setEnabled(true);
/* 296 */       frame.setVisible(true);
/*     */     }
/*     */ 
/* 300 */     if (source == BackThirdPage)
/*     */     {
/* 302 */       frame.remove(USBscroller);
/* 303 */       frame.add("Center", VersionsScroller);
/* 304 */       South.removeAll();
/* 305 */       South.add(BackSecondPage);
/* 306 */       South.add(middleSecond);
/* 307 */       South.add(NextFirstPage);
/* 308 */       frame.validate();
/* 309 */       frame.invalidate();
/* 310 */       NextFirstPage.invalidate();
/* 311 */       NextFirstPage.validate();
/* 312 */       NextFirstPage.setEnabled(false);
/* 313 */       NextFirstPage.setEnabled(true);
/* 314 */       BackSecondPage.invalidate();
/* 315 */       BackSecondPage.validate();
/* 316 */       BackSecondPage.setEnabled(false);
/* 317 */       BackSecondPage.setEnabled(true);
/* 318 */       frame.setEnabled(false);
/* 319 */       frame.setEnabled(true);
/* 320 */       frame.setVisible(true);
/*     */     }
/*     */ 
/* 325 */     if (source == LastScreen.Done) System.exit(0);
/*     */ 
/* 327 */     if (source == this.NextSelectVersion)
/*     */     {
/* 329 */       South.removeAll();
/* 330 */       frame.setEnabled(false);
/* 331 */       frame.setEnabled(true);
/* 332 */       frame.setVisible(true);
/*     */ 
/* 334 */       NextFirstPage.setEnabled(false);
/*     */ 
/* 336 */       System.out.println("Distro Selection");
/* 337 */       South.remove(this.NextSelectVersion);
/* 338 */       South.add("East", NextFirstPage);
/* 339 */       path = main.class.getResource("ubuntu.iso").toString().replace("%20", " ").replace("file:", "");
/*     */ 
/* 341 */       if (this.OS.equals("Xubuntu"))
/*     */       {
/* 347 */         String[] Versions = { 
/* 342 */           "Xubuntu 11.10 (727 MB)", 
/* 343 */           "Xubuntu 11.04 (721 MB)", 
/* 344 */           "Xubuntu 10.10 (727 MB)", 
/* 345 */           "Xubuntu 10.04 LTS (729 MB)", 
/* 346 */           "Xubuntu 9.04 (663 MB)", 
/* 347 */           "Xubuntu 8.04 (577 MB)" };
/* 348 */         this.VersionsList = new JList(Versions);
/*     */       }
/* 350 */       if (this.OS.equals("Ubuntu"))
/*     */       {
/* 358 */         String[] Versions = { 
/* 351 */           "Ubuntu 11.10 (731 MB)", 
/* 352 */           "Ubuntu 11.04 (732 MB)", 
/* 353 */           "Ubuntu 10.10 (729 MB)", 
/* 354 */           "Ubuntu 10.04 LTS (722 MB)", 
/* 355 */           "Ubuntu 9.10 (724 MB)", 
/* 356 */           "Ubuntu 9.04 (731 MB)", 
/* 357 */           "Ubuntu 8.10 (733 MB)", 
/* 358 */           "Ubuntu 8.04 (732 MB)" };
/* 359 */         this.VersionsList = new JList(Versions);
/*     */       }
/* 361 */       if (this.OS.equals("Kubuntu"))
/*     */       {
/* 369 */         String[] Versions = { 
/* 362 */           "Kubuntu 11.10 (733 MB)", 
/* 363 */           "Kubuntu 11.04 (727 MB)", 
/* 364 */           "Kubuntu 10.10 (729 MB)", 
/* 365 */           "Kubuntu 10.04 LTS (735 MB)", 
/* 366 */           "Kubuntu 9.10 (730 MB)", 
/* 367 */           "Kubuntu 9.04 (729 MB)", 
/* 368 */           "Kubuntu 8.10 (729 MB)", 
/* 369 */           "Kubuntu 8.04 (729 MB)" };
/* 370 */         this.VersionsList = new JList(Versions);
/*     */       }
/* 372 */       if (this.OS.equals("Lubuntu")) { String[] Versions = { "Lubuntu 11.10 (703 MB)" }; this.VersionsList = new JList(Versions); }
/* 373 */       if (this.OS.equals("Ubuntu Studio")) { String[] Versions = { "Ubuntu Studio 11.10 (2.01 GB)", "Ubuntu Studio 11.04 (1.64 GB)", "Ubuntu Studio 10.10 (1.88 GB)" }; this.VersionsList = new JList(Versions); }
/* 374 */       if (this.OS.equals("Edubuntu"))
/*     */       {
/* 381 */         String[] Versions = { 
/* 375 */           "Edubuntu 11.10 (2.86 GB)", 
/* 376 */           "Edubuntu 11.04 (2.94 GB)", 
/* 377 */           "Edubuntu 10.10 (2.61 GB)", 
/* 378 */           "Edubuntu 10.04 LTS (2.49 GB)", 
/* 379 */           "Edubuntu 9.04 (342 MB)", 
/* 380 */           "Edubuntu 8.10 (350 MB)", 
/* 381 */           "Edubuntu 8.04 (448 MB)" };
/* 382 */         this.VersionsList = new JList(Versions);
/* 383 */       }if (this.OS.equals("Mythbuntu"))
/*     */       {
/* 389 */         String[] Versions = { 
/* 384 */           "Mythbuntu 11.10 (711 MB)", 
/* 385 */           "Mythbuntu 11.04 (732 MB)", 
/* 386 */           "Mythbuntu 10.10 (718 MB)", 
/* 387 */           "Mythbuntu 10.04 LTS (708 MB)", 
/* 388 */           "Mythbuntu 9.04 (684 MB)", 
/* 389 */           "Mythbuntu 8.04 (595 MB)" }; this.VersionsList = new JList(Versions);
/* 390 */       }if (this.OS.equals("Ubuntu Rescue Remix"))
/*     */       {
/* 398 */         String[] Versions = { 
/* 391 */           "Ubuntu Rescue Remix 11.10 (257 MB)", 
/* 392 */           "Ubuntu Rescue Remix 11.04 (234 MB)", 
/* 393 */           "Ubuntu Rescue Remix 10.10 (199 MB)", 
/* 394 */           "Ubuntu Rescue Remix 10.04 LTS (186 MB)", 
/* 395 */           "Ubuntu Rescue Remix 9.10 (172 MB)", 
/* 396 */           "Ubuntu Rescue Remix 9.04 (175 MB)", 
/* 397 */           "Ubuntu Rescue Remix 8.10 (164 MB)", 
/* 398 */           "Ubuntu Rescue Remix 8.04 (15 MB)" }; this.VersionsList = new JList(Versions);
/* 399 */       }if (this.OS.equals("Arch Linux")) { String[] Versions = { "Arch Linux Net Install (193 MB)", "Arch Linux Core (395 MB)" }; this.VersionsList = new JList(Versions); }
/* 400 */       if (this.OS.equals("BackTrack")) { String[] Versions = { "BackTrack R1 GNOME (2.08 GB)", "BackTrack R1 KDE (2.13 GB)" }; this.VersionsList = new JList(Versions); }
/* 401 */       if (this.OS.equals("Fedora")) { String[] Versions = { "Fedora 16 (633 MB)", "Fedora 15 (594 MB)", "Fedora 14 (720 MB)", "Fedora 13 (734 MB)" }; this.VersionsList = new JList(Versions); }
/* 402 */       if (this.OS.equals("Gentoo")) { String[] Versions = { "Gentoo 12 (3.89 GB)", "Gentoo 11.2 (2.98 GB)", "Gentoo 11 (2.69 GB)" }; this.VersionsList = new JList(Versions); }
/* 403 */       if (this.OS.equals("Linux Mint")) {
/* 404 */         String[] Versions = { 
/* 405 */           "Linux Mint 5 (715 MB)", 
/* 406 */           "Linux Mint 6 (715 MB)", 
/* 407 */           "Linux Mint 7 (728 MB)", 
/* 408 */           "Linux Mint 8 (1.27 GB)", 
/* 409 */           "Linux Mint 9 (794 MB)", 
/* 410 */           "Linux Mint 10 (865 MB)", 
/* 411 */           "Linux Mint 11 (906 MB)", 
/* 412 */           "Linux Mint 12 (1.07 GB)" }; this.VersionsList = new JList(Versions);
/* 413 */       }if (this.OS.equals("PCLinuxOS")) { String[] Versions = { "PCLinuxOS KDE 2012 (722 MB)", "PCLinuxOS LXDE 2012 (532 MB)", "PCLinuxOS XFCE 2012 (707 MB)", "PCLinuxOS Openbox 2012 (715 MB)" }; this.VersionsList = new JList(Versions); }
/* 414 */       if (this.OS.equals("Puppy Linux")) { String[] Versions = { "Lucid Puppy Latest (137 MB)", "Slacko Puppy Latest (132 MB)" }; this.VersionsList = new JList(Versions);
/*     */       }
/*     */ 
/* 418 */       this.VersionsList.setSelectionMode(0);
/* 419 */       VersionsScroller = new JScrollPane(this.VersionsList);
/* 420 */       VersionsScroller.setVerticalScrollBarPolicy(22);
/* 421 */       VersionsScroller.setHorizontalScrollBarPolicy(31);
/*     */ 
/* 423 */       South.remove(this.NextSelectVersion);
/* 424 */       South.add(BackSecondPage);
/* 425 */       South.add(middleFirst);
/* 426 */       South.add(NextFirstPage);
/*     */ 
/* 428 */       frame.remove(South);
/* 429 */       frame.add("South", South);
/* 430 */       frame.remove(scroller);
/* 431 */       frame.getContentPane().add("Center", VersionsScroller);
/*     */ 
/* 433 */       VersionsScroller.transferFocus();
/* 434 */       this.VersionsList.addListSelectionListener(this);
/*     */ 
/* 437 */       frame.setVisible(true);
/*     */     }
/*     */ 
/* 442 */     if (source == NextFirstPage)
/*     */     {
/* 444 */       ScanUSB();
/* 445 */       SelectUSB = new JList(USBDevices);
/* 446 */       SelectUSB.addListSelectionListener(this);
/* 447 */       SelectUSB.setSelectionMode(0);
/*     */ 
/* 449 */       USBscroller = new JScrollPane(SelectUSB);
/* 450 */       USBscroller.setVerticalScrollBarPolicy(22);
/* 451 */       USBscroller.setHorizontalScrollBarPolicy(31);
/*     */ 
/* 453 */       frame.remove(VersionsScroller);
/* 454 */       frame.add("Center", USBscroller);
/*     */ 
/* 456 */       South.remove(NextFirstPage);
/* 457 */       South.remove(BackSecondPage);
/* 458 */       South.remove(middleFirst);
/* 459 */       South.remove(NextSecondPage);
/* 460 */       South.add(BackThirdPage);
/* 461 */       South.add(middleSecond);
/* 462 */       South.add(NextSecondPage);
/* 463 */       frame.remove(South);
/* 464 */       frame.remove(logo);
/* 465 */       frame.getContentPane().add("North", logo2);
/* 466 */       frame.getContentPane().add("South", South);
/* 467 */       frame.invalidate();
/* 468 */       frame.validate();
/* 469 */       frame.setEnabled(false);
/* 470 */       frame.setEnabled(true);
/* 471 */       frame.repaint();
/* 472 */       frame.setVisible(true);
/*     */     }
/*     */ 
/* 476 */     if (source == NextSecondPage)
/*     */     {
/* 478 */       getSize();
/*     */ 
/* 480 */       if (DeviceDouble < size / 1000.0D)
/*     */       {
/* 482 */         noSpace();
/* 483 */         System.out.println("Not enough space on the drive");
/*     */       }
/*     */ 
/* 487 */       if (DeviceDouble > size / 1000.0D)
/*     */       {
/* 490 */         if (Device == null) { String selection = (String)SelectUSB.getSelectedValue(); Device = selection; size = file.length() / 1024L;
/*     */         }
/* 492 */         this.AlertFrame = new JFrame("Ubuntu Disk Creator Erase Warning");
/* 493 */         this.AlertFrame.setDefaultCloseOperation(0);
/* 494 */         this.AlertFrame.dispose();
/*     */ 
/* 497 */         ImageIcon WarningLogo = new ImageIcon(new File(main.class.getResource("WarningLogo.png").getFile()).toString().replace("%20", " ").replace("file:", ""));
/* 498 */         JLabel WarningIcon = new JLabel(WarningLogo);
/* 499 */         JPanel WarningPanel = new JPanel();
/* 500 */         JPanel EraseQuestion = new JPanel();
/* 501 */         JLabel WarningInfo = new JLabel("<html><table><td width=>Are you sure you want to permanently erase the disk\"" + Device + " ?</td></table></html>");
/*     */ 
/* 503 */         EraseQuestion.add("West", this.DontErase);
/* 504 */         EraseQuestion.add("East", this.DoErase);
/*     */ 
/* 506 */         WarningPanel.add("East", WarningIcon);
/*     */ 
/* 508 */         this.DontErase.addActionListener(this);
/* 509 */         this.DoErase.addActionListener(this);
/* 510 */         this.DontErase.transferFocus();
/*     */ 
/* 512 */         this.AlertFrame.getContentPane().add("South", EraseQuestion);
/* 513 */         this.AlertFrame.getContentPane().add("Center", WarningInfo);
/* 514 */         this.AlertFrame.getContentPane().add("West", WarningPanel);
/* 515 */         this.AlertFrame.setSize(500, 135);
/* 516 */         this.AlertFrame.setResizable(false);
/* 517 */         this.AlertFrame.setLocationRelativeTo(frame);
/* 518 */         this.AlertFrame.setVisible(true);
/* 519 */         frame.repaint();
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 525 */     if (source == this.DoErase)
/*     */     {
/* 528 */       this.AlertFrame.dispose();
/* 529 */       this.AlertFrame.setVisible(false);
/*     */ 
/* 531 */       if (path.equals(main.class.getResource("ubuntu.iso").toString().replace("%20", " ").replace("file:", "")))
/*     */       {
/* 533 */         getSize();
/*     */ 
/* 535 */         System.out.println("Sorted the links. Downloading from " + URL);
/* 536 */         path = main.class.getResource("ubuntu.iso").toString().replace("%20", " ").replace("file:", "");
/* 537 */       }frame.repaint();
/* 538 */       Thread DownloadThread = new Thread(new Download()); DownloadThread.start();
/*     */     }
/*     */ 
/* 542 */     if (source == this.DontErase)
/*     */     {
/* 544 */       this.AlertFrame.removeAll();
/* 545 */       this.AlertFrame.dispose();
/* 546 */       frame.repaint();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void ScanUSB()
/*     */   {
/* 554 */     int counter = 0;
/*     */     try
/*     */     {
/* 558 */       DrivesScanner = new Scanner(new File(ScanUSB.DrivesPath.replace("%20", " ")));
/*     */       int x;
/* 562 */       for (; DrivesScanner.hasNext(); 
/* 565 */         x < 10)
/*     */       {
/* 564 */         x = 0;
/* 565 */         continue;
/*     */ 
/* 567 */         String CurrentLine = DrivesScanner.nextLine();
/*     */ 
/* 569 */         if ((CurrentLine.endsWith("1")) || 
/* 570 */           (CurrentLine.endsWith("2")) || 
/* 571 */           (CurrentLine.endsWith("3")) || 
/* 572 */           (CurrentLine.endsWith("4")) || 
/* 573 */           (CurrentLine.endsWith("5")) || 
/* 574 */           (CurrentLine.endsWith("6")) || 
/* 575 */           (CurrentLine.endsWith("7")) || 
/* 576 */           (CurrentLine.endsWith("8")) || 
/* 577 */           (CurrentLine.endsWith("9")) || 
/* 578 */           (CurrentLine.endsWith("10")))
/*     */         {
/* 580 */           x++;
/* 581 */           counter++;
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception E)
/*     */     {
/* 587 */       System.out.println("Could not find File in main class."); } System.out.println(counter); USBDevices = new String[counter];
/*     */     try
/*     */     {
/* 593 */       DrivesScanner = new Scanner(new File(ScanUSB.DrivesPath.replace("%20", " ")));
/*     */       int x;
/* 595 */       for (; DrivesScanner.hasNext(); 
/* 598 */         x < 10)
/*     */       {
/* 597 */         x = 0;
/* 598 */         continue;
/*     */ 
/* 600 */         String CurrentLine = DrivesScanner.nextLine();
/*     */ 
/* 602 */         if ((CurrentLine.endsWith("1")) || 
/* 603 */           (CurrentLine.endsWith("2")) || 
/* 604 */           (CurrentLine.endsWith("3")) || 
/* 605 */           (CurrentLine.endsWith("4")) || 
/* 606 */           (CurrentLine.endsWith("5")) || 
/* 607 */           (CurrentLine.endsWith("6")) || 
/* 608 */           (CurrentLine.endsWith("7")) || 
/* 609 */           (CurrentLine.endsWith("8")) || 
/* 610 */           (CurrentLine.endsWith("9")) || 
/* 611 */           (CurrentLine.endsWith("10")))
/*     */         {
/* 613 */           USBDevices[x] = CurrentLine;
/* 614 */           System.out.println("Wrote: " + CurrentLine + ", to Array");
/* 615 */           x++;
/*     */         }
/*     */       }
/*     */     } catch (Exception E) {
/* 619 */       System.out.println("Could not find File in main class.");
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void getSize()
/*     */   {
/* 627 */     if (openFile) size = file.length() / 1000000L;
/*     */ 
/* 629 */     if (Version.equals("Ubuntu 11.10 (731 MB)")) { URL = "http://releases.ubuntu.com/11.10/ubuntu-11.10-desktop-amd64.iso"; size = 731.20000000000005D; }
/* 630 */     if (Version.equals("Ubuntu 11.04 (732 MB)")) { URL = "http://releases.ubuntu.com/natty/ubuntu-11.04-desktop-amd64.iso"; size = 732.10000000000002D; }
/* 631 */     if (Version.equals("Ubuntu 10.10 (729 MB)")) { URL = "http://releases.ubuntu.com/10.10/ubuntu-10.10-desktop-amd64.iso"; size = 728.79999999999995D; }
/* 632 */     if (Version.equals("Ubuntu 10.04 LTS (722 MB)")) { URL = "http://releases.ubuntu.com/10.04/ubuntu-10.04.3-desktop-amd64.iso"; size = 722.29999999999995D; }
/* 633 */     if (Version.equals("Ubuntu 9.10 (724 MB)")) { URL = "http://old-releases.ubuntu.com/releases/karmic/ubuntu-9.10-desktop-amd64.iso"; size = 724.39999999999998D; }
/* 634 */     if (Version.equals("Ubuntu 9.04 (731 MB)")) { URL = "http://old-releases.ubuntu.com/releases/9.04/ubuntu-9.04-desktop-amd64.iso"; size = 730.60000000000002D; }
/* 635 */     if (Version.equals("Ubuntu 8.10 (733 MB)")) { URL = "http://old-releases.ubuntu.com/releases/8.10/ubuntu-8.10-desktop-amd64.iso"; size = 733.0D; }
/* 636 */     if (Version.equals("Ubuntu 8.04 (732 MB)")) { URL = "http://releases.ubuntu.com/8.04/ubuntu-8.04.4-desktop-amd64.iso"; size = 731.60000000000002D;
/*     */     }
/* 638 */     if (Version.equals("Kubuntu 11.10 (733 MB)")) { URL = "http://releases.ubuntu.com/kubuntu/oneiric/kubuntu-11.10-desktop-amd64.iso"; size = 733.29999999999995D; }
/* 639 */     if (Version.equals("Kubuntu 11.04 (727 MB)")) { URL = "http://releases.ubuntu.com/kubuntu/natty/kubuntu-11.04-desktop-amd64.iso"; size = 727.29999999999995D; }
/* 640 */     if (Version.equals("Kubuntu 10.10 (729 MB)")) { URL = "http://releases.ubuntu.com/kubuntu/maverick/kubuntu-10.10-desktop-amd64.iso"; size = 729.39999999999998D; }
/* 641 */     if (Version.equals("Kubuntu 10.04 LTS (735 MB)")) { URL = "http://releases.ubuntu.com/kubuntu/10.04/kubuntu-10.04.4-desktop-amd64.iso"; size = 735.20000000000005D; }
/* 642 */     if (Version.equals("Kubuntu 9.10 (730 MB)")) { URL = "http://old-releases.ubuntu.com/releases/kubuntu/9.10/kubuntu-9.10-desktop-amd64.iso"; size = 729.39999999999998D; }
/* 643 */     if (Version.equals("Kubuntu 9.04 (729 MB)")) { URL = "http://old-releases.ubuntu.com/releases/kubuntu/9.04/kubuntu-9.04-desktop-amd64.iso"; size = 728.39999999999998D; }
/* 644 */     if (Version.equals("Kubuntu 8.10 (729 MB)")) { URL = "http://old-releases.ubuntu.com/releases/kubuntu/8.10/kubuntu-8.10-desktop-amd64.iso"; size = 729.39999999999998D; }
/* 645 */     if (Version.equals("Kubuntu 8.04 (729 MB)")) { URL = "http://releases.ubuntu.com/kubuntu/8.04/kubuntu-8.04.2-desktop-amd64.iso"; size = 729.89999999999998D;
/*     */     }
/* 647 */     if (Version.equals("Xubuntu 11.10 (727 MB)")) { URL = "http://cdimage.ubuntu.com/xubuntu/releases/11.10/release/xubuntu-11.10-desktop-amd64.iso"; size = 727.0D; }
/* 648 */     if (Version.equals("Xubuntu 11.04 (721 MB)")) { URL = "http://cdimage.ubuntu.com/xubuntu/releases/natty/release/xubuntu-11.04-desktop-amd64.iso"; size = 721.20000000000005D; }
/* 649 */     if (Version.equals("Xubuntu 10.10 (727 MB)")) { URL = "http://cdimage.ubuntu.com/xubuntu/releases/10.10/release/xubuntu-10.10-desktop-amd64.iso"; size = 726.70000000000005D; }
/* 650 */     if (Version.equals("Xubuntu 10.04 LTS (729 MB)")) { URL = "http://cdimage.ubuntu.com/xubuntu/releases/lucid/release/xubuntu-10.04.2-desktop-amd64.iso"; size = 729.70000000000005D; }
/* 651 */     if (Version.equals("Xubuntu 9.04 (663 MB)")) { URL = "http://old-releases.ubuntu.com/releases/xubuntu/releases/9.04/release/xubuntu-9.04-desktop-amd64.iso"; size = 662.60000000000002D; }
/* 652 */     if (Version.equals("Xubuntu 8.04 (577 MB)")) { URL = "http://cdimage.ubuntu.com/xubuntu/releases/8.04/release/xubuntu-8.04.1-desktop-amd64.iso"; size = 576.89999999999998D;
/*     */     }
/* 654 */     if (Version.equals("Lubuntu 11.10 (703 MB)")) { URL = "http://cdimage.ubuntu.com/lubuntu/releases/11.10/release/lubuntu-11.10-desktop-amd64.iso"; size = 702.89999999999998D;
/*     */     }
/* 656 */     if (Version.equals("Edubuntu 11.10 (2.86 GB)")) { URL = "http://cdimage.ubuntu.com/edubuntu/releases/11.10/release/edubuntu-11.10-dvd-amd64.iso"; size = 2855.1999999999998D; }
/* 657 */     if (Version.equals("Edubuntu 11.04 (2.94 GB)")) { URL = "http://cdimage.ubuntu.com/edubuntu/releases/11.04/release/edubuntu-11.04-dvd-amd64.iso"; size = 2935.6999999999998D; }
/* 658 */     if (Version.equals("Edubuntu 10.10 (2.61 GB)")) { URL = "http://cdimage.ubuntu.com/edubuntu/releases/10.10/release/edubuntu-10.10-dvd-amd64.iso"; size = 2607.5D; }
/* 659 */     if (Version.equals("Edubuntu 10.04 LTS (2.49 GB)")) { URL = "http://cdimage.ubuntu.com/edubuntu/releases/10.04/release/edubuntu-10.04-dvd-amd64.iso"; size = 2484.6999999999998D; }
/* 660 */     if (Version.equals("Edubuntu 9.04 (342 MB)")) { URL = "http://old-releases.ubuntu.com/releases/edubuntu/releases/jaunty/release/edubuntu-9.04-addon-amd64.iso"; size = 342.39999999999998D; }
/* 661 */     if (Version.equals("Edubuntu 8.10 (350 MB)")) { URL = "http://old-releases.ubuntu.com/releases/edubuntu/8.10/edubuntu-8.10-addon-amd64.iso"; size = 350.89999999999998D; }
/* 662 */     if (Version.equals("Edubuntu 8.04 (448 MB)")) { URL = "http://releases.ubuntu.com/edubuntu/8.04/edubuntu-8.04.1-addon-amd64.iso"; size = 448.39999999999998D;
/*     */     }
/* 664 */     if (Version.equals("Ubuntu Studio 11.10 (2.01 GB)")) { URL = "http://cdimage.ubuntu.com/ubuntustudio/releases/11.10/release/ubuntustudio-11.10-alternate-amd64.iso"; size = 2011.5999999999999D; }
/* 665 */     if (Version.equals("Ubuntu Studio 11.04 (1.64 GB)")) { URL = "http://cdimage.ubuntu.com/ubuntustudio/releases/11.04/release/ubuntustudio-11.04-alternate-amd64.iso"; size = 1633.5D; }
/* 666 */     if (Version.equals("Ubuntu Studio 10.10 (1.88 GB)")) { URL = "http://cdimage.ubuntu.com/ubuntustudio/releases/10.10/release/ubuntustudio-10.10-alternate-amd64.iso"; size = 1878.5999999999999D;
/*     */     }
/* 668 */     if (Version.equals("Mythbuntu 11.10 (711 MB)")) { URL = "http://cdimage.ubuntu.com/mythbuntu/releases/11.10/release/mythbuntu-11.10-desktop-amd64.iso"; size = 711.20000000000005D; }
/* 669 */     if (Version.equals("Mythbuntu 11.04 (732 MB)")) { URL = "http://cdimage.ubuntu.com/mythbuntu/releases/11.04/release/mythbuntu-11.04-desktop-amd64.iso"; size = 731.79999999999995D; }
/* 670 */     if (Version.equals("Mythbuntu 10.10 (718 MB)")) { URL = "http://cdimage.ubuntu.com/mythbuntu/releases/10.10/release/mythbuntu-10.10-desktop-amd64.iso"; size = 718.39999999999998D; }
/* 671 */     if (Version.equals("Mythbuntu 10.04 LTS (708 MB)")) { URL = "http://cdimage.ubuntu.com/mythbuntu/releases/10.04/release/mythbuntu-10.04-desktop-amd64.iso"; size = 708.0D; }
/* 672 */     if (Version.equals("Mythbuntu 9.04 (684 MB)")) { URL = "http://old-releases.ubuntu.com/releases/mythbuntu/releases/9.04/release/mythbuntu-9.04-desktop-amd64.iso"; size = 683.70000000000005D; }
/* 673 */     if (Version.equals("Mythbuntu 8.04 (595 MB)")) { URL = "http://cdimage.ubuntu.com/mythbuntu/releases/8.04/release/mythbuntu-8.04.1-alternate-amd64.iso"; size = 594.5D;
/*     */     }
/* 675 */     if (Version.equals("Ubuntu Rescue Remix 11.10 (257 MB)")) { URL = "http://ubuntu-rescue-remix.org/files/URR/iso/ubuntu-rescue-remix-11-10.iso"; size = 256.80000000000001D; }
/* 676 */     if (Version.equals("Ubuntu Rescue Remix 11.04 (234 MB)")) { URL = "http://ubuntu-rescue-remix.org/files/URR/iso/UbuntuRescueRemix1104.iso"; size = 234.30000000000001D; }
/* 677 */     if (Version.equals("Ubuntu Rescue Remix 10.10 (199 MB)")) { URL = "http://ubuntu-rescue-remix.org/files/URR/iso/ubuntu-rescue-remix-10-10.iso"; size = 199.30000000000001D; }
/* 678 */     if (Version.equals("Ubuntu Rescue Remix 10.04 LTS (186 MB)")) { URL = "http://ubuntu-rescue-remix.org/files/URR/iso/ubuntu-rescue-remix-10-04.iso"; size = 186.0D; }
/* 679 */     if (Version.equals("Ubuntu Rescue Remix 9.10 (172 MB)")) { URL = "http://ubuntu-rescue-remix.org/files/URR/iso/ubuntu-rescue-remix-9-10-revision1.iso"; size = 172.09999999999999D; }
/* 680 */     if (Version.equals("Ubuntu Rescue Remix 9.04 (175 MB)")) { URL = "http://ubuntu-rescue-remix.org/files/URR/iso/ubuntu-rescue-remix-9.04.iso"; size = 174.80000000000001D; }
/* 681 */     if (Version.equals("Ubuntu Rescue Remix 8.10 (164 MB)")) { URL = "http://ubuntu-rescue-remix.org/files/URR/iso/ubuntu-rescue-remix-8.10.iso"; size = 164.30000000000001D; }
/* 682 */     if (Version.equals("Ubuntu Rescue Remix 8.04 (15 MB)")) { URL = "http://ubuntu-rescue-remix.org/files/URR/iso/ubuntu-remix-804.iso"; size = 15.800000000000001D;
/*     */     }
/* 684 */     if (Version.equals("Arch Linux Core (395 MB)")) { URL = "http://mirrors.kernel.org/archlinux/iso/latest/archlinux-2011.08.19-core-x86_64.iso"; size = 395.30000000000001D; }
/* 685 */     if (Version.equals("Arch Linux Net Install (193 MB)")) { URL = "http://mirrors.kernel.org/archlinux/iso/latest/archlinux-2011.08.19-netinstall-x86_64.iso"; size = 192.90000000000001D;
/*     */     }
/* 687 */     if (Version.equals("BackTrack R1 GNOME (2.08 GB)")) { URL = "http://www.backtrack-linux.org/ajax/download_redirect.php?id=BT5R1-GNOME-64.iso"; size = 2080.1999999999998D; }
/* 688 */     if (Version.equals("BackTrack R1 KDE (2.13 GB)")) { URL = "http://www.backtrack-linux.org/ajax/download_redirect.php?id=BT5R1-KDE-64.iso"; size = 2126.0D;
/*     */     }
/* 690 */     if (Version.equals("Linux Mint 5 (715 MB)")) { URL = "http://linuxfreedom.com/linuxmint/linuxmint.com/stable/5/LinuxMint-5-x64.iso"; size = 714.89999999999998D; }
/* 691 */     if (Version.equals("Linux Mint 6 (715 MB)")) { URL = "http://linuxfreedom.com/linuxmint/linuxmint.com/stable/6/LinuxMint-6-x64.iso"; size = 715.39999999999998D; }
/* 692 */     if (Version.equals("Linux Mint 7 (728 MB)")) { URL = "http://linuxfreedom.com/linuxmint/linuxmint.com/stable/7/LinuxMint-7-x64.iso"; size = 727.60000000000002D; }
/* 693 */     if (Version.equals("Linux Mint 8 (1.27 GB)")) { URL = "http://linuxfreedom.com/linuxmint/linuxmint.com/stable/8/LinuxMint-8-KDE64.iso"; size = 1268.7D; }
/* 694 */     if (Version.equals("Linux Mint 9 (794 MB)")) { URL = "http://linuxfreedom.com/linuxmint/linuxmint.com/stable/9/linuxmint-9-gnome-dvd-amd64.iso"; size = 794.0D; }
/* 695 */     if (Version.equals("Linux Mint 10 (865 MB)")) { URL = "http://linuxfreedom.com/linuxmint/stable/10/linuxmint-10-gnome-dvd-amd64.iso"; size = 865.10000000000002D; }
/* 696 */     if (Version.equals("Linux Mint 11 (906 MB)")) { URL = "http://linuxfreedom.com/linuxmint/stable/11/linuxmint-11-gnome-dvd-64bit.iso"; size = 905.89999999999998D; }
/* 697 */     if (Version.equals("Linux Mint 12 (1.07 GB)")) { URL = "http://linuxfreedom.com/linuxmint/stable/12/linuxmint-12-gnome-dvd-64bit.iso"; size = 1066.5D;
/*     */     }
/* 699 */     if (Version.equals("Fedora 16 (633 MB)")) { URL = "http://mirror.cogentco.com/pub/linux/fedora/linux/releases/16/Live/x86_64/Fedora-16-x86_64-Live-Desktop.iso"; size = 633.29999999999995D; }
/* 700 */     if (Version.equals("Fedora 15 (594 MB)")) { URL = "http://mirror.cogentco.com/pub/linux/fedora/linux/releases/15/Live/x86_64/Fedora-15-x86_64-Live-Desktop.iso"; size = 594.5D; }
/* 701 */     if (Version.equals("Fedora 14 (720 MB)")) { URL = "http://mirror.cogentco.com/pub/linux/fedora/linux/releases/14/Live/x86_64/Fedora-14-x86_64-Live-Desktop.iso"; size = 720.39999999999998D; }
/* 702 */     if (Version.equals("Fedora 13 (734 MB)")) { URL = "http://mirror.cogentco.com/pub/linux/fedora/linux/releases/13/Live/x86_64/Fedora-13-x86_64-Live-KDE.iso"; size = 734.0D;
/*     */     }
/* 704 */     if (Version.equals("Gentoo 12 (3.89 GB)")) { URL = "http://ftp.snt.utwente.nl/pub/os/linux/gentoo/releases/amd64/12.0/livedvd-amd64-multilib-2012.iso"; size = 3896.5D; }
/* 705 */     if (Version.equals("Gentoo 11.2 (2.98 GB)")) { URL = "http://gentoo.mirrors.tds.net/pub/gentoo//releases/amd64/11.2/livedvd-amd64-multilib-11.2.iso"; size = 2977.9000000000001D; }
/* 706 */     if (Version.equals("Gentoo 11 (2.69 GB)")) { URL = "http://mirrors.se.kernel.org/gentoo//releases/amd64/11.0/livedvd-amd64-multilib-11.0.iso"; size = 2699.0D;
/*     */     }
/* 708 */     if (Version.equals("PCLinuxOS KDE 2012 (722 MB)")) { URL = "http://distrib-coffee.ipsl.jussieu.fr/pub/linux/pclinuxos/live-cd/pclinuxos-kde-2012.02.iso"; size = 722.5D; }
/* 709 */     if (Version.equals("PCLinuxOS LXDE 2012 (532 MB)")) { URL = "http://distrib-coffee.ipsl.jussieu.fr/pub/linux/pclinuxos/live-cd/pclinuxos-lxde-2012.01.iso"; size = 532.60000000000002D; }
/* 710 */     if (Version.equals("PCLinuxOS XFCE 2012 (707 MB)")) { URL = "http://debian.ethz.ch/mirror/pclinuxos/live-cd/pclinuxos-phoenix-2012-02.iso"; size = 707.29999999999995D; }
/* 711 */     if (Version.equals("PCLinuxOS Openbox 2012 (715 MB)")) { URL = "http://ftp.heanet.ie/pub/pclinuxos/live-cd/pclinuxos-openbox-2011.08.iso"; size = 715.29999999999995D;
/*     */     }
/* 713 */     if (Version.equals("Slacko Puppy Latest (132 MB)")) { URL = "http://distro.ibiblio.org/pub/linux/distributions/puppylinux/puppy-5.3.1/slacko-5.3.1-SCSI-MAIN.iso"; size = 132.19999999999999D; }
/* 714 */     if (Version.equals("Lucid Puppy Latest (137 MB)")) { URL = "http://distro.ibiblio.org/pub/linux/distributions/puppylinux/puppy-5.2.8/lupu-528.004.iso"; size = 137.30000000000001D;
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void noSpace()
/*     */   {
/* 720 */     DecimalFormat twoDForm = new DecimalFormat("##.##");
/* 721 */     NoSpace.setSize(600, 120);
/* 722 */     NoSpace.setLocationRelativeTo(frame);
/*     */ 
/* 724 */     WarningInfo.setText("<html><table><td width=>There is not enough space on " + Device + " to install the selected OS which takes up " + twoDForm.format(size / 1000.0D) + " GB of space.</td></table></html>");
/* 725 */     ExitButton.addActionListener(new main());
/*     */ 
/* 727 */     SouthPanel.setLayout(new BorderLayout());
/* 728 */     SouthPanel.add("East", ExitButton);
/*     */ 
/* 730 */     NoSpace.add("North", NorthBlank);
/* 731 */     NoSpace.add("West", WarningIcon);
/* 732 */     NoSpace.add("Center", WarningInfo);
/* 733 */     NoSpace.add("East", BlankRight);
/* 734 */     NoSpace.add("South", SouthPanel);
/* 735 */     NoSpace.setResizable(false);
/* 736 */     NoSpace.setVisible(true);
/*     */   }
/*     */ }

/* Location:           /Users/henrymound/Documents/Linux USB Builder/Contents/Resources/Java/
 * Qualified Name:     main
 * JD-Core Version:    0.6.2
 */