import java.util.ArrayList;

import javax.swing.JFrame;


public class CarryTradeStrategy {

	private double MBSdata_firstPeriod ;
	private double MBSdata_secondPeriod ;

	private ArrayList<String> ABX_Tranche = new ArrayList<String>();
	private ArrayList<Double> ABX_Gross_firstPeriod = new ArrayList<Double>();
	private ArrayList<Double> ABX_Net_firstPeriod = new ArrayList<Double>();
	private ArrayList<Integer> ABX_Contracts_firstPeriod = new ArrayList<Integer>();

	private ArrayList<Double> ABX_Gross_secondPeriod = new ArrayList<Double>();
	private ArrayList<Double> ABX_Net_secondPeriod = new ArrayList<Double>();
	private ArrayList<Integer> ABX_Contracts_secondPeriod = new ArrayList<Integer>();

	private ArrayList<Double> Bonds_Yield_firstPeriod = new ArrayList<Double>();
	private ArrayList<Double> Bonds_Yield_secondPeriod = new ArrayList<Double>();

	private ArrayList<Double> CDS_Spread_firstPeriod = new ArrayList<Double>();
	private ArrayList<Double> CDS_Spread_secondPeriod = new ArrayList<Double>();
	
	private ArrayList<Double> BaselII_RiskWeight = new ArrayList<Double>();
	
	private ArrayList<Double> BaselII_GainFromCapitalReduction = new ArrayList<Double>();
	

	private double Index_Total_Gross_firstPeriod;
	private double Index_Total_Net_firstPeriod;
	private int Index_Total_Contracts_firstPeriod;

	private double Index_Total_Gross_secondPeriod;
	private double Index_Total_Net_secondPeriod;
	private int Index_Total_Contracts_secondPeriod;


	private double perc = 0.1;
	private double percYield = 0.1;
	private double BaselII_capitalRequirement = 0.08;

	private double LIBOR_firstPeriod = 0.04;
	private double LIBOR_secondPeriod = 0.02;


	public CarryTradeStrategy ()
	{
//		this.getABX_Contracts_firstPeriod();
//		this.getABX_Contracts_secondPeriod();
//		this.getABX_Gross_firstPeriod();
//		this.getABX_Gross_secondPeriod();
//		this.getABX_Net_firstPeriod();
//		this.getABX_Gross_secondPeriod();
//		this.getABX_Tranche();
//		this.getBaselII_GainFromCapitalReduction();
//		this.getBaselII_RiskWeight();
//		this.getBonds_Yield_firstPeriod();
//		this.getBonds_Yield_secondPeriod();
//		this.getCDS_Spread_firstPeriod();
//		this.getCDS_Spread_secondPeriod();
	}
	
	
	private double getMBSdata_firstPeriod ()
	{
		
		return 130.328000;
	}



	private double getMBSdata_secondPeriod ()
	{
		return 130.328000 * this.perc;
	}



	public ArrayList<String> getABX_Tranche() {

		this.ABX_Tranche.add("ABX.HE.A.06");
		this.ABX_Tranche.add("ABX.HE.A.07");
		this.ABX_Tranche.add("ABX.HE.AA.06");
		this.ABX_Tranche.add("ABX.HE.AA.07");
		this.ABX_Tranche.add("ABX.HE.AAA.06");
		this.ABX_Tranche.add("ABX.HE.AAA.07");
		this.ABX_Tranche.add("ABX.HE.BBB.06");
		this.ABX_Tranche.add("ABX.HE.BBB.07");
		this.ABX_Tranche.add("ABX.HE.BBB-.06");
		this.ABX_Tranche.add("ABX.HE.BBB-.07");
		this.ABX_Tranche.add("ABX.HE.PENAAA.06");
		this.ABX_Tranche.add("ABX.HE.PENAAA.07");

		return ABX_Tranche;
	}
	
	



	public ArrayList<Double> getABX_Gross_firstPeriod() {

		this.ABX_Gross_firstPeriod.add(29.264847507);
		this.ABX_Gross_firstPeriod.add(10.459828623);
		this.ABX_Gross_firstPeriod.add(31.433997333);
		this.ABX_Gross_firstPeriod.add(13.505142810);
		this.ABX_Gross_firstPeriod.add(62.997277581);
		this.ABX_Gross_firstPeriod.add(36.072873000);
		this.ABX_Gross_firstPeriod.add(28.616762545);
		this.ABX_Gross_firstPeriod.add(5.927458649);
		this.ABX_Gross_firstPeriod.add(30.828003008);
		this.ABX_Gross_firstPeriod.add(9.248218041);
		this.ABX_Gross_firstPeriod.add(10.848024);
		this.ABX_Gross_firstPeriod.add(11.717855);

		return ABX_Gross_firstPeriod;
	}



