
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f4728548
 */
public class EnumReport {
    private class _1103 implements ReportItf {
        public String getInstance() {
            return "1103";
        }
    }
    
    private class _1105 implements ReportItf {
        public String getInstance() {
            return "1105";
        }
    }
    
    public EnumReport(String reportId) {
        
    }
    /*
    public ReportItf report1 = new _1103("1103");
    public ReportItf report2 = new _1105();
    
    public static void main(String[] args) {
        EnumReport er = new EnumReport();
        
    }*/
}
