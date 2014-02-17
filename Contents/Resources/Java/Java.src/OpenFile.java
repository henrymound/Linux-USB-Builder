/*    */ import java.awt.Component;
/*    */ import java.awt.HeadlessException;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.io.File;
/*    */ import java.io.PrintStream;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JDialog;
/*    */ import javax.swing.JFileChooser;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JList;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JScrollPane;
/*    */ import javax.swing.JTextArea;
/*    */ import javax.swing.filechooser.FileFilter;
/*    */ 
/*    */ public class OpenFile extends JPanel
/*    */   implements ActionListener
/*    */ {
/*    */   private static final String newline = "\n";
/*    */   public JButton openButton;
/*    */   JTextArea log;
/*    */   JFileChooser fc;
/*    */   static main main;
/*    */ 
/*    */   public OpenFile()
/*    */   {
/* 20 */     this.openButton = new JButton("Local Image...");
/*    */ 
/* 22 */     this.fc = new JFileChooser() { protected JDialog createDialog(Component parent) throws HeadlessException { JDialog dialog = super.createDialog(parent); dialog.setResizable(false); return dialog;
/*    */       }
/*    */     };
/* 25 */     this.fc.addChoosableFileFilter(new OpenFile.MyFilter());
/* 26 */     this.openButton.addActionListener(this);
/*    */   }
/*    */ 
/*    */   public void actionPerformed(ActionEvent e)
/*    */   {
/* 32 */     Object source = e.getSource();
/*    */ 
/* 34 */     if (source == this.openButton) {
/* 35 */       int returnVal = this.fc.showOpenDialog(this);
/*    */ 
/* 37 */       System.out.println("OK");
/* 38 */       if (returnVal == 0) {
/* 39 */         SetBool();
/* 40 */         main.file = this.fc.getSelectedFile();
/* 41 */         System.out.println(main.file);
/* 42 */         main.path = main.file;
/* 43 */         main.frame.remove(main.scroller);
/* 44 */         main.frame.remove(main.NoInternetPane);
/* 45 */         main.Version = "";
/* 46 */         main.ScanUSB();
/* 47 */         main.SelectUSB = new JList(main.USBDevices);
/* 48 */         main.SelectUSB.addListSelectionListener(new main());
/* 49 */         main.USBscroller = new JScrollPane(main.SelectUSB);
/* 50 */         main.South.removeAll();
/* 51 */         main.South.add(main.blank);
/* 52 */         main.South.add(main.NextSecondPage);
/* 53 */         main.frame.remove(main.logo);
/* 54 */         main.frame.add("North", main.logo2);
/* 55 */         main.frame.add(main.USBscroller);
/* 56 */         main.South.setEnabled(false);
/* 57 */         main.South.setEnabled(true);
/* 58 */         main.frame.setVisible(true);
/* 59 */         main.frame.repaint();
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void SetBool()
/*    */   {
/* 81 */     main.openFile = true;
/*    */   }
/*    */ 
/*    */   class MyFilter extends FileFilter
/*    */   {
/*    */     MyFilter()
/*    */     {
/*    */     }
/*    */ 
/*    */     public boolean accept(File file)
/*    */     {
/* 67 */       String filename = file.getName();
/* 68 */       if (file.isDirectory()) return filename.endsWith("");
/* 69 */       return filename.endsWith(".iso");
/*    */     }
/*    */ 
/*    */     public String getDescription()
/*    */     {
/* 75 */       return "*.iso";
/*    */     }
/*    */   }
/*    */ }

/* Location:           /Users/henrymound/Documents/Linux USB Builder/Contents/Resources/Java/
 * Qualified Name:     OpenFile
 * JD-Core Version:    0.6.2
 */