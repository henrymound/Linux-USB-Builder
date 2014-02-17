/*    */ import java.awt.FlowLayout;
/*    */ import java.io.PrintStream;
/*    */ import java.net.URL;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JEditorPane;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JScrollPane;
/*    */ 
/*    */ public class LastScreen
/*    */   implements Runnable
/*    */ {
/* 38 */   public static JEditorPane ThankYouText = new JEditorPane();
/* 39 */   public static JScrollPane ThankYou = new JScrollPane(ThankYouText);
/*    */   main main;
/*    */   FormatDriveBar FormatDriveBar;
/*    */   EraseDrive EraseDrive;
/* 45 */   public static JButton DonateButton = new JButton("Donate!");
/* 46 */   public static JButton Done = new JButton("Done");
/* 47 */   JLabel middle = new JLabel("                                                                                           ");
/*    */ 
/* 49 */   JLabel Logo4 = new JLabel(new ImageIcon(main.class.getResource("LogoScreen4.png").getFile().toString().replace("%20", " ").replace("file", "")));
/*    */ 
/*    */   public void run()
/*    */   {
/* 53 */     FlowLayout flo = new FlowLayout();
/* 54 */     System.out.println("Done Initialized");
/*    */ 
/* 56 */     DonateButton.addActionListener(new main());
/* 57 */     Done.addActionListener(new main());
/*    */ 
/* 59 */     main.frame.setVisible(true);
/* 60 */     main.frame.remove(main.logo3);
/* 61 */     main.frame.remove(EraseDrive.CenterPanel);
/* 62 */     main.frame.add("North", this.Logo4);
/* 63 */     main.frame.setDefaultCloseOperation(3);
/*    */ 
/* 65 */     main.South.setLayout(flo);
/* 66 */     main.South.removeAll();
/* 67 */     main.South.add(DonateButton);
/* 68 */     main.South.add(this.middle);
/* 69 */     main.South.add(Done);
/*    */     try {
/* 71 */       ThankYouText.setPage(LastScreen.class.getResource("LastPage.html")); } catch (Exception f) { System.out.println("Could not find file!"); }
/*    */ 
/* 73 */     ThankYouText.setEditable(false);
/*    */ 
/* 75 */     ThankYou.setVerticalScrollBarPolicy(22);
/* 76 */     ThankYou.setHorizontalScrollBarPolicy(31);
/*    */ 
/* 79 */     main.frame.add(ThankYou);
/*    */ 
/* 81 */     main.frame.repaint();
/* 82 */     main.frame.setVisible(true);
/*    */   }
/*    */ }

/* Location:           /Users/henrymound/Documents/Linux USB Builder/Contents/Resources/Java/
 * Qualified Name:     LastScreen
 * JD-Core Version:    0.6.2
 */