
public class Contagion {
	
	public static final int CDS_COVER = 0;
	public static final int CDS_SPV_IMPACT = 1;
	
	int bank1;
	int bank2;
	double value;
	int lossType;
	
	public Contagion (int b1, int b2, double v, int lossType)
	{
		this.bank1 = b1;
		this.bank2 = b2;
		this.value = v;
		this.lossType = lossType;
	}
	

}
