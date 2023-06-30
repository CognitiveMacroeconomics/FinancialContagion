

import java.sql.*;

import java.util.ArrayList;

public class CDSBasisTradeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		CDSBasisTrade cbt = new CDSBasisTrade();
		double tg, opBasis, cp;
		double vol = 0.1;
		
		//Q1 2007 normura  CDO/CDS report spreads 
		double [][] ds2 = {{19, 34, 278, 942, 1415}, {99.5, 99.25, 92.42, 75.62, 66.62},
				{9, 15, 64, 224, 389}};
		double [] cs2 = {42, 78.52, 241.58, 522.79, 678.78};
		
		//Q1 2006 normura  CDO/CDS report spreads 
		double [][] ds = {{10, 22, 45, 121, 233}, {100.31, 100.36, 100.3, 101.06, 101.26},
				{18, 32, 54, 154, 267}};
		double [] cs = {25.8, 59.9, 118.52, 351.05, 410.84};

		//double [] erw = {0.2, 0.2, 0.5, 1, 1};
		double [] erw = {0.2, 0.2, 0.35, 1, 1};
		double crw = 0.2;
		
		//ArrayList d1 = cbt.openPosition(121.0, 351.05, 0.0, 101.06, 154);
		//ArrayList d1 = cbt.openPosition(146.62, 303.4756145, 0.0, 100.22, 154);
		
		//opBasis = 107.24;

		//for(int i = 0; i<d1.size(); i++){
		//	System.out.println(": " + d1.get(i));
		//}
		
		
		//tg = cbt.closePosition(1929, 602.0691353, opBasis, 1, 0);
		
		//System.out.println(": " + tg);
		
		
		double [][] btr = cbt.bankOpenNegativeBasisPos(ds, cs, erw, crw);
		
//		public double [][] bankCloseNegativeBasisPos(double[][] derivativeSpread, double[] cashSpread, 
//		double[][] basisTradeReport, double volatilityThreshold){
		double [][] btcr = cbt.bankCloseNegativeBasisPos(ds2, cs2, btr, vol);


		for(int i = 0; i<7; i++){
			for(int j = 0; j< btr[i].length; j++){
				System.out.println(": " + btr[i][j]);
			}
			
		}
		
		System.out.println("=========================================");
		System.out.println("=========================================");
		System.out.println("=========================================");
		System.out.println("=========================================");

		
		//BasisTradeDataController basisTradeDataController =new BasisTradeDataController();
		//ArrayList<String> labels = new ArrayList<String>();

		//String table=dataControllerAli.getDatabaseTableName("q1_07_", "RCFD2221");
		//String value= dataControllerAli.getValue("65241", "q1_07_","RCFD1707");
		//System.out.println(value);
		//labels=dataControllerAli.getVariablesList();
		//System.out.println(labels);
		
		
		
		double CHBAL = BasisTradeDataController.getCDSRisValue("484422","q1_07_","CHBAL");
		double ASSET = BasisTradeDataController.getCDSRisValue("484422","q1_07_","ASSET");
		double LIAB = BasisTradeDataController.getCDSRisValue("484422","q1_07_","LIAB");
		double EQ = BasisTradeDataController.getCDSRisValue("484422","q1_07_","EQ");
		double SCMTGBK = BasisTradeDataController.getCDSRisValue("484422","q1_07_","SCMTGBK");
		double CTDDFSWG = BasisTradeDataController.getCDSRisValue("484422","q1_07_","CTDDFSWG");
		double CTDDFSWB = BasisTradeDataController.getCDSRisValue("484422","q1_07_","CTDDFSWB");
		double RBCT1 = BasisTradeDataController.getCDSRisValue("484422","q1_07_","RBCT1");
		double RBCT2T = BasisTradeDataController.getCDSRisValue("484422","q1_07_","RBCT2T");
		double SZLNRES = BasisTradeDataController.getCDSRisValue("484422","q1_07_","SZLNRES");
		double SZLNRESHE = BasisTradeDataController.getCDSRisValue("484422","q1_07_","SZLNRESHE");
		double SZIORESTOT = BasisTradeDataController.getCDSRisValue("484422","q1_07_","SZIORESTOT");
		double SALE_AND_SPV_ENHANCEMENTS_RES = BasisTradeDataController.getCDSRisValue("484422","q1_07_","SALE_AND_SPV_ENHANCEMENTS_RES");
		double SIV_ENHANCEMENTS = BasisTradeDataController.getCDSRisValue("484422","q1_07_","SIV_ENHANCEMENTS");
		//LIAB ABCXBK ABCXOTH CHBAL CTDDFSWB CTDDFSWG DEP EQ SALE_AND_SPV_ENHANCEMENTS_RES SZIORES SZLNRES SZLNTOT SZLNRESHE SZIORESTOT SIV_ENHANCEMENTS
//		dataControllerAli.getCDSRisValue("480228","q1_07_","ASSET");
//		dataControllerAli.getCDSRisValue("480228","q1_07_","CHBAL");

//		System.out.println("=========================================");
//		System.out.println(tot);

		System.out.println("=========================================");
		System.out.println("=========================================");
		System.out.println("=========================================");
		System.out.println("=========================================");

		for(int i = 0; i<3; i++){
			for(int j = 0; j< btcr[i].length; j++){
				System.out.println(": " + btcr[i][j]);
			}
			
		}
		
		System.out.println("=========================================");
		System.out.println("=========================================");
		System.out.println("=========================================");
		System.out.println("=========================================");
		System.out.println("CHBAL: " +CHBAL);
		System.out.println("ASSET: " +ASSET); //CTDDFSWB CHBAL
		System.out.println("LIAB: " +LIAB);
		System.out.println("EQ: " +EQ);
		System.out.println("SCMTGBK: " +SCMTGBK);
		System.out.println("CTDDFSWG: " +CTDDFSWG);
		System.out.println("CTDDFSWB: " +CTDDFSWB);
		System.out.println("RBCT1: " +RBCT1);
		System.out.println("RBCT2T: " +RBCT2T);
		System.out.println("SZLNRES: " +SZLNRES);
		System.out.println("SZLNRESHE: " +SZLNRESHE);
		System.out.println("SZIORESTOT: " +SZIORESTOT);
		System.out.println("SALE_AND_SPV_ENHANCEMENTS_RES: " +SALE_AND_SPV_ENHANCEMENTS_RES);
		System.out.println("SIV_ENHANCEMENTS: " +SIV_ENHANCEMENTS);//SZIORESTOT
	}

}
