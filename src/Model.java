import java.awt.Color;
import java.util.ArrayList;

import org._3pq.jgrapht.graph.DirectedWeightedMultigraph;

import cern.colt.list.DoubleArrayList;
import cern.jet.stat.Descriptive;

import jas.engine.Sim;
import jas.engine.SimEngine;
import jas.engine.SimModel;
import jas.engine.gui.JAS;


public class Model extends SimModel {
	
	public int defaultBank = 0;
	public int orders = 10;
	public int time = 11;
	public double percMBS = 0.1;
	
	public int bankAffected;
	public double perc = .3;
	
	public boolean exp2 = true;
	public boolean isDefault = true;
	
	public String printOnFilePath =  ".\\results\\0812\\Exp3_04062009\\DB" + defaultBank + "\\";
	
//	public String printOnFilePath =  ".\\results\\0812\\MatrixTransformation1_CC_exp2\\OutsideEntityAffected_time_" + time + "\\";
	
	public boolean CoreCapitalConstraint = true;
	
	public ArrayList<double[][]> matrices;
	public ArrayList<Bank> banks;
	public ArrayList<Node> nodes;
	public ArrayList<Bar> inDegrees;
	public ArrayList<Bar> outDegrees;
	
	public ArrayList<Contagion> contagionList = new ArrayList<Contagion>();
	
//	public int SimEnd = 50;
	
	private DirectedWeightedMultigraph graph;
	public double[] share;
	
	private long totB, totG, CCs, initialTotB;
	
	private int [] DBs;
	
	Parameters param = new Parameters();
	
	FrameCDS frame = null;
	
	public Model (FrameCDS frame)
	{
		this.frame = frame;
	}
	
	public Model ()
	{
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SimEngine eng = new SimEngine();
		JAS jas = new JAS(eng);
		jas.setVisible(true);
		
		Model m = new Model ();
		eng.addModel(m);
		m.setParameters();

	}
	
	@Override
	public void setParameters() {
		// TODO Auto-generated method stub
		Sim.openProbe(this.param, "Parameters");
	}
	
	public void buildLinks (double [][] matrix)
	{
		for (int i = 0; i < matrix.length; i ++)
		{
			for(int j = 0; j < matrix.length; j ++)
			{
				nodes.get(i).removeRelation(nodes.get(j));
				
				if (matrix[i][j] > 0)
				{
					nodes.get(i).addRelation(nodes.get(j), matrix[i][j]);
				}
			}
			
			this.setNodeColour(nodes.get(i));
		}
		
		this.setNodeSize();
	}

	
	public void setNodeColour (Node node)
	{
		if (Sim.getAbsoluteTime() == 0)
		{

			if (node.getB() == 0 && node.getG() == 0)
				node.setColor(Color.gray);

			else if (node.getB() == 0 && node.getG() > 0)
			{
				System.out.println(node.toString());
				
				node.setColor(Color.red);
			}
			else if (node.getB() > 0 && node.getG() == 0)
				node.setColor(Color.blue);

			else if (node.getB() > 0 && node.getG() > 0 && 
					node.getB() > node.getG())
				node.setColor(Color.cyan);

			else if (node.getB() > 0 && node.getG() > 0 && 
					node.getB() < node.getG())
				node.setColor(Color.pink);

			else if (node.getB() > 0 && node.getG() > 0 && 
					node.getB() == node.getG())
				node.setColor(Color.white);

		}
		
		if(node.isDefaults())
			node.setColor(Color.black);
	}
	
	public void setNodeSize ()
	{
		for (int i = 0; i < share.length; i ++)
		{
			this.nodes.get(i).setSize((int)(share[i]*100)+10);
		}
		
	}