	public ArrayList<Double> getABX_Net_firstPeriod() {
		return ABX_Net_firstPeriod;
	}



	public ArrayList<Integer> getABX_Contracts_firstPeriod() {

		this.ABX_Contracts_firstPeriod.add(1317);
		this.ABX_Contracts_firstPeriod.add(705);
		this.ABX_Contracts_firstPeriod.add(1833);
		this.ABX_Contracts_firstPeriod.add(743);
		this.ABX_Contracts_firstPeriod.add(3555);
		this.ABX_Contracts_firstPeriod.add(2209);
		this.ABX_Contracts_firstPeriod.add(1449);
		this.ABX_Contracts_firstPeriod.add(400);
		this.ABX_Contracts_firstPeriod.add(1751);
		this.ABX_Contracts_firstPeriod.add(654);
		this.ABX_Contracts_firstPeriod.add(700);
		this.ABX_Contracts_firstPeriod.add(597);

		return ABX_Contracts_firstPeriod;
	}




	public ArrayList<Double> getABX_Gross_secondPeriod() {

		this.ABX_Gross_secondPeriod.add(10.223294357);
		this.ABX_Gross_secondPeriod.add(2.586489600 + 0.603192000);
		this.ABX_Gross_secondPeriod.add(12.790756374);
		this.ABX_Gross_secondPeriod.add(4.405489245 + 1.058028000);
		this.ABX_Gross_secondPeriod.add(31.515961729);
		this.ABX_Gross_secondPeriod.add(9.910917368 + 4.734365000);
		this.ABX_Gross_secondPeriod.add(11.676089701);
		this.ABX_Gross_secondPeriod.add(2.055664001 + 0.147000000);
		this.ABX_Gross_secondPeriod.add(15.435604969);
		this.ABX_Gross_secondPeriod.add(3.422416520 + 0.175080000);
		this.ABX_Gross_secondPeriod.add(15.041267450);
		this.ABX_Gross_secondPeriod.add(3.505009645 + 1.831271500);

		return ABX_Gross_secondPeriod;
	}



	public ArrayList<Double> getABX_Net_secondPeriod() {
		return ABX_Net_secondPeriod;
	}



	public ArrayList<Integer> getABX_Contracts_secondPeriod() {

		this.ABX_Contracts_secondPeriod.add(307);
		this.ABX_Contracts_secondPeriod.add(75 + 46);
		this.ABX_Contracts_secondPeriod.add(532);
		this.ABX_Contracts_secondPeriod.add(210 + 50);
		this.ABX_Contracts_secondPeriod.add(1679);
		this.ABX_Contracts_secondPeriod.add(470 + 278);
		this.ABX_Contracts_secondPeriod.add(349);
		this.ABX_Contracts_secondPeriod.add(120 + 17);
		this.ABX_Contracts_secondPeriod.add(618);
		this.ABX_Contracts_secondPeriod.add(260 + 14);
		this.ABX_Contracts_secondPeriod.add(913);
		this.ABX_Contracts_secondPeriod.add(228 + 150);

		return ABX_Contracts_secondPeriod;
	}



	public double getIndex_Total_Gross_firstPeriod() {
		return 16248.124662008;
	}



	public double getIndex_Total_Net_firstPeriod() {
		return Index_Total_Net_firstPeriod;
	}



	public int getIndex_Total_Contracts_firstPeriod() {
		return 272122;
	}



	public double getIndex_Total_Gross_secondPeriod() {
		return 10788.149948806;
	}



	public double getIndex_Total_Net_secondPeriod() {
		return Index_Total_Net_secondPeriod;
	}



