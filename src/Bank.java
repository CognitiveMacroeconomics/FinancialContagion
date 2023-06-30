
public class Bank {
	
	private int cert;
	private String namefull;
	private String nameshort;
	private double ctddfswb;
	private double ctddfswg;
	private double CC;
	private double MBS;
	private double SPV;
	private double referenceEntity_gross;
	private double referenceEntity_net;
	
	
	public Bank (int cert, String namefull, String nameshort, double ctddfswb, 
			double ctddfswg, double cc, double mbs, double spv, double referenceEntity_gross, 
			double referenceEntity_net)
	{
		this.cert = cert;
		this.namefull = namefull;
		this.nameshort = nameshort;
		this.ctddfswb = ctddfswb;
		this.ctddfswg = ctddfswg;
		this.CC = cc;
		this.MBS = mbs;
		this.SPV = spv;
		this.referenceEntity_gross = referenceEntity_gross;
		this.referenceEntity_net = referenceEntity_net;
		
		
	}
	
	
	public int getCert() {
		return cert;
	}
	public void setCert(int cert) {
		this.cert = cert;
	}
	public String getNamefull() {
		return namefull;
	}
	public void setNamefull(String namefull) {
		this.namefull = namefull;
	}
	public double getCtddfswb() {
		return ctddfswb;
	}
	public void setCtddfswb(long ctddfswb) {
		this.ctddfswb = ctddfswb;
	}
	public double getCtddfswg() {
		return ctddfswg;
	}
	public void setCtddfswg(long ctddfswg) {
		this.ctddfswg = ctddfswg;
	}
	
	public String toString ()
	{
//		System.out.println("toString");
		String s = "" + this.cert + " , " + 
						this.namefull + " , " +
						this.ctddfswb + " , " +
						this.ctddfswg + "\n";
						
						
		return s;
	}


	public double getCC() {
		return CC;
	}


	public void setCC(long cc) {
		CC = cc;
	}


	public double getMBS() {
		return MBS;
	}


	public void setMBS(long mbs) {
		MBS = mbs;
	}


	public double getSPV() {
		return SPV;
	}


	public void setSPV(long spv) {
		SPV = spv;
	}


	public String getNameshort() {
		return nameshort;
	}


	public double getReferenceEntity_gross() {
		return referenceEntity_gross;
	}


	public double getReferenceEntity_net() {
		return referenceEntity_net;
	}



}