	@Override
	public void buildModel() {
		// TODO Auto-generated method stub
		
		
		Sim.getRnd().setSeed(Parameters.seed);
		
//		System.out.println("point 0");
		
//		printOnFilePath =  ".\\results\\Q1_2006\\15122009_AIG\\Exp2_DB" + param.DefaultingBank + "\\";
		printOnFilePath =  ".\\results\\Q4_2006\\15122009_AIG\\Exp2_DB" + param.DefaultingBank + "\\";
//		printOnFilePath =  ".\\results\\Q3_2007\\15122009_AIG\\Exp2_DB" + param.DefaultingBank + "\\";
//		printOnFilePath =  ".\\results\\Q4_2007\\15122009_AIG\\Exp2_DB" + param.DefaultingBank + "\\";
//		printOnFilePath =  ".\\results\\0812\\31032004\\rndUndirectedSpreadLimit_0.05_noGainCC\\lossCoverOnly\\DB" + param.DefaultingBank + "\\";
//		printOnFilePath =  ".\\results\\0812\\31122006\\rndUndirectedSpreadLimit_0.05_noGainCC\\lossCoverOnly\\DB" + Parameters.DefaultingBank + "\\";
//		printOnFilePath =  ".\\results\\0812\\31122007\\rndUndirectedSpreadLimit_0.05_noGainCC\\lossCoverOnly\\DB" + param.DefaultingBank + "\\";
//		printOnFilePath =  ".\\results\\Q4_2008\\15122009_AIG\\Exp2_DB" + param.DefaultingBank + "\\";
		
		this.defaultBank = Parameters.DefaultingBank - 1;
		
		this.percMBS = Parameters.percentageMBS;
		
		if (this.defaultBank < 0) this.isDefault = false;
		
		
		if (Parameters.Experiment == 1)
		{
			this.CoreCapitalConstraint = false;
			this.exp2 = false;
			
		}
		else if (Parameters.Experiment == 2)
		{
			this.CoreCapitalConstraint = true;
			this.exp2 = false;
		}
		else
		{
			this.CoreCapitalConstraint = true;
			this.exp2 = true;
		}
		
		graph = new DirectedWeightedMultigraph();
		
		banks = DataController.getBanks();
//		Bank bank = new Bank(000, "Outside Entity", 0, 0);
//		
//		banks.add(bank);
		
		contagionList = new ArrayList<Contagion>();
		
		nodes = new ArrayList<Node>();
		matrices = new ArrayList<double[][]>();
		inDegrees = new ArrayList<Bar>();
		outDegrees = new ArrayList<Bar>();
		
		this.share = Matrix.Shares(banks, true);
		
		double [] shareB = Matrix.Shares(banks, false);
		
		for (int i = 0; i < banks.size(); i ++)	{
			nodes.add(new Node(graph, i, banks.get(i), share[i], shareB[i]));
		}
		
		if(!Parameters.insuranceCompanies){
			//Assumptions 0.415 of all CDS outstanding is by Hedge funds and Insurance companies
			//split is 0.34 buy and 0.49 Sell
			//2004 BIS DATAORG 6396bn
			//Gross Notional Value
			nodes.add(new Node(graph, banks.size(), new Bank(000, "Outside Entity","Outside Entity", 178.3856136,	
					197.4983579,	19.74983579,0,0,DataController.getReferenceEntity_OE_Gross()*.7, 
					DataController.getReferenceEntity_OE_Net()*.7), 0, 0));
			//Gross Fair Value
//			//2004 BIS DATAORG 72.89963287bn
//			nodes.add(new Node(graph, banks.size(), new Bank(000, "Non Banks","Non Banks", 1.2493306,	
//					1.38318745,	0.013831875,0,0,DataController.getReferenceEntity_OE_Gross()*.7, 
//					DataController.getReferenceEntity_OE_Net()*.7), 0, 0));


			//2006 BIS Data 28650bn
			//Gross Notional Value
//			nodes.add(new Node(graph, banks.size(), new Bank(000, "Outside Entity","Outside Entity", 1238.665624,
//					1371.379798,13.71379798,0,0,DataController.getReferenceEntity_OE_Gross(), 
//					DataController.getReferenceEntity_OE_Net()), 0, 0));
			//Gross Fair Value
//			nodes.add(new Node(graph, banks.size(), new Bank(000, "Outside Entity","Outside Entity", 6.29756512,	
//					6.97230424,70,0,0,DataController.getReferenceEntity_OE_Gross(), 
//							DataController.getReferenceEntity_OE_Net()), 0, 0));
			//2007 BIS Data 57894bn
//			nodes.add(new Node(graph, banks.size(), new Bank(000, "Non US Banks","Non US Banks", 2217.339834,	
//					2454.911959,	24.54911959,0,0,DataController.getReferenceEntity_OE_Gross(), 
//					DataController.getReferenceEntity_OE_Net()*.7), 0, 0));
			
			//Gross Fair Value
			//2007Q4 BIS DATAORG 2019.87bn
//			nodes.add(new Node(graph, banks.size(), new Bank(000, "Non Banks","Non Banks", 76.89649994,
//					85.13541064,	0.851354106,0,0,DataController.getReferenceEntity_OE_Gross(), 
//					DataController.getReferenceEntity_OE_Net()), 0, 0));



			//2008ORG
//			nodes.add(new Node(graph, banks.size(), new Bank(000, "Outside Entity","Outside Entity", 3001.55,3164.42,70,0,0,DataController.getReferenceEntity_OE_Gross(), 
//					DataController.getReferenceEntity_OE_Net()), 0, 0));
		}
		else{

//			//Assumptions 0.415 of all CDS outstanding is by Hedge funds and Insurance companies
//			//split is 0.34 buy and 0.49 Sell
//			//Gross Notional Value
//			//2004 BIS DATAORG 6396bn
			this.banks.add(new Bank(000, "Insurance Companies","Insurance Companies", 50.96731816,	
					146.5310397,	14.65310397,0,0,DataController.getReferenceEntity_OE_Gross()*.3, 
					DataController.getReferenceEntity_OE_Net()*.3));
			
			nodes.add(new Node(graph, banks.size()-1, this.banks.get(banks.size()-1), 0, 0));
//			
//			//2004 BIS DATAORG 6396bn
			nodes.add(new Node(graph, banks.size(), new Bank(000, "Non US Banks","Non US Banks", 178.3856136,	
					197.4983579,	19.74983579,0,0,DataController.getReferenceEntity_OE_Gross()*.7, 
					DataController.getReferenceEntity_OE_Net()*.7), 0, 0));

//			
//			//Gross Fair Value
//			//2004 BIS DATAORG 72.89963287bn
//			this.banks.add(new Bank(000, "Insurance Companies","Insurance Companies", 0.3569516,	
//					1.02623585,	0.010262359,0,0,DataController.getReferenceEntity_OE_Gross()*.3, 
//					DataController.getReferenceEntity_OE_Net()*.3));
//			
//			nodes.add(new Node(graph, banks.size()-1, this.banks.get(banks.size()-1), 0, 0));
//			
//			//2004 BIS DATAORG 72.89963287bn
//			nodes.add(new Node(graph, banks.size(), new Bank(000, "Non Banks","Non Banks", 1.2493306,	
//					1.38318745,	0.013831875,0,0,DataController.getReferenceEntity_OE_Gross()*.7, 
//					DataController.getReferenceEntity_OE_Net()*.7), 0, 0));
		

			
			
			
			//2006 BIS Data 28650bn
			//Gross Notional
//			this.banks.add(new Bank(000, "Insurance Companies","Insurance Companies", 353.9044639,
//					1017.475334, 10.17475334,0,0,DataController.getReferenceEntity_OE_Gross()*.3, 
//					DataController.getReferenceEntity_OE_Net()*.3));
//			
//			nodes.add(new Node(graph, banks.size()-1, this.banks.get(banks.size()-1), 0, 0));
			
			//2006 BIS Data 28650bn
//			nodes.add(new Node(graph, banks.size(), new Bank(000, "Non US Banks","Non US Banks", 1238.665624,
//					1371.379798,	13.71379798,0,0,DataController.getReferenceEntity_OE_Gross()*.7, 
//					DataController.getReferenceEntity_OE_Net()*.7), 0, 0));

			//2006 BIS Data 470bn
			//Gross Fair Value
//			this.banks.add(new Bank(000, "Insurance Companies","Insurance Companies", 1.79930432,
//					5.17299992,	0.051729999,0,0,DataController.getReferenceEntity_OE_Gross()*.3, 
//					DataController.getReferenceEntity_OE_Net()*.3));
//			
//			nodes.add(new Node(graph, banks.size()-1, this.banks.get(banks.size()-1), 0, 0));
//			
//			//2006 BIS Data 4700bn
//			nodes.add(new Node(graph, banks.size(), new Bank(000, "Non Banks","Non Banks", 6.29756512,
//					6.97230424,	0.069723042,0,0,DataController.getReferenceEntity_OE_Gross()*.7, 
//					DataController.getReferenceEntity_OE_Net()*.7), 0, 0));

			
			//Gross Notional
//			//2007 BIS Data 57894bn
//			this.banks.add(new Bank(000, "Insurance Companies","Insurance Companies", 633.525667,	
//					1821.386293,	18.21386293,0,0,DataController.getReferenceEntity_OE_Gross()*.3, 
//					DataController.getReferenceEntity_OE_Net()*.3));
//			
//			nodes.add(new Node(graph, banks.size()-1, this.banks.get(banks.size()-1), 0, 0));
//			
//			//2007 BIS Data 57894bn
//			nodes.add(new Node(graph, banks.size(), new Bank(000, "Non US Banks","Non US Banks", 2217.339834,	
//					2454.911959,	24.54911959,0,0,DataController.getReferenceEntity_OE_Gross()*.7, 
//					DataController.getReferenceEntity_OE_Net()*.7), 0, 0));



			//Gross Fair Value
//			//2007Q4 BIS DATAORG 2019.87bn
//			this.banks.add(new Bank(000, "Insurance Companies","Insurance Companies", 21.97042855,
//					63.16498209,	0.631649821,0,0,DataController.getReferenceEntity_OE_Gross()*.3, 
//					DataController.getReferenceEntity_OE_Net()*.3));
//			
//			nodes.add(new Node(graph, banks.size()-1, this.banks.get(banks.size()-1), 0, 0));
//			
//			//2007Q4 BIS DATAORG 2019.87bn
//			nodes.add(new Node(graph, banks.size(), new Bank(000, "Non Banks","Non Banks", 76.89649994,
//					85.13541064,	0.851354106,0,0,DataController.getReferenceEntity_OE_Gross()*.7, 
//					DataController.getReferenceEntity_OE_Net()*.7), 0, 0));
			
			
			

			
//			//2008ORG
//			this.banks.add(new Bank(000, "Insurance Companies","Insurance Companies", 3001.55*.3,3164.42*.3,70*.3,0,0,DataController.getReferenceEntity_OE_Gross()*.3, 
//					DataController.getReferenceEntity_OE_Net()*.3));
//			
//			nodes.add(new Node(graph, banks.size()-1, this.banks.get(banks.size()-1), 0, 0));
//			
//			//2008ORG
//			nodes.add(new Node(graph, banks.size(), new Bank(000, "Non US Banks","Non US Banks", 3001.55*.7,3164.42*.7,70*.7,0,0,DataController.getReferenceEntity_OE_Gross()*.7, 
//					DataController.getReferenceEntity_OE_Net()*.7), 0, 0));
		}
		
		
		if(!Parameters.insuranceCompanies)
		{
			double [] shareOE = Matrix.SharesNodes(nodes, false);

			for(int i = 0; i < nodes.size(); i ++)
			{
				inDegrees.add(new Bar(i,0));
				outDegrees.add(new Bar(i,0));

				nodes.get(i).setBufferCC(shareOE[i]);

			}
		}
		else
		{
			double [] share_B = Matrix.SharesNodes(nodes, false);
			double [] share_G = Matrix.SharesNodes(nodes, true);

			for(int i = 0; i < nodes.size(); i ++)
			{
				inDegrees.add(new Bar(i,0));
				outDegrees.add(new Bar(i,0));

				nodes.get(i).setBufferCC(share_B[i]);
				nodes.get(i).setShare(share_B[i]);
				nodes.get(i).setShareG(share_G[i]);
			}
		}


//		matrices.add(Matrix.buildMatrix(banks));
		
		double [][] m = Matrix.matrixTransformationLinksShare(Matrix.buildMatrix(banks), share, false);
		
//		System.out.println("point 1");
		
		
		if(!Parameters.rndMatrixTest)
		{
			matrices.add(m);
//			matrices.add(m);
			matrices.add(this.copyMatrix(m));
		}
		else
		{
			if(Parameters.spreadBalance)
			{
				matrices.add(Matrix.matrixTransformationRndUndirected(m, this.connectivity(m), this.computeCDSSpread(), Parameters.spreadLimit));	
				matrices.add(Matrix.matrixTransformationRndUndirected(m, this.connectivity(m), this.computeCDSSpread(), Parameters.spreadLimit));
			}
			else
			{
				matrices.add(Matrix.matrixTransformationRndUndirected(m, this.connectivity(m)));	
				matrices.add(Matrix.matrixTransformationRndUndirected(m, this.connectivity(m)));	
			}

		}
			
//		Matrix.printCSV(matrices.get(1), "test.csv");
			
//		if (param.printOnFile) Matrix.printCSV(matrices.get(matrices.size() - 1), this.printOnFilePath + "InitialMatrix0.csv");
		
		Matrix.printCSV(matrices.get(matrices.size() - 1), this.printOnFilePath + "InitialMatrix0.csv");

		String name = "Time_" + time;

		String path = "0812\\DB" + defaultBank + "_time_" + time;

		Matrix.printCSV(matrices.get(0), ".\\results\\" + path + "\\matrix_" + name + ".csv");
		
		
		
		this.computeNettingCDS();
		
//		if (param.printOnFile) this.printNettingOnFile("InitialNettingCDS");
		
		this.printNettingOnFile("InitialNettingCDS");
				
		this.updateTotB_G();
		
		this.updateCharacteristicsOfBanks();
		
		this.initialTotB = this.totB;
		
		this.buildLinks(matrices.get(matrices.size() - 1));
		
		this.getBarsInDegrees();
		this.getBarsOutDegrees();
		
		
		nodes.get(nodes.size() - 1).setShape(2);
		nodes.get(nodes.size() - 1).setSize(50);
		
		this.updateCCs();
		
//		Bank defaults
		
		
		
		
		this.buildActions();
		
		
	}
	
