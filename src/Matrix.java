import jas.engine.Sim;
import jas.engine.SimEngine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Matrix {

	
	public static double [][] contagionProcessShare (double[] G, double[] s, double [][] matrixOld)
	{
		double [][] matrix = new double [s.length][G.length];
		
		for (int i = 0; i < s.length; i ++)
		{
			for (int j = 0; j < G.length; j ++)
			{
				if (matrixOld[i][j] > 0) matrix[i][j] = s[j] * G[i];
			}
		}

		
		matrix = Matrix.matrixTransformationOnG(matrix, G);
		
		return matrix;
		
	}
	
	public static double [][] contagionProcessShare (double[] G, double [] B, double[] s, boolean increaseDimension)
	{
		double [][] matrix = new double [s.length][s.length];
		
		double newG;
		
		for (int i = 0; i < s.length; i ++)
		{
			newG = 0;
			for (int j = 0; j < s.length; j ++)
			{
				if(i == j) matrix[i][j] = 0;
				else matrix[i][j] = s[j] * G[i];
				
				newG += matrix[i][j];
			}
//			matrix[s.length][G.length] = G[i] - newG;
			
//			System.out.println(matrix[s.length][G.length]);
			
			
		}
		
		matrix = Matrix.matrixTransformationOnB(matrix, B, increaseDimension);
		matrix = Matrix.matrixTransformationOnG(matrix, G);
		
		return matrix;
		
	}
	
	public static double [][] contagionProcessShareWithOutsideEntity (double[] G, double[] s, double [][] matrix_minus)
	{
		double [][] matrix = new double [s.length + 1][s.length + 1];
		
		double newG, lossOutsideEntity;
		
		for (int i = 0; i < s.length; i ++)
		{
			newG = 0;
			for (int j = 0; j < s.length; j ++)
			{
				if(i != j && matrix_minus[i][j] != 0) 
					matrix[i][j] = s[j] * G[i];
				else
					matrix[i][j] = 0;
			
				
				newG += matrix[i][j];
			}
//			matrix[s.length][G.length] = G[i] - newG;
			
//			System.out.println(matrix[s.length][G.length]);
			
			
		}
		
		matrix = Matrix.matrixTransformationOnG(matrix, G);
		
		for (int i = 0; i < s.length; i ++)
		{
			
			lossOutsideEntity = matrix_minus[i][matrix_minus.length - 1] - matrix[i][matrix.length - 1]; 

//			if (lossOutsideEntity < 0) System.out.println("ERROR: lossOutsideEntity < 0  at row " + i);

			matrix[matrix.length - 1][i] = matrix_minus[matrix_minus.length - 1][i] - lossOutsideEntity;


			if (matrix[matrix.length - 1][i] < 0) matrix[matrix.length - 1][i] = 0;
		}
		
		
		return matrix;
		
	}
	
	
	
	
	public static double [][] matrixTransformationOnB (double [][] matrix, double[] B, boolean insertOutsideEntity)
	{
		int out = 0;
		
		if (insertOutsideEntity) out++;
		
		double [][] newMatrix = new double [matrix.length + out][matrix.length + out];

		double count;
		
		for (int j = 0; j < matrix.length; j ++)
		{
			count = 0;
			
			for (int i = 0; i < matrix.length; i ++)
			{
				newMatrix[i][j] += matrix[i][j];
				count += newMatrix[i][j];
				
//				if (count > B[j]) 
//				{
//					newMatrix[i][j] -= (count - B[j]); 
//					i = B.length;
//					
////					count -= (count - B[j]);
//				}
			}
			
//			if (count == B[j])
//				System.out.println("\n\n" +j+"   \n");
			
		}
		
//		Matrix.printVector(Matrix.getB(newMatrix));
//		
//		
		double [] newB = Matrix.getB(newMatrix);
		
		
		
		
		for (int j = 0; j < matrix.length; j ++)
		{
			if (newB[j] < B[j]) newMatrix[newMatrix.length - 1][j] = (B[j] - newB[j]);
		}
		
//		Matrix.printVector(Matrix.getB(newMatrix));
//		System.out.println("\n__________________________________________________________________________\n");
		
//		Matrix.printCSV(newMatrix, ".\\results\\matrixFinalB.csv");
		
		return newMatrix;
	}
	
	public static double [][] matrixTransformationOnG (double [][] matrix, double[] G)
	{
		
		double[] newG = Matrix.getG(matrix);
		
		for (int i = 0; i < matrix.length - 1; i ++)
		{
			if (G[i] > newG[i]) matrix[i][matrix.length - 1] = G[i] - newG[i];
		}
		
		return matrix;
		
//		Matrix.printVector(Matrix.getG(newMatrix));
//		System.out.println("\n__________________________________________________________________________\n");
//		Matrix.printVector(Matrix.getB(newMatrix));
		
//		Matrix.printCSV(newMatrix, ".\\results\\matrixF.csv");
		
//		return newMatrix;
		
	}
	
	
	public static double [][] matrixTransformationRnd (double [][] matrix, double p)
	{
		
		class Link
		{
			int i,j;
			double p;
			
			Link (int i, int j, double p)
			{
				this.i = i;
				this.j = j;
				this.p = p;
			}
		}
		
		ArrayList<Link> linkList = new ArrayList<Link> ();
		
		double [][] newMatrix = new double [matrix.length][matrix.length];
		boolean [][] links = new boolean [matrix.length][matrix.length];
		
		double totCover = 0;
		double totP = 0;
			
		for (int i = 0; i < links.length; i ++)
		{
			for (int j = 0; j < links.length; j ++)
			{
				if (Sim.getRnd().getDblFromTo(0.0, 1.0) < p && j != i)
				{
					links[i][j] = true;
					double pp = Sim.getRnd().getDblFromTo(0.0, 1.0);
					linkList.add(new Link(i,j,pp));
					totP += pp;
//					System.out.println("link " + i + "-" + j);
					
				}
				else links[i][j] = false;
				
				totCover += matrix[i][j];
				newMatrix[i][j] = 0;
			}
		}
		
		
		for (int i = 0; i < linkList.size(); i ++)
		{
			newMatrix[linkList.get(i).i][linkList.get(i).j] = totCover * (linkList.get(i).p / totP);
		}
		
//		
//		
//		double cover = totCover;
//		
//		Collections.shuffle(linkList);
//		
//		while (cover > 0)
//		{
//			
//			System.out.println(cover);
//			
//			
//			
//			
//			
//			int row = Sim.getRnd().getIntFromTo(0, links.length - 1);
//			int col = Sim.getRnd().getIntFromTo(0, links.length - 1);
//			
//			while (!links[row][col])
//			{
//				col = Sim.getRnd().getIntFromTo(0, links.length - 1);
//			}
//			
//			double value = Sim.getRnd().getDblFromTo(0.0, (totCover / (links.length * links.length)));
//			
//			if (value > cover) value = cover;
//			
//			newMatrix[row][col] += value;
//			cover -= value;
//		}
//		
		return newMatrix;
		
		
	}
	
	
	public static double [][] matrixTransformationRndUndirected (double [][] matrix, double p)
	{
		
		class Link
		{
			int i,j;
			double p;
			
			Link (int i, int j, double p)
			{
				this.i = i;
				this.j = j;
				this.p = p;
			}
		}
		
		ArrayList<Link> linkList = new ArrayList<Link> ();
		
		double [][] newMatrix = new double [matrix.length][matrix.length];
		boolean [][] links = new boolean [matrix.length][matrix.length];
		
		double totCover = 0;
		double totP = 0;
			
		for (int i = 0; i < links.length; i ++){
			for (int j = i; j < links.length; j ++){
				if (Sim.getRnd().getDblFromTo(0.0, 1.0) < p && j != i){
					links[i][j] = true;
					links[j][i] = true;
					double pp = Sim.getRnd().getDblFromTo(0.0, 1.0);
					linkList.add(new Link(i,j,pp));
					totP += pp;
					pp = Sim.getRnd().getDblFromTo(0.0, 1.0);
					linkList.add(new Link(j,i,pp));
					totP += pp;
//					System.out.println("link " + i + "-" + j);
				}
				else{
					links[i][j] = false;
					links[j][i] = false;
				}
				totCover += matrix[i][j] + matrix[j][i];
				newMatrix[i][j] = 0;
				newMatrix[j][i] = 0;
			}
		}
		
		
		for (int i = 0; i < linkList.size(); i ++){
			newMatrix[linkList.get(i).i][linkList.get(i).j] = totCover * (linkList.get(i).p / totP);
		}
		
//		
//		
//		double cover = totCover;
//		
//		Collections.shuffle(linkList);
//		
//		while (cover > 0)
//		{
//			
//			System.out.println(cover);
//			
//			
//			
//			
//			
//			int row = Sim.getRnd().getIntFromTo(0, links.length - 1);
//			int col = Sim.getRnd().getIntFromTo(0, links.length - 1);
//			
//			while (!links[row][col])
//			{
//				col = Sim.getRnd().getIntFromTo(0, links.length - 1);
//			}
//			
//			double value = Sim.getRnd().getDblFromTo(0.0, (totCover / (links.length * links.length)));
//			
//			if (value > cover) value = cover;
//			
//			newMatrix[row][col] += value;
//			cover -= value;
//		}
//		
		return newMatrix;
		
		
	}
	
	public static double [][] matrixTransformationRndUndirected (double [][] matrix, double p, double[] spread, double spreadLimit)
	{
		
		class Link
		{
			int i,j;
			double p;
			
			Link (int i, int j, double p)
			{
				this.i = i;
				this.j = j;
				this.p = p;
			}
		}
		
		ArrayList<Link> linkList = new ArrayList<Link> ();
		
		double [][] newMatrix = new double [matrix.length][matrix.length];
		boolean [][] links = new boolean [matrix.length][matrix.length];
		
		double totCover = 0;
		double totP = 0;
			
		for (int i = 0; i < links.length; i ++)
		{
			for (int j = i; j < links.length; j ++)
			{
				if (Sim.getRnd().getDblFromTo(0.0, 1.0) < p && j != i)
				{
					links[i][j] = true;
					links[j][i] = true;
					double pp = Sim.getRnd().getDblFromTo(0.0, 1.0);
					linkList.add(new Link(i,j,pp));
					totP += pp;
					
					pp = Sim.getRnd().getDblFromTo(0.0, 1.0);
					linkList.add(new Link(j,i,pp));
					totP += pp;
					
//					System.out.println("link " + i + "-" + j);
					
				}
				else
				{
					links[i][j] = false;
					links[j][i] = false;
				}
					
				totCover += matrix[i][j] + matrix[j][i];
				newMatrix[i][j] = 0;
				newMatrix[j][i] = 0;
			}
		}
		
		
		for (int i = 0; i < linkList.size(); i ++)
		{
			newMatrix[linkList.get(i).i][linkList.get(i).j] = totCover * (linkList.get(i).p / totP);
		}
		
//		
//		
//		double cover = totCover;
//		
//		Collections.shuffle(linkList);
//		
//		while (cover > 0)
//		{
//			
//			System.out.println(cover);
//			
//			
//			
//			
//			
//			int row = Sim.getRnd().getIntFromTo(0, links.length - 1);
//			int col = Sim.getRnd().getIntFromTo(0, links.length - 1);
//			
//			while (!links[row][col])
//			{
//				col = Sim.getRnd().getIntFromTo(0, links.length - 1);
//			}
//			
//			double value = Sim.getRnd().getDblFromTo(0.0, (totCover / (links.length * links.length)));
//			
//			if (value > cover) value = cover;
//			
//			newMatrix[row][col] += value;
//			cover -= value;
//		}
//		
		
		
		return Matrix.matrixTransformationSpread(newMatrix, spread, spreadLimit);
		
		
	}
	
	
	public static double [][] matrixTransformationSpread (double[][] matrix, double[] spread, double spreadLimit)
	{
		
		double spr;
		double balance;
		
		for (int i = 0; i < matrix.length; i ++)
		{
			for (int j = i; j < matrix.length; j ++)
			{
				if (matrix[i][j] > 0)
				{
					spr = Math.abs((matrix[i][j] - matrix[j][i]))/ Math.max(matrix[i][j], matrix[j][i]);
					
					spr -= Math.min(spread[i],spreadLimit);
					balance = (Math.max(matrix[i][j], matrix[j][i]) * spr)/2;
					
					if (matrix[i][j] > matrix[j][i])
					{
						matrix[i][j] -= balance;
						matrix[j][i] += balance;
					}
					else
					{
						matrix[i][j] += balance;
						matrix[j][i] -= balance;
					}
					
					if(matrix[i][j] < 0) matrix[i][j] = 0;
					if(matrix[j][i] < 0) matrix[j][i] = 0;
					
				}
			}
		}
		
		return matrix;
		
	}
	
	
	public static double [][] matrixTransformationComplete (double [][] matrix)
	{
		
		class Link
		{
			int i,j;
			double p;
			
			Link (int i, int j, double p)
			{
				this.i = i;
				this.j = j;
				this.p = p;
			}
		}
		
		ArrayList<Link> linkList = new ArrayList<Link> ();
		
		double [][] newMatrix = new double [matrix.length][matrix.length];
		boolean [][] links = new boolean [matrix.length][matrix.length];
		
		double totCover = 0;
		double totP = 0;
			
		for (int i = 0; i < links.length; i ++)
		{
			for (int j = 0; j < links.length; j ++)
			{
				if (j != i)
				{
					links[i][j] = true;
					double pp = Sim.getRnd().getDblFromTo(0.0, 1.0);
					linkList.add(new Link(i,j,pp));
					totP += pp;
					
					
//					System.out.println("link " + i + "-" + j);
					
				}
				else
				{
					links[i][j] = false;
				}
					
				totCover += matrix[i][j];
				newMatrix[i][j] = 0;
			}
		}
		
		
		for (int i = 0; i < linkList.size(); i ++)
		{
			newMatrix[linkList.get(i).i][linkList.get(i).j] = totCover * (linkList.get(i).p / totP);
		}
		
//		
//		
//		double cover = totCover;
//		
//		Collections.shuffle(linkList);
//		
//		while (cover > 0)
//		{
//			
//			System.out.println(cover);
//			
//			
//			
//			
//			
//			int row = Sim.getRnd().getIntFromTo(0, links.length - 1);
//			int col = Sim.getRnd().getIntFromTo(0, links.length - 1);
//			
//			while (!links[row][col])
//			{
//				col = Sim.getRnd().getIntFromTo(0, links.length - 1);
//			}
//			
//			double value = Sim.getRnd().getDblFromTo(0.0, (totCover / (links.length * links.length)));
//			
//			if (value > cover) value = cover;
//			
//			newMatrix[row][col] += value;
//			cover -= value;
//		}
//		
		return newMatrix;
		
		
	}
	
	
	public static double [] getB (double [][] matrix)
	{
		double [] B = new double [matrix.length];

		for (int j = 0; j < matrix.length; j ++)
		{
			B[j] = 0;
			for (int i = 0; i < matrix.length; i ++)
			{
				B[j] += matrix[i][j];
			}
		}
		
		return B;
	}
	
	public static double [] getG (double [][] matrix)
	{
		double [] G = new double [matrix.length];

		for (int i = 0; i < matrix.length; i ++)
		{
			G[i] = 0;
			for (int j = 0; j < matrix.length; j ++)
			{
				G[i] += matrix[i][j];
			}
		}
		
		return G;
	}
	
	public static double [] getShare (double [] B)
	{
		double tot = 0;
		double [] s = new double [B.length];
		
		for (int i = 0; i < B.length; i ++)
		{
			tot += B[i];
		}
		
		for (int i = 0; i < B.length; i ++)
		{
			s[i] = B[i]/tot;
		}
		
		return s;
		
	}
	
	public static double [] getNewG (double [] G, double [] B_minus, double [] B_minus_minus)
	{
		double [] newG = new double [G.length];
		
		for(int i = 0; i < G.length; i ++)
		{
			
//			if(B_minus_minus[i] != B_minus[i]) newG[i] = G[i] - (B_minus_minus[i] - B_minus[i]);
			
			newG[i] = G[i] - (B_minus_minus[i] - B_minus[i]);
			
//			System.out.println("G=" + G[i] + "   newG=" + newG[i] + 
//					"  B-=" + B_minus[i] + "  B--=" + B_minus_minus[i]);
//			
			if (newG[i] < 0) newG[i] = 0;
		}
		
		return newG;
	}
	
	public static double [] getNewG_CC (double [] G, double [] B_minus, double [] B_minus_minus, ArrayList<Node> nodes, int [] DB, double perc)
	{
		double [] newG = new double [G.length];
		
		long SPV = 0;
		double constraint;
		double totLoss;
		double loss;
		
		
		if(DB != null)
		{

			for (int i = 0; i < nodes.size(); i ++)
			{
				SPV += nodes.get(i).getSPV();
			}


		}

		for(int i = 0; i < G.length; i ++)
		{



			loss = 0;


			if(DB != null)
			{
				for (int db = 0; db < DB.length; db ++)
				{
					loss += (nodes.get(i).getG() * nodes.get(DB[db]).getShareG()) +
					(perc * nodes.get(i).getMBS() * (nodes.get(DB[db]).getSPV() / SPV));

				}
			}

			constraint = B_minus_minus[i] - B_minus[i] + loss;

			nodes.get(i).setCC(nodes.get(i).getCC() - constraint);

			if(nodes.get(i).getCC() - constraint < 0)
			{
				totLoss = constraint - nodes.get(i).getCC();
			}
			else 
			{
				totLoss = 0;
			}


			if (G[i] > 0)
			{
				newG[i] = G[i] - totLoss;
			}

			if (newG[i] < 0) newG[i] = 0;




		}
		
		return newG;
	}
	
	
	public static double [] getNewG_CC_lossCoverOnly (double [] G, double [] B_minus, double [] B_minus_minus, ArrayList<Node> nodes, int [] DB, double perc, double [][] matrix)
	{
		double [] newG = new double [G.length];

		double constraint;
		double totLoss;
		double netting;
		

		for(int i = 0; i < G.length; i ++)
		{

			if (!nodes.get(i).isDefaults())
			{
				netting = 0;


				if (DB != null)
				{	
					for (int d = 0; d < DB.length; d ++)
					{
						netting += matrix[i][DB[d]];
					}
				}

				constraint = B_minus_minus[i] - B_minus[i];

				nodes.get(i).setCC(nodes.get(i).getCC() - constraint);

				if(nodes.get(i).getCC() - constraint + netting < 0)
				{
					totLoss = constraint - nodes.get(i).getCC();
				}
				else 
				{
					totLoss = 0;
				}


				if (G[i] > 0)
				{
					newG[i] = G[i] - totLoss;
				}

				if (newG[i] < 0) newG[i] = 0;


			}

		}
		
		return newG;
	}
	
	
	
	public static double [] getNewG_CC_lossCoverAndSPV (double [] G, double [] B_minus, double [] B_minus_minus, ArrayList<Node> nodes, int [] DB, double perc, double [][] matrix)
	{
		double [] newG = new double [G.length];

		double constraint;
		double totLoss;
		double netting;
		double loss;
		double SPV = 0;
		

		if(DB != null)
		{

			for (int i = 0; i < nodes.size(); i ++)
			{
				SPV += nodes.get(i).getSPV();
			}


		}
		
		for(int i = 0; i < G.length; i ++)
		{

			if (!nodes.get(i).isDefaults())
			{
				netting = 0;
				loss = 0;

				if (DB != null)
				{	
					for (int d = 0; d < DB.length; d ++)
					{
						netting += matrix[i][DB[d]];
						
						loss += (nodes.get(i).getG() * nodes.get(DB[d]).getShareG()) +
						(perc * nodes.get(i).getMBS() * (nodes.get(DB[d]).getSPV() / SPV));
					}
				}

				constraint = B_minus_minus[i] - B_minus[i] + loss;

				nodes.get(i).setCC(nodes.get(i).getCC() - constraint);

				if(nodes.get(i).getCC() - constraint + netting < 0)
				{
					totLoss = constraint - nodes.get(i).getCC();
				}
				else 
				{
					totLoss = 0;
				}


				if (G[i] > 0)
				{
					newG[i] = G[i] - totLoss;
				}

				if (newG[i] < 0) newG[i] = 0;


			}

		}
		
		return newG;
	}
	
	public static double[][] computeLinksMatrixCaseOne (ArrayList<Bank> banks)
    {
    	double[][] matrix = new double [banks.size()][banks.size()];
    	
    	for(int i=1; i< matrix.length; i++)
    	{
    		Bank bank = banks.get(i);
    		matrix[0][i] = bank.getCtddfswb();
    		matrix[i][0] = bank.getCtddfswg();
    	}
    	
    	return matrix;
    	
    }
	
	public static double[][] computeLinksMatrixCaseTwo (ArrayList<Bank> banks)
    {
    	double[][] matrix = new double [banks.size() + 1][banks.size() + 1];
    	long totValueB = 0;
    	long totValueG = 0;
    	double shareB, shareG;
    	double[][] netFlows = new double [banks.size()][2];
    	
    	double value = 0;
    	
    	for(int i=0; i< banks.size(); i++)
    	{
    		Bank bank = banks.get(i);
    		totValueB += bank.getCtddfswb();
    		totValueG += bank.getCtddfswg();
    		
    		netFlows[i][0] = bank.getCtddfswb();
    		netFlows[i][1] = bank.getCtddfswg();
    	}
    	
    	for(int i=0; i< matrix.length - 1; i++)
    	{
    		Bank bank1 = banks.get(i);
    		shareB = (double) bank1.getCtddfswb()/totValueB;
    		shareG = (double) bank1.getCtddfswg()/totValueG;
    		
    		for(int j=0; j< matrix.length - 1; j++)
        	{
    			Bank bank2 = banks.get(j);
    			
    			if (i != j)
    			{
    				value = shareB * bank2.getCtddfswg();
    				
    					if (netFlows[i][0] >= value)
    					{
    						matrix[j][i] = value;
    						netFlows[i][0] -= value;
    						netFlows[j][1] -= value;
    					}
    					else 
    					{
    						matrix[j][i] = netFlows[i][0];
    						netFlows[j][1] -= netFlows[i][0];
    						netFlows[i][0] = 0;
    					}
    			}
        	}	
    	}
    	
//    	for(int j=0; j< matrix.length - 1; j++)
//    	{
//    		matrix [j][matrix.length - 1] = netFlows[j][1];
//    		matrix [matrix.length - 1] [j] = netFlows[j][0];
//    	}
    	
    	
    	return matrix;
    	
    }
    
    public static void printMatrix (double [][] matrix)
    {
    	for (int i = 0; i < matrix.length; i ++)
    	{
    		if (i > 0) System.out.println();
    		
    		System.out.print(matrix[i][0]);
    		for (int j = 1; j < matrix.length; j ++)
    		{
    			System.out.print("," + matrix[i][j]);
    		}
    		
    	}
    }
    
    public static void printVector (double [] vector)
    {
    	
    	System.out.print(vector[0]);
    	for (int i = 1; i < vector.length; i ++)
    	{
    		System.out.print("," + vector[i]);
    		
    	}
    }
    
    
    public static void compareMatrices (double[][] m1, double[][] m2)
    {
    	
    	for(int i = 0; i < m1.length; i ++)
    		for(int j = 0; j < m2.length; j ++)
    			if(m1[i][j] < m2[i][j])
    				System.out.println("m1[" + i + "][" + j + "] is bigger than m2[.][.]" );
    }
    
    public static double [][] buildMatrix (ArrayList<Bank> banks)
    {
    	double [] G = new double [banks.size()];
    	double [] B = new double [banks.size()];
    	double [] s = new double [banks.size()];
    	
    	for(int i = 0; i < banks.size(); i ++)
    	{
    		Bank bank = banks.get(i);
    		G[i] += bank.getCtddfswg();
    		B[i] += bank.getCtddfswb();		
    	}
    	
    	s = Matrix.getShare(B);
    	
    	
//    	System.out.println("\n__________________________________________________________________________\n");
//    	Matrix.printVector(B);
//    	System.out.println("\n__________________________________________________________________________\n");
//    	Matrix.printVector(G);
//    	System.out.println("\n__________________________________________________________________________\n");
//    	Matrix.printVector(s);
    	
    	return Matrix.contagionProcessShare(G, B, s, true);
    }
    
    public static double [] Shares (ArrayList<Bank> banks, boolean BuySide)
    {
    	double [] G = new double [banks.size()];
    	double [] B = new double [banks.size()];
    	double [] s = new double [banks.size()];
    	
    	for(int i = 0; i < banks.size(); i ++)
    	{
    		Bank bank = banks.get(i);
    		G[i] += bank.getCtddfswg();
    		B[i] += bank.getCtddfswb();		
    	}
    	
    	if (BuySide) s = Matrix.getShare(B);
    	else s = Matrix.getShare(G);
    	
    	
    	
    	return s;
    }
    
    public static double [] SharesNodes (ArrayList<Node> nodes, boolean BuySide)
    {
    	double [] G = new double [nodes.size()];
    	double [] B = new double [nodes.size()];
    	double [] s = new double [nodes.size()];
    	
    	for(int i = 0; i < nodes.size(); i ++)
    	{
    		Bank bank = nodes.get(i).getBank();
    		G[i] += bank.getCtddfswg();
    		B[i] += bank.getCtddfswb();		
    	}
    	
    	if (BuySide) s = Matrix.getShare(B);
    	else s = Matrix.getShare(G);
    	
    	
    	
    	return s;
    }
    
    
    public static void printStringInFile(String value, String path)
    {
    	
    }
    
    public static double [][] bankDefault (double [][] matrix, int bank)
    {
    	
    	double [][] newMatrix = new double [matrix.length][matrix.length];
    	
    	for (int i = 0; i < matrix.length; i ++)
    	{
    		for(int j = 0; j < matrix.length; j ++)
    		{
    			if (i != bank) newMatrix[i][j] = matrix[i][j];
    			else newMatrix[i][j] = 0;
    		}
    		
    	}
    	
    	return newMatrix;
    }
    
    public static double [][] bankDefault2 (double [][] matrix, int bank)
    {
    	
    	double [][] newMatrix = new double [matrix.length][matrix.length];
    	
    	for (int i = 0; i < matrix.length; i ++)
    	{
    		for(int j = 0; j < matrix.length; j ++)
    		{
    			if (i != bank) newMatrix[i][j] = matrix[i][j];
    			else
    			{
    				newMatrix[i][j] = 0;
    			}
    		}
    		
    	}
    	
    	for (int i = 0; i < matrix.length; i ++)
    	{
    		newMatrix[i][bank] = 0;
    	}
    	
    	return newMatrix;
    }
    
    public static double [][] matrixTransformationLinksShare(double[][] Matrix, double[] share, boolean random)
    {
    	int [] links = new int[share.length];
    	double [][] matrix = new double [Matrix.length][Matrix.length];
    	
    	
    	
    	for (int i = 0; i < Matrix.length; i ++)
    	{
    		for(int j = 0; j < Matrix.length; j ++)
    		{
    			matrix[i][j] = Matrix[i][j];
    		}
    		
    	}
    	 
    	for(int i = 0; i < links.length; i ++)
    	{
    		links[i] = (int)(links.length*share[i]) + 1;
//    		System.out.println(links[i]);
    	}
    	
    	if(!random)
    	{
    		for(int i = 0; i < links.length; i ++)
    		{
    			for(int j = links[i]; j < links.length; j ++)
    			{
    				
    				matrix[i][matrix.length - 1] +=  matrix[i][j];
    				matrix[matrix.length - 1][i] +=  matrix[i][j];
    				matrix[i][j] = 0;
    			}
    		}
    	}
    	else
    	{
    		Random generator = new Random(0);
    		
    		boolean [] check = new boolean [links.length];
    		
    		
    		
    		int remain, j;
    		for(int i = 0; i < links.length; i ++)
    		{
    			
    			for(int c = 0; c < links.length; c ++)
        		{
        			check [c]= true;
        		}
    			
    			remain = links.length - links[i];
    			
    			while (remain > 0)
    			{
    				j = generator.nextInt(links.length);
    				if (check[j])
    				{
    					matrix[i][matrix.length - 1] +=  matrix[i][j];
        				matrix[matrix.length - 1][i] +=  matrix[i][j];
        				matrix[i][j] = 0;
        				
        				check[j] = false;
        				remain --;
    				}
    			}
    		}
    	}
    	
    	return matrix;
    }
    
    public static void main(String[] args)
    {
    	int defaultBank = 25;
    	int orders = 50;
    	int time = 11;
    	boolean random = true;
    	
    	
    	ArrayList<Bank> banks = DataController.getBanks();
    	
    	ArrayList<double[][]> matrices = new ArrayList<double[][]>();
    	
    	double [] share = Matrix.Shares(banks, true);

    	
//    	matrices.add(Matrix.buildMatrix(banks));
    	
    	matrices.add(Matrix.matrixTransformationLinksShare(Matrix.buildMatrix(banks), share, random)); 
    	
    	String name = "Time_" + time;
    	
    	String path = "0812\\MatrixTransformation2\\DB" + defaultBank + "_time_" + time;
    	
    	Matrix.printCSV(matrices.get(0), ".\\results\\" + path + "\\matrix_" + name + ".csv");	
    	
    	
    	matrices.add(Matrix.bankDefault(matrices.get(0), defaultBank));
    		
    	Matrix.printCSV(matrices.get(1), ".\\results\\" + path + "\\matrix_DB" +defaultBank+ "_" + name + ".csv");
    	
    	for (int o = 0; o < orders; o ++)
    	{
    		
    		matrices.add(Matrix.matrixTransformationLinksShare(Matrix.contagionProcessShareWithOutsideEntity(Matrix.getNewG(Matrix.getG(matrices.get(o + 1)), 
    				Matrix.getB(matrices.get(o + 1)), Matrix.getB(matrices.get(o))),
    				share, matrices.get(o + 1)), share, random));
	
    		
    		Matrix.printCSV(matrices.get(o + 2), ".\\results\\" + path + "\\matrix_" + name + "_DB=" +defaultBank+ "_Order_" + (o+1) + ".csv");

    	}
    	
 
    }
    
    public static void printCSV (String string, String path)
    {
    	BufferedWriter out;
    	
    	try{
    		
    		out = new BufferedWriter(new FileWriter(path, true));
    	
    		out.write(string);
    		
    		out.close();
    	}catch (IOException e){
    	  	
    	}
    	
    }
    
    public static void printCSV (double [][] matrix, String path)
    {
    	BufferedWriter out;
    	
    	try{
    		
    		out = new BufferedWriter(new FileWriter(path, true));
    	
    		for (int i = 0; i < matrix.length; i ++)
    		{
    			for (int j = 0; j < matrix.length; j ++)
    			{
    				out.write(matrix[i][j] + ",");
    			}
    			out.write("\n");
    			
    		}
    		
    		out.close();
    	}catch (IOException e){
    	  	
    	}
    	
    }
    


	
	
	
}
