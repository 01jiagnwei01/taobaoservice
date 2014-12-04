package com.gxkj.taobaoservice.inibind;

import java.beans.PropertyEditorSupport;

import com.gxkj.taobaoservice.enums.UserLinkTypes;

public class UserLinkTypesBinder extends PropertyEditorSupport {
	public void setAsText(String text) throws IllegalArgumentException {        
       boolean found = false;
       for (UserLinkTypes d : UserLinkTypes.values()) {
            if (d.name().equals(text) ) {
               this.setValue(d);
               found = true;
               break;
           } 
      }

      if (found == false) {
          //错误的取值，我们默认为oracle类型，当然你也可以throws exception
           //this.setValue(DatabaseType.oracle);         }

      } 
    }
	public static void main(String[] args) {
		for (UserLinkTypes d : UserLinkTypes.values()) {
	       System.out.println( d.name());

	   }
	}
 


}