	public void round0 ()
	{
		
			if (this.isDefault)
			{
				nodes.get(defaultBank).setLoss_CDScover(nodes.get(defaultBank).getCC()*(-1));
				nodes.get(defaultBank).setCC(0);
				nodes.get(defaultBank).setCC_last(0);
				
//				nodes.get(defaultBank).setPercChangeCC(-1);
//				this.defaultBank();
			}
			
			
			this.bankAffected = nodes.size() - 1;
			
			
			
			if (Parameters.OutsideEntityLoss > 0)
			{

				//		Bank is affected by a percentage of its G
				//		this.affectBankG(bankAffected, this.param.OutsideEntityLoss);


				//		Bank is affected by a percentage of its G and B as well
				this.affectBankGandB(bankAffected, Parameters.OutsideEntityLoss);
				
				this.contagionProcessOnDefaultingBanks_PercLoss(bankAffected, Parameters.OutsideEntityLoss);

			}
			
			
//			this.updateDefaultingBanks_NettingCC();
			if(Parameters.endogenousBufferCC) 
		    {
				this.updateDefaultingBanks_NettingCC_EndogenousThreshold();
		    }
		    else
		    {
		    	this.updateDefaultingBanks_NettingCC();
		    }
			
			this.contagionProcessOnDefaultingBanks_LossCoverOnly();
			
			if(!Parameters.lossCoverOnly)
			{
				if (!Parameters.concentrationRisk)
				{
					this.contagionProcessOnDefaultingBanks_MBSandSPV_OE();
				}
				else
				{
					this.contagionProcessOnDefaultingBanks_MBSandSPV_OE_ConcentrationRisk();
				}
			}
	}
	
	
	public void buildActions ()
	{
		
//		eventList.scheduleSimple(0, 1, this, "resetStep");
		
		eventList.scheduleSimple(0, 99999999, this, "round0");
		

		
//	    if (!this.exp2)eventList.scheduleSimple(1, 1, this, "updateDefaultingBanks");
//	    else eventList.scheduleSimple(1, 1, this, "updateDefaultingBanks2");
	    
		/**
		 * this sets the capital loss percentage
		 */
	    if(Parameters.endogenousBufferCC) //endogenousBufferCC is set to false so never called
	    {
	    	eventList.scheduleSimple(1, 1, this, "updateDefaultingBanks_NettingCC_EndogenousThreshold");
	    }
	    else //endogenousBufferCC is set to false so this is called
	    {
	    	eventList.scheduleSimple(1, 1, this, "updateDefaultingBanks_NettingCC");
	    }
//	    if(this.CoreCapitalConstraint && !param.lossCoverOnly) eventList.scheduleSimple(1, 1, this, "contagionProcess_CC_LossCoverAndSPV");
//	    else if(this.CoreCapitalConstraint && param.lossCoverOnly)eventList.scheduleSimple(1, 1, this, "contagionProcess_CC_LossCoverOnly");
	    
//	    if(this.CoreCapitalConstraint && !param.lossCoverOnly) eventList.scheduleSimple(1, 1, this, "contagionProcess_CC_LossCoverAndSPV");
//	    else if(this.CoreCapitalConstraint && param.lossCoverOnly)
	    eventList.scheduleSimple(1, 1, this, "contagionProcessOnDefaultingBanks_LossCoverOnly");
	    
	    if(!Parameters.lossCoverOnly)//lossCoverOnly is true so never called
	    {
	    	if (!Parameters.concentrationRisk)
	    	{
	    		eventList.scheduleSimple(0, 1, this, "contagionProcessOnDefaultingBanks_MBSandSPV");
	    	}
	    	else
	    	{
	    		eventList.scheduleSimple(0, 1, this, "contagionProcessOnDefaultingBanks_MBSandSPV_ConcentrationRisk");
	    	}
	    }	
	    
	    
//	    else eventList.scheduleSimple(1, 1, this, "contagionProcess");
	    
	    
	    if (Parameters.printOnFile)
	    {
	    	eventList.scheduleSimple(0, 1, this, "printMatrix");
	    	eventList.scheduleSimple(this.orders, 1, this, "printStatisticsOnFileInDegrees");
	    	eventList.scheduleSimple(this.orders, 1, this, "printStatisticsOnFileOutDegrees");
	    	eventList.scheduleSimple(this.orders, 1, this, "printNetCConFile");
	    	eventList.scheduleSimple(this.orders, 1, this, "printNettingOnFile");
	    	eventList.scheduleSimple(this.orders, 1, this, "printPercChangeCCOnFile");
	    	eventList.scheduleSimple(this.orders, 1, this, "printLossCDScoverOnFile");
	    	eventList.scheduleSimple(this.orders, 1, this, "printLossRefEntityOnFile");
	    	eventList.scheduleSimple(this.orders, 1, this, "printLossSPVOnFile");
	    	
	    }

	    
	    
	    eventList.scheduleSimple(0, 1, this, "updateCharacteristicsOfBanks");
	    eventList.scheduleSimple(0, 1, this, "updateTotB_G");
	    
	    eventList.scheduleSimple(0, 1, this, "updateCCs");
	    
	    
	    if (this.frame != null) eventList.scheduleSimple(0, 1, this.frame, "update");
	    
	    
	    
	    
	    eventList.scheduleSimple(0, 1, this, "updateLinks");
	    eventList.scheduleSimple(0, 1, this, "getBarsInDegrees");
	    eventList.scheduleSimple(0, 1, this, "getBarsOutDegrees");
	    eventList.scheduleSimple(0, 1, this, "computeNettingCDS");
	    
//	    print the defaulting banks (21st Sept 2009)
	    eventList.scheduleSimple(0, 1, this, "consolePrintBefaultingBanks");

	    eventList.scheduleCollection(1, 1, this.nodes, Node.class, "CC_CClastEqual");
	    
//	    eventList.scheduleSimple(0, 1, this, "getConcentrationRisk");
	    eventList.scheduleSystem(this.orders, Sim.EVENT_SIMULATION_END);
	    
	}
	
