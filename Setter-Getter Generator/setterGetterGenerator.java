import java.awt.*;
import java.awt.datatransfer.*;
import java.lang.reflect.*;

class setterGetterGenerator
{
public static void main(String ff[])
{
try
{
String finalCode="";
Class c=Class.forName(ff[0]);
Field fields[]=c.getDeclaredFields();
Field property;
for(int i=0;i<fields.length;i++)
{
property=fields[i];
Class propertyType=property.getType();
//System.out.println((i+1)+". "+property.getName()+" is of type : "+propertyType.getName());
String methodName=property.getName();
String setterMethodName="set"+String.valueOf(methodName.charAt(0)).toUpperCase()+methodName.substring(1);
String getterMethodName="get"+String.valueOf(methodName.charAt(0)).toUpperCase()+methodName.substring(1);
//System.out.println("Setter method = "+setterMethodName+"\nGetter method Name : "+getterMethodName);
//System.out.println("-------------");
String setterMethodDefination="public void "+setterMethodName+"("+propertyType.getName()+" "+property.getName()+")"+"\n"+"{"+"\n"+"this."+property.getName()+"="+property.getName()+";"+"\n"+"}";
//System.out.println(setterMethodDefination);
String getterMethodDefination="public "+propertyType.getName()+" "+getterMethodName+"("+")"+"\n"+"{"+"\n"+"return "+"this."+property.getName()+";"+"\n"+"}";
//System.out.println(getterMethodDefination);
finalCode+=(setterMethodDefination+"\n"+getterMethodDefination+"\n");
}
//System.out.println(finalCode);
StringSelection ss=new StringSelection(finalCode);
Clipboard clipboard;
clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
clipboard.setContents(ss,ss);
}catch(Exception e)
{
}
}
}