	public int getIndex_Total_Contracts_secondPeriod() {
		return 160589;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CarryTradeStrategy strategy = new CarryTradeStrategy();

//		double value = 0;
//
//
//		ArrayList<Double> array = strategy.getABX_Gross_firstPeriod();
//
//		for(int i = 0; i < array.size(); i ++)
//		{
//			value +=  array.get(i);
//		}
//
//		System.out.println("Gross first period = " + value);
//
//		value = 0;
//
//		array = strategy.getABX_Gross_secondPeriod();
//
//		for(int i = 0; i < array.size(); i ++)
//		{
//			value +=  array.get(i);
//		}
//
//		System.out.println("Gross second period = " + value);
//
//		value = 0;
//
//		ArrayList<Integer> array2 = strategy.getABX_Contracts_firstPeriod();
//
//		for(int i = 0; i < array2.size(); i ++)
//		{
//			value +=  array2.get(i);
//		}
//
//		System.out.println("Contracts first period = " + value);
//
//		value = 0;
//
//		array2 = strategy.getABX_Contracts_secondPeriod();
//
//		for(int i = 0; i < array2.size(); i ++)
//		{
//			value +=  array2.get(i);
//		}
//
//		System.out.println("Contracts second period = " + value);
		
		
		
		
		
		ArrayList<Double> step1 = strategy.getCarryTrade_Step1(strategy.getCDS_Spread_firstPeriod(), 
				strategy.getBonds_Yield_firstPeriod(), strategy.getBaselII_capitalRequirement());
		
		ArrayList<Double> step2 = strategy.getCarryTrade_Step2(step1);
		
		ArrayList<Double> step3 = strategy.getCarryTrade_Step3();
		
//		ArrayList<String> names = strategy.getABX_Tranche();
		
		
		for(int i = 0; i < step1.size(); i ++)
		{
			System.out.println(
//					names.get(i) + "," +
					step1.get(i)+ "," +
					step2.get(i) + "," + 
					step3.get(i)
					);
		}

	}



	public ArrayList<Double> getBonds_Yield_firstPeriod() {

		this.Bonds_Yield_firstPeriod.add(0.05);
		this.Bonds_Yield_firstPeriod.add(0.0517);
		this.Bonds_Yield_firstPeriod.add(0.04);
		this.Bonds_Yield_firstPeriod.add(0.0503);
		this.Bonds_Yield_firstPeriod.add(0.03);
		this.Bonds_Yield_firstPeriod.add(0.044);
		this.Bonds_Yield_firstPeriod.add(0.06);
		this.Bonds_Yield_firstPeriod.add(0.0642);
		this.Bonds_Yield_firstPeriod.add(0.15);
		this.Bonds_Yield_firstPeriod.add(0.16);
		this.Bonds_Yield_firstPeriod.add(0.02);
		this.Bonds_Yield_firstPeriod.add(0.025);

		return Bonds_Yield_firstPeriod;
	}

	public ArrayList<Double> getBonds_Yield_secondPeriod() {

		this.Bonds_Yield_secondPeriod.add(0.05 * (1-this.percYield));
		this.Bonds_Yield_secondPeriod.add(0.0517* (1-this.percYield));
		this.Bonds_Yield_secondPeriod.add(0.04* (1-this.percYield));
		this.Bonds_Yield_secondPeriod.add(0.0503* (1-this.percYield));
		this.Bonds_Yield_secondPeriod.add(0.03* (1-this.percYield));
		this.Bonds_Yield_secondPeriod.add(0.044* (1-this.percYield));
		this.Bonds_Yield_secondPeriod.add(0.06* (1-this.percYield));
		this.Bonds_Yield_secondPeriod.add(0.0642* (1-this.percYield));
		this.Bonds_Yield_secondPeriod.add(0.15* (1-this.percYield));
		this.Bonds_Yield_secondPeriod.add(0.16* (1-this.percYield));
		this.Bonds_Yield_secondPeriod.add(0.02* (1-this.percYield));
		this.Bonds_Yield_secondPeriod.add(0.025* (1-this.percYield));

		return Bonds_Yield_secondPeriod;
	}



	public ArrayList<Double> getCDS_Spread_firstPeriod() {

		this.CDS_Spread_firstPeriod.add(0.015);
		this.CDS_Spread_firstPeriod.add(0.016);
		this.CDS_Spread_firstPeriod.add(0.014);
		this.CDS_Spread_firstPeriod.add(0.015);
		this.CDS_Spread_firstPeriod.add(0.013);
		this.CDS_Spread_firstPeriod.add(0.014);
		this.CDS_Spread_firstPeriod.add(0.023);
		this.CDS_Spread_firstPeriod.add(0.03);
		this.CDS_Spread_firstPeriod.add(0.035);
		this.CDS_Spread_firstPeriod.add(0.036);
		this.CDS_Spread_firstPeriod.add(0.011);
		this.CDS_Spread_firstPeriod.add(0.013);

		return CDS_Spread_firstPeriod;
	}