	public void affectBank ()
	{
		this.affectBankG(bankAffected, perc);
	}
	
	public void defaultBank ()
	{
		if (!this.exp2)matrices.add(Matrix.bankDefault(matrices.get(matrices.size() - 1), defaultBank));
		else matrices.add(Matrix.bankDefault2(matrices.get(matrices.size() - 1), defaultBank));
		
	}
	
	
	public void contagionProcess ()
	{

		matrices.add(Matrix.matrixTransformationLinksShare(Matrix.contagionProcessShareWithOutsideEntity(Matrix.getNewG(Matrix.getG(matrices.get(matrices.size() - 1)), 
				Matrix.getB(matrices.get(matrices.size() - 1)), Matrix.getB(matrices.get(matrices.size() - 2))),
				share, matrices.get(matrices.size() - 1)), share, false));


	}
	
	public void affectBankG (int bank, double perc)
	{
		for(int j = 0; j < nodes.size(); j ++)
		{
			matrices.get(matrices.size() - 1)[bank][j] *= (1 - perc);
		}
	}
	
	public void affectBankGandB (int bank, double perc)
	{
		for(int j = 0; j < nodes.size(); j ++)
		{
			matrices.get(matrices.size() - 1)[bank][j] *= (1 - perc);
			matrices.get(matrices.size() - 1)[j][bank] *= (1 - perc);
		}
	}
	
	public void updateDefaultingBanks ()
	{
		ArrayList<Node> dbs = new ArrayList<Node>();
		
		for (int i = 0; i < nodes.size() - 1; i ++)
		{
			if (nodes.get(i).getCC() <= 0 && !nodes.get(i).isDefaults())
			{
				dbs.add(nodes.get(i));
				nodes.get(i).setDefaults(true);
				nodes.get(i).setG(0);
				
				for(int j = 0; j < nodes.size(); j ++)
				{
					matrices.get(matrices.size() - 1)[i][j] = 0;
				}
//				System.out.println(nodes.get(i).getNamefull() + " defaults - CC = " + nodes.get(i).getCC());
			}
		}
		
		if (dbs.size() == 0) 
		{
			this.DBs = null;
		}
		else
		{
			int [] DB = new int [dbs.size()];

			for (int i = 0; i < DB.length; i ++)
			{
				DB[i] = dbs.get(i).getId();
			}

			this.DBs = DB;
		}
		
	}
	
	public void updateDefaultingBanks2 ()
	{
		ArrayList<Node> dbs = new ArrayList<Node>();
//		double [][] matrix = new double [matrices.get(matrices.size() - 1).length][matrices.get(matrices.size() - 1).length];
//		
//		for (int i = 0; i < matrix.length; i ++)
//		{
//			for (int j = 0; j < matrix.length; j ++)
//			{
//				matrix[i][j] = matrices.get(matrices.size() - 1)[i][j];
//			}
//		}
		
		for (int i = 0; i < nodes.size() - 1; i ++)
		{
			if (nodes.get(i).getCC() <= 0 && !nodes.get(i).isDefaults())
			{
				dbs.add(nodes.get(i));
				nodes.get(i).setDefaults(true);
				nodes.get(i).setG(0);
				
				for(int j = 0; j < nodes.size(); j ++)
				{
					matrices.get(matrices.size() - 1)[i][j] = 0;
					matrices.get(matrices.size() - 1)[j][i] = 0;
				}
//				System.out.println(nodes.get(i).getNamefull() + " defaults - CC = " + nodes.get(i).getCC());
			}
		}
		
//		matrices.add(matrix);
		
		if (dbs.size() == 0) 
		{
			this.DBs = null;
		}
		else
		{
			int [] DB = new int [dbs.size()];

			for (int i = 0; i < DB.length; i ++)
			{
				DB[i] = dbs.get(i).getId();
			}

			this.DBs = DB;
		}
		
	}
	
	/**
	 * sets the percentage change in core capital after a default
	 */
	public void updateDefaultingBanks_NettingCC ()
	{
		ArrayList<Node> dbs = new ArrayList<Node>();
		double [][] matrix = new double [matrices.get(matrices.size() - 1).length][matrices.get(matrices.size() - 1).length];
		
		for (int i = 0; i < matrix.length; i ++)
		{
			for (int j = 0; j < matrix.length; j ++)
			{
				matrix[i][j] = matrices.get(matrices.size() - 1)[i][j];
			}
		}
		
		double percLoss;
		
		for (int i = 0; i < nodes.size() - 1; i ++)
		{
			percLoss = 1 - (nodes.get(i).getCC()/nodes.get(i).getBank().getCC());
			
			nodes.get(i).setPercChangeCC(percLoss*(-1));
			
			if ( percLoss > Parameters.percentageCC
					&& !nodes.get(i).isDefaults())
			{
				dbs.add(nodes.get(i));
				nodes.get(i).setDefaults(true);
				nodes.get(i).setG(0);
				
				for(int j = 0; j < nodes.size(); j ++)
				{
					matrix[i][j] = 0;
					matrix[j][i] = 0;
				}
//				System.out.println(nodes.get(i).getNamefull() + " defaults - CC = " + nodes.get(i).getCC());
			}
		}
		
		matrices.add(matrix);
		
		if (dbs.size() == 0) 
		{
			this.DBs = null;
		}
		else
		{
			int [] DB = new int [dbs.size()];

			for (int i = 0; i < DB.length; i ++)
			{
				DB[i] = dbs.get(i).getId();
			}

			this.DBs = DB;
		}
		
	}
	
	public void updateDefaultingBanks_NettingCC_EndogenousThreshold ()
	{
		ArrayList<Node> dbs = new ArrayList<Node>();
		double [][] matrix = new double [matrices.get(matrices.size() - 1).length][matrices.get(matrices.size() - 1).length];
		
		for (int i = 0; i < matrix.length; i ++)
		{
			for (int j = 0; j < matrix.length; j ++)
			{
				matrix[i][j] = matrices.get(matrices.size() - 1)[i][j];
			}
		}
		
		double percLoss;
		
		for (int i = 0; i < nodes.size() - 1; i ++)
		{
			percLoss = 1 - (nodes.get(i).getCC()/nodes.get(i).getBank().getCC());
			
			nodes.get(i).setPercChangeCC(percLoss*(-1));
			
			double thresh = Math.max(nodes.get(i).getBufferCC(), Parameters.endogenousBufferCC_min);
			
			if ( percLoss > thresh && !nodes.get(i).isDefaults())
			{
				dbs.add(nodes.get(i));
				nodes.get(i).setDefaults(true);
				nodes.get(i).setG(0);
				
				for(int j = 0; j < nodes.size(); j ++)
				{
					matrix[i][j] = 0;
					matrix[j][i] = 0;
				}
//				System.out.println(nodes.get(i).getNamefull() + " defaults - CC = " + nodes.get(i).getCC());
			}
		}
		
		matrices.add(matrix);
		
		if (dbs.size() == 0) 
		{
			this.DBs = null;
		}
		else
		{
			int [] DB = new int [dbs.size()];

			for (int i = 0; i < DB.length; i ++)
			{
				DB[i] = dbs.get(i).getId();
			}

			this.DBs = DB;
		}
		
	}
	
	public void contagionProcess_CC ()
	{
		
		

		matrices.add(Matrix.matrixTransformationLinksShare(Matrix.contagionProcessShareWithOutsideEntity(Matrix.getNewG_CC
				(Matrix.getG(matrices.get(matrices.size() - 1)), 
				Matrix.getB(matrices.get(matrices.size() - 1)), Matrix.getB(matrices.get(matrices.size() - 2)), this.nodes, 
				this.DBs, this.percMBS),
				share, matrices.get(matrices.size() - 1)), share, false));


	}
	
