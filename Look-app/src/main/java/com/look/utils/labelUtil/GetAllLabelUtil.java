package com.look.utils.labelUtil;

import com.look.picture.judgeLabel.model.judgetable;

/**
 * Created by gaohongming on 2017/6/6.
 */
public class GetAllLabelUtil {
    public static String getAllLabel(judgetable ju)
    {
        StringBuffer label=new StringBuffer();
        for (int i = 0; i <ju.getLabelNum() ; i++) {
            switch (i)
            {
                case 0:if(!ju.getFlag1().equals("E")) {label.append(ju.getLabel1()+"-");}else {break;}
                case 1:if(!ju.getFlag2().equals("E")) {label.append(ju.getLabel2()+"-");}else {break;}
                case 2:if(!ju.getFlag3().equals("E")) {label.append(ju.getLabel3()+"-");}else {break;}
                case 3:if(!ju.getFlag4().equals("E")) {label.append(ju.getLabel4()+"-");}else {break;}
                case 4:if(!ju.getFlag5().equals("E")) {label.append(ju.getLabel5()+"-");}else {break;}
                case 5:if(!ju.getFlag6().equals("E")) {label.append(ju.getLabel6()+"-");}else {break;}
                case 6:if(!ju.getFlag7().equals("E")) {label.append(ju.getLabel7()+"-");}else {break;}
                case 7:if(!ju.getFlag8().equals("E")) {label.append(ju.getLabel8()+"-");}else {break;}
                case 8:if(!ju.getFlag9().equals("E")) {label.append(ju.getLabel9()+"-");}else {break;}
                case 9:if(!ju.getFlag10().equals("E")) {label.append(ju.getLabel10()+"-");}else {break;}
            }
        }
        return label.toString();
    }
}
