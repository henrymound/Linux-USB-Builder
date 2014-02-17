/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PrintStream;
/*     */ import java.net.URL;
/*     */ import java.util.Formatter;
/*     */ 
/*     */ public class ScanUSB
/*     */ {
/*  32 */   Process ls = null;
/*     */ 
/*  34 */   BufferedReader input = null;
/*     */ 
/*  36 */   String line = null;
/*     */   String disk1;
/*     */   String disk2;
/*     */   String disk3;
/*     */   String disk4;
/*     */   String disk5;
/*     */   String disk6;
/*     */   String disk7;
/*     */   String disk8;
/*     */   String disk9;
/*     */   String disk10;
/*  38 */   String[] USBDrives = new String[10];
/*     */   Formatter Drives;
/*  41 */   public static String DrivesPath = new File(main.class.getResource("Drives.txt").getFile()).toString();
/*     */ 
/*     */   public void ScanDrives()
/*     */   {
/*  46 */     new main();
/*     */     try
/*     */     {
/*  49 */       this.ls = Runtime.getRuntime().exec(new String[] { "diskutil", "info", "disk1" });
/*  50 */       this.input = new BufferedReader(new InputStreamReader(this.ls.getInputStream()));
/*  51 */       this.disk1 = "";
/*     */ 
/*  53 */       while ((this.line = this.input.readLine()) != null)
/*     */       {
/*  55 */         if ((this.line.startsWith("   Device / Media Name:")) || (this.line.startsWith("   Total Size:")) || (this.line.startsWith("   Protocol:                 U")))
/*     */         {
/*  57 */           if (this.line.startsWith("   Protocol:                 U")) this.line = "USB";
/*     */ 
/*  59 */           if (this.line.startsWith("   Device / Media Name:")) this.line = this.line.replace("   Device / Media Name:      ", "");
/*     */ 
/*  61 */           if (this.line.startsWith("   Total Size:")) { this.line = this.line.replace("   Total Size:               ", ""); int z = this.line.indexOf("GB"); this.line = this.line.substring(0, z); main.DeviceDouble1 = Double.valueOf(this.line.trim()).doubleValue(); this.line = ("(" + this.line + "GB" + ")");
/*     */           }
/*  63 */           this.disk1 = (this.disk1 + this.line + " ");
/*  64 */           main.DeviceRoot = "disk1";
/*     */         }
/*     */       }
/*  66 */       if (this.disk1 != "") this.disk1 += "disk1"; 
/*     */     }
/*     */     catch (Exception localException1) {
/*     */     }
/*     */     try { this.ls = Runtime.getRuntime().exec(new String[] { "diskutil", "info", "disk2" });
/*  71 */       this.input = new BufferedReader(new InputStreamReader(this.ls.getInputStream()));
/*  72 */       this.disk2 = "";
/*     */ 
/*  74 */       while ((this.line = this.input.readLine()) != null)
/*     */       {
/*  76 */         if ((this.line.startsWith("   Device / Media Name:")) || (this.line.startsWith("   Total Size:")) || (this.line.startsWith("   Protocol:                 U")))
/*     */         {
/*  78 */           if (this.line.startsWith("   Protocol:                 U")) this.line = "USB";
/*     */ 
/*  80 */           if (this.line.startsWith("   Device / Media Name:")) this.line = this.line.replace("   Device / Media Name:      ", "");
/*     */ 
/*  82 */           if (this.line.startsWith("   Total Size:")) { this.line = this.line.replace("   Total Size:               ", ""); int z = this.line.indexOf("GB"); this.line = this.line.substring(0, z); main.DeviceDouble2 = Double.valueOf(this.line.trim()).doubleValue(); this.line = ("(" + this.line + "GB" + ")");
/*     */           }
/*  84 */           this.disk2 = (this.disk2 + this.line + " ");
/*  85 */           main.DeviceRoot = "disk2";
/*     */         }
/*     */       }
/*  87 */       if (this.disk2 != "") this.disk2 += "disk2";  } catch (Exception localException2)
/*     */     {
/*     */     }
/*     */     try {
/*  91 */       this.ls = Runtime.getRuntime().exec(new String[] { "diskutil", "info", "disk3" });
/*  92 */       this.input = new BufferedReader(new InputStreamReader(this.ls.getInputStream()));
/*  93 */       this.disk3 = "";
/*     */ 
/*  95 */       while ((this.line = this.input.readLine()) != null)
/*     */       {
/*  97 */         if ((this.line.startsWith("   Device / Media Name:")) || (this.line.startsWith("   Total Size:")) || (this.line.startsWith("   Protocol:                 U")))
/*     */         {
/*  99 */           if (this.line.startsWith("   Protocol:                 U")) this.line = "USB";
/*     */ 
/* 101 */           if (this.line.startsWith("   Device / Media Name:")) this.line = this.line.replace("   Device / Media Name:      ", "");
/*     */ 
/* 103 */           if (this.line.startsWith("   Total Size:")) { this.line = this.line.replace("   Total Size:               ", ""); int z = this.line.indexOf("GB"); this.line = this.line.substring(0, z); main.DeviceDouble3 = Double.valueOf(this.line.trim()).doubleValue(); this.line = ("(" + this.line + "GB" + ")");
/*     */           }
/* 105 */           this.disk3 = (this.disk3 + this.line + " ");
/* 106 */           main.DeviceRoot = "disk3";
/*     */         }
/*     */       }
/* 108 */       if (this.disk3 != "") this.disk3 += "disk3"; 
/*     */     }
/*     */     catch (Exception localException3) {
/*     */     }
/*     */     try { this.ls = Runtime.getRuntime().exec(new String[] { "diskutil", "info", "disk4" });
/* 113 */       this.input = new BufferedReader(new InputStreamReader(this.ls.getInputStream()));
/* 114 */       this.disk4 = "";
/*     */ 
/* 116 */       while ((this.line = this.input.readLine()) != null)
/*     */       {
/* 118 */         if ((this.line.startsWith("   Device / Media Name:")) || (this.line.startsWith("   Total Size:")) || (this.line.startsWith("   Protocol:                 U")))
/*     */         {
/* 120 */           if (this.line.startsWith("   Protocol:                 U")) this.line = "USB";
/*     */ 
/* 122 */           if (this.line.startsWith("   Device / Media Name:")) this.line = this.line.replace("   Device / Media Name:      ", "");
/*     */ 
/* 124 */           if (this.line.startsWith("   Total Size:")) { this.line = this.line.replace("   Total Size:               ", ""); int z = this.line.indexOf("GB"); this.line = this.line.substring(0, z); main.DeviceDouble4 = Double.valueOf(this.line.trim()).doubleValue(); this.line = ("(" + this.line + "GB" + ")");
/*     */           }
/* 126 */           this.disk4 = (this.disk4 + this.line + " ");
/* 127 */           main.DeviceRoot = "disk4";
/*     */         }
/*     */       }
/* 129 */       if (this.disk4 != "") this.disk4 += "disk4";  } catch (Exception localException4)
/*     */     {
/*     */     }
/*     */     try {
/* 133 */       this.ls = Runtime.getRuntime().exec(new String[] { "diskutil", "info", "disk5" });
/* 134 */       this.input = new BufferedReader(new InputStreamReader(this.ls.getInputStream()));
/* 135 */       this.disk5 = "";
/*     */ 
/* 137 */       while ((this.line = this.input.readLine()) != null)
/*     */       {
/* 139 */         if ((this.line.startsWith("   Device / Media Name:")) || (this.line.startsWith("   Total Size:")) || (this.line.startsWith("   Protocol:                 U")))
/*     */         {
/* 141 */           if (this.line.startsWith("   Protocol:                 U")) this.line = "USB";
/*     */ 
/* 143 */           if (this.line.startsWith("   Device / Media Name:")) this.line = this.line.replace("   Device / Media Name:      ", "");
/*     */ 
/* 145 */           if (this.line.startsWith("   Total Size:")) { this.line = this.line.replace("   Total Size:               ", ""); int z = this.line.indexOf("GB"); this.line = this.line.substring(0, z); main.DeviceDouble5 = Double.valueOf(this.line.trim()).doubleValue(); this.line = ("(" + this.line + "GB" + ")");
/*     */           }
/* 147 */           this.disk5 = (this.disk5 + this.line + " ");
/* 148 */           main.DeviceRoot = "disk5";
/*     */         }
/*     */       }
/* 150 */       if (this.disk5 != "") this.disk5 += "disk5"; 
/*     */     }
/*     */     catch (Exception localException5) {
/*     */     }
/*     */     try { this.ls = Runtime.getRuntime().exec(new String[] { "diskutil", "info", "disk6" });
/* 155 */       this.input = new BufferedReader(new InputStreamReader(this.ls.getInputStream()));
/* 156 */       this.disk6 = "";
/*     */ 
/* 158 */       while ((this.line = this.input.readLine()) != null)
/*     */       {
/* 160 */         if ((this.line.startsWith("   Device / Media Name:")) || (this.line.startsWith("   Total Size:")) || (this.line.startsWith("   Protocol:                 U")))
/*     */         {
/* 162 */           if (this.line.startsWith("   Protocol:                 U")) this.line = "USB";
/*     */ 
/* 164 */           if (this.line.startsWith("   Device / Media Name:")) this.line = this.line.replace("   Device / Media Name:      ", "");
/*     */ 
/* 166 */           if (this.line.startsWith("   Total Size:")) { this.line = this.line.replace("   Total Size:               ", ""); int z = this.line.indexOf("GB"); this.line = this.line.substring(0, z); main.DeviceDouble6 = Double.valueOf(this.line.trim()).doubleValue(); this.line = ("(" + this.line + "GB" + ")");
/*     */           }
/* 168 */           this.disk6 = (this.disk6 + this.line + " ");
/* 169 */           main.DeviceRoot = "disk6";
/*     */         }
/*     */       }
/* 171 */       if (this.disk6 != "") this.disk6 += "disk6";  } catch (Exception localException6)
/*     */     {
/*     */     }
/*     */     try {
/* 175 */       this.ls = Runtime.getRuntime().exec(new String[] { "diskutil", "info", "disk7" });
/* 176 */       this.input = new BufferedReader(new InputStreamReader(this.ls.getInputStream()));
/* 177 */       this.disk7 = "";
/*     */ 
/* 179 */       while ((this.line = this.input.readLine()) != null)
/*     */       {
/* 181 */         if ((this.line.startsWith("   Device / Media Name:")) || (this.line.startsWith("   Total Size:")) || (this.line.startsWith("   Protocol:                 U")))
/*     */         {
/* 183 */           if (this.line.startsWith("   Protocol:                 U")) this.line = "USB";
/*     */ 
/* 185 */           if (this.line.startsWith("   Device / Media Name:")) this.line = this.line.replace("   Device / Media Name:      ", "");
/*     */ 
/* 187 */           if (this.line.startsWith("   Total Size:")) { this.line = this.line.replace("   Total Size:               ", ""); int z = this.line.indexOf("GB"); this.line = this.line.substring(0, z); main.DeviceDouble7 = Double.valueOf(this.line.trim()).doubleValue(); this.line = ("(" + this.line + "GB" + ")");
/*     */           }
/* 189 */           this.disk7 = (this.disk7 + this.line + " ");
/* 190 */           main.DeviceRoot = "disk7";
/*     */         }
/*     */       }
/* 192 */       if (this.disk7 != "") this.disk7 += "disk7"; 
/*     */     }
/*     */     catch (Exception localException7) {
/*     */     }
/*     */     try { this.ls = Runtime.getRuntime().exec(new String[] { "diskutil", "info", "disk8" });
/* 197 */       this.input = new BufferedReader(new InputStreamReader(this.ls.getInputStream()));
/* 198 */       this.disk8 = "";
/*     */ 
/* 200 */       while ((this.line = this.input.readLine()) != null)
/*     */       {
/* 202 */         if ((this.line.startsWith("   Device / Media Name:")) || (this.line.startsWith("   Total Size:")) || (this.line.startsWith("   Protocol:                 U")))
/*     */         {
/* 204 */           if (this.line.startsWith("   Protocol:                 U")) this.line = "USB";
/*     */ 
/* 206 */           if (this.line.startsWith("   Device / Media Name:")) this.line = this.line.replace("   Device / Media Name:      ", "");
/*     */ 
/* 208 */           if (this.line.startsWith("   Total Size:")) { this.line = this.line.replace("   Total Size:               ", ""); int z = this.line.indexOf("GB"); this.line = this.line.substring(0, z); main.DeviceDouble8 = Double.valueOf(this.line.trim()).doubleValue(); this.line = ("(" + this.line + "GB" + ")");
/*     */           }
/* 210 */           this.disk8 = (this.disk8 + this.line + " ");
/* 211 */           main.DeviceRoot = "disk8";
/*     */         }
/*     */       }
/* 213 */       if (this.disk8 != "") this.disk8 += "disk8";  } catch (Exception localException8)
/*     */     {
/*     */     }
/*     */     try {
/* 217 */       this.ls = Runtime.getRuntime().exec(new String[] { "diskutil", "info", "disk9" });
/* 218 */       this.input = new BufferedReader(new InputStreamReader(this.ls.getInputStream()));
/* 219 */       this.disk9 = "";
/*     */ 
/* 221 */       while ((this.line = this.input.readLine()) != null)
/*     */       {
/* 223 */         if ((this.line.startsWith("   Device / Media Name:")) || (this.line.startsWith("   Total Size:")) || (this.line.startsWith("   Protocol:                 U")))
/*     */         {
/* 225 */           if (this.line.startsWith("   Protocol:                 U")) this.line = "USB";
/*     */ 
/* 227 */           if (this.line.startsWith("   Device / Media Name:")) this.line = this.line.replace("   Device / Media Name:      ", "");
/*     */ 
/* 229 */           if (this.line.startsWith("   Total Size:")) { this.line = this.line.replace("   Total Size:               ", ""); int z = this.line.indexOf("GB"); this.line = this.line.substring(0, z); main.DeviceDouble9 = Double.valueOf(this.line.trim()).doubleValue(); this.line = ("(" + this.line + "GB" + ")");
/*     */           }
/* 231 */           this.disk9 = (this.disk9 + this.line + " ");
/* 232 */           main.DeviceRoot = "disk9";
/*     */         }
/*     */       }
/* 234 */       if (this.disk9 != "") this.disk9 += "disk9"; 
/*     */     }
/*     */     catch (Exception localException9) {
/*     */     }
/*     */     try { this.ls = Runtime.getRuntime().exec(new String[] { "diskutil", "info", "disk10" });
/* 239 */       this.input = new BufferedReader(new InputStreamReader(this.ls.getInputStream()));
/* 240 */       this.disk10 = "";
/*     */ 
/* 242 */       while ((this.line = this.input.readLine()) != null)
/*     */       {
/* 244 */         if ((this.line.startsWith("   Device / Media Name:")) || (this.line.startsWith("   Total Size:")) || (this.line.startsWith("   Protocol:                 U")))
/*     */         {
/* 246 */           if (this.line.startsWith("   Protocol:                 U")) this.line = "USB";
/*     */ 
/* 248 */           if (this.line.startsWith("   Device / Media Name:")) this.line = this.line.replace("   Device / Media Name:      ", "");
/*     */ 
/* 250 */           if (this.line.startsWith("   Total Size:")) { this.line = this.line.replace("   Total Size:               ", ""); int z = this.line.indexOf("GB"); this.line = this.line.substring(0, z); main.DeviceDouble10 = Double.valueOf(this.line.trim()).doubleValue(); this.line = ("(" + this.line + "GB" + ")");
/*     */           }
/* 252 */           this.disk10 = (this.disk10 + this.line + " ");
/* 253 */           main.DeviceRoot = "disk10";
/*     */         }
/*     */       }
/* 255 */       if (this.disk10 != "") this.disk10 += "disk10";  } catch (Exception localException10)
/*     */     {
/*     */     }
/* 258 */     int y = 0;
/*     */     try
/*     */     {
/* 262 */       DrivesPath = new File(main.class.getResource("Drives.txt").getFile()).toString();
/* 263 */       Formatter Drives = new Formatter(DrivesPath.replace("%20", " "));
/*     */ 
/* 266 */       if ((this.disk1 != null) && (this.disk1.endsWith("1"))) Drives.format("%s\n", new Object[] { this.disk1 });
/* 267 */       if ((this.disk2 != null) && (this.disk2.endsWith("2"))) Drives.format("%s\n", new Object[] { this.disk2 });
/* 268 */       if ((this.disk3 != null) && (this.disk3.endsWith("3"))) Drives.format("%s\n", new Object[] { this.disk3 });
/* 269 */       if ((this.disk4 != null) && (this.disk4.endsWith("4"))) Drives.format("%s\n", new Object[] { this.disk4 });
/* 270 */       if ((this.disk5 != null) && (this.disk5.endsWith("5"))) Drives.format("%s\n", new Object[] { this.disk5 });
/* 271 */       if ((this.disk6 != null) && (this.disk6.endsWith("6"))) Drives.format("%s\n", new Object[] { this.disk6 });
/* 272 */       if ((this.disk7 != null) && (this.disk7.endsWith("7"))) Drives.format("%s\n", new Object[] { this.disk7 });
/* 273 */       if ((this.disk8 != null) && (this.disk8.endsWith("8"))) Drives.format("%s\n", new Object[] { this.disk8 });
/* 274 */       if ((this.disk9 != null) && (this.disk9.endsWith("9"))) Drives.format("%s\n", new Object[] { this.disk9 });
/* 275 */       if ((this.disk10 != null) && (this.disk10.endsWith("10"))) Drives.format("%s\n", new Object[] { this.disk10 });
/*     */ 
/* 277 */       Drives.close();
/*     */     }
/*     */     catch (Exception e) {
/* 280 */       System.out.println("Error writing to file from class ScanUSB");
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/henrymound/Documents/Linux USB Builder/Contents/Resources/Java/
 * Qualified Name:     ScanUSB
 * JD-Core Version:    0.6.2
 */