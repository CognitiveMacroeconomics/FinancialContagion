

import java.util.ArrayList;

public class CDSBasisTrade extends BasisTrading{

	public CDSBasisTrade() {
		super();
		
	}
	
	
	public double [][] bankOpenNegativeBasisPos(double[][] derivativeSpread, double[] cashSpread, 
			double[] exposureRiskWeights, double counterPartyRiskWeight){
		
		

		/**
		 * 	Note that the credit ratings are defined as the columns and the spreads, price and coupons etc
		 *  are the rows in all the arrays used in this method.
		 *  
		 *  Also note that where the array being passed to this method contains asset class spreads, 
		 *  the row of all arrays, i.e. x[0][], should always contain the spreads of the asset
		 *  classes.
		 */
	
		//Part 1 compute capital saving on each tranche of Bonds/Securities held on balance sheet
		// assuming predefined CDS counter party credit rating and associated regulatory capital 
		// risk weight. (Note that in the case of an SPV under Basel II this would be the collateral
		// credit rating and risk weighting)
		double[] trancheSaving = computeTrancheSavings(exposureRiskWeights, counterPartyRiskWeight);
		
		
		//Part 2 compute daily funding gain or initial CDS Basis on each tranche of securities/bonds
		//held on balance sheet assuming CDS protection was bought.
		double [][] basisnCoupon = computeBasisCoupons(cashSpread, derivativeSpread);
		
		
		//Part 3 compute the net regulatory capital saving from buying protection against the 
		//bond tranches held on the balance sheet.
		double [] netCapSaving = computeNetCapSaving(trancheSaving, basisnCoupon);
		
		//Part 4 collect the computed CDS-Basis, net capital saving and initial coupons and
		//determing for each tranche if a negative basis trade is profitable.
		
		double [][] basisTradeReport = getBasisTradeReport(netCapSaving, trancheSaving, basisnCoupon);
		
		
		return basisTradeReport;
	}
	
	
	
	public double [][] bankCloseNegativeBasisPos(double[][] derivativeSpread, double[] cashSpread, 
			double[][] basisTradeReport, double volatilityThreshold){
		
		

		/**
		 * 	Note that the credit ratings are defined as the columns and the spreads, price and coupons etc
		 *  are the rows in all the arrays used in this method.
		 *  
		 *  Also note that where the array being passed to this method contains asset class spreads, 
		 *  the row of all arrays, i.e. x[0][], should always contain the spreads of the asset
		 *  classes.
		 */
	
		//Part 1 compute daily funding gain or initial CDS Basis on each tranche of securities/bonds
		//held on balance sheet assuming CDS protection was bought.
		double [][] basisnCoupon = computeBasisCoupons(cashSpread, derivativeSpread);
		
		
		//Part 2 produce trade unwind report based on opening basis, current basis and volatility threshold.
		double [][] basisTradeUnwindReport = getBasisTradeUnwindReport(basisTradeReport, basisnCoupon, volatilityThreshold);
		
		
		return basisTradeUnwindReport;
	}
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<UTILITY METHODS>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	private double[][] getBasisTradeUnwindReport(double[][] basisTradeReport,
			double[][] basisnCoupon, double volatilityThreshold) {
		/**
		 * Calculates the trade gain from a negative basis trade at the point of unwind and 
		 * determines if a negative basis trade should be closed or not based on some given 
		 * risk aversion measure.
		 */
		
		double [][] btor = new double[3][basisnCoupon[0].length];
		
		for(int i = 0; i < btor[0].length; i++){
			if((basisTradeReport[5][i] == 1.0) && (basisnCoupon[0][i] > basisTradeReport[0][i])
					&& (Math.abs(((basisnCoupon[0][i] - basisTradeReport[0][i])/ basisTradeReport[0][i])) 
							> volatilityThreshold)
							){
				//condition if a previous negative basis trade was made and the new basis has widened
				// i.e. positive or negative with an absolute value smaller than that of the old basis
				// i.e. the negative basis tends towards  zero or +infinity
				btor[0][i] = basisnCoupon[0][i] - basisTradeReport[0][i];
				btor[1][i] = 100*((basisnCoupon[0][i] - basisTradeReport[0][i])/Math.abs(basisTradeReport[0][i]));
				btor[2][i] = 1.0;
			}
			 else {
				if((basisTradeReport[5][i] == 1) && (basisnCoupon[0][i] < basisTradeReport[0][i])
						&& (((basisnCoupon[0][i] - basisTradeReport[0][i])/ basisTradeReport[0][i]) 
						> volatilityThreshold)
						){
					//condition if a previous negative basis trade was made and the new basis has narrowed
					// i.e. negative with an absolute value greater than that of the old basis 
					// i.e. the negative basis tends towards -infinity
					btor[0][i] = basisnCoupon[0][i] - basisTradeReport[0][i];
					btor[1][i] = 100*(basisnCoupon[0][i] - basisTradeReport[0][i])/basisTradeReport[0][i];
					btor[2][i] = 1.0;
				}
					else {
						btor[0][i] = basisnCoupon[0][i] - basisTradeReport[0][i];
						btor[1][i] = 100*(basisnCoupon[0][i] - basisTradeReport[0][i])/basisTradeReport[0][i];
						btor[2][i] = 0.0;
					}
			} 
		} 
		return btor;
	}