	public void contagionProcess_CC_LossCoverOnly ()
	{
		
		

		matrices.add(Matrix.matrixTransformationLinksShare(Matrix.contagionProcessShareWithOutsideEntity(Matrix.getNewG_CC_lossCoverOnly
				(Matrix.getG(matrices.get(matrices.size() - 1)), 
				Matrix.getB(matrices.get(matrices.size() - 1)), Matrix.getB(matrices.get(matrices.size() - 2)), this.nodes, 
				this.DBs, this.percMBS, matrices.get(matrices.size() - 2)),
				share, matrices.get(matrices.size() - 1)), share, false));


	}
	
	public void contagionProcess_CC_LossCoverAndSPV ()
	{
		
		

		matrices.add(Matrix.matrixTransformationLinksShare(Matrix.contagionProcessShareWithOutsideEntity(Matrix.getNewG_CC_lossCoverAndSPV
				(Matrix.getG(matrices.get(matrices.size() - 1)), 
				Matrix.getB(matrices.get(matrices.size() - 1)), Matrix.getB(matrices.get(matrices.size() - 2)), this.nodes, 
				this.DBs, this.percMBS, matrices.get(matrices.size() - 2)),
				share, matrices.get(matrices.size() - 1)), share, false));


	}
	
	public void updateLinks ()
	{
//		nodes.get(nodes.size() - 1).setXY(nodes.get(nodes.size() - 1).getSize()/2, nodes.get(nodes.size() - 1).getSize()/2);
		
		this.buildLinks(this.matrices.get(this.matrices.size() - 1));
	}
	
	public void updateCharacteristicsOfBanks()
	{
		double[] B = Matrix.getB(matrices.get(matrices.size() - 1));
		double[] G = Matrix.getG(matrices.get(matrices.size() - 1));
		
		for (int i = 0; i < nodes.size(); i ++)
		{
			nodes.get(i).setB(B[i]);
			nodes.get(i).setG(G[i]);
		}
		

	}
	
	public void updateTotB_G ()
	{
		this.totB = this.totG = 0;
		
		for(int i = 0; i < nodes.size(); i ++)
		{
			this.totB += nodes.get(i).getB();
			this.totG += nodes.get(i).getG();
		}
		
//		System.out.println(totB);
	}
	
	public String getDefaultBankName ()
	{
		if (this.defaultBank < 0) return "30% off OE";
		else return nodes.get(this.defaultBank).getName();
	}

	
	public void getBarsInDegrees ()
	{
		
		for(int i = 0; i < inDegrees.size(); i ++)
		{
			inDegrees.get(i).value =0;
		}
				
		for(int i = 0; i < nodes.size(); i ++)
		{
			inDegrees.get(nodes.get(i).getIncidentInEdges().size()).value +=1;
		}
		

	
	}
	
	public void getBarsOutDegrees ()
	{

		for(int i = 0; i < outDegrees.size(); i ++)
		{
			outDegrees.get(i).value =0;
		}
		
		for(int i = 0; i < nodes.size(); i ++)
		{
			outDegrees.get(nodes.get(i).getIncidentOutEdges().size()).value +=1;
		}
		

	
	}

	public DirectedWeightedMultigraph getGraph() {
		return graph;
	}
	
	
	public void contagionProcessOnDefaultingBanks_PercLoss (int bankAffected, double perc)
	{
		
		double netting;
		
		double [][] matrix = matrices.get(matrices.size() - 2);
		
		
		

		for(int i = 0; i < nodes.size() - 1; i ++)
		{

			if (!nodes.get(i).isDefaults())
			{
				netting = matrix[i][bankAffected]*perc 
				          - matrix[bankAffected][i]*perc;
				
				if (netting != 0)
				{
					this.contagionList.add(new Contagion (bankAffected, i, netting, Contagion.CDS_COVER)); 
					System.out.println("new contagion event");
					this.frame.getJTextArea_log().append(Sim.getAbsoluteTime() + " " + 
							this.nodes.get(this.bankAffected).getName() + 
							 " -> " + this.nodes.get(i).getName() + 
							 ":\t CDS cover loss " +
							 netting + "\n");
				}
				
				
				if (!Parameters.noCCgain)
				{
					nodes.get(i).setCC(nodes.get(i).getCC() + netting);
				}
				else if (netting < 0)
				{
					nodes.get(i).setCC(nodes.get(i).getCC() + netting);
					nodes.get(i).setLoss_CDScover(nodes.get(i).getLoss_CDScover() + netting);
				}

			}

		}
	}
	
	/**
	 * This method sets the total CDS cover loss and lost reserve capital 
	 * following the default of banks in the contagion chain
	 * multiply the variables netting and value by percentage losses realised to 
	 * get the Milne's required change regarding assumption of losses
	 */
	public void contagionProcessOnDefaultingBanks_LossCoverOnly (){
		double netting;
		double [][] matrix = matrices.get(matrices.size() - 2);

		for(int i = 0; i < nodes.size() - 1; i ++){

			if (!nodes.get(i).isDefaults()){
				netting = 0;
				if (this.DBs != null){	
					for (int d = 0; d < this.DBs.length; d ++){
						netting += (1- Parameters.recoveryRate)*(matrix[i][this.DBs[d]] - matrix[this.DBs[d]][i]);
						double value = (1- Parameters.recoveryRate)*(matrix[i][this.DBs[d]] - matrix[this.DBs[d]][i]);
						if (value != 0){
							this.contagionList.add(new Contagion (this.DBs[d], i, value, Contagion.CDS_COVER)); 
							System.out.println("new contagion event");
							this.frame.getJTextArea_log().append( 
									Sim.getAbsoluteTime() + " " + 
											this.nodes.get(this.DBs[d]).getName() + 
											" -> " + this.nodes.get(i).getName() + 
											":\t CDS cover loss " +
											value + "\n");
						}
					}
				}

				
				if (!Parameters.noCCgain){//not called as noCCgain is true
					nodes.get(i).setCC(nodes.get(i).getCC() + netting);
				}
				else if (netting < 0){
					nodes.get(i).setCC(nodes.get(i).getCC() + netting);
					nodes.get(i).setLoss_CDScover(nodes.get(i).getLoss_CDScover() + netting);
				}
			}
		}
	}
	
	
	public void contagionProcessOnDefaultingBanks_MBSandSPV ()
	{
		
		double loss, loss1, loss2;
		double SPV = 0;
		double MBS = 0;
		
		double scale;
		
		if(this.DBs != null)
		{

			for (int i = 0; i < nodes.size(); i ++)
			{
				SPV += nodes.get(i).getSPV();
				MBS += nodes.get(i).getMBS();
			}

			scale = SPV/MBS;
			
			for(int i = 0; i <  nodes.size() - 1; i ++)
			{

				if (!nodes.get(i).isDefaults())
				{
					loss = 0;
					loss1 = 0;
					loss2 = 0;


					for (int d = 0; d < DBs.length; d ++)
					{

						loss += (nodes.get(DBs[d]).getBank().getReferenceEntity_gross() * nodes.get(i).getShareG()) +	
							 scale * nodes.get(i).getMBS() * (nodes.get(DBs[d]).getSPV() / SPV);
						
						loss1 += nodes.get(DBs[d]).getBank().getReferenceEntity_gross() * nodes.get(i).getShareG();
						loss2 += scale * nodes.get(i).getMBS() * (nodes.get(DBs[d]).getSPV() / SPV);
						
						
						double value = (nodes.get(DBs[d]).getBank().getReferenceEntity_gross() * nodes.get(i).getShareG()) +
						scale * nodes.get(i).getMBS() * (nodes.get(DBs[d]).getSPV() / SPV);
						
						double value1 =  nodes.get(DBs[d]).getBank().getReferenceEntity_gross() * nodes.get(i).getShareG();
						double value2 =  scale * nodes.get(i).getMBS() * (nodes.get(DBs[d]).getSPV() / SPV);
						
						if (value != 0) 
						{
							this.contagionList.add(new Contagion (this.DBs[d], i, value, Contagion.CDS_SPV_IMPACT)); 
							System.out.println("new contagion event");
							
							if (value1 != 0)
								this.frame.getJTextArea_log().append(Sim.getAbsoluteTime() + " " + 
										this.nodes.get(this.DBs[d]).getName() + 
										 " -> " + this.nodes.get(i).getName() + 
										 ":\t Reference Entity " +
										 value1 + "\n");
							
							if (value2 != 0)
								this.frame.getJTextArea_log().append(Sim.getAbsoluteTime() + " " + 
										this.nodes.get(this.DBs[d]).getName() + 
										 " -> " + this.nodes.get(i).getName() + 
										 ":\t SPV Enhancement " +
										 value2 + "\n");
						}
					}

					nodes.get(i).setCC(nodes.get(i).getCC() - loss);
					nodes.get(i).setLoss_RefEntity((nodes.get(i).getLoss_RefEntity() -loss1));
					nodes.get(i).setLoss_SPV((nodes.get(i).getLoss_SPV() -loss2));

				}

			}

			
		}
		
				
	}
	
