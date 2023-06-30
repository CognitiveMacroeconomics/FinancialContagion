
public class Parameters {
	
	public static int Experiment = 3;
	public static int DefaultingBank = 1;
	public static double OutsideEntityLoss = 0.0;
	public static double percentageCC = 0.2;
	public static double percentageMBS = 0.1;
	public static double recoveryRate = 0.0;
	
	public static boolean lossCoverOnly = true;
	public static boolean concentrationRisk = false;
	public static boolean insuranceCompanies = true;
	public static boolean rndMatrixTest = false;
	public static boolean printOnFile = true;
	public static boolean endogenousBufferCC = false;
	public static double endogenousBufferCC_min = 0.08;
	public static boolean noCCgain = true;
	public static boolean spreadBalance = false;
	public static double spreadLimit = .05;
	public static int seed = 77;
	
	public static String [] experimentsList (){
		String [] exp = {"CDS cover","CDS cover & CDS/SPV impact",
						 "CDS/SPV Concentration Risk"};
		return exp;
	}
	
	public static String [] dataList (){
		String [] data = {"Q1 2004"};
//		String [] data = {"Q4 2006"};
//		String [] data = {"Q3 2007"};
//		String [] data = {"Q4 2007"};
//		String [] data = {"Q4 2008"};
		return data;
	}
	
	public static String [] networksList (){
		String [] data = {"cluster","random"};
		return data;
	}
}
