/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import za.ac.unisa.cs.nlp.*;

/**
 *
 * @author F4728548
 */
public class N33865523_MinimumEditDistance {
    
    public static int min_edit_distance(String X, String Y) {
        //Initialize
        int i  = 0;
        int j = 0;
        int M = X.length();
        int N = Y.length();
           
        int[][] D = new int[M][N];
        
        D[i][0] = i;
        D[0][j] = j;
                
        for (i = 1; i<M; i++) {
            for (j = 1; j<N; j++) {
                int del = D[i-1][j] + 1;
                int ins = D[i][j-1] + 1;
                int subs = D[i-1][j-1] + ((X.charAt(i) == Y.charAt(j))?0:2); //Lavingshtein Distance
                int min = Math.min(ins, del);
                min = Math.min(min, subs);
                D[i][j] = min;
            }
        }
        return D[M-1][N-1];
    }
    
    public static void main(String[] args) {
        String applicant = "applicant";
        
        String source = "appointed";
        String source2 = "appliance";
        
        int edTA = min_edit_distance(applicant, source);
        int edTE =  min_edit_distance(applicant, source2);
        
        System.out.println("\t,__________________________________________________________________,");
        System.out.println("\t|+++++++++++++++++++MINIMUM EDIT DISTANCE REPORT+++++++++++++++++++|");
        System.out.println("\t'------------------------------------------------------------------'");
        System.out.printf("\n\t\tDISTANCE FROM '%s' TO '%s' is:%d.\n", applicant, source, edTA);
        System.out.printf("\t\tDISTANCE FROM '%s' TO '%s' is:%d\n\n", applicant, source2, edTE);
        System.out.printf("\t\t=>|'%s' is closer to '%s'|<=.\n",  applicant.toUpperCase(), ((edTA==edTE)?"both".toUpperCase():(edTA<edTE)?source.toUpperCase():source2.toUpperCase()));
        System.out.println("\t,__________________________________________________________________,");
        System.out.println("\t|#############END MINIMUM EDIT DISTANCE REPORT#####################|");
        System.out.println("\t'------------------------------------------------------------------'");
    }
    
}