	private double[][] getBasisTradeReport(double[] netCapSaving,
			double[] trancheSaving, double[][] basisnCoupon) {
		/**
		 * this method produces the basis trade report strategy which the banks use to determine 
		 * whether or not to under take a negative basis trade.
		 */
		double [][] btr = new double[7][basisnCoupon[0].length];
		double sum = 0;
		
		for(int i = 0; i < btr[0].length; i++){
			btr[0][i] = basisnCoupon[0][i]; //add cds-basis to report
			btr[1][i] = basisnCoupon[1][i]; //add initial coupon to report
			btr[2][i] = trancheSaving[i]; // add regulatory capital saving
			btr[3][i] = netCapSaving[i]; // add net capital saving to report
			btr[4][i] = (-1*basisnCoupon[0][i]) + netCapSaving[i]; //add cds-basis to report
			
			//if(basisnCoupon[0][i] < 0 && netCapSaving[i] > 0){
			
			if(btr[4][i] > 0.0){
				
				 sum = sum + btr[4][i]; //if there is a negative basis and the net capital saving is positive
				//execute basis-trade;
				
			}
			
			
			//if(basisnCoupon[0][i] < 0 && netCapSaving[i] > 0){
			if(btr[4][i] > 0){
				btr[5][i] = 1.0; //if the total gain from trading is positive
				//execute basis-trade;
			}else{
				btr[5][i] = 0.0; //do not execute basis trade.
			}
			
		}
		//computed the portfolio weights to apply to each tranche of the basis trade
		for(int i = 0; i < btr[0].length; i++){
		
			if(btr[4][i] > 0.0){
			btr[6][i] = (btr[4][i]/sum); //portfolio weights are proportionate to the total income obtained from trade 
			}else{
			btr[6][i] = 0.0; //do not execute basis trade.
		
			}
		}
		


		return btr;
	}


	private double[] computeNetCapSaving(double[] trancheSaving,
			double[][] basisnCoupon) {
		/**
		 * computes the net regulatory capital saving
		 * i.e. regulatoy capital savings net of cost of opening the negative basis trade
		 */
		double [] ncs = new double [basisnCoupon[1].length];
		
		for(int i = 0; i < ncs.length; i++){
			ncs[i] = trancheSaving[i] - basisnCoupon[1][i];
		}
		
		return ncs;
	}


	private double[][] computeBasisCoupons(double[] cashSpread,
			double[][] derivativeSpread) {
		/**
		 * computed the CDS basis and initial coupon for buying credit protection
		 * given the CDS price and CDS spread and bond spreads
		 */
		//Note that the credit ratings are defined as the columns and the spreads, price and coupons are the rows.
		double [][] bt = new double [2][derivativeSpread[0].length];
		
		for(int i = 0; i < bt[0].length; i++){
			bt[0][i] = (derivativeSpread[0][i] - cashSpread[i])/10000; //CDS-Basis = (CDSSpread - bondSpread) 
																	//divide by 100 to convert to percentage
			
			bt[1][i] = ((100 - derivativeSpread[1][i]) +
					derivativeSpread[2][i])/10000; //initial coupon or cost of opening 
																	//the basis trade is (100 - CDSPrice(t)) + CDScoupon
																	//divide by 100 to convert to percentage.
		}
		return bt;
	}

	private double[] computeTrancheSavings(double[] exposureRiskWeights,
			double counterPartyRiskWeight) {
		/**
		 * computes the per tranche regulatory capital savings without accounting for the cost of 
		 * buying CDS protection.
		 */
		
		double[] trancheSaving = new double[exposureRiskWeights.length];
		
		for(int i = 0; i < exposureRiskWeights.length; i++){
			trancheSaving[i] = 0.08*(exposureRiskWeights[i] - counterPartyRiskWeight);
		}

		return trancheSaving ;
	}
	
	

	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SINGLE TRANCHE NON-BANK BASIS TRADE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	public ArrayList openPosition(double derivativeSpread, double cashSpread, double repoHedgeSpread, double  CDSPrice, double CDSCoupon){
		
		/**
		 * computes the CDS basis and initial coupon for buying credit protection using single tranche data inputs
		 */
		
		int negativeBasis, positiveBasis;
		double dailyFundingGain, protectionBuyPremium;
		
		//is there a negative basis or positive basis and what is the daily funding gain or daily carry?
		if(derivativeSpread < cashSpread){
			negativeBasis = 1;
			positiveBasis = 0;
			dailyFundingGain = -1*(derivativeSpread - cashSpread) - repoHedgeSpread;
		}else {
			negativeBasis = 0;
			positiveBasis = 1;
			dailyFundingGain = (derivativeSpread - cashSpread) - repoHedgeSpread;
		}
		
		//premium paid by protection buyer
		protectionBuyPremium = ((100 - CDSPrice) + CDSCoupon);
		
		
		this.tradeOpenPosition.add(negativeBasis); //[0,1] is there a negative bisis
		this.tradeOpenPosition.add(positiveBasis); //[0,1] is there a positive bisis
		this.tradeOpenPosition.add(dailyFundingGain); // value of negative/positive bisis which represents the daily gain/carry accrued from 
		//carrying out the basis trade.
		this.tradeOpenPosition.add(protectionBuyPremium); // this is the initial premium paid by the protection buyer to take on the basis trade
		this.tradeOpenPosition.add(CDSCoupon); // this is the regular coupon due on the CDS note defined at the start of the CDS contract
	
		return tradeOpenPosition; 
	}
	
	public double closePosition(double derivativeSpread, double cashSpread, double postionOpeningBasis, int nBasis, int pBasis){
		
		
		
		//was there a negative basis or positive basis at the opening of the trade position?
		//premium paid by protection buyer
		if(nBasis == 1 && pBasis == 0){
			
			TradeGain = (derivativeSpread - cashSpread)- (-1*postionOpeningBasis) ;
		} else if(nBasis == 0 && pBasis == 1){
			TradeGain = -1*((derivativeSpread - cashSpread)- postionOpeningBasis) ;

		}
		
		return TradeGain; 
	}


}