	public void contagionProcessOnDefaultingBanks_MBSandSPV_ConcentrationRisk ()
	{
		
		double loss, loss1, loss2;
		double SPV = 0;
		double MBS = 0;
		
		double scale;
		
		if(this.DBs != null)
		{

			for (int i = 0; i < nodes.size(); i ++)
			{
				SPV += nodes.get(i).getSPV();
				MBS += nodes.get(i).getMBS();
			}

			scale = SPV/MBS;
			
			for(int i = 0; i <  nodes.size() - 1; i ++)
			{

				if (!nodes.get(i).isDefaults())
				{
					loss = 0;
					loss1 = 0;
					loss2 = 0;
					double net, spread;


					for (int d = 0; d < DBs.length; d ++)
					{
						spread = nodes.get(DBs[d]).getBank().getReferenceEntity_gross() - 
						nodes.get(DBs[d]).getBank().getReferenceEntity_net();
						
						net = nodes.get(DBs[d]).getBank().getReferenceEntity_gross() - 
								(spread * this.getConcentrationRisk());

						loss += (net * nodes.get(i).getShareG()) +	
							 scale * nodes.get(i).getMBS() * (nodes.get(DBs[d]).getSPV() / SPV);
						
						loss1 += net * nodes.get(i).getShareG();
						loss2 += scale * nodes.get(i).getMBS() * (nodes.get(DBs[d]).getSPV() / SPV);
						
						
						double value = (net * nodes.get(i).getShareG()) +
						scale * nodes.get(i).getMBS() * (nodes.get(DBs[d]).getSPV() / SPV);
						
						double value1 =  net * nodes.get(i).getShareG();
						double value2 =  scale * nodes.get(i).getMBS() * (nodes.get(DBs[d]).getSPV() / SPV);
						
						if (value != 0) 
						{
							this.contagionList.add(new Contagion (this.DBs[d], i, value, Contagion.CDS_SPV_IMPACT)); 
							System.out.println("new contagion event");
							
							if (value1 != 0)
								this.frame.getJTextArea_log().append(Sim.getAbsoluteTime() + " " + 
										this.nodes.get(this.DBs[d]).getName() + 
										 " -> " + this.nodes.get(i).getName() + 
										 ":\t Reference Entity " +
										 value1 + "\n");
							
							if (value2 != 0)
								this.frame.getJTextArea_log().append(Sim.getAbsoluteTime() + " " + 
										this.nodes.get(this.DBs[d]).getName() + 
										 " -> " + this.nodes.get(i).getName() + 
										 ":\t SPV Enhancement " +
										 value2 + "\n");
						}
					}

					nodes.get(i).setCC(nodes.get(i).getCC() - loss);
					nodes.get(i).setLoss_RefEntity((nodes.get(i).getLoss_RefEntity() -loss1));
					nodes.get(i).setLoss_SPV((nodes.get(i).getLoss_SPV() -loss2));

				}

			}

			
		}
		
				
	}
	
	public void contagionProcessOnDefaultingBanks_MBSandSPV_OE ()
	{

		double loss, loss1, loss2;
		double SPV = 0;

		for (int i = 0; i < nodes.size(); i ++)
		{
			SPV += nodes.get(i).getSPV();
		}


		for(int i = 0; i <  nodes.size() - 1; i ++)
		{

			if (!nodes.get(i).isDefaults())
			{
				loss = 0;
				loss1 = 0;
				loss2 = 0;


				loss += (nodes.get(this.bankAffected).getBank().getReferenceEntity_gross() * Parameters.OutsideEntityLoss
						* nodes.get(i).getShareG()) +
				nodes.get(i).getMBS() * (nodes.get(this.bankAffected).getSPV() / SPV);

				
				loss1 += nodes.get(this.bankAffected).getBank().getReferenceEntity_gross() * Parameters.OutsideEntityLoss
				* nodes.get(i).getShareG();
				loss2 += nodes.get(i).getMBS() * (nodes.get(this.bankAffected).getSPV() / SPV);
				
				double value = (nodes.get(this.bankAffected).getBank().getReferenceEntity_gross() * Parameters.OutsideEntityLoss
						* nodes.get(i).getShareG()) +
				nodes.get(i).getMBS() * (nodes.get(this.bankAffected).getSPV() / SPV);

				double value1 =  nodes.get(this.bankAffected).getBank().getReferenceEntity_gross() * Parameters.OutsideEntityLoss
				* nodes.get(i).getShareG();
				double value2 =  nodes.get(i).getMBS() * (nodes.get(this.bankAffected).getSPV() / SPV);
				
				
				
				if (value != 0) 
				{
					this.contagionList.add(new Contagion (this.bankAffected, i, value, Contagion.CDS_SPV_IMPACT)); 
					System.out.println("new contagion event");
					
					if (value1 != 0)
						this.frame.getJTextArea_log().append(Sim.getAbsoluteTime() + " " + 
								this.nodes.get(this.bankAffected).getName() + 
								 " -> " + this.nodes.get(i).getName() + 
								 ":\t Reference Entity " +
								 value1 + "\n");
					
					if (value2 != 0)
						this.frame.getJTextArea_log().append(Sim.getAbsoluteTime() + " " + 
								this.nodes.get(this.bankAffected).getName() + 
								 " -> " + this.nodes.get(i).getName() + 
								 ":\t SPV Enhancement " +
								 value2 + "\n");
				}


				nodes.get(i).setCC(nodes.get(i).getCC() - loss);
				nodes.get(i).setLoss_RefEntity((nodes.get(i).getLoss_RefEntity() -loss1));
				nodes.get(i).setLoss_SPV((nodes.get(i).getLoss_SPV() -loss2));

			}

		}





	}
	
	public void contagionProcessOnDefaultingBanks_MBSandSPV_OE_ConcentrationRisk ()
	{

		double loss, loss1, loss2;
		double SPV = 0;

		for (int i = 0; i < nodes.size(); i ++)
		{
			SPV += nodes.get(i).getSPV();
		}


		for(int i = 0; i <  nodes.size() - 1; i ++)
		{

			if (!nodes.get(i).isDefaults())
			{
				loss = 0;
				loss1 = 0;
				loss2 = 0;
				double net, spread;

				
				
				spread = nodes.get(bankAffected).getBank().getReferenceEntity_gross() -
				nodes.get(bankAffected).getBank().getReferenceEntity_net();
				
				net = nodes.get(bankAffected).getBank().getReferenceEntity_gross() - 
					(spread * (1-nodes.get(bankAffected).getBufferCC()));
				
				
				loss += (net * Parameters.OutsideEntityLoss
						* nodes.get(i).getShareG()) +
				nodes.get(i).getMBS() * (nodes.get(this.bankAffected).getSPV() / SPV);

				
				loss1 += net * Parameters.OutsideEntityLoss
				* nodes.get(i).getShareG();
				loss2 += nodes.get(i).getMBS() * (nodes.get(this.bankAffected).getSPV() / SPV);
				
				double value = (net * Parameters.OutsideEntityLoss
						* nodes.get(i).getShareG()) +
				nodes.get(i).getMBS() * (nodes.get(this.bankAffected).getSPV() / SPV);

				double value1 =  net * Parameters.OutsideEntityLoss
				* nodes.get(i).getShareG();
				double value2 =  nodes.get(i).getMBS() * (nodes.get(this.bankAffected).getSPV() / SPV);
				
				
				
				if (value != 0) 
				{
					this.contagionList.add(new Contagion (this.bankAffected, i, value, Contagion.CDS_SPV_IMPACT)); 
					System.out.println("new contagion event");
					
					if (value1 != 0)
						this.frame.getJTextArea_log().append(Sim.getAbsoluteTime() + " " + 
								this.nodes.get(this.bankAffected).getName() + 
								 " -> " + this.nodes.get(i).getName() + 
								 ":\t Reference Entity " +
								 value1 + "\n");
					
					if (value2 != 0)
						this.frame.getJTextArea_log().append(Sim.getAbsoluteTime() + " " + 
								this.nodes.get(this.bankAffected).getName() + 
								 " -> " + this.nodes.get(i).getName() + 
								 ":\t SPV Enhancement " +
								 value2 + "\n");
				}


				nodes.get(i).setCC(nodes.get(i).getCC() - loss);
				nodes.get(i).setLoss_RefEntity((nodes.get(i).getLoss_RefEntity() -loss1));
				nodes.get(i).setLoss_SPV((nodes.get(i).getLoss_SPV() -loss2));

			}

		}





	}
	
	
	public void printMatrix ()
	{
		String name =  this.printOnFilePath  + "matrix_Time_" + this.time + "_DB=" +defaultBank+ "_Order_" + (matrices.size() - 2) + ".csv";
		
		Matrix.printCSV(matrices.get(matrices.size() - 1), name);

	}
	
