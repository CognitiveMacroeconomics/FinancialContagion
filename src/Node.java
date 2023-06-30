import java.awt.Paint;

import jas.graph.RelationalAgent;

import org._3pq.jgrapht.Graph;

public class Node extends RelationalAgent
	{
	
	
	private String namefull;
	private String name;
	private int cert;
	
	private double B;
	private double G;
	private double netting;
	private double share;
	private double shareG;
	private double CC;
	private double CC_last;
	private double MBS;
	private double SPV;
	private boolean defaults;
	private double percChangeCC;
	private double bufferCC;
	private double loss_CDScover;
	private double loss_RefEntity;
	private double loss_SPV;
	
	private Bank bank;
	
	

		public Node(Graph g, int id, Bank bank, double share, double shareG) {
			super(g, id);
			// TODO Auto-generated constructor stub
			
			this.bank = bank;
			this.cert = bank.getCert();
			this.B = bank.getCtddfswb();
			this.G = bank.getCtddfswg();
			this.share = share;
			this.shareG = shareG;
			this.namefull = bank.getNamefull();
			this.CC = bank.getCC();
			this.CC_last = bank.getCC();
			this.MBS = bank.getMBS();
			this.SPV = bank.getSPV();
			this.defaults = false;
			this.name = this.namefull.split(",")[0];
			this.percChangeCC = 0;
			this.bufferCC = 0;
			this.loss_CDScover = 0;
			this.loss_RefEntity = 0;
			this.loss_SPV = 0;
			
			this.setLabel("            " + this.bank.getNameshort());
		}


		public double getB() {
			return B;
		}


		public void setB(double b) {
			B = b;
		}


		public double getG() {
			return G;
		}


		public void setG(double g) {
			G = g;
		}


		public Bank getBank() {
			return bank;
		}


		public int getCert() {
			return cert;
		}


		public String getNamefull() {
			return namefull;
		}


		public double getShare() {
			return share;
		}


		public void setShare(double share) {
			this.share = share;
		}


		public double getCC() {
			return CC;
		}


		public void setCC(double cc) {
			CC = cc;
		}


		public double getMBS() {
			return MBS;
		}


		public void setMBS(double mbs) {
			MBS = mbs;
		}


		public double getSPV() {
			return SPV;
		}


		public void setSPV(double spv) {
			SPV = spv;
		}


		public boolean isDefaults() {
			return defaults;
		}


		public void setDefaults(boolean defaults) {
			this.defaults = defaults;
		}


		public String getName() {
			return name;
		}


		public double getNetting() {
			return netting;
		}


		public void setNetting(double netting) {
			this.netting = netting;
		}


		public double getShareG() {
			return shareG;
		}


		public void setShareG(double shareG) {
			this.shareG = shareG;
		}


		public double getPercChangeCC() {
			return percChangeCC;
		}


		public void setPercChangeCC(double percChangeCC) {
			this.percChangeCC = percChangeCC;
		}
		
		public String toString ()
		{
			return this.getBank().getNameshort();
		}


		public double getCC_last() {
			return CC_last;
		}


		public void setCC_last(double cc_last) {
			CC_last = cc_last;
		}
		
		public void CC_CClastEqual ()
		{
			this.CC_last = this.CC;
		}


		public double getBufferCC() {
			return bufferCC;
		}


		public void setBufferCC(double bufferCC) {
			this.bufferCC = bufferCC;
		}


		public double getLoss_CDScover() {
			return loss_CDScover;
		}


		public void setLoss_CDScover(double lossCDScover) {
			loss_CDScover = lossCDScover;
		}


		public double getLoss_RefEntity() {
			return loss_RefEntity;
		}


		public void setLoss_RefEntity(double lossRefEntity) {
			loss_RefEntity = lossRefEntity;
		}


		public double getLoss_SPV() {
			return loss_SPV;
		}


		public void setLoss_SPV(double lossSPV) {
			loss_SPV = lossSPV;
		}

		
	}