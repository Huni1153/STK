import java.awt.*;
import javax.swing.*;
public class PaintLabel extends JLabel
{
   private String code;
   private String name;

   public PaintLabel(){
   }
   public PaintLabel(String code, String name){
      super(name);
      this.code = code;
   }

   public String getCode(){
      return this.code;
   }
   public String getName(){
      return this.name;
   }
}