	public void updateCCs ()
	{
		long cc = this.CCs;
		
		this.CCs = 0;
		
		
		
		for(int i = 0; i < this.nodes.size(); i ++)
		{
			this.CCs += ((int) (nodes.get(i).getCC() *100))/100;
		}
		
		if (this.CCs > cc && cc >0) this.CCs = cc;
	}
	
		
	
	public double clusterCoeff (double [][] matrix, int node)
	{
		ArrayList<Integer> neighbours = new ArrayList();
		int k = 0;
		boolean isNeighbour;
		
		
		for (int i = 0; i < matrix.length; i ++)
		{
			isNeighbour = false;
			
			if (matrix[node][i] > 0)
			{
				isNeighbour = true;
				k++;
			}
			if (matrix[i][node] > 0)
			{
				isNeighbour = true;
				k++;
			}
			
			if (isNeighbour) neighbours.add(i);
		}
		
		int count = 0;
		
		if (neighbours.size() <= 1) return 1;
		else
		{
			for (int i = 0; i < neighbours.size(); i ++)
			{
				for (int j = 0; j < neighbours.size(); j ++)
				{
					if (matrix[neighbours.get(i)][neighbours.get(j)] > 0)
					{
						count ++;
					}
				}
			}

			return (double)count/(double)(neighbours.size()*(neighbours.size()-1));
		}
		
	}
	
	
	public double clusterCoeff (double [][] matrix)
	{
		double cc = 0;
		
		for (int i = 0; i < matrix.length; i ++)
		{
			cc += this.clusterCoeff(matrix, i);
		}
		
		return cc/matrix.length;
	}
	
	public double connectivity (double [][] matrix)
	{
		int k = 0;
		
		for (int i = 0; i < matrix.length; i ++)
		{
			for (int j = 0; j < matrix.length; j ++)
			{
				if (matrix[i][j] > 0) k ++; 
			}
		}
		
		return (double) k / (matrix.length * (matrix.length - 1));
	}
	
	
	public DoubleArrayList getStatisticListIN ()
	{
		DoubleArrayList list =  new DoubleArrayList();

		int sum = 0;
		int numDBs = 0;

		for (int i = 0; i < nodes.size(); i ++)
		{
			list.add(nodes.get(i).getIncidentInEdges().size());
			sum += nodes.get(i).getIncidentInEdges().size();
			if(nodes.get(i).isDefaults()) numDBs ++;
		}
		
		return list;
	}
	
	public DoubleArrayList getStatisticListOUT ()
	{
		DoubleArrayList list =  new DoubleArrayList();

		int sum = 0;
		int numDBs = 0;

		for (int i = 0; i < nodes.size(); i ++)
		{
			list.add(nodes.get(i).getIncidentOutEdges().size());
			sum += nodes.get(i).getIncidentOutEdges().size();
			if(nodes.get(i).isDefaults()) numDBs ++;
		}
		
		return list;
	}
	
	public ArrayList<Double> getStatisticsIN ()
	{
		DoubleArrayList list = getStatisticListIN ();
		
		ArrayList<Double> stat = new ArrayList<Double>();
		
		double mean = Descriptive.mean(list);
		double variance = Descriptive.sampleVariance(list, mean);
		double std = Math.sqrt(variance);
//		double skewness = Descriptive.sampleSkew(list, mean, variance)*0.69575312;
//		double kurtosis = Descriptive.sampleKurtosis(list, mean, variance)*0.504584486;
		double skewness = Descriptive.sampleSkew(list, mean, variance);
		double kurtosis = Descriptive.sampleKurtosis(list, mean, variance);
		double connectivity = this.connectivity(matrices.get(matrices.size() - 1));
		double cc = this.clusterCoeff(matrices.get(matrices.size() - 1));
		
		stat.add(mean);
		stat.add(variance);
		stat.add(std);
		stat.add(skewness);
		stat.add(kurtosis);
		stat.add(connectivity);
		stat.add(cc);
		
		
		return stat;
	}
	
	public ArrayList<Double> getStatisticsOUT ()
	{
		DoubleArrayList list = getStatisticListOUT ();
		
		ArrayList<Double> stat = new ArrayList<Double>();
		
		double mean = Descriptive.mean(list);
		double variance = Descriptive.sampleVariance(list, mean);
		double std = Math.sqrt(variance);
//		double skewness = Descriptive.sampleSkew(list, mean, variance)*0.671847493;
//		double kurtosis = Descriptive.sampleKurtosis(list, mean, variance)*0.434403828;
		double skewness = Descriptive.sampleSkew(list, mean, variance);
		double kurtosis = Descriptive.sampleKurtosis(list, mean, variance);
		double connectivity = this.connectivity(matrices.get(matrices.size() - 1));
		double cc = this.clusterCoeff(matrices.get(matrices.size() - 1));
		
		stat.add(mean);
		stat.add(variance);
		stat.add(std);
		stat.add(skewness);
		stat.add(kurtosis);
		stat.add(connectivity);
		stat.add(cc);
		
		return stat;
	}
	
	
	
	public void printStatisticsOnFileInDegrees ()
	{
		DoubleArrayList list =  new DoubleArrayList();
		
		int sum = 0;
		int numDBs = 0;
		
		for (int i = 0; i < nodes.size(); i ++)
		{
			list.add(nodes.get(i).getIncidentInEdges().size());
			sum += nodes.get(i).getIncidentInEdges().size();
			if(nodes.get(i).isDefaults()) numDBs ++;
		}
		
		double mean = Descriptive.mean(list);
		double variance = Descriptive.sampleVariance(list, mean);
		double std = Math.sqrt(variance);
		double skewness = Descriptive.sampleSkew(list, mean, variance);
		double kurtosis = Descriptive.sampleKurtosis(list, mean, variance);
//		double connectivity = (double) (2 * sum) / (nodes.size() * (nodes.size() - 1));
		double connectivity = this.connectivity(matrices.get(matrices.size() - 1));
		double percLossB = (double)(this.initialTotB - this.totB)/this.initialTotB;
		double cc = this.clusterCoeff(matrices.get(matrices.size() - 1));
		
		
		
		String text = mean + "," +
						std + "," +
						skewness + "," +
						kurtosis + "," +
						connectivity  + "," +
						cc + "," +
						percLossB + "," +
						numDBs;
		
		Matrix.printCSV(text, this.printOnFilePath + "statisticsInDegrees.csv");
		
	}
	