	public ArrayList<Double> getCDS_Spread_secondPeriod() {

		this.CDS_Spread_secondPeriod.add(0.015 * (1+this.percYield));
		this.CDS_Spread_secondPeriod.add(0.016* (1+this.percYield));
		this.CDS_Spread_secondPeriod.add(0.014* (1+this.percYield));
		this.CDS_Spread_secondPeriod.add(0.015* (1+this.percYield));
		this.CDS_Spread_secondPeriod.add(0.013* (1+this.percYield));
		this.CDS_Spread_secondPeriod.add(0.014* (1+this.percYield));
		this.CDS_Spread_secondPeriod.add(0.023* (1+this.percYield));
		this.CDS_Spread_secondPeriod.add(0.03* (1+this.percYield));
		this.CDS_Spread_secondPeriod.add(0.035* (1+this.percYield));
		this.CDS_Spread_secondPeriod.add(0.036* (1+this.percYield));
		this.CDS_Spread_secondPeriod.add(0.011* (1+this.percYield));
		this.CDS_Spread_secondPeriod.add(0.013* (1+this.percYield));

		return CDS_Spread_secondPeriod;
	}
	
//	carry trade condition (negative values for profitability)
	public ArrayList<Double> getCarryTrade_Step1 (ArrayList<Double> CDS_spread, 
			ArrayList<Double> Bond_Yield, double r)
	{
		double value;
		ArrayList<Double> step1 = new ArrayList<Double>();
		
		this.getABX_Tranche();
		
		for(int i = 0; i < this.ABX_Tranche.size(); i ++)
		{
			value = CDS_spread.get(i) - Bond_Yield.get(i) - r;
			step1.add(value);
		}
		
		return step1;
	}
	
//	% profit from carry trade
	public ArrayList<Double> getCarryTrade_Step2 (ArrayList<Double> step1)
	{

		ArrayList<Double> step2 = new ArrayList<Double>();
		
		for(int i = 1; i < step1.size(); i ++)
		{
			if(step1.get(i) < 0)
			{	
				step2.add(step1.get(i) * (-1));
			}
			else
			{
				step2.add(0.0);
			}
		}
		
		return step1;
	}
	
//	% gain from capital redaction
	public ArrayList<Double> getCarryTrade_Step3 ()
	{
		return this.getBaselII_GainFromCapitalReduction();
	}
	
	
	
	public ArrayList<Double> getCarryTrade_Result1 (ArrayList<Double> step1, ArrayList<Double> step2)
	{
		ArrayList<Double> profit = new ArrayList<Double>();
		
		for(int i = 1; i < step1.size(); i ++)
		{
			profit.add(step1.get(i) * step2.get(i) * (-1));
		}
		
		return profit;
	}
	
//	public ArrayList<Double> getCarryTrade_step3 (ArrayList<Double> step1, ArrayList<Double> step2)
//	{
//		ArrayList<Double> profit = new ArrayList<Double>();
//		
//		for(int i = 1; i < step1.size(); i ++)
//		{
//			profit.add(step1.get(i) * step2.get(i) * (-1));
//		}
//		
//		return profit;
//	}



	public ArrayList<Double> getBaselII_RiskWeight() {
		
			this.BaselII_RiskWeight.add(0.35);
			this.BaselII_RiskWeight.add(0.35);
			this.BaselII_RiskWeight.add(0.2);
			this.BaselII_RiskWeight.add(0.2);
			this.BaselII_RiskWeight.add(0.2);
			this.BaselII_RiskWeight.add(0.2);
			this.BaselII_RiskWeight.add(0.75);
			this.BaselII_RiskWeight.add(0.75);
			this.BaselII_RiskWeight.add(1.0);
			this.BaselII_RiskWeight.add(1.0);
			this.BaselII_RiskWeight.add(0.35);
			this.BaselII_RiskWeight.add(0.35);

		
		return BaselII_RiskWeight;
	}



	public ArrayList<Double> getBaselII_GainFromCapitalReduction() {
		
		
		
		for(int i = 0; i < this.BaselII_RiskWeight.size(); i ++)
		{
			BaselII_GainFromCapitalReduction.add(this.BaselII_capitalRequirement * 
												 (1 - this.BaselII_RiskWeight.get(i)));
		}
		
		return BaselII_GainFromCapitalReduction;
	}



	public double getBaselII_capitalRequirement() {
		return BaselII_capitalRequirement;
	}

}