	public void printStatisticsOnFileOutDegrees ()
	{
		DoubleArrayList list =  new DoubleArrayList();
		
		int sum = 0;
		int numDBs = 0;
		
		for (int i = 0; i < nodes.size(); i ++)
		{
			list.add(nodes.get(i).getIncidentOutEdges().size());
			sum += nodes.get(i).getIncidentOutEdges().size();
			if(nodes.get(i).isDefaults()) numDBs ++;
		}
		
		double mean = Descriptive.mean(list);
		double variance = Descriptive.sampleVariance(list, mean);
		double std = Math.sqrt(variance);
		double skewness = Descriptive.sampleSkew(list, mean, variance);
		double kurtosis = Descriptive.sampleKurtosis(list, mean, variance);
//		double connectivity = (double) (2 * sum) / (nodes.size() * (nodes.size() - 1));
		double connectivity = this.connectivity(matrices.get(matrices.size() - 1));
		double percLossB = (double)(this.initialTotB - this.totB)/this.initialTotB;
		double cc = this.clusterCoeff(matrices.get(matrices.size() - 1));
		
		
		
		String text = mean + "," +
						std + "," +
						skewness + "," +
						kurtosis + "," +
						connectivity  + "," +
						cc + "," +
						percLossB + "," +
						numDBs;
		
		Matrix.printCSV(text, this.printOnFilePath + "statisticsOutDegrees.csv");
		
	}
	
	public void printNetCConFile ()
	{
		
		String text0 = "" + nodes.get(0).getName();
		
		for (int i = 1; i < nodes.size() - 1; i ++)
		{
			text0 += "," + nodes.get(i).getName();
		}
		
		String text = "" + nodes.get(0).getCC();
			
		for (int i = 1; i < nodes.size() - 1; i ++)
		{
			text += "," + nodes.get(i).getCC();
		}
		
		Matrix.printCSV(text0 + "\n" + text, this.printOnFilePath + "netCC.csv");
	}
	
	public void printLossCDScoverOnFile ()
	{
		
		String text0 = "" + nodes.get(0).getName();
		
		for (int i = 1; i < nodes.size() - 1; i ++)
		{
			text0 += "," + nodes.get(i).getName();
		}
		
		String text = "" + nodes.get(0).getLoss_CDScover();
			
		for (int i = 1; i < nodes.size() - 1; i ++)
		{
			text += "," + nodes.get(i).getLoss_CDScover();
		}
		
		Matrix.printCSV(text0 + "\n" + text, this.printOnFilePath + "loss_CDScover.csv");
	}
	
	public void printLossRefEntityOnFile ()
	{
		
		String text0 = "" + nodes.get(0).getName();
		
		for (int i = 1; i < nodes.size() - 1; i ++)
		{
			text0 += "," + nodes.get(i).getName();
		}
		
		String text = "" + nodes.get(0).getLoss_RefEntity();
			
		for (int i = 1; i < nodes.size() - 1; i ++)
		{
			text += "," + nodes.get(i).getLoss_RefEntity();
		}
		
		Matrix.printCSV(text0 + "\n" + text, this.printOnFilePath + "loss_RefEntity.csv");
	}
	
	public void printLossSPVOnFile ()
	{
		
		String text0 = "" + nodes.get(0).getName();
		
		for (int i = 1; i < nodes.size() - 1; i ++)
		{
			text0 += "," + nodes.get(i).getName();
		}
		
		String text = "" + nodes.get(0).getLoss_SPV();
			
		for (int i = 1; i < nodes.size() - 1; i ++)
		{
			text += "," + nodes.get(i).getLoss_SPV();
		}
		
		Matrix.printCSV(text0 + "\n" + text, this.printOnFilePath + "loss_SPV.csv");
	}
	
	public void computeNettingCDS ()
	{
		double net;
		for (int i = 0; i < this.matrices.get(matrices.size() - 1).length; i ++)
		{
			net = 0;
			for (int j = 0; j < this.matrices.get(matrices.size() - 1).length; j ++)
			{
				net += this.matrices.get(matrices.size() - 1)[j][i] - this.matrices.get(matrices.size() - 1)[i][j];
			}
			
			this.nodes.get(i).setNetting(net);
		}
	}
	

	public void printNettingOnFile ()
	{
		
		String text0 = "" + nodes.get(0).getName();
		
		for (int i = 1; i < nodes.size() - 1; i ++)
		{
			text0 += "," + nodes.get(i).getName();
		}
		
		String text = "" + nodes.get(0).getNetting();
			
		for (int i = 1; i < nodes.size() - 1; i ++)
		{
			text += "," + nodes.get(i).getNetting();
		}
		
		Matrix.printCSV(text0 + "\n" + text, this.printOnFilePath + "netingCDS.csv");
	}
	
	public void printNettingOnFile (String name)
	{
		
		String text0 = "" + nodes.get(0).getName();
		
		for (int i = 1; i < nodes.size() - 1; i ++)
		{
			text0 += "," + nodes.get(i).getName();
		}
		
		String text = "" + nodes.get(0).getNetting();
			
		for (int i = 1; i < nodes.size() - 1; i ++)
		{
			text += "," + nodes.get(i).getNetting();
		}
		
		Matrix.printCSV(text0 + "\n" + text, this.printOnFilePath + name + ".csv");
	}
	
	public void printPercChangeCCOnFile ()
	{
		
		String text0 = "" + nodes.get(0).getName();
		
		for (int i = 1; i < nodes.size() - 1; i ++)
		{
			text0 += "," + nodes.get(i).getName();
		}
		
		String text = "" + nodes.get(0).getPercChangeCC();
			
		for (int i = 1; i < nodes.size() - 1; i ++)
		{
			text += "," + nodes.get(i).getPercChangeCC();
		}
		
		Matrix.printCSV(text0 + "\n" + text, this.printOnFilePath + "PercChangeCC.csv");
	}
	
	public void printPercChangeCCOnFile (String name)
	{
		
		String text0 = "" + nodes.get(0).getName();
		
		for (int i = 1; i < nodes.size() - 1; i ++)
		{
			text0 += "," + nodes.get(i).getName();
		}
		
		String text = "" + nodes.get(0).getPercChangeCC();
			
		for (int i = 1; i < nodes.size() - 1; i ++)
		{
			text += "," + nodes.get(i).getPercChangeCC();
		}
		
		Matrix.printCSV(text0 + "\n" + text, this.printOnFilePath + name + ".csv");
	}
	
	public double [][] copyMatrix (double [][] matrix)
	{
		
		double[][] newMatrix = new double[matrix.length][matrix.length];
		
		for(int i = 0; i < matrix.length; i ++)
			for(int j = 0; j < matrix.length; j ++)
				newMatrix[i][j] = matrix[i][j];
		
		return newMatrix;
	}
	
	public double[] computeCDSSpread ()
	{
		double [] spread = new double [this.nodes.size()];
		
		for (int i = 0; i < spread.length; i ++)
		{
			spread[i] = Math.abs(this.nodes.get(i).getG() - this.nodes.get(i).getB())/Math.max(this.nodes.get(i).getG(), this.nodes.get(i).getB());
		}
		return spread;
	}
	
	public void consolePrintBefaultingBanks ()
	{
		if(this.DBs != null)
		{
			System.out.print("Round " + Sim.getAbsoluteTime() + ": " );

			for(int i = 0; i < this.DBs.length; i ++)
			{
				System.out.print(this.banks.get(this.DBs[i]).getNameshort() + ", ");
			}
			System.out.println();
		}
	}

	public long getCCs() {
		return CCs;
	}

	public int[] getDBs() {
		return DBs;
	}

	public long getTotB() {
		return totB;
	}

	public long getTotG() {
		return totG;
	}
	
	public void resetStep ()
	{
		this.contagionList = new ArrayList<Contagion>();
	}

	public void setTotB(long totB) {
		this.totB = totB;
	}

	public void setTotG(long totG) {
		this.totG = totG;
	}

	public void setCCs(long cs) {
		CCs = cs;
	}
	
	public double getConcentrationRisk()
	{
		double cr = 0;
		
		for (int i = 0; i < this.nodes.size(); i ++)
		{
			if (!nodes.get(i).isDefaults())
			{
				cr += nodes.get(i).getBufferCC();
			}
		}
//		cr += nodes.get(this.defaultBank).getBufferCC();
		
		System.out.println("CR = " + cr);
		return cr;
	}
	
	

}
